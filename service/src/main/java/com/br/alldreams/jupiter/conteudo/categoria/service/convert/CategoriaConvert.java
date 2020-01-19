/**
 *
 */
package com.br.alldreams.jupiter.conteudo.categoria.service.convert;

import org.mapstruct.Mapper;

import com.br.alldreams.jupiter.base.convert.ConvertPadrao;
import com.br.alldreams.jupiter.conteudo.categoria.dto.CategoriaDTO;
import com.br.alldreams.jupiter.conteudo.categoria.repository.domain.Categoria;

/**
 * @author Jorge Demetrio
 * @since 19 de jan de 2020 00:47:28
 * @version 1.0
 */
@Mapper(componentModel = "spring", implementationName = "CategoriaConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = { Categoria.class })
public interface CategoriaConvert extends ConvertPadrao<CategoriaDTO, Categoria> {


}
