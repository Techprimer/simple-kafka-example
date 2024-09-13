package net.techprimer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	
	
	private KafkaTemplate<String, String> kafkaTemplate;
	public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	
	@GetMapping("/{msg}")
	public String sendMessages(@PathVariable String msg) {
		kafkaTemplate.send("firstTopic",msg);
		return msg;
	}

}
