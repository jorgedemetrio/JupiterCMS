/**
 *
 */
package com.br.alldreams.jupiter.conteudo.arquivo.repository.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;
import com.br.alldreams.jupiter.conteudo.categoria.repository.domain.Categoria;
import com.br.alldreams.jupiter.conteudo.termo.repository.domain.Termo;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 24 de jan de 2020 20:34:56
 */
@Data
@Validated
@Entity
@Table(name = "tb_file")
public class Arquivo extends ControleInformacaoAlteravel {

    /**
     *
     */
    private static final long serialVersionUID = 3999123210505881513L;

    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

    @Column(name = "compress", insertable = true, updatable = true, nullable = false, length = 200)
    private Boolean comprimir;

    @ManyToOne
    @JoinColumn(name = "id_category", insertable = true, updatable = true, nullable = false)
    private Categoria categoria;

    @ManyToMany
    @JoinTable(name = "tb_file_terms", joinColumns = {
            @JoinColumn(name = "id_file", nullable = false, insertable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "id_term", nullable = false, insertable = false, updatable = false) }, uniqueConstraints = {
                            @UniqueConstraint(columnNames = { "id_file",
                                    "id_term" }) }, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_term_file_file_id"), inverseForeignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_file_term_id"))
    private Set<Termo> termos;

}
