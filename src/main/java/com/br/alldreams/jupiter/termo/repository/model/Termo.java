/**
 *
 */
package com.br.alldreams.jupiter.termo.repository.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tb_term")
public class Termo extends BaseConteudo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5568866381310376850L;

	@Id
	@Column(name = "id", insertable = true, updatable = false, nullable = false, length = 200)
    private String id;

    @NotEmpty
    @Size(min = 1, max = 200)
	@Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;



}
