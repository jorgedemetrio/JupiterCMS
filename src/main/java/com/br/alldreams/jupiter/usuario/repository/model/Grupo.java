/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.controle.repository.model.ControleInformacaoAlteravel;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:10:45
 */
@Data
@Validated
@Entity
@Table(name = "tb_group")
public class Grupo extends ControleInformacaoAlteravel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4341520984241566583L;

    @NotEmpty
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

    @OneToMany(mappedBy = "pai")
    private List<Grupo> filhas;

    @ManyToOne
    @JoinColumn(name = "id_parent", insertable = true, updatable = true, nullable = true)
    private Grupo pai;

}
