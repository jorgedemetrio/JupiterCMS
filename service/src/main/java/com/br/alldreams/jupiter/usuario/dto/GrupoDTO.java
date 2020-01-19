/**
 *
 */
package com.br.alldreams.jupiter.usuario.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.StatusEnum;
import com.br.alldreams.jupiter.base.dto.ControleInformacaoAlteravelDTO;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:10:45
 */
@Data
@Validated
public class GrupoDTO extends ControleInformacaoAlteravelDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6019899438890842520L;

    @NotEmpty
    @Size(min = 1, max = 200)
    private String nome;

    private List<GrupoDTO> filhas;

    private GrupoDTO pai;

	private StatusEnum status;

}
