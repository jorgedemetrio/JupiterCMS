/**
 *
 */
package com.br.alldreams.jupiter.conteudo.categoria.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.ItemNaoEncontradoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SemPermissaoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SiteNaoExisteServiceException;
import com.br.alldreams.jupiter.conteudo.base.repository.domain.StatusConteudoEnum;
import com.br.alldreams.jupiter.conteudo.categoria.dto.CategoriaDTO;
import com.br.alldreams.jupiter.conteudo.categoria.repository.CategoriaRepository;
import com.br.alldreams.jupiter.conteudo.categoria.repository.domain.Categoria;
import com.br.alldreams.jupiter.conteudo.categoria.service.convert.CategoriaConvert;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 17 de jan de 2020 17:07:56
 */
@Log
@Service
public class CategoriaService extends BaseService {

    @Autowired
    private CategoriaRepository repositorio;

    @Autowired
    private CategoriaConvert convert;







    /**
     * Atualiza os dados do Categoria.
     *
     * @param categoriaDTO Categoria que será atualziado.
     * @throws DadosInvalidosServiceException    Caso envie o formulário de forma
     *                                           inválida.
     * @throws SemPermissaoServiceException      O usuário não tem permissão para
     *                                           grava a informação ou sua sessão.
     *                                           expirou.
     * @throws SiteNaoExisteServiceException     Site não exite na base.
     * @throws ItemNaoEncontradoServiceException Item que tentou atualizar não
     *                                           existe.
     * @since 16 de jan de 2020 03:12:28
     */
    public void atualizar(final CategoriaDTO categoriaDTO)
            throws DadosInvalidosServiceException, SemPermissaoServiceException, SiteNaoExisteServiceException,
            ItemNaoEncontradoServiceException {
        validar(categoriaDTO);
        if (isNull(categoriaDTO.getId())) {
            throw createException("campos-invalidos", DadosInvalidosServiceException.class, "id (Requirido)");
        }
        Categoria categoria = this.repositorio.pegarPorId(categoriaDTO.getId(), getSite().getId());
        if (isNull(categoria)) {
            throw createException("nao-encontrado", ItemNaoEncontradoServiceException.class, "Categoria");
        }
        categoria = this.convert.toEntity(categoriaDTO, categoria);
        try {
            this.repositorio.save(setDadosAlteracao(categoria));
        } catch (final SemPermissaoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Tentou gravar um categoria sem permissão", e);
            throw e;
        }
    }

    /**
     * Busca na base um usuário pelo sue nome.
     *
     *
     * @param nome           O campo nome é orbigatorio.
     * @param pagina         Pagina que está acessando. Se não for definina assume a
     *                       padrão {@link BaseService#PAGINA_INICIAL} .
     * @param itensPorPagina Itens por página na consulta. Se não for definina
     *                       assume a padrão
     *                       {@link BaseService#PADRO_MAXIMO_ITENS_PAGINA} .
     * @param ordem          Campo que deve ser ordenado.
     * @param sentido        Sentido da ordenação, deve ser ASC ou DESC como no :
     *                       {@link Direction}.
     * @return Lista de {@link CategoriaDTO} .
     * @throws DadosInvalidosServiceException    Caso envie o formulário de forma
     *                                           inválida.
     * @throws ItemNaoEncontradoServiceException Item que tentou atualizar não
     *                                           existe.
     * @throws SiteNaoExisteServiceException     Site não exite na base.
     * @since 16 de jan de 2020 03:14:53
     */
    public Page<CategoriaDTO> buscaPorNome(final String nome, final Integer pagina, final Integer itensPorPagina,
            final String ordem, final String sentido)
            throws DadosInvalidosServiceException, ItemNaoEncontradoServiceException, SiteNaoExisteServiceException {
        if (isNull(nome) || nome.isEmpty()) {
            throw createException("campo-abrigatorio", DadosInvalidosServiceException.class, "Nome");
        }
        List<CategoriaDTO> itens;
        final Page<Categoria> categorias = this.repositorio.pegarPorNome(nome, getSite().getId(),
                getPageable(pagina, itensPorPagina, ordem, sentido));

        if (isNull(categorias)) {
            itens = new ArrayList<>();
        }
        else {
            itens = this.convert.toDTO(categorias.getContent());
        }
        return getPagina(itens, categorias);
    }


    /**
     * Apaga um categoria pelo seu id.
     *
     * @param idCategoria Id do categoria a ser apagado.
     * @throws DadosInvalidosServiceException    Caso envie o formulário de forma
     *                                           inválida.
     * @throws ItemNaoEncontradoServiceException Item que tentou atualizar não
     *                                           existe.
     * @throws SiteNaoExisteServiceException     Site não exite na base.
     * @throws SemPermissaoServiceException      O usuário não tem permissão para
     *                                           grava a informação ou sua sessão.
     * @since 16 de jan de 2020 03:18:24
     */
    public void deletar(final String idCategoria) throws DadosInvalidosServiceException, ItemNaoEncontradoServiceException,
            SiteNaoExisteServiceException, SemPermissaoServiceException {
        if (isNull(idCategoria) || idCategoria.isEmpty()) {
            throw createException("campo-abrigatorio", DadosInvalidosServiceException.class, "Código da categoria");
        }
        final Categoria categoria = this.repositorio.pegarPorId(UUID.fromString(idCategoria), getSite().getId());
        if (isNull(categoria)) {
            throw createException("nao-encontrado", ItemNaoEncontradoServiceException.class, "Categoria");
        }
        categoria.setStatus(StatusConteudoEnum.DELETADO);
        this.repositorio.delete(setDadosCricao(categoria));
    }


    /**
     * Grava um novo categoria.
     *
     * @param categoriaDTO Grava o categoria informado, não deve passar o ID para essa
     *                 operação.
     * @throws DadosInvalidosServiceException Caso envie o formulário de forma
     *                                        inválida.
     * @throws SemPermissaoServiceException   O usuário não tem permissão para grava
     *                                        a informação ou sua sessão.
     * @throws SiteNaoExisteServiceException  Site não exite na base.
     * @since 16 de jan de 2020 03:19:26
     */
    public void novo(final CategoriaDTO categoriaDTO)
            throws DadosInvalidosServiceException, SemPermissaoServiceException, SiteNaoExisteServiceException {
        validar(categoriaDTO);
        if (nonNull(categoriaDTO.getId())) {
            throw createException("campos-invalidos", DadosInvalidosServiceException.class,
                    "id (Deve estar tentando gravar um categoria que já existe)");
        }
        final Categoria categoria = this.convert.toEntity(categoriaDTO);
        // categoria.setStatus(StatusConteudoEnum.ATIVO);
        try {
            this.repositorio.save(setDadosCricao(categoria));
        } catch (final SemPermissaoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Tentou gravar um categoria sem permissão", e);
            throw e;
        }
    }






    /**
     * Pega um Categoria por ID.
     *
     * @param idCategoria Id do categoria que está sendo consultado.
     * @return Retonra um {@link CategoriaDTO} .
     * @throws DadosInvalidosServiceException    Caso envie o formulário de forma
     *                                           inválida.
     * @throws ItemNaoEncontradoServiceException Item que tentou atualizar não
     *                                           existe.
     * @throws SiteNaoExisteServiceException     Site não exite na base.
     * @since 16 de jan de 2020 03:25:08
     */
    public CategoriaDTO pegar(final String idCategoria)
            throws DadosInvalidosServiceException, ItemNaoEncontradoServiceException, SiteNaoExisteServiceException {
        if (isNull(idCategoria) || idCategoria.isEmpty()) {
            throw createException("campo-abrigatorio", DadosInvalidosServiceException.class, "Código do categoria");
        }
        final Categoria categoria = this.repositorio.pegarPorId(UUID.fromString(idCategoria), getSite().getId());
        if (isNull(categoria)) {
            throw createException("nao-encontrado", ItemNaoEncontradoServiceException.class, "Categoria");
        }

        return this.convert.toDTO(categoria);
    }

    /**
     * Busca na base um usuário pelo sue nome.
     *
     *
     * @param pagina         Pafina que está acessando. Se não for definina assume a
     *                       padrão {@link BaseService#PAGINA_INICIAL} .
     * @param itensPorPagina Itens por página na consulta. Se não for definina
     *                       assume a padrão
     *                       {@link BaseService#PADRO_MAXIMO_ITENS_PAGINA} .
     * @param ordem          Campo que deve ser ordenado.
     * @param sentido        Sentido da ordenação, deve ser ASC ou DESC como no :
     *                       {@link Direction}.
     * @return Lista de {@link CategoriaDTO} .
     * @throws DadosInvalidosServiceException    Caso envie o formulário de forma
     *                                           inválida.
     * @throws ItemNaoEncontradoServiceException Item que tentou atualizar não
     *                                           existe.
     * @throws SiteNaoExisteServiceException     Site não exite na base.
     * @since 16 de jan de 2020 03:14:53
     */
    public Page<CategoriaDTO> todos( final Integer pagina, final Integer itensPorPagina,
            final String ordem, final String sentido)
            throws DadosInvalidosServiceException, ItemNaoEncontradoServiceException, SiteNaoExisteServiceException {

        List<CategoriaDTO> itens;
        final Page<Categoria> categorias = this.repositorio.todos(getSite().getId(),
                getPageable(pagina, itensPorPagina, ordem,sentido));

        if (isNull(categorias)) {
            itens = new ArrayList<>();
        }
        else {
            itens = this.convert.toDTO(categorias.getContent());
        }
        return getPagina(itens, categorias);
    }
}
