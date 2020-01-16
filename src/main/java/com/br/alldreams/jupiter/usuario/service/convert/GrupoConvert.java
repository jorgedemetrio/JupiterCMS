/**
 *
 */
package com.br.alldreams.jupiter.usuario.service.convert;

import org.mapstruct.Mapper;

import com.br.alldreams.jupiter.conteudo.pagina.repository.model.Conteudo;
import com.br.alldreams.jupiter.usuario.dto.GrupoDTO;
import com.br.alldreams.jupiter.usuario.repository.model.Grupo;

/**
 * @author Jess
 * @version 1.0
 * @since 16 de jan de 2020 00:52:48
 */
@Mapper(componentModel = "spring", implementationName = "GrupoConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = { Conteudo.class })
public interface GrupoConvert {

    GrupoDTO toGrupo(final Grupo grupo);

    Grupo toGrupo(final GrupoDTO grupo);
}
