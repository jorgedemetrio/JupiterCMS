/**
 *
 */
package com.br.alldreams.jupiter.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Jorge Demetrio
 * @since 17 de jan de 2020 02:24:54
 * @version 1.0
 */
@Profile("!dev && !test")
@EnableCaching
@Configuration
public class CachingConfiguration {

}
