package com.java_mess.java_mess.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_mess.java_mess.dto.channel.CreateChannelRequest;
import com.java_mess.java_mess.exception.ChannelExistedException;
import com.java_mess.java_mess.exception.ChannelNotFoundException;
import com.java_mess.java_mess.model.App;
import com.java_mess.java_mess.model.Channel;
import com.java_mess.java_mess.repository.ChannelRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public Channel createChannel(App app, CreateChannelRequest request) {
        log.info("Create channel app={} request={}", app, request);
        if (channelRepository.findByAppIdAndClientReferenceId(app.getId(), request.getClientReferenceId()).isPresent()) {
        throw new ChannelExistedException();
        }
        Channel channel = Channel.builder()
            .clientReferenceId(request.getClientReferenceId())
            .name(request.getName())
            .createdAt(Instant.now())
            .app(app)
            .build();
        Channel savedChannel = channelRepository.save(channel);
        log.info("saved {}", channel.getId());
        return savedChannel;
    }

    @Override
    public Channel getChannelByReferenceId(App app, String clientReferenceId) {
        log.info("Find channel app={} clientReferenceId={}", app, clientReferenceId);
        Optional<Channel> optionalChannel = channelRepository.findByAppIdAndClientReferenceId(app.getId(),
            clientReferenceId);
        return optionalChannel.orElseThrow(() -> new ChannelNotFoundException());
    }

    @Override
    public Channel getChannelById(App app, String id) {
        return channelRepository.findById(id).orElseThrow(() -> new ChannelNotFoundException());
    }
}
