/**
 *
 */
package com.br.alldreams.jupiter.base.messagem;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 04:47:34
 * @version 1.0
 */
@Data
public class ItemMensagem {

	private String descricao;
	private String codigo;
	private HttpStatus status;
	private String classe;
}
