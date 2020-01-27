/**
 *
 */
package com.br.alldreams.jupiter.conteudo.base.repository.domain;

/**
 * @author Jorge Demetrio
 * @since 14 de jan de 2020 23:01:34
 * @version 1.0
 */
public enum StatusConteudoEnum {
    /**
     * Cotnteúdo deletado
     */
    DELETADO("D"),

    /**
     * Conteduo publicado
     */
    PUBLICADO("P"),

    /**
     * Não publicado
     */
    NAO_PUBLICADO("N");

    public static StatusConteudoEnum fromString(final String valor) {
        switch (valor) {
        case "DELETADO":
        case "D":
            return DELETADO;
        case "P":
        case "PUBLICADO":
            return PUBLICADO;
        case "N":
        case "NAO_PUBLICADO":
            return NAO_PUBLICADO;
        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private StatusConteudoEnum(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
    }

}
