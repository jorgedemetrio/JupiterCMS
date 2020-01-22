/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.conteudo.produto.repostiory.domain.TipoProdutoEnum;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 18:18:02
 */
@Log
@Converter(autoApply = true)
public class TipoProducoConvert implements AttributeConverter<TipoProdutoEnum, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final TipoProdutoEnum attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoProdutoEnum convertToEntityAttribute(final String dbData) {
        return TipoProdutoEnum.fromString(dbData);
    }

}
