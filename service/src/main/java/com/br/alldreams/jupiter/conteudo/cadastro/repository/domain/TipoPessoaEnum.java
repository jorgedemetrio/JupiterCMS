/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository.domain;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 19:32:15
 * @version 1.0
 */
public enum TipoPessoaEnum {

    FISICA("F"), JURIDICA("J");

    public static TipoPessoaEnum fromString(final String valor) {
        switch (valor) {
        case "FISICA":
        case "F":
            return FISICA;
        case "J":
        case "JURIDICA":
            return JURIDICA;

        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private TipoPessoaEnum(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
    }
}
