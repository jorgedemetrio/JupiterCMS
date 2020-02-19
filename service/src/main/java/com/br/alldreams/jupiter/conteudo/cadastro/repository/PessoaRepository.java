/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.alldreams.jupiter.conteudo.cadastro.repository.domain.Pessoa;

/**
 * @author Jess
 * @version 1.0
 * @since 22 de jan de 2020 07:08:32
 */
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

    @Query("SELECT g FROM Pessoa as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
    Pessoa pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM Pessoa as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'A' ")
    Page<Pessoa> pegarPorNome(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM Pessoa as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
    Page<Pessoa> todos(@Param("site") UUID site, Pageable paginacao);

}