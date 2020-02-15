/**
 *
 */
package com.br.alldreams.jupiter.conteudo.enquete.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;
import com.br.alldreams.jupiter.base.domain.StatusEnum;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 19 de jan de 2020 01:39:30
 * @version 1.0
 */
@Entity
@Table(name = "tb_survey_answer")
@Data
@Validated
public class RespostaEnquete extends ControleInformacaoAlteravel {

    /**
     *
     */
    private static final long serialVersionUID = -7980845308902767359L;

    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "answer", insertable = true, updatable = true, nullable = false, length = 200)
    private String reposta;

    @Column(name = "total", insertable = true, updatable = true, nullable = true)
    private Long total;

    @ManyToOne
    @JoinColumn(name = "id_survey", insertable = true, updatable = true, nullable = true)
    private Enquete enquete;

    @NotNull
    @Column(name = "status", insertable = true, updatable = true, nullable = false, length = 1)
    private StatusEnum status;
}
