/**
 *
 */
package com.br.alldreams.jupiter.site.service;

import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.SemPermissaoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SiteNaoExisteServiceException;
import com.br.alldreams.jupiter.site.dto.SiteDTO;
import com.br.alldreams.jupiter.site.repository.SiteRepository;
import com.br.alldreams.jupiter.site.repository.domain.Site;
import com.br.alldreams.jupiter.site.service.convert.SiteConvert;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @since 16 de jan de 2020 01:29:02
 * @version 1.0
 */
@Log
@Service
public class SiteService extends BaseService {

    @Autowired
    private SiteConvert convert;

    @Autowired
    private SiteRepository repository;

    public void atualizar(final SiteDTO siteDTO) throws DadosInvalidosServiceException, SemPermissaoServiceException, SiteNaoExisteServiceException {
        validar(siteDTO);
        if (Objects.isNull(siteDTO.getId())) {
            createException("campos-invalidos", DadosInvalidosServiceException.class, "id (Requirido)");
        }
        Site site = this.repository.getOne(siteDTO.getId());
        if (Objects.isNull(site)) {
            createException("nao-encontrado", DadosInvalidosServiceException.class, "Site");
        }
        site = this.convert.toEntity(siteDTO, site);
        try {
            this.repository.save(setDadosAlteracao(site));
        } catch (final SemPermissaoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Tentou gravar um site sem permissão", e);
            throw e;
        }
    }

    public void deletar(final String id) throws DadosInvalidosServiceException, SemPermissaoServiceException, SiteNaoExisteServiceException {
        if (Objects.isNull(id) || id.isEmpty()) {
            throw createException("campo-abrigatorio", DadosInvalidosServiceException.class, "Código do site");
        }

        final Site site = this.repository.getOne(UUID.fromString(id));

        try {
            this.repository.save(setDadosCricao(site));
        } catch (final SemPermissaoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Tentou gravar um site sem permissão", e);
            throw e;
        }
    }

    public void novo(final SiteDTO siteDTO) throws DadosInvalidosServiceException, SemPermissaoServiceException, SiteNaoExisteServiceException {
        validar(siteDTO);
        if (Objects.nonNull(siteDTO.getId())) {
            createException("campos-invalidos", DadosInvalidosServiceException.class, "id (Deve estar tentando gravar um site que já existe)");
        }
        final Site site = this.convert.toEntity(siteDTO);

        try {
            this.repository.save(setDadosCricao(site));
        } catch (final SemPermissaoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Tentou gravar um site sem permissão", e);
            throw e;
        }
    }

}
