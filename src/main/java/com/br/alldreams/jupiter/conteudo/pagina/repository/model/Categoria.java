/**
 *
 */
package com.br.alldreams.jupiter.conteudo.pagina.repository.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.repository.model.BaseConteudo;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:47:53
 * @version 1.0
 */
@Data
@Validated
@Entity
@Table(name = "tb_category")
public class Categoria extends BaseConteudo implements Serializable {
    /**
    *
    */
    private static final long serialVersionUID = 5980977028036251986L;



    @NotEmpty
    @Size(min = 1, max = 200)
	@Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

	@OneToMany(mappedBy = "pai")
	private List<Categoria> filhas;

	@ManyToOne
	@JoinColumn(name = "id_parent", insertable = true, updatable = true, nullable = true)
	private Categoria pai;



}
