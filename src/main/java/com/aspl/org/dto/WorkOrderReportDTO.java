package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

public class WorkOrderReportDTO {

	private String workOrderCode;
	private Date workOrderDate;
	private Date validateDate;
	private Date deliveryDate;
	private Date custPoDate;
	private String custPoNumber;
	private String division;
	private String region;
	private String type;
	
	private String partyName;
	private String partyAddress;
	private String KindAttn;
	private String partyPhone;
	private String partyFax;
	
	private String amountInWords;
	private String payTerms;
	private String deliveryTerms;
	private String shippingMethod;
	private String paymentMethod;
	private String packingType;
	private String jurisdiction;
	private CustomerMasterDTO customer;
	
	private String billingAddr;
	private String shippingAddr;
	
	private Double totalQnt;
	private Double totalWt;
	private Double basicValue;
	
	private List<WorkOrderReportDetailsDTO> workOrderDetails;

	public String getWorkOrderCode() {
		return workOrderCode;
	}

	public void setWorkOrderCode(String workOrderCode) {
		this.workOrderCode = workOrderCode;
	}

	public Date getWorkOrderDate() {
		return workOrderDate;
	}

	public void setWorkOrderDate(Date workOrderDate) {
		this.workOrderDate = workOrderDate;
	}

	public Date getValidateDate() {
		return validateDate;
	}

	public void setValidateDate(Date validateDate) {
		this.validateDate = validateDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getCustPoDate() {
		return custPoDate;
	}

	public void setCustPoDate(Date custPoDate) {
		this.custPoDate = custPoDate;
	}

	public String getCustPoNumber() {
		return custPoNumber;
	}

	public void setCustPoNumber(String custPoNumber) {
		this.custPoNumber = custPoNumber;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyAddress() {
		return partyAddress;
	}

	public void setPartyAddress(String partyAddress) {
		this.partyAddress = partyAddress;
	}

	public String getKindAttn() {
		return KindAttn;
	}

	public void setKindAttn(String kindAttn) {
		KindAttn = kindAttn;
	}

	public String getPartyPhone() {
		return partyPhone;
	}

	public void setPartyPhone(String partyPhone) {
		this.partyPhone = partyPhone;
	}

	public String getPartyFax() {
		return partyFax;
	}

	public void setPartyFax(String partyFax) {
		this.partyFax = partyFax;
	}

	public String getAmountInWords() {
		return amountInWords;
	}

	public void setAmountInWords(String amountInWords) {
		this.amountInWords = amountInWords;
	}

	public String getPayTerms() {
		return payTerms;
	}

	public void setPayTerms(String payTerms) {
		this.payTerms = payTerms;
	}

	public String getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPackingType() {
		return packingType;
	}

	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public List<WorkOrderReportDetailsDTO> getWorkOrderDetails() {
		return workOrderDetails;
	}

	public void setWorkOrderDetails(List<WorkOrderReportDetailsDTO> workOrderDetails) {
		this.workOrderDetails = workOrderDetails;
	}

	public CustomerMasterDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerMasterDTO customer) {
		this.customer = customer;
	}

	public String getBillingAddr() {
		return billingAddr;
	}

	public void setBillingAddr(String billingAddr) {
		this.billingAddr = billingAddr;
	}

	public String getShippingAddr() {
		return shippingAddr;
	}

	public void setShippingAddr(String shippingAddr) {
		this.shippingAddr = shippingAddr;
	}

	public Double getTotalQnt() {
		return totalQnt;
	}

	public void setTotalQnt(Double totalQnt) {
		this.totalQnt = totalQnt;
	}

	public Double getTotalWt() {
		return totalWt;
	}

	public void setTotalWt(Double totalWt) {
		this.totalWt = totalWt;
	}

	public Double getBasicValue() {
		return basicValue;
	}

	public void setBasicValue(Double basicValue) {
		this.basicValue = basicValue;
	}
	
	
}
