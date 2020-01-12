/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:11:09
 * @version 1.0
 */
@Data
@Validated
public class MateriaDTO implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 3841592949901815697L;

	private String id;

    @NotEmpty
    @Size(min = 1, max = 200)
    private String titulo;

    @NotEmpty
    @Size(min = 1, max = 200)
    private String nomeArquivo;

    @NotNull
    private ControleDTO controle;

    @NotNull
    private MetaDadosDTO metadados;

    @NotEmpty
    private String materia;

    @NotEmpty
    private String descricao;


    private List<CategoriaDTO> categorias;


    private List<ImagemDTO> imagens;

    private List<String> termos;
}
