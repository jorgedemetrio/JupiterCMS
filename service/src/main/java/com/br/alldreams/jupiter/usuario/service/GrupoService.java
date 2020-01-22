/**
 *
 */
package com.br.alldreams.jupiter.usuario.service;

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
import com.br.alldreams.jupiter.base.domain.StatusEnum;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.ItemNaoEncontradoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SemPermissaoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SiteNaoExisteServiceException;
import com.br.alldreams.jupiter.usuario.dto.GrupoDTO;
import com.br.alldreams.jupiter.usuario.repository.GrupoRepository;
import com.br.alldreams.jupiter.usuario.repository.domain.Grupo;
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

    /**
     * Atualiza os dados do Grupo.
     *
     * @param grupoDTO Grupo que será atualziado.
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
    public void atualizar(final GrupoDTO grupoDTO)
            throws DadosInvalidosServiceException, SemPermissaoServiceException, SiteNaoExisteServiceException, ItemNaoEncontradoServiceException {
        validar(grupoDTO);
        if (isNull(grupoDTO.getId())) {
            throw createException("campos-invalidos", DadosInvalidosServiceException.class, "id (Requirido)");
        }
        Grupo grupo = this.repositorio.pegarPorId(grupoDTO.getId(), getSite().getId());
        if (isNull(grupo)) {
            throw createException("nao-encontrado", ItemNaoEncontradoServiceException.class, "Grupo");
        }
        grupo = this.convert.toEntity(grupoDTO, grupo);
        try {
            this.repositorio.save(setDadosAlteracao(grupo));
        } catch (final SemPermissaoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Tentou gravar um grupo sem permissão", e);
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
     * @return Lista de {@link GrupoDTO} .
     * @throws DadosInvalidosServiceException    Caso envie o formulário de forma
     *                                           inválida.
     * @throws ItemNaoEncontradoServiceException Item que tentou atualizar não
     *                                           existe.
     * @throws SiteNaoExisteServiceException     Site não exite na base.
     * @since 16 de jan de 2020 03:14:53
     */
    public Page<GrupoDTO> buscaPorNome(final String nome, final Integer pagina, final Integer itensPorPagina, final String ordem, final String sentido)
            throws DadosInvalidosServiceException, ItemNaoEncontradoServiceException, SiteNaoExisteServiceException {
        if (isNull(nome) || nome.isEmpty()) {
            throw createException("campo-abrigatorio", DadosInvalidosServiceException.class, "Nome");
        }
        List<GrupoDTO> itens;
        final Page<Grupo> grupos = this.repositorio.pegarPorNome(nome, getSite().getId(), getPageable(pagina, itensPorPagina, ordem, sentido));

        if (isNull(grupos)) {
            itens = new ArrayList<>();
        } else {
            itens = this.convert.toDTO(grupos.getContent());
        }
        return getPagina(itens, grupos);
    }

    /**
     * Apaga um grupo pelo seu id.
     *
     * @param idGrupo Id do grupo a ser apagado.
     * @throws DadosInvalidosServiceException    Caso envie o formulário de forma
     *                                           inválida.
     * @throws ItemNaoEncontradoServiceException Item que tentou atualizar não
     *                                           existe.
     * @throws SiteNaoExisteServiceException     Site não exite na base.
     * @throws SemPermissaoServiceException      O usuário não tem permissão para
     *                                           grava a informação ou sua sessão.
     * @since 16 de jan de 2020 03:18:24
     */
    public void deletar(final String idGrupo)
            throws DadosInvalidosServiceException, ItemNaoEncontradoServiceException, SiteNaoExisteServiceException, SemPermissaoServiceException {
        if (isNull(idGrupo) || idGrupo.isEmpty()) {
            throw createException("campo-abrigatorio", DadosInvalidosServiceException.class, "Código do grupo");
        }
        final Grupo grupo = this.repositorio.pegarPorId(UUID.fromString(idGrupo), getSite().getId());
        if (isNull(grupo)) {
            throw createException("nao-encontrado", ItemNaoEncontradoServiceException.class, "Grupo");
        }
        grupo.setStatus(StatusEnum.DELETADO);
        this.repositorio.delete(setDadosCricao(grupo));
    }

    /**
     * Grava um novo grupo.
     *
     * @param grupoDTO Grava o grupo informado, não deve passar o ID para essa
     *                 operação.
     * @throws DadosInvalidosServiceException Caso envie o formulário de forma
     *                                        inválida.
     * @throws SemPermissaoServiceException   O usuário não tem permissão para grava
     *                                        a informação ou sua sessão.
     * @throws SiteNaoExisteServiceException  Site não exite na base.
     * @since 16 de jan de 2020 03:19:26
     */
    public void novo(final GrupoDTO grupoDTO) throws DadosInvalidosServiceException, SemPermissaoServiceException, SiteNaoExisteServiceException {
        validar(grupoDTO);
        if (nonNull(grupoDTO.getId())) {
            throw createException("campos-invalidos", DadosInvalidosServiceException.class, "id (Deve estar tentando gravar um grupo que já existe)");
        }
        final Grupo grupo = this.convert.toEntity(grupoDTO);
        grupo.setStatus(StatusEnum.ATIVO);
        try {
            this.repositorio.save(setDadosCricao(grupo));
        } catch (final SemPermissaoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Tentou gravar um grupo sem permissão", e);
            throw e;
        }
    }

    /**
     * Pega um Grupo por ID.
     *
     * @param idGrupo Id do grupo que está sendo consultado.
     * @return Retonra um {@link GrupoDTO} .
     * @throws DadosInvalidosServiceException    Caso envie o formulário de forma
     *                                           inválida.
     * @throws ItemNaoEncontradoServiceException Item que tentou atualizar não
     *                                           existe.
     * @throws SiteNaoExisteServiceException     Site não exite na base.
     * @since 16 de jan de 2020 03:25:08
     */
    public GrupoDTO pegar(final String idGrupo) throws DadosInvalidosServiceException, ItemNaoEncontradoServiceException, SiteNaoExisteServiceException {
        if (isNull(idGrupo) || idGrupo.isEmpty()) {
            throw createException("campo-abrigatorio", DadosInvalidosServiceException.class, "Código do grupo");
        }
        final Grupo grupo = this.repositorio.pegarPorId(UUID.fromString(idGrupo), getSite().getId());
        if (isNull(grupo)) {
            throw createException("nao-encontrado", ItemNaoEncontradoServiceException.class, "Grupo");
        }

        return this.convert.toDTO(grupo);
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
     * @return Lista de {@link GrupoDTO} .
     * @throws DadosInvalidosServiceException    Caso envie o formulário de forma
     *                                           inválida.
     * @throws ItemNaoEncontradoServiceException Item que tentou atualizar não
     *                                           existe.
     * @throws SiteNaoExisteServiceException     Site não exite na base.
     * @since 16 de jan de 2020 03:14:53
     */
    public Page<GrupoDTO> todos(final Integer pagina, final Integer itensPorPagina, final String ordem, final String sentido)
            throws DadosInvalidosServiceException, ItemNaoEncontradoServiceException, SiteNaoExisteServiceException {

        List<GrupoDTO> itens;
        final Page<Grupo> grupos = this.repositorio.todos(getSite().getId(), getPageable(pagina, itensPorPagina, ordem, sentido));

        if (isNull(grupos)) {
            itens = new ArrayList<>();
        } else {
            itens = this.convert.toDTO(grupos.getContent());
        }
        return getPagina(itens, grupos);
    }

}
