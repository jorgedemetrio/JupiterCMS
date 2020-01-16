/**
 *
 */
package com.br.alldreams.jupiter.site.repository.model;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:37:11
 */
public enum TipoMenuEnum {
    /*
     * Geral
     */
    SEPARADOR,
    BRANCO,
    SITEMAP,

    /*
     * Conteúdo
     */
    CONTEUDOS_CONTEUDO_ESPECIFICO,
    CONTEUDOS_BLOG_CATEGORIA,
    CONTEUDOS_LISTA_CATEGORIA,
    CONTEUDOS_DESTAQUE,

    /*
     * Usuário
     */
    USUARIOS_LOGIN,
    USUARIOS_LOGOUT,
    USUARIOS_PROFILE,
    USUARIOS_EDITAR_PROFILE,
    USUARIOS_TROCAR_SENHA,
    USUARIOS_ESQUECI_SENHA,


    /*
     * Buscas
     */
    BUSCAS_BUSCA_SIMPLES,
    BUSCAS_BUSCA_AVANCADA,


    /*
     * Enquete
     */
    ENQUETES_ENQUETE_ESPECIFICA,
    ENQUETES_LISTA,
    ESQUETES_LISTA_CATEGORIAS,
    ENQUETES_BLOG_CATEGORIAS,

    /*
     * Contato
     */
    CONTATOS_ENQUETE_ESPECIFICA,
    CONTATOS_LISTA,
    CONTATOS_LISTA_CATEGORIAS,
    CONTATOS_BLOG_CATEGORIAS;

}
