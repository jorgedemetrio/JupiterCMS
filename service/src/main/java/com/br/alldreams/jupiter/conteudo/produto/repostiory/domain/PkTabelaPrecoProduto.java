/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 24 de jan de 2020 20:00:13
 */
@Validated
@Data
@Embeddable
public class PkTabelaPrecoProduto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5517879188331941883L;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_prince_liest", insertable = true, updatable = false, nullable = false)
    private TabelaDePreco tabelaPreco;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_product", insertable = true, updatable = false, nullable = false)
    private Produto produto;

}
