/**
 *
 */
package com.br.alldreams.jupiter.site.repository.domain;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 19:02:17
 */
public enum TipoCMSEnum {
    PORTAL("P"), INSTITUCIONAL("I"), CATALOGO("C"), ECOMMERCE("E");

    public static TipoCMSEnum fromString(final String valor) {
        switch (valor) {
        case "PORTAL":
        case "P":
            return PORTAL;
        case "I":
        case "INSTITUCIONAL":
            return INSTITUCIONAL;
        case "C":
        case "CATALOGO":
            return CATALOGO;
        case "E":
        case "ECOMMERCE":
            return ECOMMERCE;
        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private TipoCMSEnum(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
    }
}
