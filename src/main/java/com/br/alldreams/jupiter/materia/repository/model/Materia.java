/**
 *
 */
package com.br.alldreams.jupiter.materia.repository.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

import lombok.Data;

/**
 * @author Jorge Demetrio - Note
 * @since 11 de jan de 2020 01:11:09
 * @version 1.0
 */
@Data
@Validated
@DynamoDBTable(tableName = "TBL_MATERIA")
@DynamoDBDocument
public class Materia implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1897130732286197263L;

    @DynamoDBIndexHashKey
    @DynamoDBHashKey(attributeName = "code")
    private String id;

    @NotEmpty
    @Size(min = 1, max = 200)
    @DynamoDBAttribute(attributeName = "title")
    private String titulo;

    @NotEmpty
    @Size(min = 1, max = 200)
    @DynamoDBAttribute(attributeName = "fileName")
    private String nomeArquivo;

    @NotNull
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute(attributeName = "control")
    private Controle controle;

    @NotNull
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute(attributeName = "matadata")
    private MetaDados metadados;

    @NotEmpty
    @DynamoDBAttribute(attributeName = "news")
    private String materia;

    @NotEmpty
    @DynamoDBAttribute(attributeName = "description")
    private String descricao;

    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute(attributeName = "categories")
    private List<Categoria> categorias;

    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute(attributeName = "images")
    private List<Imagem> imagens;

    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute(attributeName = "terms")
    private List<String> termos;
}
