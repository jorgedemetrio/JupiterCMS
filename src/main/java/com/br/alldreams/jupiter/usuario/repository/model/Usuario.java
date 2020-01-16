/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;

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
public class Usuario extends ControleInformacaoAlteravel implements Serializable {
    /**
    *
    */
    private static final long serialVersionUID = -5288215955799884641L;


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
    @Column(name = "key_google", insertable = true, updatable = true, nullable = false, length = 200)
    private String chaveGoogle;

	@NotEmpty
	@Column(name = "status", insertable = true, updatable = true, nullable = false, length = 20)
	private StatusUsuarioEnum status;


	@JoinTable(name = "tb_user_permissions",
			joinColumns = {
					@JoinColumn(name = "id_user", insertable = true, nullable = false, unique = false, updatable = false) },
			inverseJoinColumns = {
					@JoinColumn(name = "permission", insertable = true, nullable = false, unique = false, updatable = false) },
			uniqueConstraints = {
					@UniqueConstraint(columnNames = { "id_user", "permission" }) }
			)
	private List<PermissoesEnum> permissoes;



}
