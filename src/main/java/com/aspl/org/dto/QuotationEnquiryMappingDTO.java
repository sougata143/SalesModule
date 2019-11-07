package com.aspl.org.dto;

public class QuotationEnquiryMappingDTO {

	private Integer quotEnqMappingId;
	private Integer enquiryId;
	private Integer quotationId;
	private Integer salesOrderId;
	private Integer isActive;
	public Integer getQuotEnqMappingId() {
		return quotEnqMappingId;
	}
	public void setQuotEnqMappingId(Integer quotEnqMappingId) {
		this.quotEnqMappingId = quotEnqMappingId;
	}
	public Integer getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
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
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	
	
}
