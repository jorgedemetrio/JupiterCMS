/**
 *
 */
package com.br.alldreams.jupiter.base;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.br.alldreams.jupiter.base.domain.ControleInformacao;
import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;
import com.br.alldreams.jupiter.base.exception.BaseException;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.SemPermissaoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SiteNaoExisteServiceException;
import com.br.alldreams.jupiter.base.messagem.Messagem;
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
public abstract class BaseService {

	public static final int PADRO_MAXIMO_ITENS_PAGINA = 10;

	public static final int PAGINA_INICIAL = 1;

	@Autowired
	private Messagem mensagem;

	@Autowired
	private Validator validator;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private SiteRepository siteRepository;

	@Autowired
	private HttpServletRequest request;


	public <T extends BaseException> T createException(final String chave, final Class<T> tipo,
			final String... parametros) {
		return mensagem.createExcetion(chave, tipo, parametros);
	}

	public BaseException createException(final String chave, final String... parametros) {
		return mensagem.createExcetion(chave, parametros);
	}


	public String getNewId() {
		return UUID.randomUUID().toString();
	}

	public Pageable getPageable(final Integer pagina, final Integer itensPorPagina, final String ordem,
			final String sentido) {
		if (isNull(ordem) || ordem.isEmpty()) {
			return PageRequest.of(nonNull(pagina) ? pagina : PAGINA_INICIAL,
					nonNull(itensPorPagina) ? itensPorPagina : PADRO_MAXIMO_ITENS_PAGINA);
		}

		return PageRequest.of(nonNull(pagina) ? pagina : PAGINA_INICIAL,
				nonNull(itensPorPagina) ? itensPorPagina : PADRO_MAXIMO_ITENS_PAGINA,
				nonNull(sentido) ? Direction.fromString(sentido) : Direction.ASC, ordem);
	}

	public <T extends Object, X extends Serializable> Page<T> getPagina(final List<T> itens,  final Page<X> origin){
		return new PageImpl<>(itens, origin.getPageable(), origin.getTotalElements());
	}

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
		if(Objects.isNull(usuario)) {
			throw createException("sem-permissao", SemPermissaoServiceException.class);
		}
		return usuario;
	}

	public <T extends ControleInformacaoAlteravel> T setDadosAlteracao(final T entity)
			throws SemPermissaoServiceException, SiteNaoExisteServiceException {
		entity.setAlterador(getUsuarioLogado());
		entity.setDataAlteracao(new Date());
		entity.setIpAlterador(request.getRemoteAddr());
		entity.setVersao(nonNull(entity.getVersao()) && !entity.getVersao().isEmpty()
				? String.valueOf(Integer.parseInt(entity.getVersao()) + 1)
				: "1");
		return entity;
	}

	public <T extends ControleInformacao> T setDadosCricao(final T entity)
			throws SemPermissaoServiceException, SiteNaoExisteServiceException {
		entity.setId(getNewId());
		entity.setCriador(getUsuarioLogado());
		entity.setDataCriacao(new Date());
		entity.setIpCriador(request.getRemoteAddr());
		entity.setSite(getSite());
		entity.setVersao("1");
		return entity;
	}

	public void validar(final Serializable entidade) throws DadosInvalidosServiceException {
		final Set<ConstraintViolation<Object>> constraints = validator.validate(entidade);
		if (Objects.nonNull(constraints) && !constraints.isEmpty()) {
			final HashSet<String> campos = new HashSet<>();
			final HashSet<String> mensagens = new HashSet<>();
			final StringBuilder campoStr = new StringBuilder();
			for (final ConstraintViolation<Object> constraintViolation : constraints) {
				mensagens.add(constraintViolation.getMessage());
				campos.add(constraintViolation.getInvalidValue().toString());
				campoStr.append(constraintViolation.getInvalidValue().toString());
			}

			final DadosInvalidosServiceException exception = mensagem.createExcetion("campos-invalidos",
					DadosInvalidosServiceException.class, campoStr.toString());

			exception.getCampos().addAll(campos);
			exception.getMensagens().addAll(mensagens);

			throw exception;

		}
	}
}
