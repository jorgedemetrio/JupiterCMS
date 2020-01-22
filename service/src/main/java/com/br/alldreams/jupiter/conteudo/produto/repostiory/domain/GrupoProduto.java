/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 20:03:58
 */
@Data
@Validated
@Entity
@Table(name = "tb_group_product")
public class GrupoProduto extends BaseConteudo {

    /**
     *
     */
    private static final long serialVersionUID = -133757938623973656L;

    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

}
