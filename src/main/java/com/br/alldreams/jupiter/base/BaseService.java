/**
 *
 */
package com.br.alldreams.jupiter.base;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.alldreams.jupiter.base.exception.BaseException;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.messagem.Messagem;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:46:14
 * @version 1.0
 */
@Data
public abstract class BaseService {

	@Autowired
	private Messagem mensagem;

	@Autowired
	private Validator validator;

	public <T extends BaseException> T createException(final String chave, final Class<T> tipo,
			final String parametros) {
		return mensagem.createExcetion(chave, tipo, parametros);
	}

	public BaseException createException(final String chave, final String parametros) {
		return mensagem.createExcetion(chave, parametros);
	}

	public String getNewId() {
		return UUID.randomUUID().toString();
	}

	public void validar(final Serializable entidade) throws DadosInvalidosServiceException {
		final Set<ConstraintViolation<Object>> constraints = validator.validate(entidade);
		if (Objects.nonNull(constraints) && !constraints.isEmpty()) {
			final HashSet<String> campos = new HashSet<>();
			final HashSet<String> mensagens = new HashSet<>();
			final StringBuilder campoStr = new StringBuilder();
			for (final ConstraintViolation<Object> constraintViolation : constraints) {
				mensagens.add(constraintViolation.getMessage());
				campos.add(constraintViolation.getInvalidValue().toString());
				campoStr.append(constraintViolation.getInvalidValue().toString());
			}

			final DadosInvalidosServiceException exception = mensagem.createExcetion("campos-invalidos",
					DadosInvalidosServiceException.class, campoStr.toString());

			exception.getCampos().addAll(campos);
			exception.getMensagens().addAll(mensagens);

			throw exception;

		}
	}
}
