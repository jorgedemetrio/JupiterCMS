/**
 *
 */
package com.br.alldreams.jupiter.conteudo.base.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jorge Demetrio
 * @since 14 de jan de 2020 23:10:48
 * @version 1.0
 */
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseConteudo extends ControleInformacaoAlteravel {

	@Id
	@Column(name = "id", insertable = true, updatable = false, nullable = false, length = 200)
	private String id;

	@NotEmpty
	@Size(min = 1, max = 250)
	@Column(name = "meta_description", insertable = true, updatable = true, nullable = true, length = 250)
	private String metaDescricao;

    @Column(name = "hits", insertable = true, updatable = true, nullable = true)
    private Long acessos;

    @Column(name = "likes", insertable = true, updatable = true, nullable = true)
    private Long curtidas;

	@NotEmpty
	@Size(min = 1, max = 250)
	@Column(name = "meta_keywords", insertable = true, updatable = true, nullable = true, length = 250)
	private String palavrasChave;

	@NotEmpty
	@Size(min = 1, max = 250)
	@Column(name = "file_name", insertable = true, updatable = true, nullable = false, length = 250)
	private String nomeArquivo;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status", insertable = true, updatable = true, nullable = false, length = 250)
	private StatusConteudoEnum status;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "access", insertable = true, updatable = true, nullable = false, length = 20)
    private AcessoEnum acesso;

    @NotEmpty
    @Column(name = "idiom", insertable = true, updatable = true, nullable = false, length = 5)
    private String idioma;

}
