/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 20:25:17
 */
public enum TipoParametroEnumProduto {

    TEXTO("T"), NUMERICO("N"), LISTA("L"), COR("C");

    public static TipoParametroEnumProduto fromString(final String valor) {
        switch (valor) {
        case "TEXTO":
        case "T":
            return TEXTO;
        case "N":
        case "NUMERICO":
            return NUMERICO;
        case "L":
        case "LISTA":
            return LISTA;
        case "C":
        case "COR":
            return COR;
        }
        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private TipoParametroEnumProduto(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
    }
}
