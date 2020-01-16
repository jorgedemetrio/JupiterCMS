/**
 *
 */
package com.br.alldreams.jupiter.usuario.service.convert;

import org.mapstruct.Mapper;

import com.br.alldreams.jupiter.base.domain.ConvertPadrao;
import com.br.alldreams.jupiter.conteudo.pagina.repository.model.Conteudo;
import com.br.alldreams.jupiter.usuario.dto.UsuarioDTO;
import com.br.alldreams.jupiter.usuario.repository.model.Usuario;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 19:22:14
 */
@Mapper(componentModel = "spring", implementationName = "UsuarioConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = { Conteudo.class })
public interface UsuarioConvert extends ConvertPadrao<UsuarioDTO, Usuario> {


}
