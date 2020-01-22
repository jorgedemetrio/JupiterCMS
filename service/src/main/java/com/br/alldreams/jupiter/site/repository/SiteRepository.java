/**
 *
 */
package com.br.alldreams.jupiter.site.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.site.repository.domain.Site;

/**
 * @author Jorge Demetrio
 * @since 16 de jan de 2020 01:23:20
 * @version 1.0
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, UUID> {

    @Query("SELECT s FROM Site as s WHERE upper(s.dns) =  upper(trim(:site)) AND s.status = 'A' ")
    Site descobrirSiteAtivoPorURL(@Param("site") String site);

    @Query("SELECT s FROM Site as s WHERE s.id = :id AND s.status = 'A' ")
    Site pegarAtivo(@Param("id") UUID id);

    @Query("SELECT s FROM Site as s WHERE upper(s.nome) like  upper(trim(:nome + '%')) AND s.status = 'A' ")
    Page<Site> pegarPorNome(@Param("nome") String nome, Pageable paginacao);
}
