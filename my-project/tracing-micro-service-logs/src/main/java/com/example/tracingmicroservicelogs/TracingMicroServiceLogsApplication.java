package com.example.tracingmicroservicelogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class TracingMicroServiceLogsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracingMicroServiceLogsApplication.class, args);
    }

}
