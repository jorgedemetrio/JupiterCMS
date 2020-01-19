/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository.domain;

/**
 * @author Jorge Demetrio
 * @since 15 de jan de 2020 00:31:52
 * @version 1.0
 */
public enum StatusUsuarioEnum {

    DELETADO("D"), ATIVO("A"), BLOQUEADO("B"), EXPIRADO("E");

    public static StatusUsuarioEnum fromString(final String valor) {
        switch (valor) {
            case "DELETADO":
            case "D":
                return DELETADO;
            case "A":
            case "ATIVO":
                return ATIVO;
            case "B":
            case "BLOQUEADO":
                return BLOQUEADO;
            case "E":
            case "EXPIRADO":
                return EXPIRADO;
        }

        throw new RuntimeException("Enumerate não encontrado");
    }

    private final String status;

    private StatusUsuarioEnum(final String valor) {
        this.status = valor;
    }

    public String getDBStatus() {
        return status;
    }

}
