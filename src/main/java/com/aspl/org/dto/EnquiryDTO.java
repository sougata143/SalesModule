package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EnquiryDTO {
	
	private Integer enquiryId;
	private String enquiryCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date enquiryDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dueDate;
	
	private CustomerMasterDTO customer;
	private String regdOfficeAddr;//from CompanyMaster
	private String billingAddr;//from CompanyMaster
	private String referenceNo;
	private String productType;
	
	private String region;
	private String division;
	
	private List<AgentDetailsDTO> agent;
	
	private String priority;
	private String sourceOfEnquiry;
	private String notes;
	private String next;
	private Integer copy;
	private Integer accepted;
	private Integer isActive;
	
	
	private PaymentTermsForSalesDTO paymentTerms;
	private PaymentMethodForSalesDTO paymentMethod;
	private ShippingMethodForSalesDTO shippingMethod;
	private DeliveryTermsForSalesDTO deliveryTerms;
	private JurisdictionForSalesDTO jurisdiction;
	private ReminderTermsForSalesDTO reminderTerms;
	
	private List<EnquiryDetailsDTO> enquiryDetails;

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getEnquiryCode() {
		return enquiryCode;
	}

	public void setEnquiryCode(String enquiryCode) {
		this.enquiryCode = enquiryCode;
	}

	public Date getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public CustomerMasterDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerMasterDTO customer) {
		this.customer = customer;
	}

	public String getRegdOfficeAddr() {
		return regdOfficeAddr;
	}

	public void setRegdOfficeAddr(String regdOfficeAddr) {
		this.regdOfficeAddr = regdOfficeAddr;
	}

	public String getBillingAddr() {
		return billingAddr;
	}

	public void setBillingAddr(String billingAddr) {
		this.billingAddr = billingAddr;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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

	public List<AgentDetailsDTO> getAgent() {
		return agent;
	}

	public void setAgent(List<AgentDetailsDTO> agent) {
		this.agent = agent;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getSourceOfEnquiry() {
		return sourceOfEnquiry;
	}

	public void setSourceOfEnquiry(String sourceOfEnquiry) {
		this.sourceOfEnquiry = sourceOfEnquiry;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public Integer getCopy() {
		return copy;
	}

	public void setCopy(Integer copy) {
		this.copy = copy;
	}

	public Integer getAccepted() {
		return accepted;
	}

	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public PaymentTermsForSalesDTO getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(PaymentTermsForSalesDTO paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public PaymentMethodForSalesDTO getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethodForSalesDTO paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public ShippingMethodForSalesDTO getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethodForSalesDTO shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public DeliveryTermsForSalesDTO getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(DeliveryTermsForSalesDTO deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public JurisdictionForSalesDTO getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(JurisdictionForSalesDTO jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public ReminderTermsForSalesDTO getReminderTerms() {
		return reminderTerms;
	}

	public void setReminderTerms(ReminderTermsForSalesDTO reminderTerms) {
		this.reminderTerms = reminderTerms;
	}

	public List<EnquiryDetailsDTO> getEnquiryDetails() {
		return enquiryDetails;
	}

	public void setEnquiryDetails(List<EnquiryDetailsDTO> enquiryDetails) {
		this.enquiryDetails = enquiryDetails;
	}

	


}
