/**
 *
 */
package com.br.alldreams.jupiter.conteudo.enquete.repository.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;
import com.br.alldreams.jupiter.conteudo.categoria.repository.domain.Categoria;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 01:50:01
 * @version 1.0
 */
@Entity
@Table(name = "tb_survey")
@Data
@Validated
public class Enquete extends BaseConteudo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -722765617002188406L;

    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "question", insertable = true, updatable = true, nullable = false, length = 200)
    private String pergunta;

    @Column(name = "printed", insertable = true, updatable = true, nullable = true)
    private Long exibido;

    @Column(name = "exposureLimit", insertable = true, updatable = true, nullable = true)
    private Long limiteExibicao;

    @Column(name = "publish_date", insertable = true, updatable = true, nullable = true)
    private Date dataPublicacao;

    @Column(name = "unpublish_date", insertable = true, updatable = true, nullable = true)
    private Date fimPublicacao;

    @NotNull
    @Column(name = "single_vote", insertable = true, updatable = true, nullable = false)
    private Boolean unicoVoto;

    @NotNull
    @Column(name = "just_logued_vote", insertable = true, updatable = true, nullable = false)
    private Boolean somenteLogadoVota;

    @NotNull
    @Column(name = "show_results", insertable = true, updatable = true, nullable = false)
    private Boolean mostrarResultado;

    @OneToMany(mappedBy = "enquete")
    private List<RespostaEnquete> resposta;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_category", insertable = true, updatable = true, nullable = false)
    private Categoria categoria;

}
