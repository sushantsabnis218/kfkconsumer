package com.whykafkawhy.kfkconsumer.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics="sweettooth")
	public void consume(String msg) {
		try {
			Thread.sleep(1000);
			System.out.println("Message Consumed from Kafka : "+msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
