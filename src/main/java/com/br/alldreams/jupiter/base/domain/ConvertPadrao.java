/**
 *
 */
package com.br.alldreams.jupiter.base.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 19:36:09
 */
public interface ConvertPadrao<DTO extends Object, ENTITY extends Serializable> {

    DTO toDTO(ENTITY entity);

    List<DTO> toDTO(List<ENTITY> entity);

    ENTITY toEntity(DTO entity);

    List<ENTITY> toEntity(List<DTO> entity);
//
//    // @Mapping(target = "itens", source = "content())")
//    @Mapping(target = "total", expression = "java(entity.getTotalElements())")
//    @Mapping(target = "totalPagina", expression = "java(entity.getTotalPages())")
//    @Mapping(target = "pagina", expression = "java(entity.getNumber())")
//    default ItensPaginado<DTO> toPaginingDTO(final Page<ENTITY> entity) {
//        return new ItensPaginado<>(toDTO(entity), entity.getTotalElements(), );
//    }

}
