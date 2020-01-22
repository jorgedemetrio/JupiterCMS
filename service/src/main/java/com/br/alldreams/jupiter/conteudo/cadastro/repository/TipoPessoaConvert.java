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

/**
 * @author Jess
 * @version 1.0
 * @since 22 de jan de 2020 06:22:27
 */
public interface TipoPessoaConvert extends JpaRepository<TipoPessoaConvert, UUID> {

    @Query("SELECT g FROM TipoPessoaConvert as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
    TipoPessoaConvert pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM TipoPessoaConvert as g JOIN g.site as s WHERE s.id = :site AND upper(g.titulo) = upper(trim(:titulo + '%'))  AND g.status = 'A' ")
    Page<TipoPessoaConvert> pegarPorTitulo(@Param("titulo") String titulo, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM TipoPessoaConvert as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
    Page<TipoPessoaConvert> todos(@Param("site") UUID site, Pageable paginacao);

}