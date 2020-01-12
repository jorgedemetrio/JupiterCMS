/**
 *
 */
package com.br.alldreams.jupiter.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:17:44
 * @version 1.0
 */
@Data
@ConfigurationProperties("dynamodb")
public class DynamoDBProperties {

	private String region;

}
