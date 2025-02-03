package com.java_mess.java_mess.repository;

import java.nio.channels.Channel;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, String> {
    Optional<Channel> findByAppIdAndClientReferenceId(String appId, String clientReferenceId);
}
