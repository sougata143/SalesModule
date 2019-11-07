package com.aspl.org.dto;

public class AgentEnquiryQuotationSalesOrderMappingDTO {

	private Integer agentMappingId;
	private Integer agentId;
	private String enquiryCode;
	private String quotationCode;
	private String salesOrderCode;
	private Integer isActive;
	
	public Integer getAgentMappingId() {
		return agentMappingId;
	}
	public void setAgentMappingId(Integer agentMappingId) {
		this.agentMappingId = agentMappingId;
	}
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	public String getEnquiryCode() {
		return enquiryCode;
	}
	public void setEnquiryCode(String enquiryCode) {
		this.enquiryCode = enquiryCode;
	}
	public String getQuotationCode() {
		return quotationCode;
	}
	public void setQuotationCode(String quotationCode) {
		this.quotationCode = quotationCode;
	}
	public String getSalesOrderCode() {
		return salesOrderCode;
	}
	public void setSalesOrderCode(String salesOrderCode) {
		this.salesOrderCode = salesOrderCode;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	
	
}
