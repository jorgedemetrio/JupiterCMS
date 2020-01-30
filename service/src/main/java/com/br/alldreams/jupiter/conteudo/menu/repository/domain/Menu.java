/**
 *
 */
package com.br.alldreams.jupiter.conteudo.menu.repository.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:33:14
 */
@Data
@Validated
@Entity
@Table(name = "tb_menu")
public class Menu extends BaseConteudo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7981957669065042605L;

    @NotEmpty
    @Column(name = "name", insertable = true, updatable = true, nullable = true, unique = false, length = 200)
    private String nome;

    @NotNull
    @Column(name = "type", insertable = true, updatable = true, nullable = true, unique = false)
    private TipoMenuEnum tipo;

    @OneToMany(mappedBy = "pai")
    private List<Menu> filhos;

    @ManyToOne
    @JoinColumn(name = "parent", insertable = true, updatable = true, nullable = true, unique = false)
    private Menu pai;

    @NotNull
    @Column(name = "parameters", insertable = true, updatable = true, nullable = true, unique = false, length = 200)
    private HashMap<String, String> parametros;

    @NotNull
    @Column(name = "startpage", insertable = true, updatable = true, nullable = false, unique = false)
    private Boolean homepage;

    @NotNull
    @Column(name = "layout", insertable = true, updatable = true, nullable = false, unique = false, length = 50)
    private String layout;

}
