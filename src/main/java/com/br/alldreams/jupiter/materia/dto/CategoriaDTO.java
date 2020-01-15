/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
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
public class CategoriaDTO extends BaseConteudoDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7965042967393910325L;



    @NotEmpty
    @Size(min = 1, max = 200)
    private String nome;

	@OneToMany(mappedBy = "pai")
	private List<CategoriaDTO> filhas;

	@ManyToOne
	private CategoriaDTO pai;



}
