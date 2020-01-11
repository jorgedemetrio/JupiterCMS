/**
 *
 */
package com.br.alldreams.jupiter.materia.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.br.alldreams.jupiter.materia.repository.model.Categoria;

/**
 * @author Jess
 * @since 11 de jan de 2020 02:25:49
 * @version 1.0
 */
@EnableScan
public interface CategoriaRepository extends CrudRepository<Categoria, String> {

}
