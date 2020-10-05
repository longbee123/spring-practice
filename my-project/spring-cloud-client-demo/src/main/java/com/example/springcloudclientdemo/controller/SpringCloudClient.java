package com.example.springcloudclientdemo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RefreshScope
public class SpringCloudClient {
    private static final Logger logs = Logger.getLogger(SpringCloudClient.class.getName());
    @Value("${hello.message}")
    String welcomeText;

    @RequestMapping(value = "/")
    public String welcomeText() {
        logs.log(Level.INFO, "API get messages is calling .......");
        return welcomeText;
    }
}
