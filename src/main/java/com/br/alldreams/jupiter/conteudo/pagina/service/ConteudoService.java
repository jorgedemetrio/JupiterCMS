/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.ErroInternoServiceException;
import com.br.alldreams.jupiter.base.exception.service.ItemNaoEncontradoServiceException;
import com.br.alldreams.jupiter.conteudo.pagina.dto.ConteudoDTO;
import com.br.alldreams.jupiter.conteudo.pagina.repository.MateriaRepository;
import com.br.alldreams.jupiter.conteudo.pagina.repository.model.Conteudo;
import com.br.alldreams.jupiter.conteudo.pagina.service.convert.ConteudoConvert;

import lombok.extern.java.Log;

/**
 * @author Jess
 * @since 11 de jan de 2020 02:27:37
 * @version 1.0
 */
@Log
@Service
public class ConteudoService extends BaseService {

	@Autowired
	private MateriaRepository repositorio;

	@Autowired
	private ConteudoConvert materiaConvert;

	public void apagar(final String codigo) throws DadosInvalidosServiceException, ErroInternoServiceException {
		if (Objects.isNull(codigo) || codigo.isEmpty()) {
			throw createException("campos-invalidos", DadosInvalidosServiceException.class, "codigo");
		}
		repositorio.deleteById(codigo);
	}

	public List<ConteudoDTO> buscar(final String titulo)
			throws DadosInvalidosServiceException, ErroInternoServiceException {
		if (Objects.isNull(titulo) || titulo.isEmpty()) {
			throw createException("campos-invalidos", DadosInvalidosServiceException.class, "titulo");
		}
		return materiaConvert.toConteudoDTO(repositorio.findByTitulo(titulo));
	}

	public void gravar(final ConteudoDTO conteudo) throws DadosInvalidosServiceException, ErroInternoServiceException {
		validar(conteudo);
		repositorio.save(materiaConvert.toConteudo(conteudo));
	}

	/**
	 * Com o código tenta localizar uma materia.
	 *
	 * @param codigo Codigo de busca.
	 * @return Retorna uma MateriaDTO.
	 * @throws ItemNaoEncontradoServiceException Se não achar.
	 * @throws ErroInternoServiceException       Erro interno.
	 * @since 12 de jan de 2020 04:11:09
	 */
	public ConteudoDTO pegar(final String codigo)
			throws ItemNaoEncontradoServiceException, ErroInternoServiceException {
		Optional<Conteudo> conteudo;
		try {
			conteudo = repositorio.findById(codigo);
			if (conteudo.isPresent()) {
				return materiaConvert.toConteudoDTO(conteudo.get());
			}
		} catch (final Exception ex) {
			log.log(Level.SEVERE, "Erro ao buscar matérias.", ex);
			throw new ErroInternoServiceException(ex);
		}
		throw createException("nao-encontrado", ItemNaoEncontradoServiceException.class, "Matéria");
	}

	public List<ConteudoDTO> todos() throws ErroInternoServiceException {
		final List<ConteudoDTO> materiasDTO = new ArrayList<>();
		repositorio.findAll().forEach(n -> materiasDTO.add(materiaConvert.toConteudoDTO(n)));
		return materiasDTO;
	}

}
