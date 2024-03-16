package com.example.SpringbootKafkaJSON.KafkaProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringbootKafkaJSON.Model.User;

@Service
public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String,User> kafkaTemplate;

	public void sendMessage(User data) {
		LOGGER.info(String.format("Message sent -> %s", data));
		 Message<User> message = MessageBuilder
	                .withPayload(data)
	                .setHeader(KafkaHeaders.TOPIC, "kafkatopic")
	                .build();

	    kafkaTemplate.send(message);
	}

}
