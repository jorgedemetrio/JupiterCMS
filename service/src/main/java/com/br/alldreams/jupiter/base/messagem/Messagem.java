/**
 *
 */
package com.br.alldreams.jupiter.base.messagem;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.br.alldreams.jupiter.base.exception.BaseException;
import com.br.alldreams.jupiter.base.exception.service.ErroInternoServiceException;

import lombok.Data;
import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 04:44:13
 * @version 1.0
 */
@Log
@Data
@ConfigurationProperties("mensagens")
public class Messagem {

	private Map<String, ItemMensagem> mensagens;


	public <T extends BaseException> T createExcetion(final String chave, final Class<T> tipo, final String... parametros) {
		final ItemMensagem item = getMensagem(chave);
		final String mensagem = Objects.isNull(parametros) || parametros.length <= 0 ? item.getDescricao()
				: String.format(item.getDescricao(), (Object[]) parametros);
		T exception = null;

		if (Objects.nonNull(tipo)) {
			try {
				exception = (tipo.getConstructor(String.class, String.class, String.class)
						.newInstance(mensagem, item.getCodigo(), mensagem));
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				log.log(Level.SEVERE, e.getMessage(), e);
			}
		}

		if (Objects.isNull(exception)) {
			throw new RuntimeException(
					"Chave possiovel criar a exception para chave: " + chave + " mensagem: " + mensagem);
		}
		return exception;

	}

	public BaseException createExcetion(final String chave, final String... parametros) {
		final ItemMensagem item = getMensagem(chave);

		final String mensagem = Objects.isNull(parametros) || parametros.length <= 0 ? item.getDescricao()
				: String.format(item.getDescricao(), (Object[]) parametros);

		BaseException exception = null;

		if (Objects.nonNull(item.getClasse()) && !item.getClasse().isEmpty()) {
			try {
				exception = BaseException.class
						.cast(Class.forName(item.getClasse()).getConstructor(String.class, String.class, String.class)
								.newInstance(mensagem, item.getCodigo(), mensagem));
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage(), e);
			}
		}

		if (Objects.isNull(exception)) {
			exception = new ErroInternoServiceException(mensagem, item.getCodigo(), mensagem);
		}

		return exception;
	}

	private ItemMensagem getMensagem(final String chave) {
		final ItemMensagem item = getMensagens().get(chave);
		if (Objects.isNull(item)) {
			throw new RuntimeException("Chave não de mensagem encontrada: " + chave);
		}
		return item;
	}
}
