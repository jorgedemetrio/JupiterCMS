/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 20:14:21
 */
@Data
@Validated
@Entity
@Table(name = "tb_product_param")
public class ParametroProduto extends ControleInformacaoAlteravel {

    /**
     *
     */
    private static final long serialVersionUID = -4745293986678480165L;

    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

    @NotNull
    @Column(name = "required", insertable = true, updatable = true, nullable = false)
    private Boolean requerido;

    @NotNull
    @Column(name = "use_search_simples", insertable = true, updatable = true, nullable = false)
    private Boolean usarBuscaSimples;

    @NotNull
    @Column(name = "use_search_advance", insertable = true, updatable = true, nullable = false)
    private Boolean usarBuscaAdvance;

    @NotNull
    @Column(name = "show_ongrid", insertable = true, updatable = true, nullable = false)
    private Boolean mostrarGrid;

    @NotNull
    @Column(name = "show_productpage", insertable = true, updatable = true, nullable = false)
    private Boolean mostrarProduto;
}
