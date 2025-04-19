package com.whykafkawhy.kfkconsumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.whykafkawhy.kfkconsumer.entities.DividendRecord;

public interface DividendRepository extends MongoRepository<DividendRecord, String>{

}
