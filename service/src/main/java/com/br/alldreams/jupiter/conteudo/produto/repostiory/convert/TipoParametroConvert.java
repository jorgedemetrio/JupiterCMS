/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.br.alldreams.jupiter.conteudo.produto.repostiory.domain.TipoParametroEnumProduto;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 20:28:52
 */
@Log
@Converter(autoApply = true)
public class TipoParametroConvert implements AttributeConverter<TipoParametroEnumProduto, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToDatabaseColumn(final TipoParametroEnumProduto attribute) {
        return attribute.getDBStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoParametroEnumProduto convertToEntityAttribute(final String dbData) {
        return TipoParametroEnumProduto.fromString(dbData);
    }

}
