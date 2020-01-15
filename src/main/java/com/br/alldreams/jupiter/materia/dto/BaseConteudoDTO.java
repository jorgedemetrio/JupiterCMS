/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.br.alldreams.jupiter.materia.repository.model.StatusConteudoEnum;

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

	@NotEmpty
	@Size(min = 1, max = 250)
	@Column(name = "meta_description", insertable = true, updatable = true, nullable = true, length = 250)
	private String metaDescricao;

	@NotEmpty
	@Size(min = 1, max = 250)
	@Column(name = "meta_keywords", insertable = true, updatable = true, nullable = true, length = 250)
	private String palavrasChave;

	@NotEmpty
	@Size(min = 1, max = 250)
	@Column(name = "file_name", insertable = true, updatable = true, nullable = false, length = 250)
	private String nomeArquivo;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status", insertable = true, updatable = true, nullable = false, length = 250)
	private StatusConteudoEnum status;

}
