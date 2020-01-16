/**
 *
 */
package com.br.alldreams.jupiter.controle.dto;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.alldreams.jupiter.site.repository.model.Site;
import com.br.alldreams.jupiter.usuario.dto.UsuarioDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jorge Demetrio
 * @since 15 de jan de 2020 00:32:59
 * @version 1.0
 */
@Getter
@Setter
public abstract class ControleInformacaoDTO {

    private String id;

    @NotNull
    private UsuarioDTO criador;

    @NotEmpty
    private String versao;

    @NotEmpty
    private String ipCriador;

    @NotNull
    private Date dataCriacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_site", insertable = true, updatable = false, nullable = false)
    private Site site;
}
