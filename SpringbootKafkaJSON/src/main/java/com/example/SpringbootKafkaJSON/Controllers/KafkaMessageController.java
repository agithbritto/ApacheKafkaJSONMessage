package com.example.SpringbootKafkaJSON.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringbootKafkaJSON.KafkaProducer.KafkaProducer;
import com.example.SpringbootKafkaJSON.Model.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaMessageController {
	private KafkaProducer kafkaProducer;

    public KafkaMessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to kafka topic");
    }

}
