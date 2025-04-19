package com.whykafkawhy.kfkconsumer.services;

import com.whykafkawhy.kfkconsumer.entities.DividendRecord;
import com.whykafkawhy.kfkconsumer.repository.DividendRepository;

public class DividendRecordService {
	
	private final transient DividendRepository repository;
	

	public DividendRecordService(DividendRepository repository) {
		this.repository = repository;
	}
	
	public void saveRecord(DividendRecord record) {
		repository.save(record);
	}
}
