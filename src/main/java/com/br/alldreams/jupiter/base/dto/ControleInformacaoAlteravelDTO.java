/**
 *
 */
package com.br.alldreams.jupiter.base.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.br.alldreams.jupiter.site.dto.SiteDTO;
import com.br.alldreams.jupiter.usuario.dto.UsuarioDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jorge Demetrio
 * @since 15 de jan de 2020 00:32:59
 * @version 1.0
 */
@Getter
@Setter
public abstract class ControleInformacaoAlteravelDTO {



    private UsuarioDTO alterador;

	private String id;

	private String ipAlterador;

    private Date dataAlteracao;

    @NotNull
    private SiteDTO site;
}
