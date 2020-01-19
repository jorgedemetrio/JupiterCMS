/**
 *
 */
package com.br.alldreams.jupiter.conteudo.busca.repository.domain;

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

import com.br.alldreams.jupiter.site.repository.domain.Site;
import com.br.alldreams.jupiter.usuario.repository.domain.Usuario;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 18 de jan de 2020 01:48:23
 * @version 1.0
 */
@Entity
@Table(name = "tb_log_busca")
@Data
@Validated
public class LogBusca implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1044322904747203977L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = true, updatable = false, nullable = false, length = 200)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user_created", insertable = true, updatable = false, nullable = true)
    private Usuario criador;

    @NotEmpty
    @Column(name = "search_term", insertable = true, updatable = false, nullable = false, length = 200)
    private String termoBusca;


    @NotEmpty
    @Column(name = "ip_creator", insertable = true, updatable = false, nullable = false, length = 20)
    private String ipCriador;

    @NotNull
    @Column(name = "created_date", insertable = true, updatable = false, nullable = false)
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_site", insertable = true, updatable = false, nullable = true)
    private Site site;


    @Column(name = "hits", insertable = true, updatable = true, nullable = true)
    private Long acessos;

    @NotEmpty
    @Column(name = "idiom", insertable = true, updatable = true, nullable = false, length = 5)
    private String idioma;
}
