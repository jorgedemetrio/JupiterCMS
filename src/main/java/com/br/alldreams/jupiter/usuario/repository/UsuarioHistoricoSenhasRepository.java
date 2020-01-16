/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.usuario.repository.model.UsuarioHistoricoSenhas;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:05:21
 */
@Repository
public interface UsuarioHistoricoSenhasRepository extends JpaRepository<UsuarioHistoricoSenhas, String> {

}
