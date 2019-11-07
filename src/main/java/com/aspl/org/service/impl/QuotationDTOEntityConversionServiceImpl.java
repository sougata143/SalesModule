package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.AgentDetailsDTO;
import com.aspl.org.dto.AgentEnquiryQuotationSalesOrderMappingDTO;
import com.aspl.org.dto.CustomerForSalesDTO;
import com.aspl.org.dto.CustomerMasterDTO;
import com.aspl.org.dto.DeliveryTermsForSalesDTO;
import com.aspl.org.dto.EnquiryDTO;
import com.aspl.org.dto.EnquiryForSalesDTO;
import com.aspl.org.dto.JurisdictionForSalesDTO;
import com.aspl.org.dto.MarketingDetailsDTO;
import com.aspl.org.dto.PaymentMethodForSalesDTO;
import com.aspl.org.dto.PaymentTermsForSalesDTO;
import com.aspl.org.dto.QuotationDTO;
import com.aspl.org.dto.QuotationDetailsDTO;
import com.aspl.org.dto.QuotationEnquiryMappingDTO;
import com.aspl.org.dto.ReminderTermsForSalesDTO;
import com.aspl.org.dto.ShippingMethodForSalesDTO;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.entity.Quotation;
import com.aspl.org.entity.ReminderTermsMasterForVendor;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
import com.aspl.org.repository.ContactsDetailsDao;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.ItemMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.QuotationDetailsRepository;
import com.aspl.org.repository.QuotationRepository;
import com.aspl.org.repository.ReminderTermsMasterDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.service.AgentDetailsService;
import com.aspl.org.service.AgentEnquiryQuotationSalesOrderMappingService;
import com.aspl.org.service.CustomerMasterService;
import com.aspl.org.service.EnquiryService;
import com.aspl.org.service.MarketingDetailsService;
import com.aspl.org.service.QuotationDTOEntityConversionService;
import com.aspl.org.service.QuotationDetailsService;
import com.aspl.org.service.QuotationEnquiryMappingService;
import com.aspl.org.utils.GlobalDefine;


@Service
@Transactional
public class QuotationDTOEntityConversionServiceImpl implements QuotationDTOEntityConversionService {

	@Autowired
	QuotationRepository quotationRepo;	
	
	@Autowired
	QuotationDetailsRepository quotationDetailsRepo;
	
	@Autowired
	ItemMasterDao itemDao;
	
	@Autowired
	CustomerMasterService customerService;
	
	@Autowired
	QuotationDetailsService quotationDetailsService;
	
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
	EnquiryService enquiryService;
	
	@Autowired
	AgentDetailsService agentService;
	
	@Autowired
	MarketingDetailsService marketingService;
	
	@Autowired
	AgentEnquiryQuotationSalesOrderMappingService agentMappingService;
	
	@Autowired
	QuotationEnquiryMappingService quotEnqMappingService;
	
	/*
	 * @Param Quotation quotation
	 * @Param authorisationStatus
	 * 
	 * This method is used to convert Quotation entity to QuotationDTO. It takes quotation entity and authorisationStatus as params and returns QuotationDTO. It consists
	 * some different entities like Enquiry, AgentDetails, DeliveryTermsMaster, PaymentMethodMaster, PaymentTermsMaster, JurisdictionMaster, ShippingMethodMaster and
	 * QuotationDetails. According to the authorization status it fetches authorized quotation details or unauthorized quotation details.  
	 * 
	 * @Returns QuotationDTO
	 */
	@Override
	public QuotationDTO prepareQuotationDTO(Quotation quotation, String authorisationStatus) {
		
		QuotationDTO quotDTO = new QuotationDTO();
		List<QuotationDetailsDTO> quotDetailsDTO = new ArrayList<>();
		
		quotDTO.setAssesableValue(quotation.getAssesableValue());
		quotDTO.setBillTo(quotation.getBillTo());
		quotDTO.setCgst(quotation.getCgst());
		quotDTO.setCreditLimit(quotation.getCreditLimit());
		
		quotDTO.setFreightType(quotation.getFreightType());
		quotDTO.setGrandTotal(quotation.getGrandTotal());
		quotDTO.setIgst(quotation.getIgst());
		quotDTO.setInsurance(quotation.getInsurance());
		quotDTO.setLst(quotation.getLst());
		quotDTO.setOtherCharges(quotation.getOtherCharges());
		quotDTO.setOutStanding(quotation.getOutStanding());
		quotDTO.setPkg(quotation.getPkg());
		quotDTO.setProductType(quotation.getProductType());
		quotDTO.setQuotationCode(quotation.getQuotationCode());
		quotDTO.setQuotationDate(quotation.getQuotationDate());
		quotDTO.setQuotationId(quotation.getQuotationId());
		quotDTO.setRateList(quotation.getRateList());
		quotDTO.setSgst(quotation.getSgst());
		quotDTO.setShipTo(quotation.getShipTo());
		quotDTO.setValidationDate(quotation.getValidationDate());
		
		quotDTO.setRegion(quotation.getRegion());
		quotDTO.setDivision(quotation.getDivision());
		
		//updated fields as per the UI
		quotDTO.setFreight(quotation.getFreight());
		quotDTO.setFreightPer(quotation.getFreightPer());
		quotDTO.setPkgPer(quotation.getPkgPer());
		quotDTO.setRoyaltyPer(quotation.getRoyaltyPer());
		quotDTO.setIgstPer(quotation.getIgstPer());
		quotDTO.setSgstPer(quotation.getSgstPer());
		quotDTO.setCgstPer(quotation.getCgstPer());
		quotDTO.setPackingType(quotation.getPackingType());
		quotDTO.setNotes(quotation.getNotes());
		quotDTO.setPreparedBy(quotation.getPreparedBy());
		quotDTO.setRoyalty(quotation.getRoyalty());
		quotDTO.setRevalidate(quotation.getRevalidate());
		
		try {
			List<EnquiryForSalesDTO> enquiryDTOs = new ArrayList<>();
			List<QuotationEnquiryMappingDTO> mappings = 
					quotEnqMappingService.getQuotationEnquiryMappingByQuotationId(quotation.getQuotationId());
			if(mappings!=null && !mappings.isEmpty()) {
				for(QuotationEnquiryMappingDTO mapping : mappings) {
					if(mapping.getEnquiryId()!=null) {
						EnquiryDTO enquiry = enquiryService.findByEnquiryId(mapping.getEnquiryId());
						EnquiryForSalesDTO enqQuotDTO = new EnquiryForSalesDTO();
						enqQuotDTO.setEnquiryCode(enquiry.getEnquiryCode());
						enqQuotDTO.setEnquiryId(enquiry.getEnquiryId());
						enquiryDTOs.add(enqQuotDTO);
					}
				}
				quotDTO.setEnquiry(enquiryDTOs);
			}
			
			List<MarketingDetailsDTO> marketings = marketingService.getMarketingDetailsForQuotation(quotation.getQuotationId());
			if(marketings!=null && !marketings.isEmpty())
				quotDTO.setMarketingDetails(marketings);
			
			List<AgentDetailsDTO> agentDTOs = new ArrayList<>();
			List<AgentEnquiryQuotationSalesOrderMappingDTO> agentMappings = 
					agentMappingService.getMappingByCodeAndType(quotation.getQuotationCode(), "quotation");
			if(agentMappings!=null && !agentMappings.isEmpty()) {
				for(AgentEnquiryQuotationSalesOrderMappingDTO agentMapping : agentMappings) {
					if(agentMapping.getAgentId()!=null) {
						AgentDetailsDTO agentDetailsDTO = agentService.getAgentDetailsById(agentMapping.getAgentId());
						agentDTOs.add(agentDetailsDTO);
					}
				}
			}
			quotDTO.setAgent(agentDTOs);
			
			if(quotation.getCustomer()!=null) {
				CustomerMasterDTO customer = customerService.getCustomerMasterById(Integer.valueOf(quotation.getCustomer()));
				CustomerForSalesDTO cust = new CustomerForSalesDTO();
				cust.setCustomerCode(customer.getCustomerCode());
				cust.setCustomerId(customer.getCustomerId());
				cust.setCustomerName(customer.getCustomerName());
				quotDTO.setCustomer(cust);
			}else {
				CustomerForSalesDTO cust = new CustomerForSalesDTO();
				cust.setCustomerCode("");
				cust.setCustomerId(0);
				cust.setCustomerName("");
				quotDTO.setCustomer(cust);
			}
			
			DeliveryTermsForSalesDTO deliveryTermsMasterforVendorDTO = new DeliveryTermsForSalesDTO();
			if(quotation.getDeliveryTermsId()!=null) {
				Optional<DeliveryTermsMasterforVendor> deliveryTermsO = deliveryMasterDao.findById(quotation.getDeliveryTermsId());
				
				if(deliveryTermsO.isPresent()) {
					DeliveryTermsMasterforVendor DeliveryTermsMasterControllerforVendor = deliveryTermsO.get();
					deliveryTermsMasterforVendorDTO.setDeliveryTermsCode(DeliveryTermsMasterControllerforVendor.getDeliveryTermsCode());
					deliveryTermsMasterforVendorDTO.setDescription(DeliveryTermsMasterControllerforVendor.getDescription());
					deliveryTermsMasterforVendorDTO.setId(DeliveryTermsMasterControllerforVendor.getId());
					
					quotDTO.setDeliveryTerms(deliveryTermsMasterforVendorDTO);
				}else {
					deliveryTermsMasterforVendorDTO.setDeliveryTermsCode("");
					deliveryTermsMasterforVendorDTO.setDescription("");
					deliveryTermsMasterforVendorDTO.setId(0);
					
					quotDTO.setDeliveryTerms(deliveryTermsMasterforVendorDTO);
				}
						
			}
			
			
			JurisdictionForSalesDTO jurisdictionMasterForVendor = new JurisdictionForSalesDTO();
			if(quotation.getJurisdictionId()!=null) {
				Optional<JurisdictionMasterForVendor> juridictionO = juridictionDao.findById(quotation.getJurisdictionId());
				if(juridictionO.isPresent()) {
					JurisdictionMasterForVendor juridiction = juridictionO.get();
					jurisdictionMasterForVendor.setDescription(juridiction.getDescription());
					jurisdictionMasterForVendor.setId(juridiction.getId());
					jurisdictionMasterForVendor.setJurisdictionCode(juridiction.getJurisdictionCode());
					
					quotDTO.setJurisdiction(jurisdictionMasterForVendor);
				}else {
					jurisdictionMasterForVendor.setDescription("");
					jurisdictionMasterForVendor.setId(0);
					jurisdictionMasterForVendor.setJurisdictionCode("");
					
					quotDTO.setJurisdiction(jurisdictionMasterForVendor);
				}
			}
			
			
			PaymentMethodForSalesDTO paymentMethodMasterforVendorDTO = new PaymentMethodForSalesDTO();
			if(quotation.getPaymentMethodId()!=null) {
				Optional<PaymentMethodMasterforVendor> paymentMethodO = paymentMethodDao.findById(quotation.getPaymentMethodId()) ;
				if(paymentMethodO.isPresent()) {
					PaymentMethodMasterforVendor masterforVendor = paymentMethodO.get();
					paymentMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
					paymentMethodMasterforVendorDTO.setId(masterforVendor.getId());
					paymentMethodMasterforVendorDTO.setPaymentMethodCode(masterforVendor.getPaymentMethodCode());
					
					quotDTO.setPaymentMethod(paymentMethodMasterforVendorDTO);
				}else {
					paymentMethodMasterforVendorDTO.setDescription("");
					paymentMethodMasterforVendorDTO.setId(0);
					paymentMethodMasterforVendorDTO.setPaymentMethodCode("");
					
					quotDTO.setPaymentMethod(paymentMethodMasterforVendorDTO);
				}
			}
			
			
			PaymentTermsForSalesDTO paymentTermsMasterforVendorDTO = new PaymentTermsForSalesDTO();
			if(quotation.getPaymentTermsId()!=null) {
				Optional<PaymentTermsMasterforVendor> paymentTermsO = paymentTermsDao.findById(quotation.getPaymentTermsId());
				if(paymentTermsO.isPresent()) {
					PaymentTermsMasterforVendor masterforVendor = paymentTermsO.get();
					paymentTermsMasterforVendorDTO.setDays(masterforVendor.getDays());
					paymentTermsMasterforVendorDTO.setDescription(masterforVendor.getDescription());
					paymentTermsMasterforVendorDTO.setDiscAmt(masterforVendor.getDisc_amt());
					paymentTermsMasterforVendorDTO.setId(masterforVendor.getId());
					paymentTermsMasterforVendorDTO.setPaymentTermsCode(masterforVendor.getPaymentTermsCode());
					
					quotDTO.setPaymentTerms(paymentTermsMasterforVendorDTO);
				}else {
					paymentTermsMasterforVendorDTO.setDays(0);
					paymentTermsMasterforVendorDTO.setDescription("");
					paymentTermsMasterforVendorDTO.setDiscAmt(0.0);
					paymentTermsMasterforVendorDTO.setId(0);
					paymentTermsMasterforVendorDTO.setPaymentTermsCode("");
					
					quotDTO.setPaymentTerms(paymentTermsMasterforVendorDTO);
				}
			}
			
			
			
			  ReminderTermsForSalesDTO reminderTermsMasterForVendorDTO = new ReminderTermsForSalesDTO(); 
			  if(quotation.getReminderTermsId()!=null) {
				  Optional<ReminderTermsMasterForVendor> reminderO =
				  reminderMasterDao.findById(quotation.getReminderTermsId());
				  if(reminderO.isPresent()) {
					  ReminderTermsMasterForVendor forVendor = reminderO.get();
					  reminderTermsMasterForVendorDTO.setDescription(forVendor.getDescription());
					  reminderTermsMasterForVendorDTO.setId(forVendor.getId());
					  reminderTermsMasterForVendorDTO.setMaxReminder(forVendor.getMaxReminder());
					  reminderTermsMasterForVendorDTO.setReminderTermsCode(forVendor.getReminderTermsCode());
				  
					  quotDTO.setReminderTerms(reminderTermsMasterForVendorDTO); 
				  }else {
					  reminderTermsMasterForVendorDTO.setDescription("");
					  reminderTermsMasterForVendorDTO.setId(0);
					  reminderTermsMasterForVendorDTO.setMaxReminder(0);
					  reminderTermsMasterForVendorDTO.setReminderTermsCode("");
				  
					  quotDTO.setReminderTerms(reminderTermsMasterForVendorDTO);
				  }
			  }
			 
			
			
			ShippingMethodForSalesDTO shippingMethodMasterforVendorDTO = new ShippingMethodForSalesDTO();
			if(quotation.getShippingMethodId()!=null) {
				Optional<ShippingMethodMasterforVendor> shippingO = shippingDao.findById(quotation.getShippingMethodId());
				if(shippingO.isPresent()) {
					ShippingMethodMasterforVendor masterforVendor = shippingO.get();
					shippingMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
					shippingMethodMasterforVendorDTO.setId(masterforVendor.getId());
					shippingMethodMasterforVendorDTO.setShippingMethodCode(masterforVendor.getShippingMethodCode());
					
					quotDTO.setShippingMethod(shippingMethodMasterforVendorDTO);
				}else {
					shippingMethodMasterforVendorDTO.setDescription("");
					shippingMethodMasterforVendorDTO.setId(0);
					shippingMethodMasterforVendorDTO.setShippingMethodCode("");
					
					quotDTO.setShippingMethod(shippingMethodMasterforVendorDTO);
				}
			}
			
			List<QuotationDetailsDTO> quotationDetails = new ArrayList<>();
			if(authorisationStatus.equalsIgnoreCase("all")) {
				quotationDetails = 
						quotationDetailsService.getAllQuotationDetailsByQuotationId(quotation.getQuotationId());
			}else if(authorisationStatus.equalsIgnoreCase("authorised")) {
				quotationDetails = 
						quotationDetailsService.getAllQuotationDetailsByQuotationIdAndStatus(quotation.getQuotationId(), GlobalDefine.quotAccept);
			}else if(authorisationStatus.equalsIgnoreCase("unauthorised")) {
				quotationDetails = 
						quotationDetailsService.getAllQuotationDetailsByQuotationIdAndStatus(quotation.getQuotationId(), 0);
			}else {
				quotationDetails = null;
			}
			
			for(QuotationDetailsDTO quotDetails : quotationDetails) {
				QuotationDetailsDTO qd = quotDetails;
				quotDetailsDTO.add(qd);
			}
			quotDTO.setQuotationItems(quotDetailsDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return quotDTO;
	}
	
	
	/*
	 * @Param QuotationDTO quotationDTO
	 * 
	 * This method is used to convert QuotationDTO to Quotation objects. It accepts QuotationDTO object as param and returns Quotation object. If the quotationDTO consists
	 * null quotation id as null then it'll create a new object i.e it'll be used for saving purpose and if the quotation id is present then it'll fetch the quotation
	 * table by it's quotation id and then replaces it by the DTO fields. That means it is used for updating.
	 * 
	 * @Returns Quotation
	 */
	@Override
	public Quotation prepeareQuotationEntity(QuotationDTO quotationDTO) {
		
		Quotation quot = new Quotation();
		
		if(quotationDTO.getQuotationId()!=null && !quotationDTO.getQuotationId().equals("null")) {
			quot = quotationRepo.findById(quotationDTO.getQuotationId()).get();
		}
		
		quot.setAssesableValue(quotationDTO.getAssesableValue());
		quot.setBillTo(quotationDTO.getBillTo());
		quot.setCgst(quotationDTO.getCgst());
		quot.setCreditLimit(quotationDTO.getCreditLimit());
//		quot.setEnquiryId(String.valueOf(quotationDTO.getEnquiry().getEnquiryId()));
		quot.setFreightType(quotationDTO.getFreightType());
		quot.setGrandTotal(quotationDTO.getGrandTotal());
		quot.setIgst(quotationDTO.getIgst());
		quot.setInsurance(quotationDTO.getInsurance());
		quot.setLst(quotationDTO.getLst());
		quot.setOtherCharges(quotationDTO.getOtherCharges());
		quot.setOutStanding(quotationDTO.getOutStanding());
		quot.setPkg(quotationDTO.getPkg());
		quot.setProductType(quotationDTO.getProductType());
//		quot.setQuotationCode(quotationDTO.getQuotationCode());
		quot.setQuotationDate(quotationDTO.getQuotationDate());
//		quot.setQuotationId(quotationDTO.getQuotationId());
		quot.setRateList(quotationDTO.getRateList());
		quot.setSgst(quotationDTO.getSgst());
		quot.setShipTo(quotationDTO.getShipTo());
		quot.setValidationDate(quotationDTO.getValidationDate());
		
		//updated fields as per the UI
		quot.setFreight(quotationDTO.getFreight());
		quot.setFreightPer(quotationDTO.getFreightPer());
		quot.setPkgPer(quotationDTO.getPkgPer());
		quot.setRoyaltyPer(quotationDTO.getRoyaltyPer());
		quot.setIgstPer(quotationDTO.getIgstPer());
		quot.setSgstPer(quotationDTO.getSgstPer());
		quot.setCgstPer(quotationDTO.getCgstPer());
		quot.setPackingType(quotationDTO.getPackingType());
		quot.setNotes(quotationDTO.getNotes());
		quot.setPreparedBy(quotationDTO.getPreparedBy());
		quot.setRoyalty(quotationDTO.getRoyalty());
		quot.setRevalidate(quotationDTO.getRevalidate());
		
		quot.setRegion(quotationDTO.getRegion());
		quot.setDivision(quotationDTO.getDivision());
		
		/*if(quotationDTO.getAgent()!=null) {
			if(quotationDTO.getAgent()!=null && !quotationDTO.getAgent().isEmpty()) {
				List<AgentDetailsDTO> agentsDTO = quotationDTO.getAgent();
				List<String> agentListS = new ArrayList<>();
				for(AgentDetailsDTO agentDTO : agentsDTO) {
					String agentIdS = String.valueOf(agentDTO.getAgentId());
					agentListS.add(agentIdS);
				}
				
			}
		}*/
		
		if(quotationDTO.getPaymentMethod()!=null )
			quot.setPaymentMethodId(quotationDTO.getPaymentMethod().getId());
		else
			quot.setPaymentMethodId(0);
		
		if(quotationDTO.getPaymentTerms()!=null)
			quot.setPaymentTermsId(quotationDTO.getPaymentTerms().getId());
		else
			quot.setPaymentTermsId(0);
		
		if(quotationDTO.getDeliveryTerms()!=null)
			quot.setDeliveryTermsId(quotationDTO.getDeliveryTerms().getId());
		else
			quot.setDeliveryTermsId(0);
		
		if(quotationDTO.getJurisdiction()!=null)
			quot.setJurisdictionId(quotationDTO.getJurisdiction().getId());
		else
			quot.setJurisdictionId(0);
		
		if(quotationDTO.getShippingMethod()!=null)
			quot.setShippingMethodId(quotationDTO.getShippingMethod().getId());
		else
			quot.setShippingMethodId(0);
		
		if(quotationDTO.getReminderTerms()!=null)
			quot.setReminderTermsId(quotationDTO.getReminderTerms().getId());
		else
			quot.setReminderTermsId(0);
		
		if(quotationDTO.getCustomer()!=null)
			quot.setCustomer(String.valueOf(quotationDTO.getCustomer().getCustomerId()));
		else
			quot.setCustomer("");
		
//		quot.setQuotationItems(quotationItems);
		
		return quot;
	}

}
