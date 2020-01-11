package com.br.alldreams.jupiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.alldreams.jupiter.materia.repository.model.Materia;

@SpringBootApplication
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);

        final Materia m = new Materia();

    }

}
