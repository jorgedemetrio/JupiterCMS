/**
 *
 */
package com.br.alldreams.jupiter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 *
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 17:47:12
 * @version 1.0
 */
@Configuration
public class ThymeleafConfig {

//org.springframework.web.servlet.mvc.annotation.
//org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter
//org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
