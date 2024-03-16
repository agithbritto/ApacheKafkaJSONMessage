package com.example.SpringbootKafkaJSON.KafkaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringbootKafkaJSON.Model.User;

@Service
public class KafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "group-id")
	public void consume(User message){
        LOGGER.info(String.format("Message received -> %s", message.toString()));
    }

}
