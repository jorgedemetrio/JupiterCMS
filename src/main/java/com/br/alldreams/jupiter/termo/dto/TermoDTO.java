/**
 *
 */
package com.br.alldreams.jupiter.termo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.dto.BaseConteudoDTO;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:47:53
 * @version 1.0
 */
@Data
@Validated
public class TermoDTO extends BaseConteudoDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1678668533717716459L;

    private String id;

    @NotEmpty
    private String nome;



}
