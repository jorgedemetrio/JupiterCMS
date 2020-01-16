/**
 *
 */
package com.br.alldreams.jupiter.usuario.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.ItemNaoEncontradoServiceException;
import com.br.alldreams.jupiter.usuario.dto.GrupoDTO;
import com.br.alldreams.jupiter.usuario.repository.GrupoRepository;
import com.br.alldreams.jupiter.usuario.repository.model.Grupo;
import com.br.alldreams.jupiter.usuario.service.convert.GrupoConvert;

import lombok.extern.java.Log;

/**
 * @author Jess
 * @version 1.0
 * @since 16 de jan de 2020 00:37:24
 */
@Log
@Service
public class GrupoService extends BaseService {

    @Autowired
    private GrupoRepository repositorio;

    @Autowired
    private GrupoConvert convert;

    public void deletarGrupo(final String idGrupo) throws DadosInvalidosServiceException, ItemNaoEncontradoServiceException {
        if (Objects.isNull(idGrupo) || idGrupo.isEmpty()) {
            throw createException("campo-abrigatorio", DadosInvalidosServiceException.class, "Código do grupo");
        }
        final Grupo grupo = repositorio.getOne(idGrupo);
        if (Objects.isNull(grupo)) {
            throw createException("campo-abrigatorio", ItemNaoEncontradoServiceException.class, "Grupo");
        }
        repositorio.delete(grupo);
    }

    public void salvarGrupo(final GrupoDTO grupoDTO) throws DadosInvalidosServiceException {
        validar(grupoDTO);
        final Grupo grupo = convert.toGrupo(grupoDTO);

        if (Objects.isNull(grupo.getId())) {
            grupo.setId(getNewId());
        }

        repositorio.save(grupo);
    }
}
