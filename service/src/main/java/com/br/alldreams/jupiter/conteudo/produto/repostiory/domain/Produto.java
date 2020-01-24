/**
 *
 */
package com.br.alldreams.jupiter.conteudo.produto.repostiory.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.br.alldreams.jupiter.conteudo.arquivo.repository.domain.Arquivo;
import com.br.alldreams.jupiter.conteudo.base.repository.convert.ImagemConteudoConvert;
import com.br.alldreams.jupiter.conteudo.base.repository.domain.BaseConteudo;
import com.br.alldreams.jupiter.conteudo.base.repository.domain.Imagem;
import com.br.alldreams.jupiter.conteudo.categoria.repository.domain.Categoria;
import com.br.alldreams.jupiter.conteudo.termo.repository.domain.Termo;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 21 de jan de 2020 18:03:06
 */
@Data
@Validated
@Entity
@Table(name = "tb_product")
public class Produto extends BaseConteudo {

    /**
     *
     */
    private static final long serialVersionUID = 6091800854981711237L;

    @NotEmpty
    @Size(min = 1, max = 200)
    @Column(name = "name", insertable = true, updatable = true, nullable = false, length = 200)
    private String nome;

    @Column(name = "description", insertable = true, updatable = true, nullable = true, length = 2000)
    private String descricao;

    @NotNull
    @Column(name = "price", insertable = true, updatable = true, nullable = false)
    private Double preco;

    @NotEmpty
    @Column(name = "sku", insertable = true, updatable = true, nullable = false)
    private String sku;

    @NotNull
    @Column(name = "stock", insertable = true, updatable = true, nullable = false)
    private Double estoque;

    @NotNull
    @Column(name = "type", insertable = true, updatable = true, nullable = false)
    private TipoProdutoEnum tipo;

    @NotNull
    @Column(name = "meansure", insertable = true, updatable = true, nullable = false)
    private MedicaoProdutoEnum medicao;

    @OneToMany(mappedBy = "id.produtoPrincipal")
    private Set<Produto> combinacoes;

    @ManyToMany(mappedBy = "id.produtoPrincipal")
    private Set<Produto> assossiados;

    @OneToMany(mappedBy = "id.produto")
    private Set<TabelaPrecoProduto> precos;

    @ManyToOne
    @JoinColumn(name = "id_category", insertable = true, updatable = true, nullable = false)
    private Categoria categoria;

    @Column(name = "images", insertable = true, updatable = true, nullable = true, length = 2000)
    @Convert(converter = ImagemConteudoConvert.class)
    private List<Imagem> imagens;

    @ManyToMany
    @JoinTable(name = "tb_product_terms", joinColumns = {
            @JoinColumn(name = "id_product", nullable = false, insertable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "id_term", nullable = false, insertable = false, updatable = false) }, uniqueConstraints = {
                            @UniqueConstraint(columnNames = { "id_product",
                                    "id_term" }) }, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_term_product_prod_id"), inverseForeignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_term_product_term_id"))
    private Set<Termo> termos;

    @ManyToMany
    @JoinTable(name = "tb_product_file", joinColumns = {
            @JoinColumn(name = "id_product", nullable = false, insertable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "id_file", nullable = false, insertable = false, updatable = false) }, uniqueConstraints = {
                            @UniqueConstraint(columnNames = { "id_product",
                                    "id_term" }) }, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_term_product_prod_id"), inverseForeignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_file_product_file_id"))
    private Set<Arquivo> arquivos;

}
