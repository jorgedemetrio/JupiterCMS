/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.alldreams.jupiter.conteudo.cadastro.repository.domain.Estado;

/**
 * @author Jess
 * @version 1.0
 * @since 22 de jan de 2020 07:05:33
 */
public interface EstadoRespository extends JpaRepository<Estado, UUID> {

//    @Query("SELECT g FROM Estado as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
//    Estado pegarPorId(@Param("id") UUID id, @Param("site") UUID site);
//
//    @Query("SELECT g FROM Estado as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'A' ")
//    Page<Estado> pegarPorTitulo(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);
//
//    @Query("SELECT g FROM Estado as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
//    Page<Estado> todos(@Param("site") UUID site, Pageable paginacao);

}