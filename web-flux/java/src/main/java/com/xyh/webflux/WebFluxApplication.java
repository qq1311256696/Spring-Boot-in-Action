package com.xyh.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class, args);
    }

}
