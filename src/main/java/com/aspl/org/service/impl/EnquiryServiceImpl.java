package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.AgentDetailsDTO;
import com.aspl.org.dto.AgentEnquiryQuotationSalesOrderMappingDTO;
import com.aspl.org.dto.EnquiryDTO;
import com.aspl.org.dto.EnquiryDetailsDTO;
import com.aspl.org.entity.Enquiry;
import com.aspl.org.entity.EnquiryDetails;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.repository.ContactsDetailsDao;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.EnquiryDao;
import com.aspl.org.repository.EnquiryDetailsDao;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.ReminderTermsMasterDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.service.AgentDetailsService;
import com.aspl.org.service.AgentEnquiryQuotationSalesOrderMappingService;
import com.aspl.org.service.CustomerMasterService;
import com.aspl.org.service.EnquiryDTOEntityConversionService;
import com.aspl.org.service.EnquiryDetailsService;
import com.aspl.org.service.EnquiryService;

@Service
@Transactional
public class EnquiryServiceImpl implements EnquiryService {
	
	@Autowired
	EnquiryDao enquiryDao;
	
	@Autowired
	EnquiryDetailsDao enquiryDetailsDao;
	
	@Autowired
	EnquiryDetailsService enquiryDetailsService;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Autowired
	CustomerMasterService customerService;
	
	@Autowired 
	ContactsDetailsDao contactsDetailsDao;
	
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
	AgentDetailsService agentService;
	
	@Autowired
	AgentEnquiryQuotationSalesOrderMappingService agentMappingService;
	
	@Autowired
	EnquiryDTOEntityConversionService enquiryDTOEntityConversionService;
	
	/*
	 * @Patam List<EnquiryDTO> enquiryDTO
	 * 
	 * This method is used to save enquiry. This method receives a list of enquiry DTOs and then saves it one by one by iterating 
	 * through the list. It calls prepareEnquiryEntity method to convert the enquiry dto to enquiry entity. prepareEnquiryEntity
	 * method takes enquiry dto as param and returns enquiry entity object. After saving the enquiry header table it also saves
	 * enquiry details table . 
	 * 
	 * @Return ResponseDetails
	 */

	@Override
	public ResponseDetails enquirySave(EnquiryDTO enquiryDTO) throws Exception {
		Enquiry enquiry = new Enquiry();
		
		/*String enquiryCode = "";
		
		Long enquiryCount = enquiryDao.count();
		
		DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
		String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//		(formattedDate);
		Integer currYear = Integer.valueOf(formattedDate);
		Integer nextYear = currYear+1;
		enquiryCode = "ENQ/"+(enquiryCount+1)+"/"+currYear+"-"+nextYear;*/
	
			Enquiry enq = enquiryDTOEntityConversionService.prepareEnquiryEntity(enquiryDTO);
			enq.setStatus(0);
			enquiry = enquiryDao.save(enq);
		
		//Saving enquiry header end
		
		
		for (EnquiryDetailsDTO enquiryDetailsDTO : enquiryDTO.getEnquiryDetails()) {
			enquiryDetailsDTO.setEnquiryId(enquiry.getEnquiryId());
			enquiryDetailsService.saveEnquiryDetails(enquiryDetailsDTO);
		}
		
		if(enquiry!=null) {
			for(AgentDetailsDTO agentDTO : enquiryDTO.getAgent()) {
				AgentEnquiryQuotationSalesOrderMappingDTO agentMappingDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
				
				if(agentDTO.getAgentMappingId()!=null && agentDTO.getAgentMappingId()!=0) {
					agentMappingDTO = agentMappingService.getMappingByMappingId(agentDTO.getAgentMappingId());
				}
				
				agentMappingDTO.setAgentId(agentDTO.getAgentId());
				agentMappingDTO.setEnquiryCode(enquiryDTO.getEnquiryCode());
				agentMappingDTO.setIsActive(1);
				agentMappingDTO.setQuotationCode("");
				agentMappingDTO.setSalesOrderCode("");
				
				agentMappingService.saveAgentEnquiryQuotationSalesOrderMapping(agentMappingDTO);
			}
		}
		

         return new ResponseDetails(new Date(), "We have created your enquiry successfully", null, 1);
	}
	
	/*
	 * @Param customer
	 * 
	 * This method is used for fetching enquiry by customer. It calls prepareEnquiryDTO method to convert the fetched entity
	 * object to DTO object. prepareEnquiryDTO method accepts Enquiry entity object as param and returns EnquiryDTO object.
	 * 
	 * @Return EnquiryDTO
	 */
	@Override
	public List<EnquiryDTO> getEnquiryByCustomer(Integer customer){
		List<EnquiryDTO> enquiryDTOs = new ArrayList<>();
		try {
			List<Enquiry> enquirys = enquiryDao.findByCustomer(customer);
			for(Enquiry enquiry : enquirys) {
				EnquiryDTO enquiryDTO = new EnquiryDTO();
				enquiryDTO = enquiryDTOEntityConversionService.prepareEnquiryDTO(enquiry);
				enquiryDTOs.add(enquiryDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return enquiryDTOs;
	}
	
	/*
	 * @Param EnquiryDTO enquiryDTO
	 * 
	 * This method is used to update enquiry. This method receives a object of enquiry DTO and then updates it. It calls 
	 * prepareEnquiryEntity method to convert the enquiry dto to enquiry entity. prepareEnquiryEntity
	 * method takes enquiry dto as param and returns enquiry entity object. After updating the enquiry header table it also saves
	 * enquiry details table . 
	 * 
	 * @Return ResponseDetails
	 */

	@Override
	public ResponseDetails enquiryUpdate(EnquiryDTO enquiryDTO) throws Exception {
		Enquiry enq = new Enquiry();
		try {
			if(enquiryDTO.getEnquiryId()!=null) {
				
				List<EnquiryDetailsDTO> enquiryDetailsDTO = enquiryDTO.getEnquiryDetails();
				List<EnquiryDetailsDTO> enquiryDetailsDTOs = new ArrayList<>();
				
				List<AgentDetailsDTO> agents = new ArrayList<>();
				List<AgentDetailsDTO> agentsEnqDTO = enquiryDTO.getAgent();
				for(AgentDetailsDTO agent : agentsEnqDTO) {
					agents.add(agent);
				}
				
				for(EnquiryDetailsDTO dto : enquiryDetailsDTO) {
					enquiryDetailsDTOs.add(dto);
				}
				
				enq = enquiryDTOEntityConversionService.prepareEnquiryEntity(enquiryDTO);
				Enquiry enquiryEntity = enquiryDao.save(enq);
				
				if(enquiryDTO!=null) {
					for(AgentDetailsDTO agentDTO : agents) {
						AgentEnquiryQuotationSalesOrderMappingDTO agentMappingDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
						
						if(agentDTO.getAgentMappingId()!=null || agentDTO.getAgentMappingId()!=0) {
							agentMappingDTO = agentMappingService.getMappingByMappingId(agentDTO.getAgentMappingId());
						}
						
						agentMappingDTO.setAgentId(agentDTO.getAgentId());
						agentMappingDTO.setEnquiryCode(enquiryDTO.getEnquiryCode());
						agentMappingDTO.setIsActive(1);
						agentMappingDTO.setQuotationCode("");
						agentMappingDTO.setSalesOrderCode("");
						
						agentMappingService.saveAgentEnquiryQuotationSalesOrderMapping(agentMappingDTO);
					}
				}
				
				for(EnquiryDetailsDTO dto : enquiryDetailsDTOs) {
					dto.setEnquiryId(enquiryEntity.getEnquiryId());
					enquiryDetailsService.saveEnquiryDetails(dto);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "Enquiry updated successfully", enq.toString());
	}
	
	/*
	 *This method is used for fetching all the enquiries which has isActvive status as 1 i.e fetching all the active enquiries.
	 *It calls prepareEnquiryDTO for converting the entity class to DTO class. prepareEnquiryDTO method takes a param, which is 
	 the enquiry entity 
	 *
	 *@Return List<EnquiryDTO>
	 */

	@Override
	public List<EnquiryDTO> getAllEnquiry() {
		List<EnquiryDTO> enqDTOs = new ArrayList<>();
		try {
			List<Enquiry> enqs = enquiryDao.findByIsActive(1);
			for(Enquiry enq : enqs) {
				EnquiryDTO enqDTO = new EnquiryDTO();
				enqDTO = enquiryDTOEntityConversionService.prepareEnquiryDTO(enq);
				enqDTOs.add(enqDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return enqDTOs;
	}



	/*
	 * @Param enquiryId
	 * 
	 * This method is used for fetching quotation by enquiry id. It calls prepareEnquiryDTO method to convert the fetched entity
	 * object to DTO object. prepareEnquiryDTO method accepts Enquiry entity object as param and returns EnquiryDTO object.
	 * 
	 * @Retrun EnquiryDTO
	 */

	@Override
	public EnquiryDTO findByEnquiryId(Integer enquiryId) {
		EnquiryDTO enqDTO = new EnquiryDTO();
		try {
			
			Enquiry enq = enquiryDao.findById(enquiryId).get();
			enqDTO = enquiryDTOEntityConversionService.prepareEnquiryDTO(enq);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return enqDTO;
	}
		
	/*
	 * @Param Integer enquiryId
	 * 
	 * This method is used to delete enquiry. This deletion is soft delete that means it only changes the is active status to 0.
	 * 
	 * @Return ResponseDetails
	 */

	@Override
	public ResponseDetails softDeleteEnquiry(Integer enquiryId) {
		
           try {
			
			Enquiry enq = enquiryDao.findById(enquiryId).get();
			
			enq.setIsActive(0);
			
			enquiryDao.save(enq);
			
			List<EnquiryDetails> enqDetails = enquiryDetailsDao.findByEnquiryId(enquiryId);
			
			for(EnquiryDetails enqDetail : enqDetails) {
				enqDetail.setIsActive(0);
				enquiryDetailsDao.save(enqDetail);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "enquiry updated successfully", "200");
	}



}
