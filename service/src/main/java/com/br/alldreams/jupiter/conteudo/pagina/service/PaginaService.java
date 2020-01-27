/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.service;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.ErroInternoServiceException;
import com.br.alldreams.jupiter.base.exception.service.ItemNaoEncontradoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SiteNaoExisteServiceException;
import com.br.alldreams.jupiter.conteudo.pagina.dto.PaginaDTO;
import com.br.alldreams.jupiter.conteudo.pagina.repository.PaginaRepository;
import com.br.alldreams.jupiter.conteudo.pagina.repository.domain.Pagina;
import com.br.alldreams.jupiter.conteudo.pagina.service.convert.PaginaConvert;

import lombok.extern.java.Log;

/**
 * @author Jess
 * @since 11 de jan de 2020 02:27:37
 * @version 1.0
 */
@Log
@Service
public class PaginaService extends BaseService {

    @Autowired
    private PaginaRepository repositorio;

    @Autowired
    private PaginaConvert conteudoConvert;

    public void apagar(final String codigo) throws DadosInvalidosServiceException, ErroInternoServiceException {
        if (Objects.isNull(codigo) || codigo.isEmpty()) {
            throw createException("campos-invalidos", DadosInvalidosServiceException.class, "codigo");
        }
        repositorio.deleteById(UUID.fromString(codigo));
    }

    public Page<PaginaDTO> buscar(final String titulo, final Integer pagina, final Integer itensPorPagina, final String ordem, final String sentido)
            throws DadosInvalidosServiceException, ErroInternoServiceException, SiteNaoExisteServiceException {
        if (Objects.isNull(titulo) || titulo.isEmpty()) {
            throw createException("campos-invalidos", DadosInvalidosServiceException.class, "titulo");
        }

        final Page<Pagina> paginaConteudo = repositorio.buscaPorTitulo(titulo, getSite().getId(), getPageable(pagina, itensPorPagina, ordem, sentido));

        final List<PaginaDTO> itens = conteudoConvert.toDTO(paginaConteudo.getContent());

        return getPagina(itens, paginaConteudo);
    }

    public void gravar(final PaginaDTO conteudo) throws DadosInvalidosServiceException, ErroInternoServiceException {
        validar(conteudo);
        repositorio.save(conteudoConvert.toEntity(conteudo));
    }

    /**
     * Com o código tenta localizar um conteuod.
     *
     * @param codigo Codigo de busca.
     * @return Retorna uma ConteudoDTO.
     * @throws ItemNaoEncontradoServiceException Se não achar.
     * @throws ErroInternoServiceException       Erro interno.
     * @since 12 de jan de 2020 04:11:09
     */
    public PaginaDTO pegar(final String codigo) throws ItemNaoEncontradoServiceException, ErroInternoServiceException {
        Pagina conteudo;
        try {
            conteudo = repositorio.pegarPorId(UUID.fromString(codigo), getSite().getId());
            if (isNull(conteudo)) {
                return conteudoConvert.toDTO(conteudo);
            }
        } catch (final Exception ex) {
            log.log(Level.SEVERE, "Erro ao buscar matérias.", ex);
            throw new ErroInternoServiceException(ex);
        }
        throw createException("nao-encontrado", ItemNaoEncontradoServiceException.class, "Matéria");
    }

    public List<PaginaDTO> todos() throws ErroInternoServiceException {
        final List<PaginaDTO> conteudosDTO = new ArrayList<>();
        repositorio.findAll().forEach(n -> conteudosDTO.add(conteudoConvert.toDTO(n)));
        return conteudosDTO;
    }

}
