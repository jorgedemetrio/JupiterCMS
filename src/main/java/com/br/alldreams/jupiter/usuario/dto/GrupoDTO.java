/**
 *
 */
package com.br.alldreams.jupiter.usuario.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.controle.repository.model.ControleInformacaoAlteravel;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:10:45
 */
@Data
@Validated
public class GrupoDTO extends ControleInformacaoAlteravel implements Serializable {



    private String nome;
    private List<GrupoDTO> filhas;

    private GrupoDTO pai;

}
