/**
 *
 */
package com.br.alldreams.jupiter.base.exception.service;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:54:22
 * @version 1.0
 */
@Getter
public class SemPermissaoServiceException extends BaseServiceException {



	/**
	 *
	 */
	private static final long serialVersionUID = 2552886671396589639L;
	private String codigo;
	private String descricao;
	private final HttpStatus status = HttpStatus.UNAUTHORIZED;

	public SemPermissaoServiceException(final Exception ex) {
		super(ex);
	}

	public SemPermissaoServiceException(final Exception ex, final String codeParam) {
		super(ex);
		this.codigo = codeParam;
	}



	public SemPermissaoServiceException(final Exception ex, final String message, final HttpStatus statusParam) {
		super(message, ex);
		this.descricao = message;
	}

	public SemPermissaoServiceException(final Exception ex, final String message, final String codeParam) {
		super(message, ex);
		this.codigo = codeParam;
		this.descricao = message;
	}


	public SemPermissaoServiceException(final Exception ex, final String message,
			final String codeParam, final String descricaoParam) {
		super(message, ex);
		this.codigo = codeParam;
		this.descricao = descricaoParam;
	}

	public SemPermissaoServiceException(final String message) {
		super(message);
		this.getMessage();
	}

	public SemPermissaoServiceException(final String message, final Exception ex) {
		super(message, ex);
		this.descricao = message;
	}

	public SemPermissaoServiceException(final String codeParam, final String descricaoParam) {
		super(descricaoParam);

		this.codigo = codeParam;
		this.descricao = descricaoParam;
	}

	public SemPermissaoServiceException(final String message, final String codeParam, final String descricaoParam) {
		super(message);
		this.codigo = codeParam;
		this.descricao = descricaoParam;
	}

}
