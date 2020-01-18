/**
 *
 */
package com.br.alldreams.jupiter.base.exception.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:54:22
 * @version 1.0
 */
@Getter
public class DadosInvalidosServiceException extends BaseServiceException {



	/**
	 *
	 */
	private static final long serialVersionUID = 2552886671396589639L;
	private String codigo;
	private String descricao;
	private final HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
	private final Set<String> campos = new HashSet<>();
	private final Set<String> mensagens = new HashSet<>();

	public DadosInvalidosServiceException(final Exception ex) {
		super(ex);
	}

	public DadosInvalidosServiceException(final Exception ex, final String codeParam) {
		super(ex);
		this.codigo = codeParam;
	}



	public DadosInvalidosServiceException(final Exception ex, final String message, final HttpStatus statusParam) {
		super(message, ex);
		this.descricao = message;
	}

	public DadosInvalidosServiceException(final Exception ex, final String message, final String codeParam) {
		super(message, ex);
		this.codigo = codeParam;
		this.descricao = message;
	}


	public DadosInvalidosServiceException(final Exception ex, final String message,
			final String codeParam, final String descricaoParam) {
		super(message, ex);
		this.codigo = codeParam;
		this.descricao = descricaoParam;
	}

	public DadosInvalidosServiceException(final String message) {
		super(message);
		this.getMessage();
	}

	public DadosInvalidosServiceException(final String message, final Exception ex) {
		super(message, ex);
		this.descricao = message;
	}

	public DadosInvalidosServiceException(final String codeParam, final String descricaoParam) {
		super(descricaoParam);

		this.codigo = codeParam;
		this.descricao = descricaoParam;
	}

	public DadosInvalidosServiceException(final String message, final String codeParam, final String descricaoParam) {
		super(message);
		this.codigo = codeParam;
		this.descricao = descricaoParam;
	}

}
