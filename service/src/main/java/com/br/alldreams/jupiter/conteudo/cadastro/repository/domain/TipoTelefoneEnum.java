/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository.domain;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 20:27:20
 * @version 1.0
 */
public enum TipoTelefoneEnum {
    CELULAR("C"), CASA("A"), TRABALHO("T"), RECADO("R");

    public static TipoTelefoneEnum fromString(final String valor) {
        switch (valor) {
        case "CELULAR":
        case "C":
            return CELULAR;
        case "A":
        case "CASA":
            return CASA;
        case "T":
        case "TRABALHO":
            return TRABALHO;
        case "R":
        case "RECADO":
            return RECADO;
        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private TipoTelefoneEnum(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
    }
}
