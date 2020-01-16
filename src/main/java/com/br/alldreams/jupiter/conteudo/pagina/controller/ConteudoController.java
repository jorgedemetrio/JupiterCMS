/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.alldreams.jupiter.base.BaseController;
import com.br.alldreams.jupiter.base.exception.service.ErroInternoServiceException;
import com.br.alldreams.jupiter.conteudo.pagina.dto.ConteudoDTO;
import com.br.alldreams.jupiter.conteudo.pagina.service.ConteudoService;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 06:15:33
 * @version 1.0
 */
@Log
@Controller
public class ConteudoController extends BaseController {

	@Autowired
	private ConteudoService service;

	@GetMapping("/")
	public ModelAndView index() {
		List<ConteudoDTO> materias = null;

		final ModelAndView model = new ModelAndView("materia");

		try {
			materias = this.service.todos();

		} catch (final ErroInternoServiceException e) {
			log.log(Level.SEVERE, "Erro ao carregar a lista", e);
			materias = new ArrayList<>();
			model.setStatus(e.getStatus());
		}
		model.addObject("materias", materias);
		return model;
	}

}
