/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.repository.convert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.conteudo.pagina.repository.model.Imagem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @since 14 de jan de 2020 23:14:18
 * @version 1.0
 */
@Log
@Converter(autoApply = true)
public class ImagemConteudoConvert implements AttributeConverter<List<Imagem>, String> {

	private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String convertToDatabaseColumn(final List<Imagem> attribute) {
		try {
			return OBJECT_MAPPER.writeValueAsString(attribute);
		} catch (final JsonProcessingException e) {
			log.log(Level.SEVERE, "Erro ao converter List<Imagem> em String: ", e);
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Imagem> convertToEntityAttribute(final String dbData) {
		if(Objects.isNull(dbData) || dbData.isEmpty()) {
			return new ArrayList<>();
		}


		try {
			return OBJECT_MAPPER.readValue(dbData, new TypeReference<List<Imagem>>() {
			});
		} catch (final JsonProcessingException e) {
			log.log(Level.SEVERE, "Erro ao converter: " + dbData, e);
			return new ArrayList<>();
		}
	}

}
