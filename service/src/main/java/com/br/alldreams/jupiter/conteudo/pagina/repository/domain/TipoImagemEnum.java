/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.repository.domain;

/**
 * @author Jorge Demetrio
 * @since 14 de jan de 2020 23:29:23
 * @version 1.0
 */
public enum TipoImagemEnum {
    DESTAQUE("D"), CONTEUDO("C"), THUMB("T");

    public static TipoImagemEnum fromString(final String valor) {
        switch (valor) {
        case "DESTAQUE":
        case "D":
            return DESTAQUE;
        case "C":
        case "CONTEUDO":
            return CONTEUDO;
        case "T":
        case "THUMB":
            return THUMB;
        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private TipoImagemEnum(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
    }
}
