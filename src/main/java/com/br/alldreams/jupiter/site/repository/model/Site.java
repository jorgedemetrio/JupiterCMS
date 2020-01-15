/**
 *
 */
package com.br.alldreams.jupiter.site.repository.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.controle.repository.model.ControleInformacaoAlteravel;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 14 de jan de 2020 22:50:54
 * @version 1.0
 */
@Data
@Validated
@Entity
@Table(name = "tb_site")
public class Site extends ControleInformacaoAlteravel implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3769857701895659927L;

	@NotEmpty
	@Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
	private String nome;

	@NotEmpty
	@Column(name = "dns", insertable = true, updatable = true, nullable = false, length = 200)
	private String dns;

}
