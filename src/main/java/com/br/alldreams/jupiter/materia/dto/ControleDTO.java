/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:29:00
 * @version 1.0
 */
@Data
@Validated
public class ControleDTO implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 901403715401729183L;

	private UsuarioDTO alterador;

    @NotNull
    private UsuarioDTO criador;

    @NotEmpty
    private String versao;

    @NotEmpty
    private String ipCriador;

    private String ipAlterador;

    private Date dataAlteracao;

    @NotNull
    private Date dataCriacao;

    @NotEmpty
    private String site;

}
