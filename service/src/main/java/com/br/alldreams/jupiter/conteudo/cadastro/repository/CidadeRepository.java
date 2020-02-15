/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.alldreams.jupiter.conteudo.cadastro.repository.domain.Cidade;

/**
 * @author Jess
 * @version 1.0
 * @since 22 de jan de 2020 06:28:09
 */
public interface CidadeRepository extends JpaRepository<Cidade, UUID> {

//    @Query("SELECT g FROM Cidade as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
//    Cidade pegarPorId(@Param("id") UUID id, @Param("site") UUID site);
//
//    @Query("SELECT g FROM Cidade as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'A' ")
//    Page<Cidade> pegarPorTitulo(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);
//
//    @Query("SELECT g FROM Cidade as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
//    Page<Cidade> todos(@Param("site") UUID site, Pageable paginacao);

}