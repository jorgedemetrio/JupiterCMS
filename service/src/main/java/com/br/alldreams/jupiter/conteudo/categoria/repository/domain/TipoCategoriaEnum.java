/**
 *
 */
package com.br.alldreams.jupiter.conteudo.categoria.repository.domain;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 17 de jan de 2020 17:09:04
 */
public enum TipoCategoriaEnum {

    PUBLICO("U"), PAGINA("P"), PRODUTO("R"), CONTATO("C"), BANNER("B");

    public static TipoCategoriaEnum fromString(final String valor) {
        switch (valor) {
        case "U":
        case "PUBLICO":
            return PUBLICO;
        case "P":
        case "PAGINA":
            return PAGINA;
        case "R":
        case "PRODUTO":
            return PRODUTO;
        case "C":
        case "CONTATO":
            return CONTATO;
        case "B":
        case "BANNER":
            return BANNER;
        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private TipoCategoriaEnum(final String valor) {
        this.status = valor;

    }

    public String getDBStatus() {
        return status;
    }

    public String getStatus() {
        return status;
    }
}
