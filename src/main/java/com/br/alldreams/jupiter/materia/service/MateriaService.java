/**
 *
 */
package com.br.alldreams.jupiter.materia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.materia.repository.MateriaRepository;
import com.br.alldreams.jupiter.materia.repository.model.Materia;

import lombok.RequiredArgsConstructor;

/**
 * @author Jess
 * @since 11 de jan de 2020 02:27:37
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class MateriaService {

    private final MateriaRepository repositorio;

    public void gravar(final Materia materia) {
        repositorio.save(materia);
    }

    public Materia pegar(final String codigo) {
        final Optional<Materia> materia = repositorio.findById(codigo);
        return materia.get();
    }

    public void apagar(final String codigo) {
        repositorio.deleteById(codigo);
    }

    public List<Materia> buscar(final String titulo) {
        return repositorio.findByTitulo(titulo);
    }

}
