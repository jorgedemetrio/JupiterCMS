/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jess
 * @since 11 de jan de 2020 02:05:26
 * @version 1.0
 */
@Data
@Validated
public class ImagemDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6911774040915872345L;

	@NotEmpty
    private String endereco;

    private String desricao;

    @NotNull
    private Boolean destaque;

}
