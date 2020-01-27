/**
 *
 */
package com.br.alldreams.jupiter.conteudo.base.repository.domain;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.pagina.repository.domain.TipoImagemEnum;

import lombok.Data;

/**
 * @author Jess
 * @since 11 de jan de 2020 02:05:26
 * @version 1.0
 */
@Data
@Validated
public class Imagem implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4171170971866403033L;

    @NotEmpty
    private String endereco;

    private String desricao;

    @NotNull
    private Boolean destaque;

    @NotNull
    private TipoImagemEnum tipo;

}
