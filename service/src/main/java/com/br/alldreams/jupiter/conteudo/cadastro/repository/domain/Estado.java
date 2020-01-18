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
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 20:02:05
 * @version 1.0
 */
@Entity
@Table(name = "tb_state")
@Data
@Validated
public class Estado implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4497933969556380810L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uf", insertable = false, updatable = false, nullable = true, length = 3)
    private String uf;

    @Column(name = "name", insertable = false, updatable = false, nullable = true, length = 200)
    private String nome;
}
