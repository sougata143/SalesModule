package com.aspl.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.AgentDetailsDTO;
import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.ItemForCategoryMapDTO;
import com.aspl.org.dto.SalesorderDetailsDTO;
import com.aspl.org.dto.SubCategoryForMappingDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.SalesorderDetails;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.ReminderTermsMasterDao;
import com.aspl.org.repository.SalesorderDao;
import com.aspl.org.repository.SalesorderDetailsDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.repository.SubCategoryRepo;
import com.aspl.org.service.AgentDetailsService;
import com.aspl.org.service.AgentEnquiryQuotationSalesOrderMappingService;
import com.aspl.org.service.CustomerMasterService;
import com.aspl.org.service.MarketingDetailsService;
import com.aspl.org.service.QuotationEnquiryMappingService;
import com.aspl.org.service.QuotationService;
import com.aspl.org.service.SalesOrderDetailsEntityDTOConversionService;
import com.aspl.org.service.UomMasterService;
import com.aspl.org.service.WorkOrderDetailsService;
import com.aspl.org.service.WorkOrderService;


@Service
@Transactional
public class SalesOrderDetailsEntityDTOConversionServiceImpl implements SalesOrderDetailsEntityDTOConversionService {

	@Autowired
	SalesorderDao salesorderDao;
	
	@Autowired
	SalesorderDetailsDao salesorderDetailsDao;
	
	@Autowired
	CustomerMasterService customerService;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Autowired
	AgentDetailsService agentService;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	SubCategoryRepo subCategoryRepo;	
	
	@Autowired
	DeliveryTermsMasterDao deliveryMasterDao;
	
	@Autowired
	JurisdictionMasterDao juridictionDao;
	
	@Autowired
	PaymentMethodMasterDao paymentMethodDao;
	
	@Autowired
	PaymentTermsMasterDao paymentTermsDao;
	
	@Autowired
	ReminderTermsMasterDao reminderMasterDao;
	
	@Autowired
	ShippingMethodMasterDao shippingDao;
	
	@Autowired
	WorkOrderService workOrderService;
	
	@Autowired
	WorkOrderDetailsService workOrderDetailsService;
	
	@Autowired
	AgentEnquiryQuotationSalesOrderMappingService agentMappingService;
	
	@Autowired
	QuotationEnquiryMappingService quotSalesOrderMapping;
	
	@Autowired
	QuotationService quotationService;
	
	@Autowired
	UomMasterService uomService;
	
	@Autowired
	MarketingDetailsService marketingService;
	
	/*
	 * @Param SalesorderDetails
	 * 
	 * This method is used convert salesorderDetails dto from salesorder details entity. It takes SalesorderDetails entity object as param and returns SalesorderDetailsDTO object.
	 * This method consists several different DTO objects. Those DTO objects are ItemMaster, Category and SubCategory.
	 * 
	 * @Returns SalesorderDetailsDTO
	 */
	@Override
	public SalesorderDetailsDTO prepareSalesorderDetailsDTO(SalesorderDetails salesorderDetails) {
		
       SalesorderDetailsDTO salesorderDetailsDTO = new SalesorderDetailsDTO();
		try {
			
			if(salesorderDetails.getAgentId()!=null) {
				AgentDetailsDTO agentDTO = new AgentDetailsDTO();
				
				agentDTO = agentService.getAgentDetailsById(salesorderDetails.getAgentId());
				
				salesorderDetailsDTO.setAgentId(agentDTO.getAgentId());
			}
			
			if(salesorderDetails.getItemId()!=null) {
				ItemForCategoryMapDTO item = new ItemForCategoryMapDTO();
				ItemMaster itemEntity = itemDao.findById(salesorderDetails.getItemId()).get();
				
				if(itemEntity.getCategoryId2()!=null) {
					Category cat = categoryRepo.findById(itemEntity.getCategoryId2()).get();
					CategoryMappingDTO cate = new CategoryMappingDTO();
					cate.setCategoryId(cat.getCategoryId());
					cate.setCategoryName(cat.getCategoryName());
					
					item.setCategory(cate);
				}
				
				if(itemEntity.getSubCategoryId2()!=null) {
					SubCategory subCat = subCategoryRepo.findById(itemEntity.getSubCategoryId2()).get();
					SubCategoryForMappingDTO subCate = new SubCategoryForMappingDTO();
					subCate.setSubCategoryId(subCat.getSubCategoryId());
					subCate.setSubCategoryName(subCat.getSubCategoryName());
					
					item.setSubCategory(subCate);
				}
				
				
				item.setItemCode(itemEntity.getItemCode());
				item.setItemId(itemEntity.getId());
				item.setItemName(itemEntity.getItemName());
				item.setVendorId(itemEntity.getVendorCode());
				
				salesorderDetailsDTO.setItem(item);
			}
			
			if(salesorderDetails.getUom()!=null) {
				UomMaster uom = uomService.getUomByUomId(salesorderDetails.getUom());
				salesorderDetailsDTO.setUom(uom);
			}
			
			salesorderDetailsDTO.setCustPartName(salesorderDetails.getCustPartName());
			salesorderDetailsDTO.setCustPartNo(salesorderDetails.getCustPartNo());
			salesorderDetailsDTO.setAmortisationQty(salesorderDetails.getAmortisationQty());
			salesorderDetailsDTO.setAmortisationValue(salesorderDetails.getAmortisationValue());
			salesorderDetailsDTO.setAssessibleValue(salesorderDetails.getAssessibleValue());
			salesorderDetailsDTO.setDiscount(salesorderDetails.getDiscount());
			salesorderDetailsDTO.setDrawingNo(salesorderDetails.getDrawingNo());
			salesorderDetailsDTO.setSalesOrderDetailsId(salesorderDetails.getSalesOrderDetailsId());
			salesorderDetailsDTO.setMachiningCostPerPiece(salesorderDetails.getMachiningCostPerPiece());
			salesorderDetailsDTO.setMachiningToolingCost(salesorderDetails.getMachiningToolingCost());
			salesorderDetailsDTO.setSalesorderId(salesorderDetails.getSalesorder().getSalesorderId());;
			salesorderDetailsDTO.setQuotationId(salesorderDetails.getQuotationId());
			salesorderDetailsDTO.setMaterial(salesorderDetails.getMaterial());
			salesorderDetailsDTO.setNotes(salesorderDetails.getNotes());
			salesorderDetailsDTO.setPreparedBy(salesorderDetails.getPreparedBy());
			
			salesorderDetailsDTO.setRevisionNo(salesorderDetails.getRevisionNo());
			salesorderDetailsDTO.setQty(salesorderDetails.getQty());
			salesorderDetailsDTO.setRateType(salesorderDetails.getRateType());
			salesorderDetailsDTO.setTotal(salesorderDetails.getTotal());
			salesorderDetailsDTO.setUnitPrice(salesorderDetails.getUnitPrice());
			salesorderDetailsDTO.setTotalMachiningCost(salesorderDetails.getTotalMachiningCost());
			salesorderDetailsDTO.setTotalWeight(salesorderDetails.getTotalWeight());
			salesorderDetailsDTO.setSellingPrice(salesorderDetails.getSellingPrice());
			salesorderDetailsDTO.setDiscount(salesorderDetails.getDiscount());
			salesorderDetailsDTO.setMachiningCostPerPiece(salesorderDetails.getMachiningCostPerPiece());
			salesorderDetailsDTO.setMachiningToolingCost(salesorderDetails.getMachiningToolingCost());
			salesorderDetailsDTO.setAmortisationQty(salesorderDetails.getAmortisationQty());
			salesorderDetailsDTO.setAmortisationValue(salesorderDetails.getAmortisationValue());
			salesorderDetailsDTO.setRoundOff(salesorderDetails.getRoundOff());
			salesorderDetailsDTO.setRemarks(salesorderDetails.getRemarks());
			salesorderDetailsDTO.setAssessibleValue(salesorderDetails.getAssessibleValue());
			
			salesorderDetailsDTO.setWeight(salesorderDetails.getWeight());
			salesorderDetailsDTO.setUnit(salesorderDetails.getUnit());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return salesorderDetailsDTO;
	}

	
	/*
	 * @Param SalesorderDetailsDTO
	 * 
	 * This method is used convert salesorder details entity from salesorder details dto. It takes SalesorderDetails dto object as param and 
	 * returns SalesorderDetails object.
	 * 
	 * @Returns SalesorderDetails
	 */
	@Override
	public SalesorderDetails prepareSalesorderDetailsEntity(SalesorderDetailsDTO salesorderDetailsDTO) {
	
      SalesorderDetails salesorderDetails = new SalesorderDetails();
      
      if(salesorderDetailsDTO.getSalesOrderDetailsId()!=null) {
    	  salesorderDetails = salesorderDetailsDao.findById(salesorderDetailsDTO.getSalesOrderDetailsId()).get();
      }
      
      salesorderDetails.setCustPartName(salesorderDetailsDTO.getCustPartName());
      salesorderDetails.setCustPartNo(salesorderDetailsDTO.getCustPartNo());
      salesorderDetails.setSoid(salesorderDetailsDTO.getSalesorderId());
      salesorderDetails.setMaterial(salesorderDetailsDTO.getMaterial());
      salesorderDetails.setNotes(salesorderDetailsDTO.getNotes());
      salesorderDetails.setPreparedBy(salesorderDetailsDTO.getPreparedBy());
      salesorderDetails.setQuotationId(salesorderDetailsDTO.getQuotationId());
		
      salesorderDetails.setAgentId(salesorderDetailsDTO.getAgentId());
		
      if(salesorderDetailsDTO.getWeight()!=null) {
    	  salesorderDetails.setWeight(salesorderDetailsDTO.getWeight());
      }else {
    	  salesorderDetails.setWeight(0.0);
      }
      salesorderDetails.setUnit(salesorderDetailsDTO.getUnit());
		
      salesorderDetails.setRevisionNo(salesorderDetailsDTO.getRevisionNo());
      salesorderDetails.setDrawingNo(salesorderDetailsDTO.getDrawingNo());
      
      if(salesorderDetailsDTO.getQty()!=null) {
    	  salesorderDetails.setQty(salesorderDetailsDTO.getQty());
      }else {
    	  salesorderDetails.setQty(0.0);
      }
      
      if(salesorderDetailsDTO.getRateType()!=null && !salesorderDetailsDTO.getRateType().equalsIgnoreCase("null")) {
    	  salesorderDetails.setRateType(salesorderDetailsDTO.getRateType());
      }else {
    	  salesorderDetails.setRateType("");
      }
      
      if(salesorderDetailsDTO.getTotal()!=null) {
    	  salesorderDetails.setTotal(salesorderDetailsDTO.getTotal());
      }else {
    	  salesorderDetails.setTotal(0.0);
      }
      
      if(salesorderDetailsDTO.getUnitPrice()!=null) {
    	  salesorderDetails.setUnitPrice(salesorderDetailsDTO.getUnitPrice());
      }else {
    	  salesorderDetails.setUnitPrice(0.0);
      }
      
      if(salesorderDetailsDTO.getTotalMachiningCost()!=null) {
    	  salesorderDetails.setTotalMachiningCost(salesorderDetailsDTO.getTotalMachiningCost());
      }else {
    	  salesorderDetails.setTotalMachiningCost(0.0);
      }
      
      if(salesorderDetailsDTO.getTotalWeight()!=null) {
    	  salesorderDetails.setTotalWeight(salesorderDetailsDTO.getTotalWeight());
      }else {
    	  salesorderDetails.setTotalWeight(0.0);
      }
      
      if(salesorderDetailsDTO.getSellingPrice()!=null) {
    	  salesorderDetails.setSellingPrice(salesorderDetailsDTO.getSellingPrice());
      }else {
    	  salesorderDetails.setSellingPrice(0.0);
      }
      
      if(salesorderDetailsDTO.getDiscount()!=null) {
    	  salesorderDetails.setDiscount(salesorderDetailsDTO.getDiscount());
      }else {
    	  salesorderDetails.setDiscount(0.0);
      }
      
      if(salesorderDetailsDTO.getMachiningCostPerPiece()!=null) {
    	  salesorderDetails.setMachiningCostPerPiece(salesorderDetailsDTO.getMachiningCostPerPiece());
      }else {
    	  salesorderDetails.setMachiningCostPerPiece(0.0);
      }
      
      if(salesorderDetailsDTO.getMachiningToolingCost()!=null) {
    	  salesorderDetails.setMachiningToolingCost(salesorderDetailsDTO.getMachiningToolingCost());
      }else {
    	  salesorderDetails.setMachiningToolingCost(0.0);
      }
      
      if(salesorderDetailsDTO.getAmortisationQty()!=null) {
    	  salesorderDetails.setAmortisationQty(salesorderDetailsDTO.getAmortisationQty());
      }else {
    	  salesorderDetails.setAmortisationQty(0.0);
      }
      
      if(salesorderDetailsDTO.getAmortisationValue()!=null) {
    	  salesorderDetails.setAmortisationValue(salesorderDetailsDTO.getAmortisationValue());
      }else {
    	  salesorderDetails.setAmortisationValue(0.0);
      }
      
      if(salesorderDetailsDTO.getRoundOff()!=null) {
    	  salesorderDetails.setRoundOff(salesorderDetailsDTO.getRoundOff());
      }else {
    	  salesorderDetails.setRoundOff(0.0);
      }
      
      salesorderDetails.setRemarks(salesorderDetailsDTO.getRemarks());
      
      if(salesorderDetailsDTO.getAssessibleValue()!=null) {
    	  salesorderDetails.setAssessibleValue(salesorderDetailsDTO.getAssessibleValue());
      }else {
    	  salesorderDetails.setAssessibleValue(0.0);
      }
		
      salesorderDetails.setIsActive(1);
      salesorderDetails.setItemId(salesorderDetailsDTO.getItem().getItemId());
      salesorderDetails.setUom(salesorderDetailsDTO.getUom().getUomId());
		
		
      return salesorderDetails;
		
	}

}
