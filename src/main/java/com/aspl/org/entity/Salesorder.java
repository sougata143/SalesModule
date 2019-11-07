package com.aspl.org.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sales_order")

public class Salesorder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer salesorderId;
	@Column(name="salesorder_code")
	private String salesorderCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date orderDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validityDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	private String salesService;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date purchaseDate;
	@Column(name="is_active",columnDefinition="smallint(11) default 1")
	private Integer isActive;
	private String regdOfficeAddr;//from CompanyMaster
	private String billingAddr;//from CompanyMaster
	private Integer quotation;
	
	private String purchaseCode;
	private String customer;
	private String amendmentNumber;
	private Date amendmentDate;
	private String region;
	private String division;
	private String productType;
	private Double creditLimit;
	private Double outStanding;
	@Column(columnDefinition="int(11) default '1'")
	private Integer accepted;
	private String authorise;
	
	private Double cgst;
	private Double sgst;
	private Double igst;
	private Double total_with_gst;
	private Double freight;
	private String freightType;
	private Double royalty;
	private Double accessibleValue;
	private String insurance;
	private Double otherCharges;
	private Double grandTotal;
	private String currency;
	private String packingType;
	private String specification; 
	private String marketing;
	private String purchase;
	private String manufacturing;
	private String jobber;
	
	private Double pkg;
	private String advance;
	private String balance;
	//private String manufacturing;
	
	
	private Integer paymentTermsId;
	private Integer paymentMethodId;
	private Integer shippingMethodId;
	private Integer deliveryTermsId;
	private Integer jurisdictionId;
	private Integer reminderTerms;
	
	//As per UI changes
	private String poReference;
	private Integer lst;
	private String rateList;
	private String bookedBy;
	private String notes;
	private Date revalidate;
	
	private Integer status;
	private Date createdDate;
	private Integer salesorderStatus;
 
	/*
	 * For editing purpose UI needs these fields
	 */
	private Double pkgPer;
	private Double accessibleValuePer;
	private Double freightPer;
	private Double royaltyPer;
	private Double igstPer;
	private Double cgstPer;
	private Double sgstPer;
	
	private Integer quotSalesOrderMappingId;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="salesorder")
	List<SalesorderDetails> salesorderDetails;

	public Integer getSalesorderId() {
		return salesorderId;
	}

	public void setSalesorderId(Integer salesorderId) {
		this.salesorderId = salesorderId;
	}

	public String getSalesorderCode() {
		return salesorderCode;
	}

	public void setSalesorderCode(String salesorderCode) {
		this.salesorderCode = salesorderCode;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public String getSalesService() {
		return salesService;
	}

	public void setSalesService(String salesService) {
		this.salesService = salesService;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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

	public Integer getQuotation() {
		return quotation;
	}

	public void setQuotation(Integer quotation) {
		this.quotation = quotation;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getAmendmentNumber() {
		return amendmentNumber;
	}

	public void setAmendmentNumber(String amendmentNumber) {
		this.amendmentNumber = amendmentNumber;
	}

	public Date getAmendmentDate() {
		return amendmentDate;
	}

	public void setAmendmentDate(Date amendmentDate) {
		this.amendmentDate = amendmentDate;
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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

	public Integer getAccepted() {
		return accepted;
	}

	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}

	public String getAuthorise() {
		return authorise;
	}

	public void setAuthorise(String authorise) {
		this.authorise = authorise;
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

	public Double getIgst() {
		return igst;
	}

	public void setIgst(Double igst) {
		this.igst = igst;
	}

	public Double getTotal_with_gst() {
		return total_with_gst;
	}

	public void setTotal_with_gst(Double total_with_gst) {
		this.total_with_gst = total_with_gst;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getFreightType() {
		return freightType;
	}

	public void setFreightType(String freightType) {
		this.freightType = freightType;
	}

	public Double getRoyalty() {
		return royalty;
	}

	public void setRoyalty(Double royalty) {
		this.royalty = royalty;
	}

	public Double getAccessibleValue() {
		return accessibleValue;
	}

	public void setAccessibleValue(Double accessibleValue) {
		this.accessibleValue = accessibleValue;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPackingType() {
		return packingType;
	}

	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getMarketing() {
		return marketing;
	}

	public void setMarketing(String marketing) {
		this.marketing = marketing;
	}

	public String getPurchase() {
		return purchase;
	}

	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}

	public String getManufacturing() {
		return manufacturing;
	}

	public void setManufacturing(String manufacturing) {
		this.manufacturing = manufacturing;
	}

	public String getJobber() {
		return jobber;
	}

	public void setJobber(String jobber) {
		this.jobber = jobber;
	}

	public Double getPkg() {
		return pkg;
	}

	public void setPkg(Double pkg) {
		this.pkg = pkg;
	}

	public String getAdvance() {
		return advance;
	}

	public void setAdvance(String advance) {
		this.advance = advance;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getSalesorderStatus() {
		return salesorderStatus;
	}

	public void setSalesorderStatus(Integer salesorderStatus) {
		this.salesorderStatus = salesorderStatus;
	}

	public Double getPkgPer() {
		return pkgPer;
	}

	public void setPkgPer(Double pkgPer) {
		this.pkgPer = pkgPer;
	}

	public Double getAccessibleValuePer() {
		return accessibleValuePer;
	}

	public void setAccessibleValuePer(Double accessibleValuePer) {
		this.accessibleValuePer = accessibleValuePer;
	}

	public Double getFreightPer() {
		return freightPer;
	}

	public void setFreightPer(Double freightPer) {
		this.freightPer = freightPer;
	}

	public Double getRoyaltyPer() {
		return royaltyPer;
	}

	public void setRoyaltyPer(Double royaltyPer) {
		this.royaltyPer = royaltyPer;
	}

	public Double getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(Double igstPer) {
		this.igstPer = igstPer;
	}

	public Double getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(Double cgstPer) {
		this.cgstPer = cgstPer;
	}

	public Double getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(Double sgstPer) {
		this.sgstPer = sgstPer;
	}

	public Integer getQuotSalesOrderMappingId() {
		return quotSalesOrderMappingId;
	}

	public void setQuotSalesOrderMappingId(Integer quotSalesOrderMappingId) {
		this.quotSalesOrderMappingId = quotSalesOrderMappingId;
	}

	public List<SalesorderDetails> getSalesorderDetails() {
		return salesorderDetails;
	}

	public void setSalesorderDetails(List<SalesorderDetails> salesorderDetails) {
		this.salesorderDetails = salesorderDetails;
	}

	public Integer getReminderTerms() {
		return reminderTerms;
	}

	public void setReminderTerms(Integer reminderTerms) {
		this.reminderTerms = reminderTerms;
	}

	public String getPoReference() {
		return poReference;
	}

	public void setPoReference(String poReference) {
		this.poReference = poReference;
	}

	public Integer getLst() {
		return lst;
	}

	public void setLst(Integer lst) {
		this.lst = lst;
	}

	public String getRateList() {
		return rateList;
	}

	public void setRateList(String rateList) {
		this.rateList = rateList;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getRevalidate() {
		return revalidate;
	}

	public void setRevalidate(Date revalidate) {
		this.revalidate = revalidate;
	}

	

}
