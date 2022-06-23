package com.ddlab.rnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService {
	
	@Value(value = "${kafka.topic.name}")
	private String topicName;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void sendMessage(String msg) {
		kafkaTemplate.send(topicName, msg);
		System.out.println("Msg sent successfully ...");
	}
}
