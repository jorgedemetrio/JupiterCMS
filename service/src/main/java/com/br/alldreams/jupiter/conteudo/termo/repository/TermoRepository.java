/**
 *
 */
package com.br.alldreams.jupiter.conteudo.termo.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.conteudo.termo.repository.domain.Termo;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 14:02:32
 */
@Repository
public interface TermoRepository extends JpaRepository<Termo, UUID> {

    @Query("SELECT g FROM Termo as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'ATIVO' ")
    Termo pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM Termo as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'ATIVO' ")
    Page<Termo> pegarPorNome(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM Termo as g JOIN g.site as s WHERE s.id = :site AND g.status = 'ATIVO' ")
    Page<Termo> todos(@Param("site") UUID site, Pageable paginacao);

}
