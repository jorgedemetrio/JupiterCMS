/**
 *
 */
package com.br.alldreams.jupiter.materia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.alldreams.jupiter.base.BaseController;
import com.br.alldreams.jupiter.base.exception.service.ErroInternoServiceException;
import com.br.alldreams.jupiter.materia.dto.MateriaDTO;
import com.br.alldreams.jupiter.materia.service.MateriaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 06:15:33
 * @version 1.0
 */
@Log
@Controller
@RequiredArgsConstructor
public class MateriaController extends BaseController {

	private final MateriaService service;

	@GetMapping("/")
	public ModelAndView index() {
		List<MateriaDTO> materias = null;

		final ModelAndView model = new ModelAndView("materia");

		try {
			materias = service.todos();

		} catch (final ErroInternoServiceException e) {
			log.log(Level.SEVERE, "Erro ao carregar a lista", e);
			materias = new ArrayList<>();
			model.setStatus(e.getStatus());
		}
		model.addObject("materias", materias);
		return model;
	}

}
