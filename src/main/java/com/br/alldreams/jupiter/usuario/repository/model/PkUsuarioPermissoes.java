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
public class PkUsuarioPermissoes implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 6521705085922829176L;

	@Enumerated
	@Column(name = "permission", insertable = true, updatable = false, nullable = false, unique = false, length = 200)
	private PermissoesEnum permissao;

	@ManyToOne
	@JoinColumn(name = "id_user", insertable = true, updatable = false, nullable = false, unique = false)
	private Usuario usuario;

}
