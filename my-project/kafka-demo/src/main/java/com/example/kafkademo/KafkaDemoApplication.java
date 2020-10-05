package com.example.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaDemoApplication implements ApplicationRunner {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("Newmessage", msg);
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @KafkaListener(topics = "Newmessage", groupId= "group_id")
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sendMessage("Hello Spring Boot !!");
    }
}
