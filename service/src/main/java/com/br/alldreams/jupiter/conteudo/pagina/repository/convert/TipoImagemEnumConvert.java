/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.repository.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.conteudo.pagina.repository.domain.TipoImagemEnum;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 18:18:02
 */
@Log
@Converter(autoApply = true)
public class TipoImagemEnumConvert implements AttributeConverter<TipoImagemEnum, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final TipoImagemEnum attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoImagemEnum convertToEntityAttribute(final String dbData) {
        return TipoImagemEnum.fromString(dbData);
    }

}
