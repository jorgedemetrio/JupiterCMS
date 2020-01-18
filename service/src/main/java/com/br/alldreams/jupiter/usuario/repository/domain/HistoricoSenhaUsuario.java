/**
 *
 */
package com.br.alldreams.jupiter.usuario.repository.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 13:29:30
 */
@Data
@Validated
@Entity
@Table(name = "tb_history_pass")
public class HistoricoSenhaUsuario implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 4325251551325353767L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = true)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_user", insertable = true, updatable = false, nullable = false)
    private Usuario usuario;

    @NotNull
    @Column(name = "created", insertable = true, updatable = false, nullable = false)
    private Date dataCriado;

    @NotEmpty
    @Column(name = "pass", insertable = true, updatable = false, nullable = false)
    private String senha;
}
