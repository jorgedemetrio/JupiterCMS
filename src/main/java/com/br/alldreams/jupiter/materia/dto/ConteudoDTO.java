/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:11:09
 * @version 1.0
 */
@Data
@Validated
public class ConteudoDTO extends BaseConteudoDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2909582859276481664L;


    private String titulo;


	private String conteudo;


	private String destaque;



	private CategoriaDTO categoria;


    private List<ImagemDTO> imagens;


	private List<TermoDTO> termos;
}
