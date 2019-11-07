package com.aspl.org.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="work_order")
public class WorkOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer workOrderId;
	
	private String workOrderCode;
	private Date workOrderDate;
	private Date validityDate;
	private Date deliveryDate;
	private Date custPoDate;
	private String custPo;
	private String division;
	private String region;
	private String orderType;
	private String vendorId;
	
	private String payTerms;
	private String payMethod;
	private String deliveryTerms;
	private String shippingMethod;
	private String jurisdiction;

	private Integer customerId;
	private String billingAddr;
	private String shippingAddr;
	
	private String packingType;
	private Integer salesOrderId;
	
	private Integer status;
	private Integer isActive;

	public Integer getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(Integer workOrderId) {
		this.workOrderId = workOrderId;
	}

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

	public Date getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
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

	public String getCustPo() {
		return custPo;
	}

	public void setCustPo(String custPo) {
		this.custPo = custPo;
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getPayTerms() {
		return payTerms;
	}

	public void setPayTerms(String payTerms) {
		this.payTerms = payTerms;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
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

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getPackingType() {
		return packingType;
	}

	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public Integer getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Integer salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	
	
	
}
