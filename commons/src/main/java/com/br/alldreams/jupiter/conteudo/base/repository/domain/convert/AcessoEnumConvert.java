/**
 *
 */
package com.br.alldreams.jupiter.conteudo.base.repository.domain.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.AcessoEnum;

/**
 * @author Jorge Demetrio
 * @since 19 de jan de 2020 01:03:26
 * @version 1.0
 */
@Converter(autoApply = true)
public class AcessoEnumConvert implements AttributeConverter<AcessoEnum, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final AcessoEnum attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AcessoEnum convertToEntityAttribute(final String dbData) {
        return AcessoEnum.fromString(dbData);
    }

}
