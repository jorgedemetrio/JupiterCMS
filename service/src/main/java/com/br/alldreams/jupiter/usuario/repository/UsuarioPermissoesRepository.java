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
 * @since 21 de jan de 2020 19:25:08
 */
public interface UsuarioPermissoesRepository <UsuarioPermissoes , UUID> {

    @Query("SELECT g FROM UsuarioPermissoes as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
    UsuarioPermissoes pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM UsuarioPermissoes as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'A' ")
    Page<UsuarioPermissoes> pegarPorNome(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM UsuarioPermissoes as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
    Page<UsuarioPermissoes> todos(@Param("site") UUID site, Pageable paginacao);

}



