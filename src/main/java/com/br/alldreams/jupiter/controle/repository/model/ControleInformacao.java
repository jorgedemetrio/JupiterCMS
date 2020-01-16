/**
 *
 */
package com.br.alldreams.jupiter.controle.repository.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.alldreams.jupiter.site.repository.model.Site;
import com.br.alldreams.jupiter.usuario.repository.model.Usuario;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jorge Demetrio
 * @since 15 de jan de 2020 00:32:59
 * @version 1.0
 */
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ControleInformacao {

	@Id
	@Column(name = "id", insertable = true, updatable = false, nullable = false, length = 200)
	private String id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_user_created", insertable = true, updatable = false, nullable = false)
	private Usuario criador;

	@NotEmpty
	@Column(name = "version", insertable = true, updatable = true, nullable = false, length = 250)
	private String versao;

	@NotEmpty
	@Column(name = "ip_creator", insertable = true, updatable = false, nullable = false, length = 20)
	private String ipCriador;

	@NotNull
	@Column(name = "created_date", insertable = true, updatable = false, nullable = false)
	private Date dataCriacao;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_site", insertable = true, updatable = false, nullable = false)
	private Site site;
}
