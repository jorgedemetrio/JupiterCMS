/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:38:21
 * @version 1.0
 */
@Data
@Validated
public class MetaDados implements Serializable {

    /**
    *
    */
    private static final long serialVersionUID = -3555071701298862722L;

    @NotEmpty
    private String desceicao;

    @NotEmpty
    private List<String> palavrasChave;

}
