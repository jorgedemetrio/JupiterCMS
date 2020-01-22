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
 * @since 21 de jan de 2020 18:26:55
 */
@Validated
@Data
@Embeddable
public class PkAssociacaoProduto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5170731476161033865L;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_product_paret", insertable = true, updatable = false, nullable = false)
    private Produto produtoPrincipal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_product", insertable = true, updatable = false, nullable = false)
    private Produto combinacao;

}
