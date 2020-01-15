/**
 *
 */
package com.br.alldreams.jupiter.materia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.materia.repository.model.Conteudo;


/**
 * @author Jess
 * @since 11 de jan de 2020 02:14:19
 * @version 1.0
 */
@Repository
public interface MateriaRepository extends CrudRepository<Conteudo, String> {

    List<Conteudo> findByTitulo(final String titulo);
}
