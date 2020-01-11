/**
 *
 */
package com.br.alldreams.jupiter.materia.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.br.alldreams.jupiter.materia.repository.model.Materia;

/**
 * @author Jess
 * @since 11 de jan de 2020 02:14:19
 * @version 1.0
 */
@EnableScan
public interface MateriaRepository extends CrudRepository<Materia, String> {

    public List<Materia> findByTitulo(final String titulo);
}
