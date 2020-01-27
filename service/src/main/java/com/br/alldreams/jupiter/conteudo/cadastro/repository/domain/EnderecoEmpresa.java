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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;
import com.sun.istack.NotNull;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 19:41:23
 * @version 1.0
 */
@Entity
@Table(name = "tb_endereco_company")
@Data
@Validated
public class EnderecoEmpresa extends ControleInformacaoAlteravel {




    /**
     *
     */
    private static final long serialVersionUID = 1802789042659379510L;

    @NotEmpty
    @Size(min = 1, max = 2000)
    @Column(name = "nome", insertable = true, updatable = true, nullable = false, length = 2000)
    private String nome;

    @Size(max = 2000)
    @Column(name = "public_place", insertable = true, updatable = true, nullable = true, length = 2000)
    private String logradouro;

    @Size(min = 1, max = 2000)
    @NotEmpty
    @Column(name = "address", insertable = true, updatable = true, nullable = false, length = 2000)
    private String endereco;

    @Size(max = 20)
    @Column(name = "number", insertable = true, updatable = true, nullable = true, length = 20)
    private String numero;

    @Size(max = 2000)
    @Column(name = "complement", insertable = true, updatable = true, nullable = true, length = 2000)
    private String complemento;

    @Size(min = 9, max = 9)
    @NotEmpty
    @Pattern(regexp = "^\\d{5}[-]\\d{3}$")
    @Column(name = "zipcode", insertable = true, updatable = true, nullable = false, length = 2000)
    private String cep;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_city", insertable = true, updatable = true, nullable = false)
    private Cidade cidade;

    @NotNull
    @Column(name = "main", insertable = true, updatable = true, nullable = false)
    private Boolean principal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_company", insertable = true, updatable = false, nullable = false)
    private Empresa empresa;
}
