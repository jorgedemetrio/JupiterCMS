/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:05:21
 */
@Repository
public interface UsuarioHistoricoSenhasRepository extends JpaRepository<UsuarioHistoricoSenhasRepository, Long> {

    @Query("SELECT g FROM UsuarioHistoricoSenhasRepository as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
    UsuarioHistoricoSenhasRepository pegarPorId(@Param("id") Long id, @Param("site") UUID site);

    @Query("SELECT g FROM UsuarioHistoricoSenhasRepository as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'A' ")
    Page<UsuarioHistoricoSenhasRepository> pegarPorNome(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM UsuarioHistoricoSenhasRepository as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
    Page<UsuarioHistoricoSenhasRepository> todos(@Param("site") UUID site, Pageable paginacao);

}