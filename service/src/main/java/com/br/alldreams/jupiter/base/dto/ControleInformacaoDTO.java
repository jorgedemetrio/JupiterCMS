/**
 *
 */
package com.br.alldreams.jupiter.base.dto;

import java.util.Date;
import java.util.UUID;

import com.br.alldreams.jupiter.site.repository.domain.Site;
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

    private UUID id;

    private UsuarioDTO criador;

    private String versao;

    private String ipCriador;

    private Date dataCriacao;

    private Site site;
}
