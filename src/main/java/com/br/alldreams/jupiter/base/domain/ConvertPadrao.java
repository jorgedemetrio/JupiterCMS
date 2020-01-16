/**
 *
 */
package com.br.alldreams.jupiter.base.domain;

import java.io.Serializable;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 19:36:09
 */
public interface ConvertPadrao<DTO extends Object, ENTITY extends Serializable> {

    DTO toDTO(ENTITY entity);

    List<DTO> toDTO(List<ENTITY> entity);

    @InheritInverseConfiguration
    ENTITY toEntity(DTO entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criador", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "ipCriador", ignore = true)
    ENTITY toEntity(DTO dto, @MappingTarget ENTITY origem);

    List<ENTITY> toEntity(List<DTO> entity);

}
