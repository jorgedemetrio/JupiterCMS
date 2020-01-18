/**
 *
 */
package com.br.alldreams.jupiter.base.convert;

import java.io.Serializable;
import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 19:36:09
 */
public interface ConvertPadrao<D extends Object, E extends Serializable> {

	D toDTO(E entity);

	List<D> toDTO(List<E> entity);

	E toEntity(D entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criador", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "ipCriador", ignore = true)
	E toEntity(D dto, @MappingTarget E origem);

	List<E> toEntity(List<D> entity);

}
