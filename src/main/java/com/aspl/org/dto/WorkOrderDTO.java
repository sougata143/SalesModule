package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkOrderDTO {

	private Integer workOrderId;
	
	private String workOrderCode;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date workOrderDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validityDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date custPoDate;
	
	private String custPo;
	private String division;
	private String region;
	private String orderType;
	private CustomerMasterDTO customerId;
	
	private String billingAddr;
	private String shippingAddr;
	
	private PaymentTermsForSalesDTO paymentTerms;
	private PaymentMethodForSalesDTO paymentMethod;
	private ShippingMethodForSalesDTO shippingMethod;
	private DeliveryTermsForSalesDTO deliveryTerms;
	private JurisdictionForSalesDTO jurisdiction;
	private ReminderTermsForSalesDTO reminderTerms;
	
	private CustomerForSalesDTO customer;
	
	private String packingType;
	private Integer salesOrderId;
	
	private String status;
	private String isActive;
	
	private List<WorkOrderDetailsDTO> workOrderDetailsDTO;

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

	public CustomerMasterDTO getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerMasterDTO customerId) {
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

	public CustomerForSalesDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerForSalesDTO customer) {
		this.customer = customer;
	}

	public String getPackingType() {
		return packingType;
	}

	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public List<WorkOrderDetailsDTO> getWorkOrderDetailsDTO() {
		return workOrderDetailsDTO;
	}

	public void setWorkOrderDetailsDTO(List<WorkOrderDetailsDTO> workOrderDetailsDTO) {
		this.workOrderDetailsDTO = workOrderDetailsDTO;
	}

	public Integer getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Integer salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

}
