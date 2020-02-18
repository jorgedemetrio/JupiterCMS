/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;
import com.br.alldreams.jupiter.base.domain.StatusEnum;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 19:40:08
 * @version 1.0
 */
@Entity
@Table(name = "tb_email_company")
@Data
@Validated
public class EmailEmpresa extends ControleInformacaoAlteravel {




    /**
     *
     */
    private static final long serialVersionUID = -2885130187021135806L;

    @Size(min = 3, max = 250)
    @NotEmpty
    @Email
    @Column(name = "email", insertable = true, updatable = true, nullable = false, length = 250)
    private String email;

    @Column(name = "description", insertable = true, updatable = true, nullable = true, length = 2000)
    private String descricao;

    @NotNull
    @Column(name = "main", insertable = true, updatable = true, nullable = false)
    private Boolean principal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_company", insertable = true, updatable = false, nullable = false)
    private Empresa empresa;

    @NotNull
    @Column(name = "status", insertable = true, updatable = true, nullable = false, length = 1)
    private StatusEnum status;
}
