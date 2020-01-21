/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 18:08:46
 */
public enum TipoProdutoEnum {

    /**
     * Trata o produto como venda normal.
     */
    NORMAL("N"),

    /**
     * Configrua um ou mais campos para definir o preço e estoque, como roupas que
     * tem tamanho e cor.
     */
    CONFIGURAVEL("C"),

    /**
     * Combinavel você pode definir algumas combinações com outros produtos, como
     * uma computador que pode alterar a memoria processador e afins. Para isso
     */
    COMBINAVEL("O");

    public static TipoProdutoEnum fromString(final String valor) {
        switch (valor) {
        case "NORMAL":
        case "N":
            return NORMAL;
        case "C":
        case "CONFIGURAVEL":
            return CONFIGURAVEL;
        case "O":
        case "COMBINAVEL":
            return COMBINAVEL;
        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private TipoProdutoEnum(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
    }

}
