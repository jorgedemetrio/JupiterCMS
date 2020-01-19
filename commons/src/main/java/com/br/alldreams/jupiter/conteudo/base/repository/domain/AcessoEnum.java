/**
 *
 */
package com.br.alldreams.jupiter.conteudo.base.repository.domain;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:13:30
 */
public enum AcessoEnum {

    PUBLICO("P"), LOGADO("L"), ESPECIFICO("E"), NAO_LOGADO("N"), ESPECIAL("S");
    
    
    
    
    
    public static AcessoEnum fromString(final String valor) {
        switch (valor) {
            case "PUBLICO":
            case "P":
                return PUBLICO;
            case "L":
            case "LOGADO":
                return LOGADO;
            case "E":
            case "ESPECIFICO":
                return ESPECIFICO;
            case "N":
            case "NAO_LOGADO":
                return NAO_LOGADO;
            case "S":
            case "ESPECIAL":
                return ESPECIAL;
        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private AcessoEnum(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
    }

}
