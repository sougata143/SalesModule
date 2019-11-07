package com.aspl.org.dto;

public class WorkOrderReportDetailsDTO {

	private String itemCode;
	private String itemDescription;
	private String unit;
	private Double quantity;
	private Double eachWt;
	private String totalWt;
	private Double rate;
	private Double total;
	private String custPartName;
	private String itemName;
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getEachWt() {
		return eachWt;
	}
	public void setEachWt(Double eachWt) {
		this.eachWt = eachWt;
	}
	public String getTotalWt() {
		return totalWt;
	}
	public void setTotalWt(String totalWt) {
		this.totalWt = totalWt;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getCustPartName() {
		return custPartName;
	}
	public void setCustPartName(String custPartName) {
		this.custPartName = custPartName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
		
}
