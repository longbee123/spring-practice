package com.example.hystrixdemo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @RequestMapping(value = "/")
    @HystrixCommand(fallbackMethod = "fallback_print1", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String print() throws InterruptedException {
        Thread.sleep(3000);
        return "Hello World !!";
    }

    private String fallback_print(){
        return "Too long !!!!";
    }
    private String fallback_print1() throws Exception {
       return "Waitting ....";
    }
}
