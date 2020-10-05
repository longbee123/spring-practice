package com.example.springadminserver;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdminServerApplication.class, args);
    }

}
