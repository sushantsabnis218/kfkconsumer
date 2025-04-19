package com.whykafkawhy.kfkconsumer.services;

import org.bson.json.JsonObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whykafkawhy.kfkconsumer.entities.DividendRecord;
import com.whykafkawhy.kfkconsumer.repository.DividendRepository;

@Service
public class KafkaConsumerService {
	
	private final transient DividendRepository repository;
	
	public KafkaConsumerService(DividendRepository repository){
		this.repository = repository;
	}

	@KafkaListener(topics="sweettooth")
	public void consume(String msg) {
		try {
			Thread.sleep(1000);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode= mapper.readTree(msg);
			System.out.println("Rootnode as text : "+rootNode.toPrettyString());
			System.out.println(rootNode.isTextual());
			if(rootNode.isTextual()) {
				rootNode = mapper.readTree(rootNode.asText());
				System.out.println("Rootnode has results : "+rootNode.has("results"));
				if(rootNode.has("results")) {
					JsonNode resultsNodeArr = rootNode.get("results");
					if(resultsNodeArr.isArray()) {
						System.out.println("Results arr :"+resultsNodeArr.toPrettyString());
						for(JsonNode result : resultsNodeArr) {
							System.out.println(result.toPrettyString());
							DividendRecord record = mapper.treeToValue(result, DividendRecord.class);
							repository.save(record);
						}
					}
				}
			}
			System.out.println("Message consumed from kafka : "+msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
