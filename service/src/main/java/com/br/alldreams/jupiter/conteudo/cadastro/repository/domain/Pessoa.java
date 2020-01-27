/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 19:20:51
 * @version 1.0
 */
@Entity
@Table(name = "tb_person")
@Data
@Validated
public class Pessoa extends ControleInformacaoAlteravel {
    /**
    *
    */
    private static final long serialVersionUID = 4686883211139893194L;

    @NotEmpty
    @Size(min = 1, max = 2000)
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 2000)
    private String nome;

    @Size(max = 2000)
    @Column(name = "document", insertable = true, updatable = true, nullable = true, length = 2000)
    private String documento;

    @CPF
    @Size(max = 14)
    @Column(name = "national_tax", insertable = true, updatable = true, nullable = true, length = 2000)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_user", insertable = true, updatable = true, nullable = true, length = 20)
    private TipoPessoaEnum tipo;

    @OneToMany(mappedBy = "pessoa")
    private List<TelefonePessoa> telefones;

    @OneToMany(mappedBy = "pessoa")
    private List<EmailPessoa> emails;

    @OneToMany(mappedBy = "pessoa")
    private List<EnderecoPessoa> enderecos;
}
