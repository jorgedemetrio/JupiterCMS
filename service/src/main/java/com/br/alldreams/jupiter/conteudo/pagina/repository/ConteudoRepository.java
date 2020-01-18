/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.conteudo.pagina.repository.domain.Conteudo;


/**
 * @author Jess
 * @since 11 de jan de 2020 02:14:19
 * @version 1.0
 */
@Repository
public interface ConteudoRepository extends CrudRepository<Conteudo, String> {

    List<Conteudo> findByTitulo(final String titulo);
}
