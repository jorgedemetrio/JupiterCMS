/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.conteudo.cadastro.repository.domain.TipoTelefoneEnum;

/**
 * @author Jorge Demetrio
 * @since 19 de jan de 2020 01:29:57
 * @version 1.0
 */
@Converter(autoApply = true)
public class TipoTelefoneConvert implements AttributeConverter<TipoTelefoneEnum, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final TipoTelefoneEnum attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoTelefoneEnum convertToEntityAttribute(final String dbData) {
        return TipoTelefoneEnum.fromString(dbData);
    }
}
