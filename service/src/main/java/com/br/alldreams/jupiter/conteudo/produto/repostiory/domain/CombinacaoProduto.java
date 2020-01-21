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

import com.br.alldreams.jupiter.site.repository.domain.Site;
import com.br.alldreams.jupiter.usuario.repository.domain.Usuario;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 18:26:40
 */
@Data
@Validated
@Entity
@Table(name = "tb_combination_product")
public class CombinacaoProduto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4381528691214658012L;

    @Id
    @EmbeddedId
    private PkCombinacaoProduto id;

    @NotNull
    @Column(name = "price_item", insertable = true, updatable = true, nullable = false, length = 20)
    private Double precoItemCombinacao;

    @NotNull
    @Column(name = "max_combinations", insertable = true, updatable = true, nullable = false)
    private Double maxCombination;

    @NotNull
    @Column(name = "min_combinations", insertable = true, updatable = true, nullable = false)
    private Double minCombination;

    @ManyToOne
    @JoinColumn(name = "id_user_altered", insertable = true, updatable = true, nullable = true)
    private Usuario alterador;

    @Column(name = "ip_alterator", insertable = true, updatable = true, nullable = true, length = 20)
    private String ipAlterador;

    @Column(name = "updated_date", insertable = true, updatable = false, nullable = false)
    private Date dataAlteracao;

    @ManyToOne
    @JoinColumn(name = "id_user_created", insertable = true, updatable = false, nullable = true)
    private Usuario criador;

    @NotEmpty
    @Column(name = "version", insertable = true, updatable = true, nullable = false, length = 250)
    private String versao;

    @NotEmpty
    @Column(name = "ip_creator", insertable = true, updatable = false, nullable = false, length = 20)
    private String ipCriador;

    @NotNull
    @Column(name = "created_date", insertable = true, updatable = false, nullable = false)
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_site", insertable = true, updatable = false, nullable = true)
    private Site site;
}
