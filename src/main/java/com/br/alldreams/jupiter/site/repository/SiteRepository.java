/**
 *
 */
package com.br.alldreams.jupiter.site.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.site.repository.model.Site;

/**
 * @author Jorge Demetrio
 * @since 16 de jan de 2020 01:23:20
 * @version 1.0
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, String> {

	@Query("SELECT s FROM Site as s WHERE upper(s.dns) =  upper(trim(:site)) AND s.status = 'ATIVO' ")
	Site descobrirSiteAtivoPorURL(@Param("site") String site);

	@Query("SELECT s FROM Site as s WHERE s.id = :id AND s.status = 'ATIVO' ")
	Site pegarAtivo(@Param("id") String id);

	@Query("SELECT s FROM Site as s WHERE upper(s.nome) like  upper(trim(:nome + '%')) AND s.status = 'ATIVO' ")
	Page<Site> pegarPorNome(@Param("nome") String nome, Pageable paginacao);
}
