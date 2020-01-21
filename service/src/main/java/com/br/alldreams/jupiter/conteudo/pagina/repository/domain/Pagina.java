/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.repository.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.base.repository.convert.ImagemConteudoConvert;
import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;
import com.br.alldreams.jupiter.conteudo.base.repository.domain.Imagem;
import com.br.alldreams.jupiter.conteudo.categoria.repository.domain.Categoria;
import com.br.alldreams.jupiter.conteudo.termo.repository.domain.Termo;

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
public class Pagina extends BaseConteudo implements Serializable {

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
					@JoinColumn(name = "id_term", nullable = false, insertable = false, updatable = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "id_content", "id_term" }) },
                            foreignKey = @ForeignKey(value =  ConstraintMode.CONSTRAINT, name = "fk_term_content_cnt_id"),
                            inverseForeignKey = @ForeignKey(value =  ConstraintMode.CONSTRAINT, name = "fk_content_term_id"))
    private Set<Termo> termos;
}
