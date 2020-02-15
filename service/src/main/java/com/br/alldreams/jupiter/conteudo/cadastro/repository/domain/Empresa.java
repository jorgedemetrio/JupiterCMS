/**
 *
 */
package com.br.alldreams.jupiter.conteudo.cadastro.repository.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;
import com.br.alldreams.jupiter.base.domain.StatusEnum;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 27 de jan de 2020 15:59:14
 */
@Entity
@Table(name = "tb_company")
@Data
@Validated
public class Empresa extends ControleInformacaoAlteravel {

    /**
     *
     */
    private static final long serialVersionUID = 3064904215235778668L;

    @NotEmpty
    @Size(min = 1, max = 2000)
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 2000)
    private String nomeFantasia;

    @Column(name = "full_name", insertable = true, updatable = true, nullable = true, length = 2000)
    private String razaoSocial;

    @Column(name = "website", insertable = true, updatable = true, nullable = true, length = 250)
    private String website;

    @NotEmpty
    @Size(min = 1, max = 2000)
    @Column(name = "about", insertable = true, updatable = true, nullable = true, length = 2000)
    private String sobre;

    @CNPJ
    @Column(name = "national_tax_num", insertable = true, updatable = true, nullable = true, length = 20)
    private String cnpj;

    @NotNull
    @Column(name = "status", insertable = true, updatable = true, nullable = false, length = 1)
    private StatusEnum status;

    @OneToMany(mappedBy = "empresa")
    private List<TelefoneEmpresa> telefones;

    @OneToMany(mappedBy = "empresa")
    private List<EmailEmpresa> emails;

    @OneToMany(mappedBy = "empresa")
    private List<EnderecoEmpresa> enderecos;
}
