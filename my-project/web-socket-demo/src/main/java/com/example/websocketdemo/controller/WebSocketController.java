package com.example.websocketdemo.controller;

import com.example.websocketdemo.util.Greeting;
import com.example.websocketdemo.util.HelloMessage;
import com.example.websocketdemo.util.Working;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

    @RequestMapping(value = "/")
    public String index(){

        return "index";
    }
    @MessageMapping("/mess")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message){
        return new Greeting(message.getName());
    }
}

