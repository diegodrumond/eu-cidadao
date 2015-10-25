package com.gdg.hackathon.eucidadao.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gdg.hackathon.eucidadao.controller")
public class EuCidadaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EuCidadaoApplication.class, args);
    }
}
