package com.krtopi.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krtopi.backend.chat.KafkaMessageEvent;
import com.krtopi.backend.config.KafkaConfigProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class KrtopiBackendServerApplication {

	@Autowired
	private ObjectMapper objectMapper;

	public static void main(String[] args) {
		SpringApplication.run(KrtopiBackendServerApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(final KafkaTemplate<String, String> kafkaTemplate, final KafkaConfigProps kafkaConfigProps) throws JsonProcessingException{
		final KafkaMessageEvent event = new KafkaMessageEvent();
		event.setDatetime(LocalDateTime.now());
		event.setId(UUID.randomUUID().toString());
		final String payload = objectMapper.writeValueAsString(event);

		return args -> {
			kafkaTemplate.send(kafkaConfigProps.getTopic(), payload);
		};
	}
	@KafkaListener(topics = "messages")
	public String listens(final String in){
		System.out.println(in);
		return in;
	}

}
