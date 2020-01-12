package com.br.alldreams.jupiter.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.br.alldreams.jupiter.config.properties.DynamoDBProperties;

import lombok.RequiredArgsConstructor;

/**
 *
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:15:49
 * @version 1.0
 */
@Configuration
@RequiredArgsConstructor
@EnableDynamoDBRepositories
  (basePackages = { "com.br.alldreams.jupiter.materia.repository"})
public class DynamoDBConfig {


	private final DynamoDBProperties properties;

	/**
	 * Retorna amazonAWSCredentials.
	 *
	 * @return Um AWSCredentialsProvider.
	 * @since 12 de jan de 2020 03:15:54
	 */
    @Bean
    public AWSCredentialsProvider amazonAWSCredentials() {
        return new DefaultAWSCredentialsProviderChain();
    }

	/**
	 * Retorna um AmazonDynamoDB.
	 *
	 * @param credentialsProvider Credenciais.
	 * @return Um AmazonDynamoDB.
	 * @since 12 de jan de 2020 03:16:39
	 */
    @Bean
    public AmazonDynamoDB amazonDynamoDB(final AWSCredentialsProvider credentialsProvider) {
		return AmazonDynamoDBClientBuilder.standard()
        		.withCredentials(credentialsProvider)
				.withRegion(Regions.fromName(properties.getRegion()))
        		.build();


    }

}
