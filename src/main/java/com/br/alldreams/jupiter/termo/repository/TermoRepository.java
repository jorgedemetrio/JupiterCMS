/**
 *
 */
package com.br.alldreams.jupiter.termo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.termo.repository.model.Termo;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 14:02:32
 */
@Repository
public interface TermoRepository extends JpaRepository<Termo, String> {

}
