/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

import java.io.Serializable;
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

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.StatusEnum;
import com.br.alldreams.jupiter.site.repository.domain.Site;
import com.br.alldreams.jupiter.usuario.repository.domain.Usuario;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 24 de jan de 2020 19:59:35
 */
@Data
@Validated
@Entity
@Table(name = "tb_price_list_product")
public class TabelaPrecoProduto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6366322402218892508L;



    @Id
    @EmbeddedId
    private PkTabelaPrecoProduto id;

    @NotNull
    @Column(name = "price", insertable = true, updatable = true, nullable = false)
    private Double preco;

    @NotNull
    @Column(name = "minimun", insertable = true, updatable = true, nullable = false)
    private Double quantidadeMinima;

    @NotNull
    @Column(name = "status", insertable = true, updatable = true, nullable = false)
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "id_user_created", insertable = true, updatable = false, nullable = true)
    private Usuario criador;

    @NotEmpty
    @Column(name = "ip_creator", insertable = true, updatable = false, nullable = false, length = 20)
    private String ipCriador;

    @NotNull
    @Column(name = "created_date", insertable = true, updatable = false, nullable = false)
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_site", insertable = true, updatable = false, nullable = true)
    private Site site;

    @ManyToOne
    @JoinColumn(name = "last_version", insertable = true, updatable = false, nullable = true)
    private TabelaDePreco versaoAnterior;
}
