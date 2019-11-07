package com.aspl.org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="salesorder_details")
public class SalesorderDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer salesOrderDetailsId;
	
	  private Integer soid;
	  @Column(name = "Item_Code")
		private String itemCode;
	  
	private String salesorderCode;
	private Integer itemId;
	private String custPartNo;
	private String custPartName;
	private String material;
	private Integer agentId;
	
	private String notes;
	private String preparedBy;
	private Integer quotationId;
	
	private Double weight;
	private String unit;
	
	private Integer revisionNo;
	private Integer drawingNo;
	private Double qty;
	private String rateType;
	private Double totalWeight;
	private Double unitPrice;
	private Double sellingPrice;
	private Double total;
	private Double discount;
	private Double machiningCostPerPiece;
	private Double totalMachiningCost;
	private Double machiningToolingCost;
	private Double amortisationQty;
	private Double amortisationValue;
	private Double assessibleValue;
	private Double roundOff;
	private String remarks;
	
	private Integer uom;
	
	private Integer soDetailsStaus;
	
	private Integer status;
	private Integer isActive;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="soid",insertable=false,updatable=false)
	Salesorder salesorder;

	public Integer getSalesOrderDetailsId() {
		return salesOrderDetailsId;
	}

	public void setSalesOrderDetailsId(Integer salesOrderDetailsId) {
		this.salesOrderDetailsId = salesOrderDetailsId;
	}

	public Integer getSoid() {
		return soid;
	}

	public void setSoid(Integer soid) {
		this.soid = soid;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getSalesorderCode() {
		return salesorderCode;
	}

	public void setSalesorderCode(String salesorderCode) {
		this.salesorderCode = salesorderCode;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getCustPartNo() {
		return custPartNo;
	}

	public void setCustPartNo(String custPartNo) {
		this.custPartNo = custPartNo;
	}

	public String getCustPartName() {
		return custPartName;
	}

	public void setCustPartName(String custPartName) {
		this.custPartName = custPartName;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
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

	public Integer getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(Integer quotationId) {
		this.quotationId = quotationId;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getRevisionNo() {
		return revisionNo;
	}

	public void setRevisionNo(Integer revisionNo) {
		this.revisionNo = revisionNo;
	}

	public Integer getDrawingNo() {
		return drawingNo;
	}

	public void setDrawingNo(Integer drawingNo) {
		this.drawingNo = drawingNo;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public Double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getMachiningCostPerPiece() {
		return machiningCostPerPiece;
	}

	public void setMachiningCostPerPiece(Double machiningCostPerPiece) {
		this.machiningCostPerPiece = machiningCostPerPiece;
	}

	public Double getTotalMachiningCost() {
		return totalMachiningCost;
	}

	public void setTotalMachiningCost(Double totalMachiningCost) {
		this.totalMachiningCost = totalMachiningCost;
	}

	public Double getMachiningToolingCost() {
		return machiningToolingCost;
	}

	public void setMachiningToolingCost(Double machiningToolingCost) {
		this.machiningToolingCost = machiningToolingCost;
	}

	public Double getAmortisationQty() {
		return amortisationQty;
	}

	public void setAmortisationQty(Double amortisationQty) {
		this.amortisationQty = amortisationQty;
	}

	public Double getAmortisationValue() {
		return amortisationValue;
	}

	public void setAmortisationValue(Double amortisationValue) {
		this.amortisationValue = amortisationValue;
	}

	public Double getAssessibleValue() {
		return assessibleValue;
	}

	public void setAssessibleValue(Double assessibleValue) {
		this.assessibleValue = assessibleValue;
	}

	public Double getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(Double roundOff) {
		this.roundOff = roundOff;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getSoDetailsStaus() {
		return soDetailsStaus;
	}

	public void setSoDetailsStaus(Integer soDetailsStaus) {
		this.soDetailsStaus = soDetailsStaus;
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

	public Salesorder getSalesorder() {
		return salesorder;
	}

	public void setSalesorder(Salesorder salesorder) {
		this.salesorder = salesorder;
	}

	public Integer getUom() {
		return uom;
	}

	public void setUom(Integer uom) {
		this.uom = uom;
	}
	

	
	

}
