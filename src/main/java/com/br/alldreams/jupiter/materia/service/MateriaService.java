/**
 *
 */
package com.br.alldreams.jupiter.materia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;

import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.exception.service.ErroInternoServiceException;
import com.br.alldreams.jupiter.base.exception.service.ItemNaoEncontradoServiceException;
import com.br.alldreams.jupiter.materia.dto.MateriaDTO;
import com.br.alldreams.jupiter.materia.repository.MateriaRepository;
import com.br.alldreams.jupiter.materia.repository.model.Materia;
import com.br.alldreams.jupiter.materia.service.convert.MateriaConvert;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

/**
 * @author Jess
 * @since 11 de jan de 2020 02:27:37
 * @version 1.0
 */
@Log
@RequiredArgsConstructor
@Service
public class MateriaService extends BaseService {

	private final MateriaRepository repositorio;

	private final MateriaConvert materiaConvert;

	public void apagar(final String codigo) throws DadosInvalidosServiceException, ErroInternoServiceException {
		if (Objects.isNull(codigo) || codigo.isEmpty()) {
			throw createException("campos-invalidos", DadosInvalidosServiceException.class, "codigo");
		}
		repositorio.deleteById(codigo);
	}

	public List<MateriaDTO> buscar(final String titulo)
			throws DadosInvalidosServiceException, ErroInternoServiceException {
		if (Objects.isNull(titulo) || titulo.isEmpty()) {
			throw createException("campos-invalidos", DadosInvalidosServiceException.class, "titulo");
		}
		return materiaConvert.toMateriaDTO(repositorio.findByTitulo(titulo));
	}

	public void gravar(final MateriaDTO materia) throws DadosInvalidosServiceException, ErroInternoServiceException {
		validar(materia);
		repositorio.save(materiaConvert.toMateria(materia));
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
	public MateriaDTO pegar(final String codigo) throws ItemNaoEncontradoServiceException, ErroInternoServiceException {
		Optional<Materia> materia;
		try {
			materia = repositorio.findById(codigo);
			if (materia.isPresent()) {
				return materiaConvert.toMateriaDTO(materia.get());
			}
		} catch (final Exception ex) {
			log.log(Level.SEVERE, "Erro ao buscar matérias.", ex);
			throw new ErroInternoServiceException(ex);
		}
		throw createException("nao-encontrado", ItemNaoEncontradoServiceException.class, "Matéria");
	}

	public List<MateriaDTO> todos() throws ErroInternoServiceException {
		final List<MateriaDTO> materiasDTO = new ArrayList<>();
		repositorio.findAll().forEach(n -> materiasDTO.add(materiaConvert.toMateriaDTO(n)));
		return materiasDTO;
	}

}
