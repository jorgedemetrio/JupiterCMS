/**
 *
 */
package com.br.alldreams.jupiter.conteudo.categoria.repository.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.conteudo.categoria.repository.domain.TipoCategoriaEnum;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @since 19 de jan de 2020 05:20:31
 * @version 1.0
 */
@Log
@Converter(autoApply = true)
public class TipoCategoriaConvert implements AttributeConverter<TipoCategoriaEnum, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final TipoCategoriaEnum attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoCategoriaEnum convertToEntityAttribute(final String dbData) {
        return TipoCategoriaEnum.fromString(dbData);
    }

}
