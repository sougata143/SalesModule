package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

public class QuotationReportDTO {

	private String quotationCode;
	private Date quotationDate;
	private Date validationDate;
	private CustomerMasterDTO customer;
	private String billTo;
	private String shipTo;
	private String enquiry;
	private String productType;
	private String lst;
	private String region;
	private String division;
	private AgentDetailsDTO agent;
	private Double creditLimit;
	private Double outStanding;
	private String freightType;
	private String rateList;
	private Double assesableValue;
	private Double pkg;
	private Double igst;
	private Double cgst;
	private Double sgst;
	private Double insurance;
	private Double otherCharges;
	private Double grandTotal;

	private List<MarketingDetailsDTO> marketing;
	
	private String paymentTerms;
	private String paymentMethod;
	private String shippingMethod;
	private String deliveryTerms;
	private String jurisdiction;
	
	private List<QuotationDetailsReportDTO> quotationItems;

	public String getQuotationCode() {
		return quotationCode;
	}

	public void setQuotationCode(String quotationCode) {
		this.quotationCode = quotationCode;
	}

	public Date getQuotationDate() {
		return quotationDate;
	}

	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}

	public Date getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}

	public CustomerMasterDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerMasterDTO customer) {
		this.customer = customer;
	}

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public String getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(String enquiry) {
		this.enquiry = enquiry;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getLst() {
		return lst;
	}

	public void setLst(String lst) {
		this.lst = lst;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public AgentDetailsDTO getAgent() {
		return agent;
	}

	public void setAgent(AgentDetailsDTO agent) {
		this.agent = agent;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Double getOutStanding() {
		return outStanding;
	}

	public void setOutStanding(Double outStanding) {
		this.outStanding = outStanding;
	}

	public String getFreightType() {
		return freightType;
	}

	public void setFreightType(String freightType) {
		this.freightType = freightType;
	}

	public String getRateList() {
		return rateList;
	}

	public void setRateList(String rateList) {
		this.rateList = rateList;
	}

	public Double getAssesableValue() {
		return assesableValue;
	}

	public void setAssesableValue(Double assesableValue) {
		this.assesableValue = assesableValue;
	}

	public Double getPkg() {
		return pkg;
	}

	public void setPkg(Double pkg) {
		this.pkg = pkg;
	}

	public Double getIgst() {
		return igst;
	}

	public void setIgst(Double igst) {
		this.igst = igst;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getInsurance() {
		return insurance;
	}

	public void setInsurance(Double insurance) {
		this.insurance = insurance;
	}

	public Double getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(Double otherCharges) {
		this.otherCharges = otherCharges;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<MarketingDetailsDTO> getMarketing() {
		return marketing;
	}

	public void setMarketing(List<MarketingDetailsDTO> marketing) {
		this.marketing = marketing;
	}

	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public List<QuotationDetailsReportDTO> getQuotationItems() {
		return quotationItems;
	}

	public void setQuotationItems(List<QuotationDetailsReportDTO> quotationItems) {
		this.quotationItems = quotationItems;
	}

	
}
