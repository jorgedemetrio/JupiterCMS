/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jorge Demetrio
 * @since 15 de jan de 2020 00:32:59
 * @version 1.0
 */
@Getter
@Setter
public abstract class BaseControleDTO {

	@ManyToOne
	@JoinColumn(name = "id_user_altered", insertable = true, updatable = true, nullable = true)
	private UsuarioDTO alterador;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_user_created", insertable = true, updatable = false, nullable = false)
	private UsuarioDTO criador;

	@NotEmpty
	@Column(name = "version", insertable = true, updatable = true, nullable = false, length = 250)
	private String versao;


	@NotEmpty
	@Column(name = "ip_creator", insertable = true, updatable = false, nullable = false, length = 20)
	private String ipCriador;

	@NotEmpty
	@Column(name = "ip_alterator", insertable = true, updatable = true, nullable = true, length = 20)
	private String ipAlterador;

	@Column(name = "altered_date", insertable = true, updatable = true, nullable = true)
	private Date dataAlteracao;

	@NotNull
	@Column(name = "created_date", insertable = true, updatable = false, nullable = false)
	private Date dataCriacao;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_site", insertable = true, updatable = false, nullable = false)
	private SiteDTO site;
}
