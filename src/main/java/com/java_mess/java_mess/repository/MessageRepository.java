package com.java_mess.java_mess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java_mess.java_mess.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
    @Query(value = "select * from message where channel_id = :channelId order by id desc LIMIT :limit", nativeQuery = true)
    List<Message> listLatestMessages(@Param("channelId") String channelId, @Param(value = "limit") int limit);

    @Query(value = "select * from message where id < :id and channel_id = :channelId order by id desc LIMIT :limit", nativeQuery = true)
    List<Message> listMessagesBeforeId(@Param("id") long id, @Param("channelId") String channelId,
            @Param(value = "limit") int limit);

    @Query(value = "select * from message where id > :id and channel_id = :channelId order by id asc LIMIT :limit", nativeQuery = true)
    List<Message> listMessagesAfterId(@Param("id") long id, @Param("channelId") String channelId,
            @Param(value = "limit") int limit);
}
