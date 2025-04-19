package com.whykafkawhy.kfkconsumer.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Sample record 
 * 			"cash_amount": 0.15,
            "currency": "CNY",
            "dividend_type": "CD",
            "ex_dividend_date": "2000-08-15",
            "frequency": 1,
            "id": "E4a7d4e17e772232caf90d14c98574c1e7b15c49c94246678bd28b603e0501954",
            "pay_date": "2000-08-18",
            "record_date": "2000-08-16",
            "ticker": "CHVKF"
 */
@Document(collection="dividend")
public class DividendRecord {
	
	@Id
	private String id;
	 
	@JsonProperty("id")
	private String recordId;

	@JsonProperty("cash_amount")
	private Integer cashAmount;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("dividend_type")
	private String dividendType;
	
	@JsonProperty("ex_dividend_date")
	private String exDividendDate;
	
	@JsonProperty("frequency")
	private Integer frequency;
	
	@JsonProperty("pay_date")
	private String payDate;
	
	@JsonProperty("record_date")
	private String recordDate;
	
	@JsonProperty("ticker")
	private String ticker;
	
	@JsonProperty("declaration_date")
	private String declarationDate;
}
