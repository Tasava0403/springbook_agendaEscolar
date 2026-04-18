package com.example.conbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ConBdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConBdApplication.class, args);
    }

}
