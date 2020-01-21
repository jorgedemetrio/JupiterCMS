/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Jess
 * @version 1.0
 * @since 21 de jan de 2020 11:59:13
 */
public interface GrupoPermissoesRepository<GrupoPermissoes, UUID> {

    @Query("SELECT g FROM GrupoPermissoes as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
    GrupoPermissoes pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM GrupoPermissoes as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'A' ")
    Page<GrupoPermissoes> pegarPorNome(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM GrupoPermissoes as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
    Page<GrupoPermissoes> todos(@Param("site") UUID site, Pageable paginacao);

}
