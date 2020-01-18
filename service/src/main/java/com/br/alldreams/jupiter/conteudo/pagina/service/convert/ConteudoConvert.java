/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.service.convert;

import org.mapstruct.Mapper;

import com.br.alldreams.jupiter.base.convert.ConvertPadrao;
import com.br.alldreams.jupiter.conteudo.pagina.dto.ConteudoDTO;
import com.br.alldreams.jupiter.conteudo.pagina.repository.domain.Conteudo;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:39:21
 * @version 1.0
 */
@Mapper(componentModel = "spring", implementationName = "ConteudoConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = { Conteudo.class })
public interface ConteudoConvert extends ConvertPadrao<ConteudoDTO, Conteudo> {





}
