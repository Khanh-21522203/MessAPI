package com.java_mess.java_mess.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.java_mess.java_mess.dto.message.MessageEvent;

@Service
public class KafkaSender {
    private final KafkaTemplate<String, MessageEvent> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, MessageEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, MessageEvent message) {
        kafkaTemplate.send(topic, message);
    }
}
