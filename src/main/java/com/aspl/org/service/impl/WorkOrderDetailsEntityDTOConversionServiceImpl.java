package com.aspl.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.ItemForCategoryMapDTO;
import com.aspl.org.dto.ItemMasterDTO;
import com.aspl.org.dto.SalesorderDetailsDTO;
import com.aspl.org.dto.WorkOrderDetailsDTO;
import com.aspl.org.entity.WorkOrderDetails;
import com.aspl.org.repository.WorkOrderDetailsRepository;
import com.aspl.org.service.ItemMasterService;
import com.aspl.org.service.WorkOrderDetailsEntityDTOConversionService;

@Service
@Transactional
public class WorkOrderDetailsEntityDTOConversionServiceImpl implements WorkOrderDetailsEntityDTOConversionService {

	@Autowired
	WorkOrderDetailsRepository workOrderRepository;
	
	@Autowired
	ItemMasterService itemService;
	
	@Override
	public WorkOrderDetailsDTO prepareWorkOrderDetailsDTO(WorkOrderDetails workOrderDetails) {
		// TODO Auto-generated method stub
		WorkOrderDetailsDTO detailsDTO = new WorkOrderDetailsDTO();
		
		ItemForCategoryMapDTO itemDTO = new ItemForCategoryMapDTO();
		if(workOrderDetails.getItemId()!=null) {
			ItemMasterDTO itemMaster = itemService.findByItemId(Integer.valueOf(workOrderDetails.getItemId()));
			
			itemDTO.setCategory(itemMaster.getCategoryId());
			itemDTO.setItemCode(itemMaster.getItemCode());
			itemDTO.setItemId(itemMaster.getId());
			itemDTO.setItemName(itemMaster.getItemName());
			itemDTO.setSubCategory(itemMaster.getSubCategoryId());
			itemDTO.setVendorId(String.valueOf(itemMaster.getVendorCode()));
			
		}
		
		detailsDTO.setDrawingInfo(workOrderDetails.getDrawingInfo());
		detailsDTO.setEachWt(workOrderDetails.getEachWt());
		detailsDTO.setItem(itemDTO);
		detailsDTO.setQuantity(workOrderDetails.getQuantity());
		detailsDTO.setRate(workOrderDetails.getRate());
		detailsDTO.setTotal(workOrderDetails.getTotal());
		detailsDTO.setWorkOrderDetailsId(workOrderDetails.getWorkOrderDetailsId());
		detailsDTO.setWorkOrderId(workOrderDetails.getWorkOrderId());
		detailsDTO.setCustPartName(workOrderDetails.getCustPartName());
		detailsDTO.setUnit(workOrderDetails.getUnit());
		detailsDTO.setSalesOrderDetailsId(workOrderDetails.getSalesOrderDetailsId());
		
		//for Foundry Entry
		if(workOrderDetails.getPatternId()!=null) {
			detailsDTO.setPatternId(workOrderDetails.getPatternId());
		}
		
		if(workOrderDetails.getMethodingId()!=null) {
			detailsDTO.setMethodingId(workOrderDetails.getMethodingId());
		}
		
		if(workOrderDetails.getMouldingId()!=null) {
			detailsDTO.setMouldingId(workOrderDetails.getMouldingId());
		}
		
		if(workOrderDetails.getChargeMixId()!=null) {
			detailsDTO.setChargeMixId(workOrderDetails.getChargeMixId());
		}
		
		if(workOrderDetails.getInductionFurnaceId()!=null) {
			detailsDTO.setInductionFurnaceId(workOrderDetails.getInductionFurnaceId());
		}
		
		if(workOrderDetails.getPowerInformationId()!=null) {
			detailsDTO.setPowerInformationId(workOrderDetails.getPowerInformationId());
		}
		
		if(workOrderDetails.getPowerConsumpsoinId()!=null) {
			detailsDTO.setPowerConsumpsoinId(workOrderDetails.getPowerConsumpsoinId());
		}
		
		if(workOrderDetails.getTappingINformationId()!=null) {
			detailsDTO.setTappingINformationId(workOrderDetails.getTappingINformationId());
		}
		
		if(workOrderDetails.getPouringId()!=null) {
			detailsDTO.setPouringId(workOrderDetails.getPouringId());
		}
		
		if(workOrderDetails.getChemicalReportId()!=null) {
			detailsDTO.setChemicalReportId(workOrderDetails.getChemicalReportId());
		}
		
		if(workOrderDetails.getFirstStageInformationId()!=null) {
			detailsDTO.setFirstStageInformationId(workOrderDetails.getFirstStageInformationId());
		}
		
		return detailsDTO;
	}

	@Override
	public WorkOrderDetails prepareWorkOrderDetailsEntity(WorkOrderDetailsDTO workOrderDetailsDTO) {
		// TODO Auto-generated method stub
		WorkOrderDetails details = new WorkOrderDetails();
		
		if(workOrderDetailsDTO.getWorkOrderDetailsId()!=null) {
			details = workOrderRepository.findById(workOrderDetailsDTO.getWorkOrderDetailsId()).get();
		}
		
		details.setDrawingInfo(workOrderDetailsDTO.getDrawingInfo());
		details.setEachWt(workOrderDetailsDTO.getEachWt());
		details.setItemId(String.valueOf(workOrderDetailsDTO.getItem().getItemId()));
		details.setQuantity(workOrderDetailsDTO.getQuantity());
		details.setRate(workOrderDetailsDTO.getRate());
		details.setTotal(workOrderDetailsDTO.getTotal());
		details.setWorkOrderDetailsId(workOrderDetailsDTO.getWorkOrderDetailsId());
		details.setWorkOrderId(workOrderDetailsDTO.getWorkOrderId());
		details.setCustPartName(workOrderDetailsDTO.getCustPartName());
		details.setSalesOrderDetailsId(workOrderDetailsDTO.getSalesOrderDetailsId());
		
		//for Foundry module
		if(workOrderDetailsDTO.getPatternId()!=null) {
			details.setPatternId(workOrderDetailsDTO.getPatternId());
		}
		
		if(workOrderDetailsDTO.getMethodingId()!=null) {
			details.setMethodingId(workOrderDetailsDTO.getMethodingId());
		}
		
		if(workOrderDetailsDTO.getMouldingId()!=null) {
			details.setMouldingId(workOrderDetailsDTO.getMouldingId());
		}
		
		if(workOrderDetailsDTO.getChargeMixId()!=null) {
			details.setChargeMixId(workOrderDetailsDTO.getChargeMixId());
		}
		
		if(workOrderDetailsDTO.getInductionFurnaceId()!=null) {
			details.setInductionFurnaceId(workOrderDetailsDTO.getInductionFurnaceId());
		}
		
		if(workOrderDetailsDTO.getPowerInformationId()!=null) {
			details.setPowerInformationId(workOrderDetailsDTO.getPowerInformationId());
		}
		
		if(workOrderDetailsDTO.getPowerConsumpsoinId()!=null) {
			details.setPowerConsumpsoinId(workOrderDetailsDTO.getPowerConsumpsoinId());
		}
		
		if(workOrderDetailsDTO.getTappingINformationId()!=null) {
			details.setTappingINformationId(workOrderDetailsDTO.getTappingINformationId());
		}
		
		if(workOrderDetailsDTO.getPouringId()!=null) {
			details.setPouringId(workOrderDetailsDTO.getPouringId());
		}
		
		if(workOrderDetailsDTO.getChemicalReportId()!=null) {
			details.setChemicalReportId(workOrderDetailsDTO.getChemicalReportId());
		}
		
		if(workOrderDetailsDTO.getFirstStageInformationId()!=null) {
			details.setFirstStageInformationId(workOrderDetailsDTO.getFirstStageInformationId());
		}		
		
		return details;
	}

	@Override
	public WorkOrderDetailsDTO prepareWorkOrderDetailsFromSalesOrderDetails(SalesorderDetailsDTO soDetailsDTO, 
			Integer workOrderId,Integer salesOrderDetailsId) {
		// TODO Auto-generated method stub
		WorkOrderDetailsDTO detailsDTO = new WorkOrderDetailsDTO();
		
		if(salesOrderDetailsId!=null) {
			List<WorkOrderDetails> detailsEntityList = workOrderRepository.findBySalesOrderDetailsId(salesOrderDetailsId);
			WorkOrderDetails detailsEntity = new WorkOrderDetails();
			if(!detailsEntityList.isEmpty()) {
				detailsEntity = detailsEntityList.get(0);
			}
			detailsDTO = prepareWorkOrderDetailsDTO(detailsEntity);
		}
		
		detailsDTO.setDrawingInfo("");
		detailsDTO.setEachWt(soDetailsDTO.getWeight());
		detailsDTO.setItem(soDetailsDTO.getItem());
		detailsDTO.setQuantity(soDetailsDTO.getQty());
		detailsDTO.setRate(soDetailsDTO.getSellingPrice());
		detailsDTO.setTotal(soDetailsDTO.getTotal());
		detailsDTO.setWorkOrderId(workOrderId);
		detailsDTO.setCustPartName(soDetailsDTO.getCustPartName());
		detailsDTO.setUnit(soDetailsDTO.getUnit());
		detailsDTO.setSalesOrderDetailsId(salesOrderDetailsId);
		
		//for Foundry Entry
		detailsDTO.setPatternId(0);
		detailsDTO.setMethodingId(0);
		detailsDTO.setMouldingId(0);
		detailsDTO.setChargeMixId(0);
		detailsDTO.setInductionFurnaceId(0);
		detailsDTO.setPowerInformationId(0);
		detailsDTO.setPowerConsumpsoinId(0);
		detailsDTO.setTappingINformationId(0);
		detailsDTO.setPouringId(0);
		detailsDTO.setChemicalReportId(0);
		detailsDTO.setFirstStageInformationId(0);
		
		return detailsDTO;
	}

}
