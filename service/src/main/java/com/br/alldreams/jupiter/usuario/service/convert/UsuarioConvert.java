/**
 *
 */
package com.br.alldreams.jupiter.usuario.service.convert;

import org.mapstruct.Mapper;

import com.br.alldreams.jupiter.base.convert.ConvertPadrao;
import com.br.alldreams.jupiter.conteudo.pagina.repository.domain.Pagina;
import com.br.alldreams.jupiter.usuario.dto.UsuarioDTO;
import com.br.alldreams.jupiter.usuario.repository.domain.Usuario;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 19:22:14
 */
@Mapper(componentModel = "spring", implementationName = "UsuarioConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = { Pagina.class })
public interface UsuarioConvert extends ConvertPadrao<UsuarioDTO, Usuario> {

}
