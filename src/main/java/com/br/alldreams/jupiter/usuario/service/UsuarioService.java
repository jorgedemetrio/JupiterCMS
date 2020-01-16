/**
 *
 */
package com.br.alldreams.jupiter.usuario.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.base.domain.ItensPaginado;
import com.br.alldreams.jupiter.site.dto.SiteDTO;
import com.br.alldreams.jupiter.usuario.dto.UsuarioDTO;
import com.br.alldreams.jupiter.usuario.repository.UsuarioRepository;
import com.br.alldreams.jupiter.usuario.repository.model.Usuario;
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

    public Page<UsuarioDTO> buscaPorNome(final String nome, final SiteDTO site, final Integer itensPorPagina, final Integer pagina, final String sentido, final String ordenacao) {

            final Page<Usuario> usuairosPaginados = this.repositorio
                    .todos(site.getId(), getPageable(pagina, itensPorPagina, sentido, ordenacao));

            final List<UsuarioDTO> itens = this.convert.toDTO(usuairosPaginados.getContent());

            return getPagina(itens, usuairosPaginados);

    }

    public Page<UsuarioDTO> getAll(final SiteDTO site, final Integer itensPorPagina, final Integer pagina, final fianl String sentido,  final String ordenacao) {
        final Page<Usuario> usuairosPaginados = this.repositorio
                .todos(site.getId(), getPageable(pagina, itensPorPagina, sentido, ordenacao));

        final List<UsuarioDTO> itens = this.convert.toDTO(usuairosPaginados.getContent());

        return getPagina(itens, usuairosPaginados);
    }

}
