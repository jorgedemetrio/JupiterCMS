/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.usuario.repository.model.Grupo;

/**
 * @author Jess
 * @version 1.0
 * @since 16 de jan de 2020 00:33:09
 */
@Repository
public interface GrupoRepository extends JpaRepository<Grupo, String> {

	@Query("SELECT g FROM Grupo as g JOIN s.site as s WHERE s.id = :site AND g.id :id AND g.status = 'ATIVO' ")
	Grupo pegarPorId(@Param("id") String id, @Param("site") String site);

	@Query("SELECT g FROM Grupo as g JOIN s.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'ATIVO' ")
	Page<Grupo> pegarPorNome(@Param("nome") String nome, @Param("site") String site, Pageable paginacao);
}
