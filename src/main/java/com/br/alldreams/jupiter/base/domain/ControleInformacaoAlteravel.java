/**
 *
 */
package com.br.alldreams.jupiter.base.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.br.alldreams.jupiter.usuario.repository.domain.Usuario;

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
public abstract class ControleInformacaoAlteravel extends ControleInformacao {

	@ManyToOne
	@JoinColumn(name = "id_user_altered", insertable = true, updatable = true, nullable = true)
	private Usuario alterador;


	@Column(name = "ip_alterator", insertable = true, updatable = true, nullable = true, length = 20)
	private String ipAlterador;


	@Column(name = "updated_date", insertable = true, updatable = false, nullable = false)
	private Date dataAlteracao;

}
