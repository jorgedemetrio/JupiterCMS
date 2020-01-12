/**
 *
 */
package com.br.alldreams.jupiter.base.exception.service;

import org.springframework.http.HttpStatus;

import com.br.alldreams.jupiter.base.exception.BaseException;

import lombok.Getter;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:52:21
 * @version 1.0
 */
@Getter
public abstract class BaseServiceException extends BaseException {

	/**
	 *
	 */
	private static final long serialVersionUID = -2927448931552670990L;

	private String codigo;
	private String descricao;
	private HttpStatus status;

	public BaseServiceException(final Exception ex) {
		super(ex);
	}

	public BaseServiceException(final Exception ex, final HttpStatus statusParam) {
		super(ex);
		this.status = statusParam;
	}

	public BaseServiceException(final Exception ex, final HttpStatus statusParam, final String codeParam) {
		super(ex);
		this.status = statusParam;
		this.codigo = codeParam;
	}

	public BaseServiceException(final Exception ex, final HttpStatus statusParam, final String codeParam,
			final String descricaoParam) {
		super(ex);
		this.status = statusParam;
		this.codigo = codeParam;
		this.descricao = descricaoParam;
	}

	public BaseServiceException(final Exception ex, final String message, final HttpStatus statusParam) {
		super(message, ex);
		this.status = statusParam;
		this.descricao = message;
	}

	public BaseServiceException(final Exception ex, final String message, final HttpStatus statusParam,
			final String codeParam) {
		super(message, ex);
		this.status = statusParam;
		this.codigo = codeParam;
		this.descricao = message;
	}

	public BaseServiceException(final Exception ex, final String message, final HttpStatus statusParam,
			final String codeParam, final String descricaoParam) {
		super(message, ex);
		this.status = statusParam;
		this.codigo = codeParam;
		this.descricao = descricaoParam;
	}

	public BaseServiceException( final HttpStatus statusParam, final String codeParam, final String descricaoParam) {
		super(descricaoParam);
		this.status = statusParam;
		this.codigo = codeParam;
		this.descricao = descricaoParam;
	}

	public BaseServiceException(final String message) {
		super(message);
	}

	public BaseServiceException(final String message, final Exception ex) {
		super(message, ex);
		this.descricao = message;
	}

	public BaseServiceException(final String message, final HttpStatus statusParam) {
		super(message);
		this.status = statusParam;
		this.descricao = message;
	}

	public BaseServiceException(final String message, final HttpStatus statusParam, final String codeParam) {
		super(message);
		this.status = statusParam;
		this.codigo = codeParam;
	}

	public BaseServiceException(final String message, final HttpStatus statusParam, final String codeParam,
			final String descricaoParam) {
		super(message);
		this.status = statusParam;
		this.codigo = codeParam;
		this.descricao = descricaoParam;
	}

}
