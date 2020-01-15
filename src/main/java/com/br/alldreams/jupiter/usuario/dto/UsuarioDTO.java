/**
 *
 */
package com.br.alldreams.jupiter.usuario.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.controle.dto.BaseControleDTO;
import com.br.alldreams.jupiter.usuario.repository.model.StatusUsuarioEnum;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:30:23
 * @version 1.0
 */
@Data
@Validated
public class UsuarioDTO extends BaseControleDTO implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = -4070707268829374476L;


    @NotEmpty
    private String nome;

	@NotEmpty
	private String email;


	@NotEmpty
	private String senha;

	@NotEmpty
	private StatusUsuarioEnum status;





}