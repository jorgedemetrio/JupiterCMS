/**
 *
 */
package com.br.alldreams.jupiter.base.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 19:10:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItensPaginado<T> {


    /**
     *
     */
    private static final long serialVersionUID = -453128126541327504L;

    private List<T> itens;

    private Long total;

    private Integer totalPagina;

    private Integer pagina;

    public void add(final T item) {
        if (Objects.isNull(this.itens)) {
            this.itens = new ArrayList<T>();
        }

        if (Objects.nonNull(this.itens)) {
            this.itens.add(item);
        }
    }

}
