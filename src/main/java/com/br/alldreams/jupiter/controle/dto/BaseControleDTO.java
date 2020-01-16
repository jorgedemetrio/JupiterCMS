/**
 *
 */
package com.br.alldreams.jupiter.controle.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.alldreams.jupiter.site.dto.SiteDTO;
import com.br.alldreams.jupiter.usuario.dto.UsuarioDTO;

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

	private String id;

	@ManyToOne
	private UsuarioDTO alterador;

	@NotNull
	@ManyToOne
	private UsuarioDTO criador;

	@NotEmpty
	private String versao;


	@NotEmpty
	private String ipCriador;

	@NotEmpty
	private String ipAlterador;

	@Column(name = "altered_date", insertable = true, updatable = true, nullable = true)
	private Date dataAlteracao;

	@NotNull
	private Date dataCriacao;

	@NotNull
	@ManyToOne
	private SiteDTO site;
}
