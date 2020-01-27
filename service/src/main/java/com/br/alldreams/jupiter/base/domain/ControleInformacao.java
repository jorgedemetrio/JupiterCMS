/**
 *
 */
package com.br.alldreams.jupiter.base.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.alldreams.jupiter.site.repository.domain.Site;
import com.br.alldreams.jupiter.usuario.repository.domain.Usuario;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jorge Demetrio
 * @since 15 de jan de 2020 00:32:59
 * @version 1.0
 */
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ControleInformacao implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 754453971544664891L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = true, updatable = false, nullable = false, length = 200)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_user_created", insertable = true, updatable = false, nullable = true)
    private Usuario criador;



    @NotEmpty
    @Column(name = "ip_creator", insertable = true, updatable = false, nullable = false, length = 20)
    private String ipCriador;

    @NotNull
    @Column(name = "created_date", insertable = true, updatable = false, nullable = false)
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_site", insertable = true, updatable = false, nullable = true)
    private Site site;
}
