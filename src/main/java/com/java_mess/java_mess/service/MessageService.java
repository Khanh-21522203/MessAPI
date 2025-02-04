package com.java_mess.java_mess.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java_mess.java_mess.dto.message.ListMessageRequest;
import com.java_mess.java_mess.dto.message.SendMessageRequest;
import com.java_mess.java_mess.model.App;
import com.java_mess.java_mess.model.Message;

@Service
public interface MessageService {
    Message sendMessage(App app, String channelId, SendMessageRequest request);

    List<Message> listMessages(App app, ListMessageRequest request);
}