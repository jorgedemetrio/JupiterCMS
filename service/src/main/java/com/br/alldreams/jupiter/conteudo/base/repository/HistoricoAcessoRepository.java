/**
 *
 */
package com.br.alldreams.jupiter.conteudo.base.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.HistoricoAcesso;

/**
 * @author Jess
 * @version 1.0
 * @since 22 de jan de 2020 06:14:33
 */
public interface HistoricoAcessoRepository extends JpaRepository<HistoricoAcesso, UUID> {
//
//    @Query("SELECT g FROM HistoricoAcesso as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
//    HistoricoAcesso pegarPorId(@Param("id") UUID id, @Param("site") UUID site);
//
//    @Query("SELECT g FROM HistoricoAcesso as g JOIN g.site as s WHERE s.id = :site AND upper(g.titulo) = upper(trim(:titulo + '%'))  AND g.status = 'A' ")
//    Page<HistoricoAcesso> pegarPorTitulo(@Param("titulo") String titulo, @Param("site") UUID site, Pageable paginacao);
//
//    @Query("SELECT g FROM HistoricoAcesso as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
//    Page<HistoricoAcesso> todos(@Param("site") UUID site, Pageable paginacao);

}
