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
@Table(name = "tb_association_product")
public class AssociacaoProduto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4381528691214658012L;

    @Id
    @EmbeddedId
    private PkAssociacaoProduto id;

    @NotNull
    @Column(name = "order", insertable = true, updatable = false, nullable = false)
    private Integer ordem;

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
