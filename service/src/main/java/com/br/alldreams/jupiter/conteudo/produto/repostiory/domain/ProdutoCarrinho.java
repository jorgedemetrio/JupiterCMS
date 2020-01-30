/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.StatusConteudoEnum;
import com.br.alldreams.jupiter.site.repository.domain.Site;
import com.br.alldreams.jupiter.usuario.repository.domain.Usuario;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 18:03:06
 */
@Data
@Validated
@Entity
@Table(name = "tb_product_cart")
public class ProdutoCarrinho {

    /**
     *
     */
    private static final long serialVersionUID = 6091800854981711237L;

    @Id
    @EmbeddedId
    private PkProdutoCarrinho id;

    @ManyToOne
    @JoinColumn(name = "id_user_created", insertable = true, updatable = false, nullable = true)
    private Usuario criador;

    @notn
    @Column(name = "quantity", insertable = true, updatable = true, nullable = false)
    private Long quantidade;

    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

    @Column(name = "description", insertable = true, updatable = true, nullable = true, length = 2000)
    private String descricao;

    @NotEmpty
    @Column(name = "sku", insertable = true, updatable = true, nullable = false)
    private String sku;


    @NotEmpty
    @Column(name = "ip_creator", insertable = true, updatable = false, nullable = false, length = 20)
    private String ipCriador;

    @NotNull
    @Column(name = "created_date", insertable = true, updatable = false, nullable = false)
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_site", insertable = true, updatable = false, nullable = true)
    private Site site;

    @NotNull
    @Column(name = "price", insertable = true, updatable = true, nullable = false)
    private Double preco;

    @NotNull
    @Column(name = "promotional_price", insertable = true, updatable = true, nullable = false)
    private Double precoPromocional;


    @NotNull
    @Column(name = "status", insertable = true, updatable = true, nullable = false, length = 1)
    private StatusConteudoEnum status;

}
