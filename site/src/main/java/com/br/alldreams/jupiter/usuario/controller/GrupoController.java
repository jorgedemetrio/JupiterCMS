/**
 *
 */
package com.br.alldreams.jupiter.usuario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.alldreams.jupiter.base.BaseController;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.ItemNaoEncontradoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SemPermissaoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SiteNaoExisteServiceException;
import com.br.alldreams.jupiter.usuario.dto.GrupoDTO;
import com.br.alldreams.jupiter.usuario.service.GrupoService;

/**
 * @author Jorge Demetrio
 * @since 16 de jan de 2020 03:26:51
 * @version 1.0
 */
@Controller("/grupo")
@RequestMapping("/grupo")
public class GrupoController extends BaseController {

    @Autowired
    GrupoService service;

//	@Secured(value = "has(GRUPO_USUARIO_DELETAR)")
    @DeleteMapping("/{id}")
    public ModelAndView deletar(@RequestParam("id") final String id) {
        final ModelAndView model = new ModelAndView("/site/grupo");
        try {
            service.deletar(id);
        } catch (DadosInvalidosServiceException | ItemNaoEncontradoServiceException | SiteNaoExisteServiceException | SemPermissaoServiceException e) {
            return tratarException(e, "/");
        }
        return model;
    }

    @GetMapping
    public ModelAndView home(@RequestParam(name = "pagina", defaultValue = "1", required = false) final Integer pagina,
            @RequestParam(name = "itensPorPagina", defaultValue = "10", required = false) final Integer itensPorPagina,
            @RequestParam(name = "ordem", defaultValue = "nome", required = false) final String ordem,
            @RequestParam(name = "sentido", defaultValue = "ASC", required = false) final String sentido) {
        final ModelAndView model = new ModelAndView("/site/grupo");
        try {
            service.todos(pagina, itensPorPagina, ordem, sentido);
        } catch (DadosInvalidosServiceException | ItemNaoEncontradoServiceException | SiteNaoExisteServiceException e) {
            return tratarException(e, "/site/grupo");
        }
        return model;
    }

    @PostMapping("/")
    public ModelAndView salvar(@RequestBody @Valid final GrupoDTO formulario) {
        final ModelAndView model = new ModelAndView("/site/grupo");
        try {
            service.novo(formulario);
        } catch (DadosInvalidosServiceException | SiteNaoExisteServiceException | SemPermissaoServiceException e) {
            return tratarException(e, "/");
        }
        return model;
    }

}
