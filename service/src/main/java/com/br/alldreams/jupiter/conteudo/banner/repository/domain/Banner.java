/**
 *
 */
package com.br.alldreams.jupiter.conteudo.banner.repository.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;
import com.br.alldreams.jupiter.conteudo.categoria.repository.domain.Categoria;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 17 de jan de 2020 17:14:40
 */
@Entity
@Table(name = "tb_banner")
@Data
@Validated
public class Banner extends BaseConteudo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6807339659017733494L;

    @NotEmpty
    @Column(name = "title", insertable = true, updatable = true, nullable = false, length = 200)
    private String titulo;

    @Column(name = "script", insertable = true, updatable = true, nullable = true, length = 200)
    private String stript;

    @Column(name = "printed", insertable = true, updatable = true, nullable = true)
    private Long exibido;

    @Column(name = "exposureLimit", insertable = true, updatable = true, nullable = true)
    private Long limiteExibicao;

    @Column(name = "publish_date", insertable = true, updatable = true, nullable = true)
    private Date dataPublicacao;

    @Column(name = "unpublish_date", insertable = true, updatable = true, nullable = true)
    private Date fimPublicacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_category", insertable = true, updatable = true, nullable = false)
    private Categoria categoria;

}
