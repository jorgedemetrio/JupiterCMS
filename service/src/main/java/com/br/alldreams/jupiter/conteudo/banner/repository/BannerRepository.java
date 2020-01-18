/**
 *
 */
package com.br.alldreams.jupiter.conteudo.banner.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.alldreams.jupiter.conteudo.banner.repository.domain.Banner;

/**
 * @author Jess
 * @version 1.0
 * @since 18 de jan de 2020 19:12:24
 */
public interface BannerRepository extends JpaRepository<Banner, UUID> {

    @Query("SELECT g FROM Banner as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'ATIVO' ")
    Banner pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM Banner as g JOIN g.site as s WHERE s.id = :site AND upper(g.nome) = upper(trim(:nome + '%'))  AND g.status = 'ATIVO' ")
    Page<Banner> pegarPorNome(@Param("nome") String nome, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM Banner as g JOIN g.site as s WHERE s.id = :site AND g.status = 'ATIVO' ")
    Page<Banner> todos(@Param("site") UUID site, Pageable paginacao);

}
