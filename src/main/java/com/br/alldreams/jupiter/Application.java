package com.br.alldreams.jupiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.br.alldreams.jupiter.base.messagem.Messagem;
import com.br.alldreams.jupiter.config.properties.DynamoDBProperties;
import com.br.alldreams.jupiter.materia.repository.model.Materia;

@SpringBootApplication
@EnableConfigurationProperties({ Messagem.class, DynamoDBProperties.class })
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);

        final Materia m = new Materia();

    }

}
