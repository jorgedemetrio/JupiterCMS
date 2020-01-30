/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 30 de jan de 2020 00:12:27
 * @version 1.0
 */
@Data
@Validated
@Entity
@Table(name = "tb_cart")
public class Carrinho extends BaseConteudo {


    /**
     *
     */
    private static final long serialVersionUID = 2506757242215016047L;


    @Size(min = 1, max = 200)
    @Column(name = "promotion", insertable = true, updatable = true, nullable = true, length = 200)
    private String codigoPromocional;

}
