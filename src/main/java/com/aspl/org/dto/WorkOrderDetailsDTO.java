package com.aspl.org.dto;

public class WorkOrderDetailsDTO {

private Integer workOrderDetailsId;
	
	private ItemForCategoryMapDTO item;
	private Double quantity;
	private Double eachWt;
	private Double rate;
	private Double total;
	private String drawingInfo;
	private Integer workOrderId;
	private String unit;
	private String custPartName;
	
	//for foundry
	private Integer patternId;
	private Integer mouldingId;
	private Integer methodingId;
	private Integer inductionFurnaceId;
	private Integer chargeMixId;
	private Integer powerInformationId;
	private Integer tappingINformationId;
	private Integer powerConsumpsoinId;
	private Integer pouringId;
	private Integer chemicalReportId;
	private Integer firstStageInformationId;
	
	private Integer salesOrderDetailsId;
	
	private Integer status;
	
	public Integer getWorkOrderDetailsId() {
		return workOrderDetailsId;
	}
	public void setWorkOrderDetailsId(Integer workOrderDetailsId) {
		this.workOrderDetailsId = workOrderDetailsId;
	}
	public ItemForCategoryMapDTO getItem() {
		return item;
	}
	public void setItem(ItemForCategoryMapDTO item) {
		this.item = item;
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
	public String getDrawingInfo() {
		return drawingInfo;
	}
	public void setDrawingInfo(String drawingInfo) {
		this.drawingInfo = drawingInfo;
	}
	public Integer getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(Integer workOrderId) {
		this.workOrderId = workOrderId;
	}
	public Integer getPatternId() {
		return patternId;
	}
	public void setPatternId(Integer patternId) {
		this.patternId = patternId;
	}
	public Integer getMouldingId() {
		return mouldingId;
	}
	public void setMouldingId(Integer mouldingId) {
		this.mouldingId = mouldingId;
	}
	public Integer getMethodingId() {
		return methodingId;
	}
	public void setMethodingId(Integer methodingId) {
		this.methodingId = methodingId;
	}
	public Integer getInductionFurnaceId() {
		return inductionFurnaceId;
	}
	public void setInductionFurnaceId(Integer inductionFurnaceId) {
		this.inductionFurnaceId = inductionFurnaceId;
	}
	public Integer getChargeMixId() {
		return chargeMixId;
	}
	public void setChargeMixId(Integer chargeMixId) {
		this.chargeMixId = chargeMixId;
	}
	public Integer getPowerInformationId() {
		return powerInformationId;
	}
	public void setPowerInformationId(Integer powerInformationId) {
		this.powerInformationId = powerInformationId;
	}
	public Integer getTappingINformationId() {
		return tappingINformationId;
	}
	public void setTappingINformationId(Integer tappingINformationId) {
		this.tappingINformationId = tappingINformationId;
	}
	public Integer getPowerConsumpsoinId() {
		return powerConsumpsoinId;
	}
	public void setPowerConsumpsoinId(Integer powerConsumpsoinId) {
		this.powerConsumpsoinId = powerConsumpsoinId;
	}
	public Integer getPouringId() {
		return pouringId;
	}
	public void setPouringId(Integer pouringId) {
		this.pouringId = pouringId;
	}
	public Integer getChemicalReportId() {
		return chemicalReportId;
	}
	public void setChemicalReportId(Integer chemicalReportId) {
		this.chemicalReportId = chemicalReportId;
	}
	public Integer getFirstStageInformationId() {
		return firstStageInformationId;
	}
	public void setFirstStageInformationId(Integer firstStageInformationId) {
		this.firstStageInformationId = firstStageInformationId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCustPartName() {
		return custPartName;
	}
	public void setCustPartName(String custPartName) {
		this.custPartName = custPartName;
	}
	public Integer getSalesOrderDetailsId() {
		return salesOrderDetailsId;
	}
	public void setSalesOrderDetailsId(Integer salesOrderDetailsId) {
		this.salesOrderDetailsId = salesOrderDetailsId;
	}

}
