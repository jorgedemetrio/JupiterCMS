/**
 *
 */
package com.br.alldreams.jupiter.usuario.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.controle.dto.ControleInformacaoAlteravelDTO;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:10:45
 */
@Data
@Validated
public class GrupoDTO extends ControleInformacaoAlteravelDTO implements Serializable {

    private String nome;
    private List<GrupoDTO> filhas;

    private GrupoDTO pai;

}
