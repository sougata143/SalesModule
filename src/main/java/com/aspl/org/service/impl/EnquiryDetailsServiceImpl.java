package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.AgentDetailsDTO;
import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.EnquiryDetailsDTO;
import com.aspl.org.dto.ItemForCategoryMapDTO;
import com.aspl.org.dto.SubCategoryForMappingDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.EnquiryDetails;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.EnquiryDetailsDao;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.ReminderTermsMasterDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.repository.SubCategoryRepo;
import com.aspl.org.repository.UomMasterRepo;
import com.aspl.org.service.AgentDetailsService;
import com.aspl.org.service.EnquiryDetailsService;

@Service
@Transactional
public class EnquiryDetailsServiceImpl implements EnquiryDetailsService {
	
	@Autowired
	EnquiryDetailsDao enquiryDetailsDao;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Autowired
	AgentDetailsService agentService;
	
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
	DeliveryTermsMasterDao deliveryMasterDao;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	SubCategoryRepo subCategoryRepo;
	
	@Autowired
	UomMasterRepo uomDao;
	
	/*
	 * This method is used for fetching all the active enquiry details i.e which have is active status as 1. It then calls prepareEnquiryDetailsDTO method which accepts
	 * EnquiryDetails entity class as param and return EnquiryDetailsDTO.
	 * 
	 * @Returns List<EnquiryDetailsDTO> 
	 */
	@Override
	public List<EnquiryDetailsDTO> getAllEnquiryDetails() {
		List<EnquiryDetailsDTO> enqDetailsDTO = new ArrayList<>();
		try {
			List<EnquiryDetails> enqDetails = enquiryDetailsDao.findByStatus(1);
			for(EnquiryDetails details : enqDetails) {
				EnquiryDetailsDTO detailsDTO = new EnquiryDetailsDTO();
				detailsDTO = prepareEnquiryDetailsDTO(details);
				enqDetailsDTO.add(detailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return enqDetailsDTO;
	}
	
	/*
	 * @Param Integer id
	 * 
	 * This method is used to fetch enquiry by enquiry details id. It takes enquiry details id as param and returns EnquiryDetailsDTO. After fetching the enquiry by
	 * it's id it calls prepareEnquiryDetailsDTO method to convert the enquiry details entity object to enquiry details DTO. This method takes Enquiry details entity 
	 * object and returns EnquiryDetailsDTO object.
	 * 
	 * @Returns EnquiryDetailsDTO
	 */

	@Override
	public EnquiryDetailsDTO getEnquiryDetailsById(Integer id) {
		EnquiryDetailsDTO enqItemDTO = new EnquiryDetailsDTO();
		try {
			EnquiryDetails enq = enquiryDetailsDao.findById(id).get();
			enqItemDTO = prepareEnquiryDetailsDTO(enq);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return enqItemDTO;
	}
	
	/*
	 * @Param EnquiryDetailsDTO enquiryDetailsDTO
	 * 
	 * This method is used to save enquiry details. It takes enquiry details dto as param and returns EnquiryDetails object. It calls prepareEnquiryDetailsEntity method
	 * to convert the EnquiryDetailsDTO to EnquiryDetails Entity object and then saves it by calling save method of JpaRepository.
	 * 
	 * @Returns EnquiryDetails
	 */

	@Override
	public EnquiryDetails saveEnquiryDetails(EnquiryDetailsDTO enquiryDetailsDTO) {
		EnquiryDetails enqItem = new EnquiryDetails();
		try {
			enqItem = prepareEnquiryDetailsEntity(enquiryDetailsDTO);
			enquiryDetailsDao.save(enqItem);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return enqItem;
	}

	/*
	 * @Param Integer id
	 * 
	 * This method is used to soft delete enquiry details, that means it updates the is active status to 0. It takes quotation details id as param and returns ResponseDetails.
	 * It calls findById method to fetch the enquiry details entity by enquiry details id and the makes the isActive status to 0 and saves it.
	 * 
	 * @Returns EnquiryDetails
	 */

	@Override
	public ResponseDetails softDelete(Integer id) {
		EnquiryDetails enqItem = new EnquiryDetails();
		try {
			enqItem = enquiryDetailsDao.findById(id).get();
			enqItem.setStatus(0);
			enquiryDetailsDao.save(enqItem);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "deleted successfully", "200");
	}
	
	/*
	 * @Param EnquiryDetailsDTO enquiryDetailsDTO
	 * 
	 * This method is used to update enquiry details. It takes enquiry details dto as param and returns EnquiryDetails object. It calls prepareEnquiryDetailsEntity method
	 * to convert the EnquiryDetailsDTO to EnquiryDetails Entity object and then saves it by calling save method of JpaRepository.
	 * 
	 * @Returns EnquiryDetails
	 */

	@Override
	public EnquiryDetails updateEnquiryDetails(EnquiryDetailsDTO enquiryDetailsDTO) {
		EnquiryDetails enqItem = new EnquiryDetails();
		try {
			enqItem = prepareEnquiryDetailsEntity(enquiryDetailsDTO);
			enquiryDetailsDao.save(enqItem);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return enqItem;
	}
	
	
	/*
	 * @Param Integer enquiryId
	 * 
	 * This method is used to fetch enquiry details by enquiry id. It then returns all the enquiry details entities by the enquiry id. It uses prepareEnquiryDetailsDTO
	 * method to convert entity to dto. 
	 * 
	 * @Retruns List<EnquiryDetailsDTO>
	 */

	@Override
	public List<EnquiryDetailsDTO> getAllEnquiryDetailsByEnquiryId(Integer enquiryId) {
		List<EnquiryDetailsDTO> enqDetailsDTO = new ArrayList<>();
		try {
			List<EnquiryDetails> enqDetails = enquiryDetailsDao.findByEnquiryId(enquiryId);
			for(EnquiryDetails details : enqDetails) {
				EnquiryDetailsDTO detailsDTO = new EnquiryDetailsDTO();
				detailsDTO = prepareEnquiryDetailsDTO(details);
				enqDetailsDTO.add(detailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return enqDetailsDTO;
	}
	/*
	 * @Param Integer enquiryId
	 * @Param Integer status
	 * 
	 * This method is used to fetch enquiry details by enquiry id and status. It then returns all the enquiry details entities by the enquiry id and the status.
	 * It uses prepareEnquiryDetailsDTO method to convert entity to dto. 
	 * 
	 * @Retruns List<EnquiryDetailsDTO>
	 */

	@Override
	public List<EnquiryDetailsDTO> getAllEnquiryDetailsByEnquiryIdAndStatus(Integer enquiryId, Integer status) {
		List<EnquiryDetailsDTO> enqDetailsDTO = new ArrayList<>();
		try {
			List<EnquiryDetails> enqDetails = enquiryDetailsDao.findByEnquiryIdAndStatus(enquiryId, status);
			for(EnquiryDetails details : enqDetails) {
				EnquiryDetailsDTO detailsDTO = new EnquiryDetailsDTO();
				detailsDTO = prepareEnquiryDetailsDTO(details);
				enqDetailsDTO.add(detailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return enqDetailsDTO;
	}
	
	
	/*
	 * @Param EnquiryDetails
	 * 
	 * This method is used convert enquiry details dto from enquiry details entity. It takes EnquiryDetails entity object as param and returns EnquiryDetailsDTO object.
	 * This method consists several different DTO objects. Those DTO objects are ItemMaster, Category and SubCategory.
	 * 
	 * @Returns EnquiryDetailsDTO
	 */

	@Override
	public EnquiryDetailsDTO prepareEnquiryDetailsDTO(EnquiryDetails enquiryDetails) {
		EnquiryDetailsDTO enqDetailsDTO = new EnquiryDetailsDTO();
		try {
			
			if(enquiryDetails.getAgentId()!=null) {
				AgentDetailsDTO agentDTO = new AgentDetailsDTO();
				
				agentDTO = agentService.getAgentDetailsById(enquiryDetails.getAgentId());
				
				enqDetailsDTO.setAgent(agentDTO);
			}
			
			if(enquiryDetails.getItemId()!=null) {
				ItemForCategoryMapDTO item = new ItemForCategoryMapDTO();
				ItemMaster itemEntity = itemDao.findById(enquiryDetails.getItemId()).get();
				
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
				
				enqDetailsDTO.setItem(item);
				
				UomMaster uomDTO = new UomMaster();
				UomMaster uom = new UomMaster();
				if(itemEntity.getPurchaseUom()!=null && !itemEntity.getPurchaseUom().equals("")) {
					uom = uomDao.findById(Integer.valueOf(itemEntity.getPurchaseUom())).get();
					
					uomDTO.setDecimalPlace(uom.getDecimalPlace());
					uomDTO.setIsActive(uom.getIsActive());
					uomDTO.setUomCode(uom.getUomCode());
					uomDTO.setUomDescription(uom.getUomDescription());
					uomDTO.setUomId(uom.getUomId());
					
					enqDetailsDTO.setUom(uomDTO);
				}
			}
			
			enqDetailsDTO.setCustPartName(enquiryDetails.getCustPartName());
			enqDetailsDTO.setCustPartNo(enquiryDetails.getCustPartNo());
			enqDetailsDTO.setEnquiryId(enquiryDetails.getEnquiryId());
			enqDetailsDTO.setId(enquiryDetails.getId());
			enqDetailsDTO.setMaterial(enquiryDetails.getMaterial());
			enqDetailsDTO.setOffTake(enquiryDetails.getOffTake());
			enqDetailsDTO.setPath(enquiryDetails.getPath());
			
			enqDetailsDTO.setRevisionNo(enquiryDetails.getRevisionNo());
			enqDetailsDTO.setDrawingNo(enquiryDetails.getDrawingNo());
			enqDetailsDTO.setQty(enquiryDetails.getQty());
			enqDetailsDTO.setRateType(enquiryDetails.getRateType());
			enqDetailsDTO.setTotal(enquiryDetails.getTotal());
			enqDetailsDTO.setUnitPrice(enquiryDetails.getUnitPrice());
			enqDetailsDTO.setTotalMachiningCost(enquiryDetails.getTotalMachiningCost());
			enqDetailsDTO.setTotalWeight(enquiryDetails.getTotalWeight());
			enqDetailsDTO.setSellingPrice(enquiryDetails.getSellingPrice());
			enqDetailsDTO.setDiscount(enquiryDetails.getDiscount());
			enqDetailsDTO.setMachiningCostPerPiece(enquiryDetails.getMachiningCostPerPiece());
			enqDetailsDTO.setMachiningToolingCost(enquiryDetails.getMachiningToolingCost());
			enqDetailsDTO.setAmortisationQty(enquiryDetails.getAmortisationQty());
			enqDetailsDTO.setAmortisationValue(enquiryDetails.getAmortisationValue());
			enqDetailsDTO.setRoundOff(enquiryDetails.getRoundOff());
			enqDetailsDTO.setRemarks(enquiryDetails.getRemarks());
			enqDetailsDTO.setAssessibleValue(enquiryDetails.getAssessibleValue());
			
			enqDetailsDTO.setWeight(enquiryDetails.getWeight());
			enqDetailsDTO.setUnit(enquiryDetails.getUnit());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return enqDetailsDTO;
	}
	
	/*
	 * @Param EnquiryDetailsDTO
	 * 
	 * This method is used convert enquiry details entity from enquiry details dto. It takes EnquiryDetails dto object as param and 
	 * returns EnquiryDetails object.
	 * 
	 * @Returns EnquiryDetails
	 */

	@Override
	public EnquiryDetails prepareEnquiryDetailsEntity(EnquiryDetailsDTO enquiryDetailsDTO) {
		EnquiryDetails enqDetails = new EnquiryDetails();
		
		if(enquiryDetailsDTO.getId()!=null) {
			enqDetails = enquiryDetailsDao.findById(enquiryDetailsDTO.getId()).get();
		}
		
		enqDetails.setCustPartName(enquiryDetailsDTO.getCustPartName());
		enqDetails.setCustPartNo(enquiryDetailsDTO.getCustPartNo());
		enqDetails.setEnquiryId(enquiryDetailsDTO.getEnquiryId());
		enqDetails.setId(enquiryDetailsDTO.getId());
		enqDetails.setMaterial(enquiryDetailsDTO.getMaterial());
		enqDetails.setOffTake(enquiryDetailsDTO.getOffTake());
		enqDetails.setPath(enquiryDetailsDTO.getPath());
		enqDetails.setWeight(enquiryDetailsDTO.getWeight());
		enqDetails.setUnit(enquiryDetailsDTO.getUnit());
		enqDetails.setUom(enquiryDetailsDTO.getUom().getUomId());
		
		enqDetails.setRevisionNo(enquiryDetailsDTO.getRevisionNo());
		enqDetails.setDrawingNo(enquiryDetailsDTO.getDrawingNo());
		enqDetails.setQty(enquiryDetailsDTO.getQty());
		enqDetails.setRateType(enquiryDetailsDTO.getRateType());
		enqDetails.setTotal(enquiryDetailsDTO.getTotal());
		enqDetails.setUnitPrice(enquiryDetailsDTO.getUnitPrice());
		enqDetails.setTotalMachiningCost(enquiryDetailsDTO.getTotalMachiningCost());
		enqDetails.setTotalWeight(enquiryDetailsDTO.getTotalWeight());
		enqDetails.setSellingPrice(enquiryDetailsDTO.getSellingPrice());
		enqDetails.setDiscount(enquiryDetailsDTO.getDiscount());
		enqDetails.setMachiningCostPerPiece(enquiryDetailsDTO.getMachiningCostPerPiece());
		enqDetails.setMachiningToolingCost(enquiryDetailsDTO.getMachiningToolingCost());
		enqDetails.setAmortisationQty(enquiryDetailsDTO.getAmortisationQty());
		enqDetails.setAmortisationValue(enquiryDetailsDTO.getAmortisationValue());
		enqDetails.setRoundOff(enquiryDetailsDTO.getRoundOff());
		enqDetails.setRemarks(enquiryDetailsDTO.getRemarks());
		enqDetails.setAssessibleValue(enquiryDetailsDTO.getAssessibleValue());
		
		enqDetails.setIsActive(1);
		enqDetails.setItemId(enquiryDetailsDTO.getItem().getItemId());
		enqDetails.setStatus(0);
		
		return enqDetails;
	}





}
