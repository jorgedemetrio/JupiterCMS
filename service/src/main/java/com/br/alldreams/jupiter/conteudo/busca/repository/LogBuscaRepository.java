/**
 *
 */
package com.br.alldreams.jupiter.conteudo.busca.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.alldreams.jupiter.conteudo.busca.repository.domain.LogBusca;

/**
 * @author Jess
 * @version 1.0
 * @since 22 de jan de 2020 06:18:48
 */
public interface LogBuscaRepository extends JpaRepository<LogBusca, UUID> {

    @Query("SELECT g FROM LogBusca as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
    LogBusca pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM LogBusca as g JOIN g.site as s WHERE s.id = :site AND upper(g.titulo) = upper(trim(:titulo + '%'))  AND g.status = 'A' ")
    Page<LogBusca> pegarPorTitulo(@Param("titulo") String titulo, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM LogBusca as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
    Page<LogBusca> todos(@Param("site") UUID site, Pageable paginacao);

}