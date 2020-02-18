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

import com.br.alldreams.jupiter.conteudo.cadastro.repository.domain.EmailPessoa;

/**
 * @author Jess
 * @version 1.0
 * @since 22 de jan de 2020 06:57:08
 */
public interface EmailPessoaRepository extends JpaRepository<EmailPessoa, UUID> {

    @Query("SELECT g FROM EmailPessoa as g JOIN g.site as s WHERE s.id = :site AND upper(g.email) = upper(trim(:email + '%'))  AND g.status = 'A' ")
    Page<EmailPessoa> pegarPorEmail(@Param("email") String email, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM EmailPessoa as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
    EmailPessoa pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM EmailPessoa as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
    Page<EmailPessoa> todos(@Param("site") UUID site, Pageable paginacao);

}