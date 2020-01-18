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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.alldreams.jupiter.base.BaseCommonsController;
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
@Controller("/page")
@RequestMapping("/page")
public class ConteudoController extends BaseCommonsController {

	@Autowired
	private ConteudoService service;

	@GetMapping("/")
	public ModelAndView home() {
		List<ConteudoDTO> conteudos = null;

		final ModelAndView model = new ModelAndView("/site/conteudo");

		try {
			conteudos = this.service.todos();

		} catch (final ErroInternoServiceException e) {
			log.log(Level.SEVERE, "Erro ao carregar a lista", e);
			conteudos = new ArrayList<>();
			model.setStatus(e.getStatus());
		}
		model.addObject("conteudos", conteudos);
		return model;
	}

}
