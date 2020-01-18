/**
 *
 */
package com.br.alldreams.jupiter.usuario.service.convert;

import org.mapstruct.Mapper;

import com.br.alldreams.jupiter.base.convert.ConvertPadrao;
import com.br.alldreams.jupiter.usuario.dto.GrupoDTO;
import com.br.alldreams.jupiter.usuario.repository.domain.Grupo;

/**
 * @author Jess
 * @version 1.0
 * @since 16 de jan de 2020 00:52:48
 */
@Mapper(componentModel = "spring", implementationName = "GrupoConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = {
		Grupo.class })
public interface GrupoConvert extends ConvertPadrao<GrupoDTO, Grupo> {


}
