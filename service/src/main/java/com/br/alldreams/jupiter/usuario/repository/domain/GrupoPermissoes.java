/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 17 de jan de 2020 01:24:10
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_group_permissions")
public class GrupoPermissoes implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2128827259127623190L;

	@EmbeddedId
	private PkGrupoPermissoes id;

	@ManyToOne
	@JoinColumn(name = "id_user_created", insertable = true, updatable = false, nullable = true)
	private Usuario criador;

	@NotEmpty
	@Column(name = "ip_creator", insertable = true, updatable = false, nullable = false, length = 20)
	private String ipCriador;

	@NotNull
	@Column(name = "created_date", insertable = true, updatable = false, nullable = false)
	private Date dataCriacao;

}