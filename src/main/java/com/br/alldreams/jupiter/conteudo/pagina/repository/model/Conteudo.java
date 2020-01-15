/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.repository.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.pagina.repository.convert.ImagemConteudoConvert;
import com.br.alldreams.jupiter.conteudo.repository.model.BaseConteudo;
import com.br.alldreams.jupiter.termo.repository.model.Termo;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:11:09
 * @version 1.0
 */
@Data
@Validated
@Entity
@Table(name = "tb_content")
public class Conteudo extends BaseConteudo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1897130732286197263L;



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
	private Categoria categoria;

	@Column(name = "images", insertable = true, updatable = true, nullable = true, length = 2000)
	@Convert(converter = ImagemConteudoConvert.class)
    private List<Imagem> imagens;

	@ManyToMany
	@JoinTable(name = "tb_content_terms", joinColumns = {
			@JoinColumn(name = "id_content", nullable = false, insertable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_term", nullable = false, insertable = false, updatable = false) })
	private List<Termo> termos;
}
