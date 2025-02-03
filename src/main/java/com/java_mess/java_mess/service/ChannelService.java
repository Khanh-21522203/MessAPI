package com.java_mess.java_mess.service;

import org.springframework.stereotype.Service;

import com.java_mess.java_mess.dto.channel.CreateChannelRequest;
import com.java_mess.java_mess.model.App;
import com.java_mess.java_mess.model.Channel;

@Service
public interface ChannelService {
    Channel createChannel(App app, CreateChannelRequest requets);

    Channel getChannelByReferenceId(App app, String clientReferenceId);

    Channel getChannelById(App app, String id);
}
