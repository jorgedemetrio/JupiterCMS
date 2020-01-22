/**
 *
 */
package com.br.alldreams.jupiter.base;

import static java.util.Objects.nonNull;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.br.alldreams.jupiter.base.domain.ControleInformacao;
import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;
import com.br.alldreams.jupiter.base.exception.service.SemPermissaoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SiteNaoExisteServiceException;
import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;
import com.br.alldreams.jupiter.site.repository.SiteRepository;
import com.br.alldreams.jupiter.site.repository.domain.Site;
import com.br.alldreams.jupiter.usuario.repository.UsuarioRepository;
import com.br.alldreams.jupiter.usuario.repository.domain.Usuario;

import lombok.Getter;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:46:14
 * @version 1.0
 */
@Getter
public abstract class BaseService extends BaseCommonsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private HttpServletRequest request;

    @Cacheable(condition = "#{${spring.profiles.active} != 'dev' && ${spring.profiles.active} != 'test' ")
    public Site getSite() throws SiteNaoExisteServiceException {
        final Site site = siteRepository.descobrirSiteAtivoPorURL(request.getServerName());
        if (Objects.isNull(site)) {
            throw createException("site-nao-existe", SiteNaoExisteServiceException.class);
        }
        return site;
    }

    @Cacheable(condition = "#{${spring.profiles.active} != 'dev' && ${spring.profiles.active} != 'test' ")
    public Usuario getUsuarioLogado() throws SemPermissaoServiceException, SiteNaoExisteServiceException {
        // final Authentication authentication =
        // SecurityContextHolder.getContext().getAuthentication();
        final Usuario usuario = usuarioRepository.buscarUsuario(getSite().getId(), "");// authentication.getName());
        if (Objects.isNull(usuario)) {
            throw createException("sem-permissao", SemPermissaoServiceException.class);
        }
        return usuario;
    }

    public <T extends ControleInformacaoAlteravel> T setDadosAlteracao(final T entity) throws SemPermissaoServiceException, SiteNaoExisteServiceException {
        entity.setAlterador(getUsuarioLogado());
        entity.setDataAlteracao(new Date());
        entity.setIpAlterador(request.getRemoteAddr());
        entity.setVersao(nonNull(entity.getVersao()) && !entity.getVersao().isEmpty() ? String.valueOf(Integer.parseInt(entity.getVersao()) + 1) : "1");
        return entity;
    }

    public <T extends ControleInformacao> T setDadosCricao(final T entity) throws SemPermissaoServiceException, SiteNaoExisteServiceException {
        entity.setId(null);
        entity.setCriador(getUsuarioLogado());
        entity.setDataCriacao(new Date());
        entity.setIpCriador(request.getRemoteAddr());
        entity.setSite(getSite());
        entity.setVersao("1");
        return entity;
    }

    public <T extends BaseConteudo> T setDadosCricao(final T entity) throws SemPermissaoServiceException, SiteNaoExisteServiceException {
        entity.setId(UUID.randomUUID());

        entity.setCriador(getUsuarioLogado());
        entity.setDataCriacao(new Date());
        entity.setIpCriador(request.getRemoteAddr());
        entity.setSite(getSite());
        entity.setVersao("1");
        return entity;
    }
}
