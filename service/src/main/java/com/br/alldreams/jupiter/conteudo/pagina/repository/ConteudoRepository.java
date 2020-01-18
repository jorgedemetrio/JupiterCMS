/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.conteudo.pagina.repository.domain.Conteudo;
import com.br.alldreams.jupiter.usuario.repository.domain.Grupo;

/**
 * @author Jess
 * @since 11 de jan de 2020 02:14:19
 * @version 1.0
 */
@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, UUID> {

    @Query("SELECT g FROM Conteudo as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'ATIVO' ")
    Conteudo pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM Conteudo as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'ATIVO' ")
    Page<Grupo> pegarPorNome(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM Conteudo as g JOIN g.site as s WHERE s.id = :site AND g.status = 'ATIVO' ")
    Page<Conteudo> todos(@Param("site") UUID site, Pageable paginacao);
}
