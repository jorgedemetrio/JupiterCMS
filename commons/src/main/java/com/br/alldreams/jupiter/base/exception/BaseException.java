/**
 *
 */
package com.br.alldreams.jupiter.base.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:46:45
 * @version 1.0
 */
@Getter
public abstract class BaseException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 202690872424513993L;

    private String codigo;
    private String descricao;
    private HttpStatus status;

    /**
     * Construtor.
     * @param ex Erro.
     */
    public BaseException(final Exception ex) {
        super(ex);
    }
    
    /**
     * Construtor.
     * @param ex Erro.
     * @param statusParam Status.
     */
    public BaseException(final Exception ex, final HttpStatus statusParam) {
        super(ex);
        this.status = statusParam;
    }

    public BaseException(final Exception ex, final HttpStatus statusParam, final String codeParam) {
        super(ex);
        this.status = statusParam;
        this.codigo = codeParam;
    }

    public BaseException(final Exception ex, final HttpStatus statusParam, final String codeParam, final String descricaoParam) {
        super(descricaoParam, ex);
        this.status = statusParam;
        this.codigo = codeParam;
        this.descricao = descricaoParam;
    }

    public BaseException(final Exception ex, final String message, final HttpStatus statusParam) {
        super(message, ex);
        this.status = statusParam;
    }

    public BaseException(final Exception ex, final String message, final HttpStatus statusParam, final String codeParam) {
        super(message, ex);
        this.status = statusParam;
        this.codigo = codeParam;
    }

    public BaseException(final Exception ex, final String message, final HttpStatus statusParam, final String codeParam, final String descricaoParam) {
        super(message, ex);
        this.status = statusParam;
        this.codigo = codeParam;
        this.descricao = descricaoParam;
    }

    public BaseException(final HttpStatus statusParam, final String codeParam, final String descricaoParam) {
        super(descricaoParam);
        this.status = statusParam;
        this.codigo = codeParam;
        this.descricao = descricaoParam;
    }

    public BaseException(final String message) {
        super(message);
    }

    public BaseException(final String message, final Exception ex) {
        super(message, ex);
    }

    public BaseException(final String message, final HttpStatus statusParam) {
        super(message);
        this.status = statusParam;
        this.descricao = message;
    }

    public BaseException(final String message, final HttpStatus statusParam, final String codeParam) {
        super(message);
        this.status = statusParam;
        this.codigo = codeParam;
    }

    public BaseException(final String message, final HttpStatus statusParam, final String codeParam, final String descricaoParam) {
        super(message);
        this.status = statusParam;
        this.codigo = codeParam;
        this.descricao = descricaoParam;
    }

}
