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

import com.br.alldreams.jupiter.conteudo.pagina.repository.domain.Pagina;

/**
 * @author Jess
 * @since 11 de jan de 2020 02:14:19
 * @version 1.0
 */
@Repository
public interface PaginaRepository extends JpaRepository<Pagina, UUID> {

    @Query("SELECT g FROM Pagina as g JOIN g.site as s WHERE s.id = :site AND upper(g.titulo) = upper(trim(:titulo + '%'))  AND g.status = 'A' ")
    Page<Pagina> buscaPorTitulo(@Param("titulo") String titulo, @Param("site") UUID site, Pageable paginacao);

    @Query("SELECT g FROM Pagina as g JOIN g.site as s WHERE s.id = :site AND g.id = :id AND g.status = 'A' ")
    Pagina pegarPorId(@Param("id") UUID id, @Param("site") UUID site);

    @Query("SELECT g FROM Pagina as g JOIN g.site as s WHERE s.id = :site AND g.status = 'A' ")
    Page<Pagina> todos(@Param("site") UUID site, Pageable paginacao);

}
