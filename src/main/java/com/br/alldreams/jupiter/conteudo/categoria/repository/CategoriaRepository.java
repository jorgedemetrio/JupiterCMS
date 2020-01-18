/**
 *
 */
package com.br.alldreams.jupiter.conteudo.categoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.conteudo.categoria.repository.domain.Categoria;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 17 de jan de 2020 17:06:43
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String> {

}
