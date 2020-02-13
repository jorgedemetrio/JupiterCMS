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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @since 30 de jan de 2020 00:30:53
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Validated
public class PkProdutoCarrinho implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8943652020106054397L;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_product", insertable = true, updatable = false, nullable = false)
    private Produto produto;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_cart", insertable = true, updatable = false, nullable = false)
    private Carrinho carrinho;
}
