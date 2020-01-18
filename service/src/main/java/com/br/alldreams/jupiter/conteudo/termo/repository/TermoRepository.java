/**
 *
 */
package com.br.alldreams.jupiter.conteudo.termo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.conteudo.termo.repository.domain.Termo;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 14:02:32
 */
@Repository
public interface TermoRepository extends JpaRepository<Termo, UUID> {

}
