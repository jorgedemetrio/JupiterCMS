/**
 *
 */
package com.br.alldreams.jupiter.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Jorge Demetrio
 * @since 16 de jan de 2020 03:41:33
 * @version 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class AuthenticationConfig extends WebSecurityConfigurerAdapter {
	private static final String USUARIO_POR_LOGIN = "SELECT name, pass, status FROM tb_usuario WHERE email = ? AND status = 'ATIVO' ";

	private static final String PERMISSOES_POR_USUARIO = "SELECT u.login, p.nome FROM usuario_permissao up"
			+ " JOIN tb_usuario u ON u.id = up.usuarios_id" + " JOIN permissao p ON p.id = up.permissoes_id"
			+ " WHERE u.login = ?";

	private static final String PERMISSOES_POR_GRUPO = "SELECT g.id, g.nome, p.nome FROM grupo_permissao gp"
			+ " JOIN grupo g ON g.id = gp.grupos_id JOIN permissao p ON p.id = gp.permissoes_id"
			+ " JOIN usuario_grupo ug ON ug.grupos_id = g.id" + " JOIN tb_usuario u ON u.id = ug.usuarios_id"
			+ " WHERE u.login = ?";

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(final AuthenticationManagerBuilder builder) throws Exception {
		// System.out.println(new BCryptPasswordEncoder().encode("123"));
		builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
				.usersByUsernameQuery(USUARIO_POR_LOGIN).authoritiesByUsernameQuery(PERMISSOES_POR_USUARIO)
				.groupAuthoritiesByUsername(PERMISSOES_POR_GRUPO).rolePrefix("ROLE_");
	}

}
