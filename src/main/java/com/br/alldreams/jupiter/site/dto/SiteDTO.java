/**
 *
 */
package com.br.alldreams.jupiter.site.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.dto.ControleInformacaoAlteravelDTO;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 14 de jan de 2020 22:50:54
 * @version 1.0
 */
@Data
@Validated
public class SiteDTO extends ControleInformacaoAlteravelDTO implements Serializable {



	/**
	 *
	 */
	private static final long serialVersionUID = -6327137851755539010L;


	@NotEmpty
	private String nome;

	@NotEmpty
	private String dns;

}
