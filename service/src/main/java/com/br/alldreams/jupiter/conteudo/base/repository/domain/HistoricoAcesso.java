/**
 *
 */
package com.br.alldreams.jupiter.conteudo.base.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacao;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 14:43:34
 */
@Data
@Validated
@Entity
@Table(name = "tb_history_access")
public class HistoricoAcesso extends ControleInformacao {

    /**
     *
     */
    private static final long serialVersionUID = 2771531578930823385L;

    @NotEmpty
    @Column(name = "page", insertable = true, updatable = false, nullable = false, length = 250)
    private String pagina;

    @NotEmpty
    @Column(name = "log", insertable = true, updatable = false, nullable = false, length = 2000)
    private String log;

}
