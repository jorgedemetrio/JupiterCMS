/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.service.convert;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.br.alldreams.jupiter.conteudo.pagina.dto.ConteudoDTO;
import com.br.alldreams.jupiter.conteudo.pagina.repository.domain.Conteudo;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:39:21
 * @version 1.0
 */
@Mapper(componentModel = "spring", implementationName = "ConteudoConvertImpl", implementationPackage = "<PACKAGE_NAME>.impl", imports = { Conteudo.class })
public interface ConteudoConvert {


	/**
	 * Converte um DTO para banco.
	 *
	 * @param conteudo ConteudoDTO a ser convertida.
	 * @return Retorna a Conteudo.
	 * @since 12 de jan de 2020 03:42:33
	 */
	Conteudo toConteudo(ConteudoDTO conteudo);

	/**
	 * Converte um DTO para banco.
	 *
	 * @param conteudo ConteudoDTO a ser convertida.
	 * @param target   Conteudo já instanciada.
	 * @return Retorna a Conteudo.
	 * @since 12 de jan de 2020 03:42:33
	 */
	@Mapping(target = "id", ignore = true)
	Conteudo toConteudoCreate(ConteudoDTO conteudo, @MappingTarget Conteudo target);



	/**
	 * Convert para Conteudo de banco para DTO.
	 *
	 * @param conteudo Conteudo a ser convertida.
	 * @return Retornar ConteudoDTO.
	 * @since 12 de jan de 2020 03:43:39
	 */
	@InheritInverseConfiguration(name = "toConteudo")
	ConteudoDTO toConteudoDTO(Conteudo conteudo);

	/**
	 *
	 * @param conteudo
	 * @return
	 * @since 15 de jan de 2020 00:48:30
	 */
	List<ConteudoDTO> toConteudoDTO(List<Conteudo> conteudo);
}
