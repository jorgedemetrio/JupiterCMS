/**
 *
 */
package com.br.alldreams.jupiter.site.repository.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.site.repository.domain.TipoCMSEnum;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @since 19 de jan de 2020 05:15:51
 * @version 1.0
 */
@Log
@Converter(autoApply = true)
public class TipoCMSConvert implements AttributeConverter<TipoCMSEnum, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final TipoCMSEnum attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoCMSEnum convertToEntityAttribute(final String dbData) {
        return TipoCMSEnum.fromString(dbData);
    }

}
