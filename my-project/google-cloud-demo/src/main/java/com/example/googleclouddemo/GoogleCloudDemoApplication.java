package com.example.googleclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GoogleCloudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleCloudDemoApplication.class, args);
    }
    @RequestMapping(value = "/")
    public String success() {
        return "APP Engine deployment success";
    }
}
