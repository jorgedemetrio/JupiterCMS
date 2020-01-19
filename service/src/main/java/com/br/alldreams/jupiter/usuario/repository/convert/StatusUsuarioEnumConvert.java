/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.usuario.repository.domain.StatusUsuarioEnum;

/**
 * @author Jorge Demetrio
 * @since 19 de jan de 2020 01:03:26
 * @version 1.0
 */
@Converter(autoApply = true)
public class StatusUsuarioEnumConvert implements AttributeConverter<StatusUsuarioEnum, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final StatusUsuarioEnum attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusUsuarioEnum convertToEntityAttribute(final String dbData) {
        return StatusUsuarioEnum.fromString(dbData);
    }

}
