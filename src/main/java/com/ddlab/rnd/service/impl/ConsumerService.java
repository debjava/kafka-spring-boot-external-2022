package com.ddlab.rnd.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@KafkaListener(topics = "${kafka.topic.name}")
	public void consume(String msg) {
		System.out.println("Message received by consumer as: "+msg);
	}
}
