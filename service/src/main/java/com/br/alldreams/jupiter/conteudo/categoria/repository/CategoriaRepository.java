/**
 *
 */
package com.br.alldreams.jupiter.conteudo.categoria.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.conteudo.categoria.repository.domain.Categoria;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 17 de jan de 2020 17:06:43
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

    @Query("SELECT g FROM Categoria as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'ATIVO' ")
    Categoria pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM Categoria as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'ATIVO' ")
    Page<Categoria> pegarPorNome(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM Grupo as g JOIN g.site as s WHERE s.id = :site AND g.status = 'ATIVO' ")
    Page<Categoria> todos(@Param("site") UUID site, Pageable paginacao);

}
