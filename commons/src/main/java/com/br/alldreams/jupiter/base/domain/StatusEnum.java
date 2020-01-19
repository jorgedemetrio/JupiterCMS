/**
 *
 */
package com.br.alldreams.jupiter.base.domain;

/**
 * @author Jorge Demetrio
 * @since 14 de jan de 2020 23:01:34
 * @version 1.0
 */
public enum StatusEnum {
    /**
     * Deletado
     */
    DELETADO("D"),

    /**
     * Ativo
     */
    ATIVO("A"),

    /**
     * INATIVO
     */
    INATIVO("A");

    public static StatusEnum fromString(final String valor) {
        switch (valor) {
        case "DELETADO":
        case "D":
            return DELETADO;
        case "A":
        case "ATIVO":
            return ATIVO;
        case "I":
        case "INATIVO":
            return INATIVO;
        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private StatusEnum(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
        }

    }
