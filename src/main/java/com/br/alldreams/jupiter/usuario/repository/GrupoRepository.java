/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.usuario.repository.model.Grupo;

/**
 * @author Jess
 * @version 1.0
 * @since 16 de jan de 2020 00:33:09
 */
@Repository
public interface GrupoRepository extends JpaRepository<Grupo, String> {

    Page<Grupo> findByNome(final String nome, final Pageable paginacao);
}
