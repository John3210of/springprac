package com.assignment.loginimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LoginImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginImplApplication.class, args);
    }

}
