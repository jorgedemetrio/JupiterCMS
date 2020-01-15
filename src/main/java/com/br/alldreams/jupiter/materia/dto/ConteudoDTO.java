/**
 *
 */
package com.br.alldreams.jupiter.materia.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.materia.repository.convert.ImagemConteudoConvert;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:11:09
 * @version 1.0
 */
@Data
@Validated
public class ConteudoDTO extends BaseConteudoDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2909582859276481664L;

	@Id
	@Column(name = "id", insertable = true, updatable = false, nullable = false, length = 200)
    private String id;

    @NotEmpty
    @Size(min = 1, max = 200)
	@Column(name = "title", insertable = true, updatable = true, nullable = false, length = 200)
    private String titulo;

    @NotEmpty
	@Column(name = "content", insertable = true, updatable = true, nullable = false, length = 200)
	private String conteudo;

    @NotEmpty
	@Column(name = "spotlight", insertable = true, updatable = true, nullable = false, length = 200)
	private String destaque;


	@ManyToOne
	@JoinColumn(name = "id_category", insertable = true, updatable = true, nullable = false)
	private CategoriaDTO categoria;

	@Column(name = "images", insertable = true, updatable = true, nullable = true, length = 2000)
	@Convert(converter = ImagemConteudoConvert.class)
    private List<ImagemDTO> imagens;

	@ManyToMany
	@JoinTable(name = "tb_content_terms", joinColumns = {
			@JoinColumn(name = "id_content", nullable = false, insertable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_term", nullable = false, insertable = false, updatable = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "id_content", "id_term" }) })
	private List<TermoDTO> termos;
}
