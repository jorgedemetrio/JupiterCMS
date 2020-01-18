/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.sun.istack.NotNull;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 20:01:59
 * @version 1.0
 */
@Entity
@Table(name = "tb_city")
@Data
@Validated
public class Cidade implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3842929765615916036L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = true)
    private Long id;

    @Column(name = "name", insertable = false, updatable = false, nullable = true, length = 200)
    private String nome;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "uf", insertable = false, updatable = false, nullable = false)
    private Estado uf;

}
