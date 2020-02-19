/**
 *
 */
package com.br.alldreams.jupiter.conteudo.enquete.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.alldreams.jupiter.conteudo.enquete.repository.domain.RespostaEnquete;

/**
 * @author Jess
 * @version 1.0
 * @since 22 de jan de 2020 07:18:52
 */
public interface RespostaEnqueteRepository extends JpaRepository<RespostaEnquete, UUID> {

    @Query("SELECT g FROM RespostaEnquete as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
    RespostaEnquete pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM RespostaEnquete as g JOIN g.site as s WHERE s.id = :site AND upper(g.reposta) = upper(trim(:reposta + '%'))  AND g.status = 'A' ")
    Page<RespostaEnquete> pegarPorReposta(@Param("reposta") String reposta, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM RespostaEnquete as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
    Page<RespostaEnquete> todos(@Param("site") UUID site, Pageable paginacao);

}