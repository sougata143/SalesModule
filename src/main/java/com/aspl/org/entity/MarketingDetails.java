package com.aspl.org.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marketing_details")
public class MarketingDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer marketingId;
	
	private String terms;
	private String description;
	private Integer quotationId;
	private Integer salesOrderId;
	
	public Integer getMarketingId() {
		return marketingId;
	}
	public void setMarketingId(Integer marketingId) {
		this.marketingId = marketingId;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(Integer quotationId) {
		this.quotationId = quotationId;
	}
	public Integer getSalesOrderId() {
		return salesOrderId;
	}
	public void setSalesOrderId(Integer salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	
}
