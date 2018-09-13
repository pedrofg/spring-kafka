package com.kafka.consumer.example.springbootkafkaconsumerexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "KafkaExample", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumer Message: " + message);
	}

	@KafkaListener(topics = "KafkaExampleJson", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(User user, Acknowledgment acknowledgment) {
		System.out.println("Consumed Json message: " + user);
	}
}
