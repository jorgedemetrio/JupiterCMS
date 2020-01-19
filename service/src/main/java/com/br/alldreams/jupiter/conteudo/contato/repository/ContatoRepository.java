/**
 *
 */
package com.br.alldreams.jupiter.conteudo.contato.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.alldreams.jupiter.conteudo.contato.repository.domain.Contato;
import com.br.alldreams.jupiter.usuario.repository.domain.Grupo;

/**
 * @author Jess
 * @version 1.0
 * @since 18 de jan de 2020 19:23:29
 */
public interface ContatoRepository extends JpaRepository<Contato, UUID> {

    @Query("SELECT g FROM Contato as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
    Grupo pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM Contato as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'A' ")
    Page<Contato> pegarPorNome(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM Contato as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
    Page<Contato> todos(@Param("site") UUID site, Pageable paginacao);

}
