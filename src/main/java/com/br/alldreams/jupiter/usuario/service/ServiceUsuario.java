/**
 *
 */
package com.br.alldreams.jupiter.usuario.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.base.domain.ItensPaginado;
import com.br.alldreams.jupiter.site.dto.SiteDTO;
import com.br.alldreams.jupiter.usuario.dto.UsuarioDTO;
import com.br.alldreams.jupiter.usuario.repository.UsuarioRepository;
import com.br.alldreams.jupiter.usuario.service.convert.UsuarioConvert;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:04:30
 */
@Log
@Service
public class ServiceUsuario extends BaseService{

    @Autowired
    private UsuarioRepository repositorio;

    @Autowired
    private UsuarioConvert convert;

    public ItensPaginado<UsuarioDTO> findByNome(final SiteDTO site, final Integer itensPorPagina, final Integer pagina, final String ordenacao) {
        return this.convert
                .toPaginingDTO(this.repositorio.findAll(PageRequest.of(pagina, itensPorPagina, Sort.by(Objects.nonNull(ordenacao) ? ordenacao : "nome"))));
    }

    public ItensPaginado<UsuarioDTO> getAll(final SiteDTO site, final Integer itensPorPagina, final Integer pagina, final String ordenacao) {
        return this.convert
                .toPaginingDTO(this.repositorio.findAll(PageRequest.of(pagina, itensPorPagina, Sort.by(Objects.nonNull(ordenacao) ? ordenacao : "nome"))));
    }

}
