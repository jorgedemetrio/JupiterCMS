/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.alldreams.jupiter.usuario.repository.model.Usuario;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:05:21
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	/**
	 * Busca o usuário logado pela email (campo de autenticação) e o site que está
	 * logado.
	 *
	 * @param site
	 * @param email
	 * @return
	 * @since 16 de jan de 2020 01:39:03
	 */
	@Query("SELECT u FROM Usuario AS u JOIN u.site AS s WHERE u.email = :email AND s.id = :site AND u.status = 'ATIVO'")
	Usuario buscarUsuario(@Param("site") String site, @Param("email") String email);

	/**
	 * Busca o usuário logado pela email (campo de autenticação) e o site que está
	 * logado.
	 *
	 * @param site
	 * @param email
	 * @return
	 * @since 16 de jan de 2020 01:39:03
	 */
	@Query("SELECT u FROM Usuario AS u JOIN u.site AS s WHERE s.id = :site AND u.email = :email AND u.senha = :senha AND u.status = 'ATIVO'")
	Usuario login(@Param("site") String site, @Param("email") String email, @Param("senha") String senha);
}
