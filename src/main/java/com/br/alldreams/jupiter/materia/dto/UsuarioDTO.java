/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:30:23
 * @version 1.0
 */
@Data
@Validated
public class UsuarioDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6475594391636433676L;

	@NotEmpty
    private String nome;

    @NotEmpty
    private String id;

}
