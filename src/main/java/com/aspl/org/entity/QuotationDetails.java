package com.aspl.org.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quotation_details")
public class QuotationDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer detailsId;
	
	private Integer itemId;
	private String custPartNo;
	private String custPartName;
	private String material;
	
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
	
	private Integer status;
	private Integer isActive;
	private Integer uom;
	
	public Integer getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
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
	public Integer getUom() {
		return uom;
	}
	public void setUom(Integer uom) {
		this.uom = uom;
	}
	
}
