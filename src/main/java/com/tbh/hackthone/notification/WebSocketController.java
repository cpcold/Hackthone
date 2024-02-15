package com.tbh.hackthone.notification;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat/{channel}")
    @SendTo("/topic/{channel}")
    public String sendMessage(String message) {
        return message;
    }
}
