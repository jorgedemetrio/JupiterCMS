/**
 *
 */
package com.br.alldreams.jupiter.base.dto;

import java.util.Date;

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
public abstract class ControleInformacaoAlteravelDTO extends ControleInformacaoDTO {

    private UsuarioDTO alterador;

    private String ipAlterador;

    private Date dataAlteracao;

}
