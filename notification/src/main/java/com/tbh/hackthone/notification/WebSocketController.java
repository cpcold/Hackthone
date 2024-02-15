package com.tbh.hackthone.notification;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @PostMapping("/chat/{channel}")
//    @SendTo("/topic/{channel}")
    public String sendMessage(String message) {
        return message;
    }
}
