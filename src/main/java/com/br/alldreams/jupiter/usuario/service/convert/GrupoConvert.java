/**
 *
 */
package com.br.alldreams.jupiter.usuario.service.convert;

import org.mapstruct.Mapper;

import com.br.alldreams.jupiter.base.domain.ConvertPadrao;
import com.br.alldreams.jupiter.usuario.dto.GrupoDTO;
import com.br.alldreams.jupiter.usuario.repository.model.Grupo;

/**
 * @author Jess
 * @version 1.0
 * @since 16 de jan de 2020 00:52:48
 */
@Mapper(componentModel = "spring", implementationName = "GrupoConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = {
		Grupo.class })
public interface GrupoConvert extends ConvertPadrao<GrupoDTO, Grupo> {

//
//	GrupoDTO toGrupo(Grupo grupo);
//
//	@InheritInverseConfiguration
//	Grupo toGrupo(GrupoDTO grupo);
//
//	@Mapping(target = "id", ignore = true)
//	@Mapping(target = "criador", ignore = true)
//	@Mapping(target = "dataCriacao", ignore = true)
//	@Mapping(target = "ipCriador", ignore = true)
//	Grupo toGrupo(GrupoDTO grupo, @MappingTarget Grupo origem);
//
//	List<Grupo> toGrupos(List<GrupoDTO> grupo);
//
//	List<GrupoDTO> toGruposDTO(List<Grupo> grupo);
}
