/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository.domain;

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

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 19:41:45
 * @version 1.0
 */
@Entity
@Table(name = "tb_phone_company")
@Data
@Validated
public class TelefoneEmpresa extends ControleInformacaoAlteravel {


    /**
     *
     */
    private static final long serialVersionUID = 5531433252871790876L;

    @NotEmpty
    @Size(min = 1, max = 2000)
    @Column(name = "nome", insertable = true, updatable = true, nullable = false, length = 2000)
    private String nome;

    @Size(max = 4)
    @Column(name = "ddd", insertable = true, updatable = true, nullable = true, length = 4)
    private String ddd;

    @NotEmpty
    @Size(min = 3, max = 20)
    @Column(name = "number", insertable = true, updatable = true, nullable = false, length = 20)
    private String numero;

    @NotNull
    @Column(name = "main", insertable = true, updatable = true, nullable = false)
    private Boolean principal;

    @NotNull
    @Column(name = "type", insertable = true, updatable = true, nullable = false, length = 1)
    private TipoTelefoneEnum tipo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_company", insertable = true, updatable = false, nullable = false)
    private Empresa empresa;
}