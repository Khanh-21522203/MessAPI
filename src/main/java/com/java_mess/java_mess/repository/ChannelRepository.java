package com.java_mess.java_mess.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java_mess.java_mess.model.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, String> {
    Optional<Channel> findByAppIdAndClientReferenceId(String appId, String clientReferenceId);
}
