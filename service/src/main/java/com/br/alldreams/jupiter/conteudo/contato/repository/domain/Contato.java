/**
 *
 */
package com.br.alldreams.jupiter.conteudo.contato.repository.domain;

import java.io.Serializable;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 01:49:07
 * @version 1.0
 */
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
