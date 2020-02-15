/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.alldreams.jupiter.usuario.repository.domain.GrupoPermissoes;

/**
 * @author Jess
 * @version 1.0
 * @since 22 de jan de 2020 06:11:16
 */
public interface GrupoPermissoesRepository extends JpaRepository<GrupoPermissoes, UUID> {
//
//    @Query("SELECT g FROM GrupoPermissoes as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
//    GrupoPermissoes pegarPorId(@Param("id") UUID id, @Param("site") UUID site);
//
//    @Query("SELECT g FROM GrupoPermissoes as g JOIN g.site as s WHERE s.id = :site AND upper(g.titulo) = upper(trim(:titulo + '%'))  AND g.status = 'A' ")
//    Page<GrupoPermissoes> pegarPorTitulo(@Param("titulo") String titulo, @Param("site") UUID site, Pageable paginacao);
//
//    @Query("SELECT g FROM GrupoPermissoes as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
//    Page<GrupoPermissoes> todos(@Param("site") UUID site, Pageable paginacao);

}
