package com.aspl.org.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="enquiry_sales")
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer enquiryId;
	@Column(name="enquiry_code")
	private String enquiryCode;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date enquiryDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dueDate;
	private Integer customer;
	private String regdOfficeAddr;//from CompanyMaster
	private String billingAddr;//from CompanyMaster
	private String referenceNo;
	private String productType;
	private String region;
	private String division;
	private String priority;
	private String sourceOfEnquiry;
	private String notes;
	private String next;
	private Integer accepted;
	
	private Integer agent;
	
	
	private Integer paymentTermsId;
	private Integer paymentMethodId;
	private Integer shippingMethodId;
	private Integer deliveryTermsId;
	private Integer jurisdictionId;
	private Integer reminderTerms;
	
	private Integer status;
	@Column(columnDefinition="int(11) default '1'")
	private Integer copy;
	@Column(name="is_active",columnDefinition="smallint(11) default '1'")
	private Integer isActive;
	
	
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
	public Integer getCustomer() {
		return customer;
	}
	public void setCustomer(Integer customer) {
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
	public Integer getAccepted() {
		return accepted;
	}
	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}
	public Integer getAgent() {
		return agent;
	}
	public void setAgent(Integer agent) {
		this.agent = agent;
	}
	public Integer getPaymentTermsId() {
		return paymentTermsId;
	}
	public void setPaymentTermsId(Integer paymentTermsId) {
		this.paymentTermsId = paymentTermsId;
	}
	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public Integer getShippingMethodId() {
		return shippingMethodId;
	}
	public void setShippingMethodId(Integer shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}
	public Integer getDeliveryTermsId() {
		return deliveryTermsId;
	}
	public void setDeliveryTermsId(Integer deliveryTermsId) {
		this.deliveryTermsId = deliveryTermsId;
	}
	public Integer getJurisdictionId() {
		return jurisdictionId;
	}
	public void setJurisdictionId(Integer jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCopy() {
		return copy;
	}
	public void setCopy(Integer copy) {
		this.copy = copy;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getReminderTerms() {
		return reminderTerms;
	}
	public void setReminderTerms(Integer reminderTerms) {
		this.reminderTerms = reminderTerms;
	}

	

}
