package com.br.alldreams.jupiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

import com.br.alldreams.jupiter.base.messagem.Messagem;

@SpringBootApplication(scanBasePackages = "com.br.alldreams.jupiter")
@EnableCaching
@EnableConfigurationProperties({ Messagem.class })
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
