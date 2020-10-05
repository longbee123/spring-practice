package com.example.springcloudclientdemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringCloudClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientDemoApplication.class, args);
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
