/**
 *
 */
package com.br.alldreams.jupiter.conteudo.contato.repository.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

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

    private String email;

    private String telefone;

    private String dddTelefone;

    private String descricao;

}
