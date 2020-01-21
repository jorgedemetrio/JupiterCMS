/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 18:04:52
 */
public enum MedicaoProdutoEnum {

    PESO("P"),
    /**
     * Inteiro
     */
    UNIDADE("U"), LITRO("L"), HORA("H");

    public static MedicaoProdutoEnum fromString(final String valor) {
        switch (valor) {
        case "PESO":
        case "P":
            return PESO;
        case "U":
        case "UNIDADE":
            return UNIDADE;
        case "L":
        case "LITRO":
            return LITRO;
        case "H":
        case "HORA":
            return HORA;
        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private MedicaoProdutoEnum(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
    }
}
