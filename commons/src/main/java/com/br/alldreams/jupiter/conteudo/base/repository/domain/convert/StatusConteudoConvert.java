/**
 *
 */
package com.br.alldreams.jupiter.conteudo.base.repository.domain.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.StatusConteudoEnum;

/**
 * @author Jorge Demetrio
 * @since 19 de jan de 2020 01:03:26
 * @version 1.0
 */
@Converter(autoApply = true)
public class StatusConteudoConvert implements AttributeConverter<StatusConteudoEnum, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final StatusConteudoEnum attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusConteudoEnum convertToEntityAttribute(final String dbData) {
        return StatusConteudoEnum.fromString(dbData);
    }

}
