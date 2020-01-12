/**
 *
 */
package com.br.alldreams.jupiter.materia.service.convert;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.br.alldreams.jupiter.materia.dto.MateriaDTO;
import com.br.alldreams.jupiter.materia.repository.model.Materia;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:39:21
 * @version 1.0
 */
@Mapper(componentModel = "spring", implementationName = "MateriaConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = {
		Materia.class })
public interface MateriaConvert {

	/**
	 * Converte um DTO para banco.
	 *
	 * @param materia MateriaDTO a ser convertida.
	 * @return Retorna a Materia.
	 * @since 12 de jan de 2020 03:42:33
	 */
	Materia toMateria(MateriaDTO materia);

	/**
	 * Converte um DTO para banco.
	 *
	 * @param materia MateriaDTO a ser convertida.
	 * @param target  Materia já instanciada.
	 * @return Retorna a Materia.
	 * @since 12 de jan de 2020 03:42:33
	 */
	@Mapping(target = "id", ignore = true)
	Materia toMateria(MateriaDTO materia, @MappingTarget Materia target);



	List<MateriaDTO> toMateriaDTO(List<Materia> materia);

	/**
	 * Convert para Materia de banco para DTO.
	 *
	 * @param materia Materia a ser convertida.
	 * @return Retornar MateriaDTO.
	 * @since 12 de jan de 2020 03:43:39
	 */
	@InheritInverseConfiguration
	MateriaDTO toMateriaDTO(Materia materia);
}
