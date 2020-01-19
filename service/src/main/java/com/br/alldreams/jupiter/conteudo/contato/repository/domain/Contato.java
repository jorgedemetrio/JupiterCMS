/**
 *
 */
package com.br.alldreams.jupiter.conteudo.contato.repository.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 01:49:07
 * @version 1.0
 */
@Entity
@Table(name = "tb_contato")
@Data
@Validated
public class Contato extends BaseConteudo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 9207410745315804518L;

    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

    @Email
    @Column(name = "email", insertable = true, updatable = true, nullable = false, length = 200)
    private String email;

    @Column(name = "phone", insertable = true, updatable = true, nullable = false, length = 20)
    private String telefone;

    @Column(name = "ddd", insertable = true, updatable = true, nullable = false, length = 20)
    private String dddTelefone;

    @Column(name = "description", insertable = true, updatable = true, nullable = false, length = 2000)
    private String descricao;

}
