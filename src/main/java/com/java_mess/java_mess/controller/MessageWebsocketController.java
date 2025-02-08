package com.java_mess.java_mess.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.java_mess.java_mess.dto.message.MessageEvent;

@Controller
public class MessageWebsocketController {
    @MessageMapping("/sendMessage")
    @SendTo("/topic/group")
    public MessageEvent broadcastGroupMessage(@Payload MessageEvent message) {
        //Sending this message to all the subscribers
        return message;
    }

    @MessageMapping("/newUser")
    @SendTo("/topic/group")
    public MessageEvent addUser(@Payload MessageEvent message,
                           SimpMessageHeaderAccessor headerAccessor) {
        // Add user in web socket session
        if (headerAccessor.getSessionAttributes() != null) {
            headerAccessor.getSessionAttributes().put("username", message.getClientUserId());
        }
        return message;
    }
}
