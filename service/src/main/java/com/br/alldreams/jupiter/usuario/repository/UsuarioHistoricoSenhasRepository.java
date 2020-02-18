/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.usuario.repository.domain.HistoricoSenhaUsuario;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:05:21
 */
@Repository
public interface UsuarioHistoricoSenhasRepository extends JpaRepository<HistoricoSenhaUsuario, Long> {

//    @Query("SELECT g FROM HistoricoSenhaUsuario as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
//    HistoricoSenhaUsuario pegarPorId(@Param("id") Long id, @Param("site") UUID site);
//
//    @Query("SELECT g FROM HistoricoSenhaUsuario as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'A' ")
//    Page<HistoricoSenhaUsuario> pegarPorNome(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);
//
//    @Query("SELECT g FROM HistoricoSenhaUsuario as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
//    Page<HistoricoSenhaUsuario> todos(@Param("site") UUID site, Pageable paginacao);

}