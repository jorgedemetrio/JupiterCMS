/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 17 de jan de 2020 01:24:53
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PkGrupoPermissoes implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2897375163672614625L;

	@Enumerated
	@Column(name = "permission", insertable = true, updatable = false, nullable = false, unique = false, length = 200)
	private PermissoesEnum permissao;

	@ManyToOne
	@JoinColumn(name = "id_group", insertable = true, updatable = false, nullable = false, unique = false)
	private Grupo grupo;

}
