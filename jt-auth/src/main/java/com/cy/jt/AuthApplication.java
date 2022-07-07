package com.cy.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableFeignClients
@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
    }
}
//http://localhost:8099/auth/oauth/token?client_id=gateway-client&client_secret=123456&grant_type=password&username=tony&password=123456
//http://localhost:8099/auth/oauth/check_token