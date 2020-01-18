/**
 *
 */
package com.br.alldreams.jupiter.conteudo.enquete.repository.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 01:50:01
 * @version 1.0
 */
@Entity
@Table(name = "tb_enquete")
@Data
@Validated
public class Enquete extends BaseConteudo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -722765617002188406L;

}
