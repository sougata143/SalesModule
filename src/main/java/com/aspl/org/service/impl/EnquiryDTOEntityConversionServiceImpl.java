package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.AgentDetailsDTO;
import com.aspl.org.dto.AgentEnquiryQuotationSalesOrderMappingDTO;
import com.aspl.org.dto.CustomerMasterDTO;
import com.aspl.org.dto.DeliveryTermsForSalesDTO;
import com.aspl.org.dto.EnquiryDTO;
import com.aspl.org.dto.EnquiryDetailsDTO;
import com.aspl.org.dto.JurisdictionForSalesDTO;
import com.aspl.org.dto.PaymentMethodForSalesDTO;
import com.aspl.org.dto.PaymentTermsForSalesDTO;
import com.aspl.org.dto.ReminderTermsForSalesDTO;
import com.aspl.org.dto.ShippingMethodForSalesDTO;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.entity.Enquiry;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.entity.ReminderTermsMasterForVendor;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
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


@Service
@Transactional
public class EnquiryDTOEntityConversionServiceImpl implements EnquiryDTOEntityConversionService {
	
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

	/*
	 * @Param Enquiry enquiry
	 * 
	 * This method is used to convert Enquiry entity to EnquiryDTO. It takes enquiry entity and returns EnquiryDTO. It consists
	 * some different entities like Enquiry, AgentDetails, DeliveryTermsMaster, PaymentMethodMaster, PaymentTermsMaster, JurisdictionMaster, ShippingMethodMaster. 
	 * 
	 * @Returns EnquiryDTO
	 */
	  @Override 
	  public EnquiryDTO prepareEnquiryDTO(Enquiry enquiry) {
		  
		  EnquiryDTO enqDTO = new EnquiryDTO();
			List<EnquiryDetailsDTO> enqDetailsDTO = new ArrayList<>();
			
			enqDTO.setAccepted(enquiry.getAccepted());
			enqDTO.setBillingAddr(enquiry.getBillingAddr());
			enqDTO.setCopy(enquiry.getCopy());
			enqDTO.setEnquiryCode(enquiry.getEnquiryCode());
			enqDTO.setDueDate(enquiry.getDueDate());
			
			/*if(enquiry.getEnquiryId()!=null) {
				EnquiryDTO enquiry = enquiryService.findByEnquiryId(Integer.valueOf(quotation.getEnquiryId()));
				quotDTO.setEnquiry(enquiry);
			}
			*/
			enqDTO.setEnquiryDate(enquiry.getEnquiryDate());
			enqDTO.setEnquiryId(enquiry.getEnquiryId());
			enqDTO.setNext(enquiry.getNext());
			enqDTO.setNotes(enquiry.getNotes());
			enqDTO.setPriority(enquiry.getPriority());
			enqDTO.setProductType(enquiry.getProductType());
			enqDTO.setReferenceNo(enquiry.getReferenceNo());
			enqDTO.setRegdOfficeAddr(enquiry.getRegdOfficeAddr());
			enqDTO.setSourceOfEnquiry(enquiry.getSourceOfEnquiry());
			
			enqDTO.setRegion(enquiry.getRegion());
			enqDTO.setDivision(enquiry.getDivision());
			
			try {
				List<AgentDetailsDTO> agentDTOs = new ArrayList<>();
				List<AgentEnquiryQuotationSalesOrderMappingDTO> agentMappings = 
						agentMappingService.getMappingByCodeAndType(enquiry.getEnquiryCode(), "enquiry");
				
				if(agentMappings!=null && !agentMappings.isEmpty()) {
					for(AgentEnquiryQuotationSalesOrderMappingDTO mapping : agentMappings) {
						if(mapping.getAgentId()!=null) {
							AgentDetailsDTO agentDTO = agentService.getAgentDetailsById(mapping.getAgentId());
							agentDTO.setAgentMappingId(mapping.getAgentMappingId());
							agentDTOs.add(agentDTO);
						}
					}
				}
				
				if(!agentDTOs.isEmpty())
					enqDTO.setAgent(agentDTOs);
				
				if(enquiry.getCustomer()!=null) {
					CustomerMasterDTO customer = customerService.getCustomerMasterById(Integer.valueOf(enquiry.getCustomer()));
					enqDTO.setCustomer(customer);
				}
				
				DeliveryTermsForSalesDTO deliveryTermsMasterforVendorDTO = new DeliveryTermsForSalesDTO();
				if(enquiry.getDeliveryTermsId()!=null) {
					Optional<DeliveryTermsMasterforVendor> deliveryTermsO = deliveryMasterDao.findById(enquiry.getDeliveryTermsId());
					
					if(deliveryTermsO.isPresent()) {
						DeliveryTermsMasterforVendor DeliveryTermsMasterControllerforVendor = deliveryTermsO.get();
						deliveryTermsMasterforVendorDTO.setDeliveryTermsCode(DeliveryTermsMasterControllerforVendor.getDeliveryTermsCode());
						deliveryTermsMasterforVendorDTO.setDescription(DeliveryTermsMasterControllerforVendor.getDescription());
						deliveryTermsMasterforVendorDTO.setId(DeliveryTermsMasterControllerforVendor.getId());
						
						enqDTO.setDeliveryTerms(deliveryTermsMasterforVendorDTO);
					}else {
						deliveryTermsMasterforVendorDTO.setDeliveryTermsCode("");
						deliveryTermsMasterforVendorDTO.setDescription("");
						deliveryTermsMasterforVendorDTO.setId(0);
						
						enqDTO.setDeliveryTerms(deliveryTermsMasterforVendorDTO);
					}
							
				}
				
				
				JurisdictionForSalesDTO jurisdictionMasterForVendor = new JurisdictionForSalesDTO();
				if(enquiry.getJurisdictionId()!=null) {
					Optional<JurisdictionMasterForVendor> juridictionO = juridictionDao.findById(enquiry.getJurisdictionId());
					if(juridictionO.isPresent()) {
						JurisdictionMasterForVendor juridiction = juridictionO.get();
						jurisdictionMasterForVendor.setDescription(juridiction.getDescription());
						jurisdictionMasterForVendor.setId(juridiction.getId());
						jurisdictionMasterForVendor.setJurisdictionCode(juridiction.getJurisdictionCode());
						
						enqDTO.setJurisdiction(jurisdictionMasterForVendor);
					}else {
						jurisdictionMasterForVendor.setDescription("");
						jurisdictionMasterForVendor.setId(0);
						jurisdictionMasterForVendor.setJurisdictionCode("");
						
						enqDTO.setJurisdiction(jurisdictionMasterForVendor);
					}
				}
				
				
				PaymentMethodForSalesDTO paymentMethodMasterforVendorDTO = new PaymentMethodForSalesDTO();
				if(enquiry.getPaymentMethodId()!=null) {
					Optional<PaymentMethodMasterforVendor> paymentMethodO = paymentMethodDao.findById(enquiry.getPaymentMethodId()) ;
					if(paymentMethodO.isPresent()) {
						PaymentMethodMasterforVendor masterforVendor = paymentMethodO.get();
						paymentMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
						paymentMethodMasterforVendorDTO.setId(masterforVendor.getId());
						paymentMethodMasterforVendorDTO.setPaymentMethodCode(masterforVendor.getPaymentMethodCode());
						
						enqDTO.setPaymentMethod(paymentMethodMasterforVendorDTO);
					}else {
						paymentMethodMasterforVendorDTO.setDescription("");
						paymentMethodMasterforVendorDTO.setId(0);
						paymentMethodMasterforVendorDTO.setPaymentMethodCode("");
						
						enqDTO.setPaymentMethod(paymentMethodMasterforVendorDTO);
					}
				}
				
				
				PaymentTermsForSalesDTO paymentTermsMasterforVendorDTO = new PaymentTermsForSalesDTO();
				if(enquiry.getPaymentTermsId()!=null) {
					Optional<PaymentTermsMasterforVendor> paymentTermsO = paymentTermsDao.findById(enquiry.getPaymentTermsId());
					if(paymentTermsO.isPresent()) {
						PaymentTermsMasterforVendor masterforVendor = paymentTermsO.get();
						paymentTermsMasterforVendorDTO.setDays(masterforVendor.getDays());
						paymentTermsMasterforVendorDTO.setDescription(masterforVendor.getDescription());
						paymentTermsMasterforVendorDTO.setDiscAmt(masterforVendor.getDisc_amt());
						paymentTermsMasterforVendorDTO.setId(masterforVendor.getId());
						paymentTermsMasterforVendorDTO.setPaymentTermsCode(masterforVendor.getPaymentTermsCode());
						
						enqDTO .setPaymentTerms(paymentTermsMasterforVendorDTO);
					}else {
						paymentTermsMasterforVendorDTO.setDays(0);
						paymentTermsMasterforVendorDTO.setDescription("");
						paymentTermsMasterforVendorDTO.setDiscAmt(0.0);
						paymentTermsMasterforVendorDTO.setId(0);
						paymentTermsMasterforVendorDTO.setPaymentTermsCode("");
						
						enqDTO .setPaymentTerms(paymentTermsMasterforVendorDTO);
					}
				}
				
				
				
				ReminderTermsForSalesDTO reminderTermsMasterForVendorDTO = new ReminderTermsForSalesDTO();
				if(enquiry.getReminderTerms()!=null) {
				  Optional<ReminderTermsMasterForVendor> reminderO =
				  reminderMasterDao.findById(enquiry.getReminderTerms());
				  if(reminderO.isPresent()) { ReminderTermsMasterForVendor forVendor =
					  reminderO.get();
					  reminderTermsMasterForVendorDTO.setDescription(forVendor.getDescription());
					  reminderTermsMasterForVendorDTO.setId(forVendor.getId());
					  reminderTermsMasterForVendorDTO.setMaxReminder(forVendor.getMaxReminder());
					  reminderTermsMasterForVendorDTO.setReminderTermsCode(forVendor.getReminderTermsCode());
						  
					  enqDTO.setReminderTerms(reminderTermsMasterForVendorDTO); 
				  }else {
					  reminderTermsMasterForVendorDTO.setDescription("");
					  reminderTermsMasterForVendorDTO.setId(0);
					  reminderTermsMasterForVendorDTO.setMaxReminder(0);
					  reminderTermsMasterForVendorDTO.setReminderTermsCode("");
						  
					  enqDTO.setReminderTerms(reminderTermsMasterForVendorDTO);
				  }
				}
				 
				
				
				ShippingMethodForSalesDTO shippingMethodMasterforVendorDTO = new ShippingMethodForSalesDTO();
				if(enquiry.getShippingMethodId()!=null) {
					Optional<ShippingMethodMasterforVendor> shippingO = shippingDao.findById(enquiry.getShippingMethodId());
					if(shippingO.isPresent()) {
						ShippingMethodMasterforVendor masterforVendor = shippingO.get();
						shippingMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
						shippingMethodMasterforVendorDTO.setId(masterforVendor.getId());
						shippingMethodMasterforVendorDTO.setShippingMethodCode(masterforVendor.getShippingMethodCode());
						
						enqDTO.setShippingMethod(shippingMethodMasterforVendorDTO);
					}else {
						shippingMethodMasterforVendorDTO.setDescription("");
						shippingMethodMasterforVendorDTO.setId(0);
						shippingMethodMasterforVendorDTO.setShippingMethodCode("");
						
						enqDTO.setShippingMethod(shippingMethodMasterforVendorDTO);
					}
				}
				
				List<EnquiryDetailsDTO> enquiryDetails = 
						enquiryDetailsService.getAllEnquiryDetailsByEnquiryId(enquiry.getEnquiryId());
				for(EnquiryDetailsDTO enqDetails : enquiryDetails) {
					EnquiryDetailsDTO qd = enqDetails;
					enqDetailsDTO.add(qd);
				}
				enqDTO.setEnquiryDetails(enquiryDetails);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return enqDTO;
	  }
	  
	  /*
		 * @Param EnquiryDTO enquiryDTO
		 * 
		 * This method is used to convert EnquiryDTO to Enquiry objects. It accepts EnquiryDTO object as param and returns Enquiry object. If the enquiryDTO consists
		 * null enquiry id as null then it'll create a new object i.e it'll be used for saving purpose and if the enquiry id is present then it'll fetch the enquiry
		 * table by it's enquiry id and then replaces it by the DTO fields. That means it is used for updating.
		 * 
		 * @Returns Enquiry
		 */

	@Override
	public Enquiry prepareEnquiryEntity(EnquiryDTO enquiryDTO) {
		
     Enquiry enq = new Enquiry();
		
		if(enquiryDTO.getEnquiryId()!=null && !enquiryDTO.getEnquiryId().equals("null")) {
			enq = enquiryDao.findById(enquiryDTO.getEnquiryId()).get();
		}
		
		enq.setAccepted(enquiryDTO.getAccepted());
		enq.setBillingAddr(enquiryDTO.getBillingAddr());
		enq.setCopy(enquiryDTO.getCopy());
		enq.setEnquiryCode(enquiryDTO.getEnquiryCode());
		enq.setDueDate(enquiryDTO.getDueDate());
		enq.setEnquiryDate(enquiryDTO.getEnquiryDate());
		enq.setNext(enquiryDTO.getNext());
		enq.setNotes(enquiryDTO.getNotes());
		enq.setPriority(enquiryDTO.getPriority());
		enq.setProductType(enquiryDTO.getProductType());
		enq.setReferenceNo(enquiryDTO.getReferenceNo());
		enq.setRegdOfficeAddr(enquiryDTO.getRegdOfficeAddr());
		enq.setSourceOfEnquiry(enquiryDTO.getSourceOfEnquiry());
		enq.setIsActive(1);
		
		enq.setRegion(enquiryDTO.getRegion());
		enq.setDivision(enquiryDTO.getDivision());
		
		if(enquiryDTO.getPaymentMethod()!=null )
			enq.setPaymentMethodId(enquiryDTO.getPaymentMethod().getId());
		else
			enq.setPaymentMethodId(0);
		
		if(enquiryDTO.getPaymentTerms()!=null)
			enq.setPaymentTermsId(enquiryDTO.getPaymentTerms().getId());
		else
			enq.setPaymentTermsId(0);
		
		if(enquiryDTO.getDeliveryTerms()!=null)
			enq.setDeliveryTermsId(enquiryDTO.getDeliveryTerms().getId());
		else
			enq.setDeliveryTermsId(0);
		
		if(enquiryDTO.getJurisdiction()!=null)
			enq.setJurisdictionId(enquiryDTO.getJurisdiction().getId());
		else
			enq.setJurisdictionId(0);
		
		if(enquiryDTO.getShippingMethod()!=null)
			enq.setShippingMethodId(enquiryDTO.getShippingMethod().getId());
		else
			enq.setShippingMethodId(0);
		
		if(enquiryDTO.getReminderTerms()!=null)
			enq.setShippingMethodId(enquiryDTO.getReminderTerms().getId());
		else
			enq.setShippingMethodId(0);
		
		
		if(enquiryDTO.getCustomer()!=null)
			enq.setCustomer(enquiryDTO.getCustomer().getCustomerId());
		else
			enq.setCustomer(0);
		
//		quot.setQuotationItems(quotationItems);
		
		return enq;
	}

}
