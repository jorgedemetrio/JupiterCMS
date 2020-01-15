/**
 *
 */
package com.br.alldreams.jupiter.materia.repository.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:30:23
 * @version 1.0
 */
@Data
@Validated
@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario extends BaseControle implements Serializable {
    /**
    *
    */
    private static final long serialVersionUID = -5288215955799884641L;


	@Id
	@Column(name = "id", insertable = true, updatable = false, nullable = false, length = 200)
	private String id;

    @NotEmpty
	@Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

	@NotEmpty
	@Column(name = "email", insertable = true, updatable = true, nullable = false, length = 200)
	private String email;


	@NotEmpty
	@Column(name = "pass", insertable = true, updatable = true, nullable = false, length = 200)
	private String senha;

	@NotEmpty
	@Column(name = "status", insertable = true, updatable = true, nullable = false, length = 20)
	private StatusUsuarioEnum status;





}
