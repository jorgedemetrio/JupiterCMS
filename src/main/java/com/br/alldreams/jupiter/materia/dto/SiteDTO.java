/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 14 de jan de 2020 22:50:54
 * @version 1.0
 */
@Data
@Validated
public class SiteDTO extends BaseControleDTO implements Serializable {



	/**
	 *
	 */
	private static final long serialVersionUID = -6327137851755539010L;


	@NotEmpty
	private String nome;

	@NotEmpty
	private String dns;

}
