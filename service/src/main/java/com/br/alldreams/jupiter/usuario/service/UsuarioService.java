/**
 *
 */
package com.br.alldreams.jupiter.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.base.exception.service.SiteNaoExisteServiceException;
import com.br.alldreams.jupiter.usuario.dto.UsuarioDTO;
import com.br.alldreams.jupiter.usuario.repository.UsuarioRepository;
import com.br.alldreams.jupiter.usuario.repository.domain.Usuario;
import com.br.alldreams.jupiter.usuario.service.convert.UsuarioConvert;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:04:30
 */
@Log
@Service
public class UsuarioService extends BaseService {

    @Autowired
    private UsuarioRepository repositorio;

    @Autowired
    private UsuarioConvert convert;

    public Page<UsuarioDTO> buscaPorNome(final String nome, final Integer itensPorPagina, final Integer pagina, final String sentido, final String ordenacao)
            throws SiteNaoExisteServiceException {

        final Page<Usuario> usuairosPaginados = this.repositorio.buscarPorNome(getSite().getId(), nome,
                getPageable(pagina, itensPorPagina, sentido, ordenacao));

        final List<UsuarioDTO> itens = this.convert.toDTO(usuairosPaginados.getContent());

        return getPagina(itens, usuairosPaginados);

    }

    public Page<UsuarioDTO> todos(final Integer itensPorPagina, final Integer pagina, final String sentido, final String ordenacao)
            throws SiteNaoExisteServiceException {
        final Page<Usuario> usuairosPaginados = this.repositorio.todos(getSite().getId(), getPageable(pagina, itensPorPagina, sentido, ordenacao));

        final List<UsuarioDTO> itens = this.convert.toDTO(usuairosPaginados.getContent());

        return getPagina(itens, usuairosPaginados);
    }

}
