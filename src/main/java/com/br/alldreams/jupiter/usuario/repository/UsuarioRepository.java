/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.usuario.repository.model.Usuario;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:05:21
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Page<Usuario> findByNome(String nome, Pageable paginacao);

}
