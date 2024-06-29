package com.krtopi.backend.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krtopi.backend.config.KafkaConfigProps;
import org.springframework.kafka.core.KafkaTemplate;

public class ChatServiceImpl implements ChatService{
    private ObjectMapper objectMapper;
    private KafkaTemplate<String, String> kafkaTemplate;
    private KafkaConfigProps kafkaConfigProps;
    public ChatServiceImpl(
            final ObjectMapper objectMapper,
            final KafkaTemplate<String, String> kafkaTemplate,
            final KafkaConfigProps kafkaConfigProps) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigProps = kafkaConfigProps;
    }
}
