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
 * @since 11 de jan de 2020 01:47:53
 * @version 1.0
 */
@Data
@Validated
public class CategoriaDTO implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 7489326289986527001L;

	private String id;

    @NotEmpty
    private String nome;

    private List<String> categoriasFilhas;

    private String categoriaPai;

    @NotEmpty
    @Size(min = 1, max = 200)
    private String nomeArquivo;

    @NotNull
    private ControleDTO controle;

    @NotNull
    private MetaDadosDTO metadados;

}
