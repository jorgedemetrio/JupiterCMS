/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 22 de jan de 2020 14:22:12
 */
@Data
@Validated
@Entity
@Table(name = "tb_price_list")
public class TabelaDePreco extends ControleInformacaoAlteravel {

    /**
     *
     */
    private static final long serialVersionUID = -5842064204445963246L;

    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

    @NotNull
    @Column(name = "start_vigency", insertable = true, updatable = true, nullable = false)
    private Date inicioVigencia;

    @NotNull
    @Column(name = "end_vigency", insertable = true, updatable = true, nullable = false)
    private Date fimVigencia;

    @OneToMany(mappedBy = "id.tabelaPreco")
    private Set<TabelaPrecoProduto> precos;


}
