/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.conteudo.cadastro.repository.domain.TipoPessoaEnum;

/**
 * @author Jorge Demetrio
 * @since 19 de jan de 2020 01:29:57
 * @version 1.0
 */
@Converter(autoApply = true)
public class TipoPessoaConvert implements AttributeConverter<TipoPessoaEnum, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final TipoPessoaEnum attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoPessoaEnum convertToEntityAttribute(final String dbData) {
        return TipoPessoaEnum.fromString(dbData);
    }
}
