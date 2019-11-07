package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.CategoryMappingDTO;
import com.aspl.org.dto.ItemForCategoryMapDTO;
import com.aspl.org.dto.QuotationDetailsDTO;
import com.aspl.org.dto.SubCategoryForMappingDTO;
import com.aspl.org.entity.Category;
import com.aspl.org.entity.ItemMaster;
import com.aspl.org.entity.QuotationDetails;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.SubCategory;
import com.aspl.org.entity.UomMaster;
import com.aspl.org.repository.CategoryRepo;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.QuotationDetailsRepository;
import com.aspl.org.repository.ReminderTermsMasterDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.repository.SubCategoryRepo;
import com.aspl.org.service.AgentDetailsService;
import com.aspl.org.service.QuotationDetailsService;
import com.aspl.org.service.UomMasterService;


/*
 *This service is used for CRUD operations on QuotationDetails entity. 
 */

@Service 
@Transactional
public class QuotationDetailsServiceImpl implements QuotationDetailsService {

	@Autowired
	QuotationDetailsRepository quotationDetailsRepository;
	
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
	UomMasterService uomService;
	
	
	
	/*
	 * This method is used for fetching all the active quotation details i.e which have is active status as 1. It then calls prepareQuotationDetailsDTO method which accepts
	 * QuotationDetails entity class as param and return QuotationDetailsDTO.
	 * 
	 * @Returns List<QuotationDetailsDTO
	 */
	@Override
	public List<QuotationDetailsDTO> getAllQuotationDetails() {
		
		List<QuotationDetailsDTO> quotDetailsDTO = new ArrayList<>();
		try {
			List<QuotationDetails> quotDetails = quotationDetailsRepository.findByStatus(1);
			for(QuotationDetails details : quotDetails) {
				QuotationDetailsDTO detailsDTO = new QuotationDetailsDTO();
				detailsDTO = prepareQuotationDetailsDTO(details);
				quotDetailsDTO.add(detailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotDetailsDTO;
	}

	
	/*
	 * @Param Integer quotationDetailsId
	 * 
	 * This method is used to fetch quotation by quotation details id. It takes quotation details id as param and returns QuotationDetailsDTO. After fetching the quotation by
	 * it's id it calls prepareQuotationDetailsDTO method to convert the quotation details entity object to quotation details DTO. This method takes Quotation details entity 
	 * object and returns QuotationDetailsDTO object.
	 * 
	 * @Returns QuotationDetailsDTO
	 */
	@Override
	public QuotationDetailsDTO getQuotationDetailsById(Integer quotationDetailsId) {
		
		QuotationDetailsDTO quotItemDTO = new QuotationDetailsDTO();
		try {
			QuotationDetails quot = quotationDetailsRepository.findById(quotationDetailsId).get();
			quotItemDTO = prepareQuotationDetailsDTO(quot);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotItemDTO;
	}

	
	/*
	 * @Param QuotaionDetailsDTO quotationDetailsDTO
	 * 
	 * This method is used to save quotation details. It takes quotation details dto as param and returns QuotationDetails object. It calls prepareQuotationDetailsEntity method
	 * to convert the QuotationDetailsDTO to QuotationDetails Entity object and then saves it by calling save method of JpaRepository.
	 * 
	 * @Returns QuotationDetails
	 */
	@Override
	public QuotationDetails saveQuotationDetails(QuotationDetailsDTO quotationDetailsDTO) {
		
		QuotationDetails quotItem = new QuotationDetails();
		try {
			quotItem = prepareQuotationDetailsEntity(quotationDetailsDTO);
			quotationDetailsRepository.save(quotItem);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotItem;
	}

	
	/*
	 * @Param QuotaionDetailsDTO quotationDetailsDTO
	 * 
	 * This method is used to update quotation details. It takes quotation details dto as param and returns QuotationDetails object. It calls prepareQuotationDetailsEntity method
	 * to convert the QuotationDetailsDTO to QuotationDetails Entity object and then saves it by calling save method of JpaRepository.
	 * 
	 * @Returns QuotationDetails
	 */
	@Override
	public QuotationDetails updateQuotationDetails(QuotationDetailsDTO quotationDetailsDTO) {
	
		QuotationDetails quotItem = new QuotationDetails();
		try {
			quotItem = prepareQuotationDetailsEntity(quotationDetailsDTO);
			quotationDetailsRepository.save(quotItem);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotItem;
	}

	
	/*
	 * @Param Integer quotationDetailsId
	 * 
	 * This method is used to soft delete quotation details, that means it updates the is active status to 0. It takes quotation details id as param and returns ResponseDetails.
	 * It calls findById method to fetch the quotation details entity by quotation details id and the makes the isActive status to 0 and saves it.
	 * 
	 * @Returns QuotationDetails
	 */
	@Override
	public ResponseDetails softDelete(Integer quotationDetailsId) {
		
		QuotationDetails quotItem = new QuotationDetails();
		try {
			quotItem = quotationDetailsRepository.findById(quotationDetailsId).get();
			quotItem.setStatus(0);
			quotationDetailsRepository.save(quotItem);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "deleted successfully", "200");
	}

	
	/*
	 * @Param Integer quotId
	 * 
	 * This method is used to fetch quotation details by quotation id. It then returns all the quotation details entities by the quotation id. It uses prepareQuotationDetailsDTO
	 * method to convert entity to dto. 
	 * 
	 * @Retruns List<QuotationDetailsDTO>
	 */
	@Override
	public List<QuotationDetailsDTO> getAllQuotationDetailsByQuotationId(Integer quotId) {
	
		List<QuotationDetailsDTO> quotDetailsDTO = new ArrayList<>();
		try {
			List<QuotationDetails> quotDetails = quotationDetailsRepository.findByQuotationId(quotId);
			for(QuotationDetails details : quotDetails) {
				QuotationDetailsDTO detailsDTO = new QuotationDetailsDTO();
				detailsDTO = prepareQuotationDetailsDTO(details);
				quotDetailsDTO.add(detailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return quotDetailsDTO;
	}
	
	
	/*
	 * @Param Integer quotId
	 * @Param Integer status
	 * 
	 * This method is used to fetch quotation details by quotation id and status. It then returns all the quotation details entities by the quotation id and the status.
	 * It uses prepareQuotationDetailsDTO method to convert entity to dto. 
	 * 
	 * @Retruns List<QuotationDetailsDTO>
	 */
	@Override
	public List<QuotationDetailsDTO> getAllQuotationDetailsByQuotationIdAndStatus(Integer quotId, Integer status) {
		
		List<QuotationDetailsDTO> quotDetailsDTO = new ArrayList<>();
		try {
			List<QuotationDetails> quotDetails = quotationDetailsRepository.findByQuotationIdAndStatus(quotId, status);
			for(QuotationDetails details : quotDetails) {
				QuotationDetailsDTO detailsDTO = new QuotationDetailsDTO();
				detailsDTO = prepareQuotationDetailsDTO(details);
				quotDetailsDTO.add(detailsDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return quotDetailsDTO;
	}

	
	/*
	 * @Param QuotationDetails
	 * 
	 * This method is used convert quotation details dto from quotation details entity. It takes QuotationDetails entity object as param and returns QuotationDetailsDTO object.
	 * This method consists several different DTO objects. Those DTO objects are ItemMaster, Category and SubCategory.
	 * 
	 * @Returns QuotationDetailsDTO
	 */
	@Override
	public QuotationDetailsDTO prepareQuotationDetailsDTO(QuotationDetails quotationDetails) {
		
		QuotationDetailsDTO quotDetailsDTO = new QuotationDetailsDTO();
		try {
			if(quotationDetails.getItemId()!=null) {
				ItemForCategoryMapDTO item = new ItemForCategoryMapDTO();
				ItemMaster itemEntity = itemDao.findById(quotationDetails.getItemId()).get();
				
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
				
				quotDetailsDTO.setItem(item);
			}
			
			quotDetailsDTO.setCustPartName(quotationDetails.getCustPartName());
			quotDetailsDTO.setCustPartNo(quotationDetails.getCustPartNo());
			quotDetailsDTO.setDetailsId(quotationDetails.getDetailsId());
			quotDetailsDTO.setMaterial(quotationDetails.getMaterial());
			quotDetailsDTO.setQuotationId(quotationDetails.getQuotationId());
			
			quotDetailsDTO.setRevisionNo(quotationDetails.getRevisionNo());
			quotDetailsDTO.setDrawingNo(quotationDetails.getDrawingNo());
			quotDetailsDTO.setQty(quotationDetails.getQty());
			quotDetailsDTO.setRateType(quotationDetails.getRateType());
			quotDetailsDTO.setTotal(quotationDetails.getTotal());
			quotDetailsDTO.setUnitPrice(quotationDetails.getUnitPrice());
			quotDetailsDTO.setTotalMachiningCost(quotationDetails.getTotalMachiningCost());
			quotDetailsDTO.setTotalWeight(quotationDetails.getTotalWeight());
			quotDetailsDTO.setSellingPrice(quotationDetails.getSellingPrice());
			quotDetailsDTO.setDiscount(quotationDetails.getDiscount());
			quotDetailsDTO.setMachiningCostPerPiece(quotationDetails.getMachiningCostPerPiece());
			quotDetailsDTO.setMachiningToolingCost(quotationDetails.getMachiningToolingCost());
			quotDetailsDTO.setAmortisationQty(quotationDetails.getAmortisationQty());
			quotDetailsDTO.setAmortisationValue(quotationDetails.getAmortisationValue());
			quotDetailsDTO.setRoundOff(quotationDetails.getRoundOff());
			quotDetailsDTO.setRemarks(quotationDetails.getRemarks());
			quotDetailsDTO.setAssessibleValue(quotationDetails.getAssessibleValue());
			
			if(quotationDetails.getUom()!=null) {
				UomMaster uom = uomService.getUomByUomId(quotationDetails.getUom());
				quotDetailsDTO.setUom(uom);
			}
			
			quotDetailsDTO.setWeight(quotationDetails.getWeight());
			quotDetailsDTO.setUnit(quotationDetails.getUnit());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotDetailsDTO;
	}

	
	/*
	 * @Param QuotationDetailsDTO
	 * 
	 * This method is used convert quotation details entity from quotation details dto. It takes QuotationDetails dto object as param and 
	 * returns QuotationDetails object.
	 * 
	 * @Returns QuotationDetails
	 */
	@Override
	public QuotationDetails prepareQuotationDetailsEntity(QuotationDetailsDTO quotationDetailsDTO) {
		
		QuotationDetails quotDetails = new QuotationDetails();
		
		if(quotationDetailsDTO.getDetailsId()!=null) {
			quotDetails = quotationDetailsRepository.findById(quotationDetailsDTO.getDetailsId()).get();
		}
		
		quotDetails.setCustPartName(quotationDetailsDTO.getCustPartName());
		quotDetails.setCustPartNo(quotationDetailsDTO.getCustPartNo());
		quotDetails.setDetailsId(quotationDetailsDTO.getDetailsId());
		quotDetails.setMaterial(quotationDetailsDTO.getMaterial());
		quotDetails.setQuotationId(quotationDetailsDTO.getQuotationId());
		
		quotDetails.setWeight(quotationDetailsDTO.getWeight());
		quotDetails.setUnit(quotationDetailsDTO.getUnit());
		quotDetails.setUom(quotationDetailsDTO.getUom().getUomId());
		
		quotDetails.setRevisionNo(quotationDetailsDTO.getRevisionNo());
		quotDetails.setDrawingNo(quotationDetailsDTO.getDrawingNo());
		quotDetails.setQty(quotationDetailsDTO.getQty());
		quotDetails.setRateType(quotationDetailsDTO.getRateType());
		quotDetails.setTotal(quotationDetailsDTO.getTotal());
		quotDetails.setUnitPrice(quotationDetailsDTO.getUnitPrice());
		quotDetails.setTotalMachiningCost(quotationDetailsDTO.getTotalMachiningCost());
		quotDetails.setTotalWeight(quotationDetailsDTO.getTotalWeight());
		quotDetails.setSellingPrice(quotationDetailsDTO.getSellingPrice());
		quotDetails.setDiscount(quotationDetailsDTO.getDiscount());
		quotDetails.setMachiningCostPerPiece(quotationDetailsDTO.getMachiningCostPerPiece());
		quotDetails.setMachiningToolingCost(quotationDetailsDTO.getMachiningToolingCost());
		quotDetails.setAmortisationQty(quotationDetailsDTO.getAmortisationQty());
		quotDetails.setAmortisationValue(quotationDetailsDTO.getAmortisationValue());
		quotDetails.setRoundOff(quotationDetailsDTO.getRoundOff());
		quotDetails.setRemarks(quotationDetailsDTO.getRemarks());
		quotDetails.setAssessibleValue(quotationDetailsDTO.getAssessibleValue());
		
		quotDetails.setIsActive(1);
		quotDetails.setItemId(quotationDetailsDTO.getItem().getItemId());
		quotDetails.setStatus(0);
		
		return quotDetails;
	}

}
