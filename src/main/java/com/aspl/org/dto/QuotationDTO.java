package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class QuotationDTO {

	private Integer quotationId;
	private String quotationCode;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date quotationDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validationDate;
	
	private String billTo;
	private String shipTo;
	private List<EnquiryForSalesDTO> enquiry;
	private String productType;
	private String lst;
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
	
	//updated fields as per the UI
	private Double pkgPer;
	private Double freight;
	private Double freightPer;
	private Double royalty;
	private Double royaltyPer;
	private Double igstPer;
	private Double cgstPer;
	private Double sgstPer;
	private String packingType;
	private String notes;
	private String preparedBy;
	private Date revalidate;
	
	private String region;
	private String division;
	
	private List<AgentDetailsDTO> agent;
	
	private CustomerForSalesDTO customer;
	
	private PaymentTermsForSalesDTO paymentTerms;
	private PaymentMethodForSalesDTO paymentMethod;
	private ShippingMethodForSalesDTO shippingMethod;
	private DeliveryTermsForSalesDTO deliveryTerms;
	private JurisdictionForSalesDTO jurisdiction;
	private ReminderTermsForSalesDTO reminderTerms;
	
	private List<MarketingDetailsDTO> marketingDetails;
	
	private List<QuotationDetailsDTO> quotationItems;

	public Integer getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(Integer quotationId) {
		this.quotationId = quotationId;
	}

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

	public List<EnquiryForSalesDTO> getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(List<EnquiryForSalesDTO> enquiry) {
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

	public Double getPkgPer() {
		return pkgPer;
	}

	public void setPkgPer(Double pkgPer) {
		this.pkgPer = pkgPer;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Double getFreightPer() {
		return freightPer;
	}

	public void setFreightPer(Double freightPer) {
		this.freightPer = freightPer;
	}

	public Double getRoyalty() {
		return royalty;
	}

	public void setRoyalty(Double royalty) {
		this.royalty = royalty;
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

	public String getPackingType() {
		return packingType;
	}

	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
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

	public CustomerForSalesDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerForSalesDTO customer) {
		this.customer = customer;
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

	public List<MarketingDetailsDTO> getMarketingDetails() {
		return marketingDetails;
	}

	public void setMarketingDetails(List<MarketingDetailsDTO> marketingDetails) {
		this.marketingDetails = marketingDetails;
	}

	public List<QuotationDetailsDTO> getQuotationItems() {
		return quotationItems;
	}

	public void setQuotationItems(List<QuotationDetailsDTO> quotationItems) {
		this.quotationItems = quotationItems;
	}

	public Date getRevalidate() {
		return revalidate;
	}

	public void setRevalidate(Date revalidate) {
		this.revalidate = revalidate;
	}
	
}
