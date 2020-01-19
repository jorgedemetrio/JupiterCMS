/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.base.dto.BaseConteudoDTO;
import com.br.alldreams.jupiter.conteudo.categoria.dto.CategoriaDTO;
import com.br.alldreams.jupiter.conteudo.termo.dto.TermoDTO;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:11:09
 * @version 1.0
 */
@Data
@Validated
public class PaginaDTO extends BaseConteudoDTO implements Serializable {

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
