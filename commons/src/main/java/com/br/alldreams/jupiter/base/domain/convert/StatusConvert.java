/**
 *
 */
package com.br.alldreams.jupiter.base.domain.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.base.domain.StatusEnum;

/**
 * @author Jorge Demetrio
 * @since 19 de jan de 2020 01:16:54
 * @version 1.0
 */
@Converter(autoApply = true)
public class StatusConvert implements AttributeConverter<StatusEnum, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final StatusEnum attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusEnum convertToEntityAttribute(final String dbData) {
        return StatusEnum.fromString(dbData);
    }

}
