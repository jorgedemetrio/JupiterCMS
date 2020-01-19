/**
 *
 */
package com.br.alldreams.jupiter.conteudo.categoria.controller;

import static java.util.Objects.isNull;

import java.util.UUID;
import java.util.logging.Level;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.alldreams.jupiter.base.BaseController;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.ItemNaoEncontradoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SemPermissaoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SiteNaoExisteServiceException;
import com.br.alldreams.jupiter.conteudo.categoria.dto.CategoriaDTO;
import com.br.alldreams.jupiter.conteudo.categoria.service.CategoriaService;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 17 de jan de 2020 16:59:37
 */
@Log
@Controller("/categoria")
@RequestMapping("/categoria")
public class CategoriaController extends BaseController {

    public static final String BASE = "/categoria";
    public static final String HOME = BASE + "/home";
    public static final String FORM = BASE + "/form";

    @Autowired
    CategoriaService service;

    @GetMapping("/form/{id}")
    public ModelAndView atualizar(@PathParam("id") final String id) {
        final ModelAndView model = new ModelAndView(FORM);
        try {
            model.addObject("item", service.pegar(id));
        } catch (DadosInvalidosServiceException | ItemNaoEncontradoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Erro ao recuperar a categoria", e);
            return tratarException(e, HOME);
        }
        return model;
    }

    @PutMapping("/form/{id}")
    public ModelAndView atualizar(@PathParam("id") final String id, @RequestBody @Validated final CategoriaDTO categoria) {
        final ModelAndView model = new ModelAndView(HOME);
        try {
            categoria.setId(UUID.fromString(id));
            service.atualizar(categoria);
        } catch (ItemNaoEncontradoServiceException | DadosInvalidosServiceException | SemPermissaoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Erro ao gravar a categoria", e);
            return tratarException(e, FORM);
        }
        return model;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathParam("id") final String id) {
        final ModelAndView model = new ModelAndView(HOME);
        try {
            service.deletar(id);
        } catch (ItemNaoEncontradoServiceException | DadosInvalidosServiceException | SemPermissaoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Erro ao apagar a categoria", e);
            return tratarException(e, HOME);
        }
        return model;
    }

    @GetMapping
    public ModelAndView home(@RequestParam(name = "nome", required = false) final String nomeFiltro,
            @RequestParam(name = "pagina", defaultValue = "1", required = false) final Integer pagina,
            @RequestParam(name = "itensPorPagina", defaultValue = "10", required = false) final Integer itensPorPagina,
            @RequestParam(name = "ordem", defaultValue = "nome", required = false) final String ordem,
            @RequestParam(name = "sentido", defaultValue = "ASC", required = false) final String sentido) {
        final ModelAndView model = new ModelAndView(HOME);
        try {

            if (isNull(nomeFiltro) || nomeFiltro.isEmpty()) {
                model.addObject("itens", service.todos(pagina, itensPorPagina, ordem, sentido));
            } else {
                model.addObject("itens", service.buscaPorNome(nomeFiltro, pagina, itensPorPagina, ordem, sentido));
            }

        } catch (DadosInvalidosServiceException | ItemNaoEncontradoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Erro ao consultar a categoria", e);
            return tratarException(e, HOME);
        }
        return model;
    }

    @GetMapping("/form")
    public ModelAndView novo() {
        return new ModelAndView(FORM);
    }

    @PostMapping("/")
    public ModelAndView novo(@RequestBody @Validated final CategoriaDTO categoria) {
        final ModelAndView model = new ModelAndView(HOME);
        try {
            service.novo(categoria);

        } catch (DadosInvalidosServiceException | SemPermissaoServiceException | SiteNaoExisteServiceException e) {
            log.log(Level.INFO, "Erro ao gravar uma nova categoria", e);
            return tratarException(e, FORM);
        }
        return model;
    }

}
