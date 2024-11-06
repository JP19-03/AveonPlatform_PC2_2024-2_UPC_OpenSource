package com.aventon.platform.u202014511;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class U202014511Application {

    public static void main(String[] args) {
        SpringApplication.run(U202014511Application.class, args);
    }

}
