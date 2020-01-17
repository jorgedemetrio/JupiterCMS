/**
 *
 */
package com.br.alldreams.jupiter.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.alldreams.jupiter.base.BaseController;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.ItemNaoEncontradoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SemPermissaoServiceException;
import com.br.alldreams.jupiter.base.exception.service.SiteNaoExisteServiceException;
import com.br.alldreams.jupiter.usuario.service.GrupoService;

/**
 * @author Jorge Demetrio
 * @since 16 de jan de 2020 03:26:51
 * @version 1.0
 */
@RequestMapping("/admin/grupo")
@Controller
public class GrupoAdminController extends BaseController {

	@Autowired
	GrupoService service;

//	@Secured(value = "has(GRUPO_USUARIO_DELETAR)")
	@DeleteMapping("/{id}")
	public ModelAndView deletar(@RequestParam("id") final String id) {
		final ModelAndView model = new ModelAndView("/admin/grupo");
		try {
			service.deletar(id);
		} catch (DadosInvalidosServiceException | ItemNaoEncontradoServiceException | SiteNaoExisteServiceException
				| SemPermissaoServiceException e) {
			return tratarException(e, "/admin/grupo");
		}
		return model;
	}

}
