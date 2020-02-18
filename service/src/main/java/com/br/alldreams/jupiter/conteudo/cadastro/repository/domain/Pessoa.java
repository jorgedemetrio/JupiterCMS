/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;
import com.br.alldreams.jupiter.base.domain.StatusEnum;

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

    @ManyToMany
    @JoinTable(name = "tb_person_file", joinColumns = {
            @JoinColumn(name = "id_person", nullable = false, insertable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "id_file", nullable = false, insertable = false, updatable = false) }, uniqueConstraints = {
                            @UniqueConstraint(columnNames = { "id_person",
                                    "id_file" }) }, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_term_page_page_id"), inverseForeignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_file_page_file_id"))

    private List<Empresa> empresas;

    @NotNull
    @Column(name = "status", insertable = true, updatable = true, nullable = false, length = 1)
    private StatusEnum status;
}
