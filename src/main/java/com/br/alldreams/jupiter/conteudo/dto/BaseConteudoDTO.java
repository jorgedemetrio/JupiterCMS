/**
 *
 */
package com.br.alldreams.jupiter.conteudo.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.br.alldreams.jupiter.conteudo.pagina.repository.model.StatusConteudoEnum;
import com.br.alldreams.jupiter.controle.dto.BaseControleDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jorge Demetrio
 * @since 14 de jan de 2020 23:10:48
 * @version 1.0
 */
@Getter
@Setter
public abstract class BaseConteudoDTO extends BaseControleDTO {

	private String id;

	@NotEmpty
	@Size(min = 1, max = 250)
	private String metaDescricao;

	@NotEmpty
	@Size(min = 1, max = 250)
	private String palavrasChave;

	@NotEmpty
	@Size(min = 1, max = 250)
	private String nomeArquivo;

	@NotNull
	@Enumerated(EnumType.STRING)

	private StatusConteudoEnum status;

}
