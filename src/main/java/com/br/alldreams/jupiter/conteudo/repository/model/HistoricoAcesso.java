/**
 *
 */
package com.br.alldreams.jupiter.conteudo.repository.model;

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
@Table(name = "tb_history_pass")
public class HistoricoAcesso extends ControleInformacao {

    @NotEmpty
    @Column(name = "id", insertable = true, updatable = false, nullable = false, length = 250)
    private String pagina;

    @NotEmpty
    @Column(name = "id", insertable = true, updatable = false, nullable = false, length = 2000)
    private String log;


}
