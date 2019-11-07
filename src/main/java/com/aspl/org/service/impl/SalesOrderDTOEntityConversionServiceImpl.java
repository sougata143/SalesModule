package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.aspl.org.dto.JurisdictionForSalesDTO;
import com.aspl.org.dto.MarketingDetailsDTO;
import com.aspl.org.dto.PaymentMethodForSalesDTO;
import com.aspl.org.dto.PaymentTermsForSalesDTO;
import com.aspl.org.dto.QuotationDTO;
import com.aspl.org.dto.QuotationEnquiryMappingDTO;
import com.aspl.org.dto.QuotationForSalesOrderDTO;
import com.aspl.org.dto.ReminderTermsForSalesDTO;
import com.aspl.org.dto.SalesorderDTO;
import com.aspl.org.dto.SalesorderDetailsDTO;
import com.aspl.org.dto.ShippingMethodForSalesDTO;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.entity.ReminderTermsMasterForVendor;
import com.aspl.org.entity.Salesorder;
import com.aspl.org.entity.SalesorderDetails;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
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
import com.aspl.org.service.SalesOrderDTOEntityConversionService;
import com.aspl.org.service.SalesOrderDetailsEntityDTOConversionService;
import com.aspl.org.service.UomMasterService;
import com.aspl.org.service.WorkOrderDetailsService;
import com.aspl.org.service.WorkOrderEntityDTOConversionService;
import com.aspl.org.service.WorkOrderService;


@Service
@Transactional
public class SalesOrderDTOEntityConversionServiceImpl implements SalesOrderDTOEntityConversionService {

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
	
	@Autowired
	SalesOrderDetailsEntityDTOConversionService salesOrderDetailsEntityDTOConversionService;
	WorkOrderEntityDTOConversionService workOrderEntityDTOConversionService;
	
	
	/*
	 * @Param Salesorder salesorder
	 * @Param authorisationStatus
	 * 
	 * This method is used to convert Salesorder entity to SalesorderDTO. It takes salesorder entity and authorisationStatus as params and returns SalesorderDTO. It consists
	 * some different entities like Enquiry, AgentDetails, DeliveryTermsMaster, PaymentMethodMaster, PaymentTermsMaster, JurisdictionMaster, ShippingMethodMaster and
	 * SalesorderDetails. According to the authorization status it fetches authorized salesorder details or unauthorized salesorder details.  
	 * 
	 * @Returns SalesorderDTO
	 */
	@Override
	public SalesorderDTO prepareSalesorderDTO(Salesorder salesorder,String authorization) {
		
		SalesorderDTO salesorderDTO = new SalesorderDTO();
		
		salesorderDTO.setSalesService(salesorder.getSalesService());
		
		salesorderDTO.setAccepted(salesorder.getAccepted());
		salesorderDTO.setBillingAddr(salesorder.getBillingAddr());
		salesorderDTO.setCgst(salesorder.getCgst());
		salesorderDTO.setCgstPer(salesorder.getCgstPer());
		salesorderDTO.setCreatedDate(salesorder.getCreatedDate());
		salesorderDTO.setDeliveryDate(salesorder.getDeliveryDate());
		salesorderDTO.setFreight(salesorder.getFreight());
		salesorderDTO.setGrandTotal(salesorder.getGrandTotal());
		salesorderDTO.setSalesOrderId(salesorder.getSalesorderId());
		salesorderDTO.setIgst(salesorder.getIgst());
		salesorderDTO.setCreditLimit(salesorder.getCreditLimit());
		salesorderDTO.setPurchaseDate(salesorder.getPurchaseDate());
		salesorderDTO.setDeliveryDate(salesorder.getDeliveryDate());
		salesorderDTO.setInsurance(salesorder.getInsurance());
		salesorderDTO.setIsActive(salesorder.getIsActive());
		salesorderDTO.setOrderDate(salesorder.getOrderDate());
		salesorderDTO.setOtherCharges(salesorder.getOtherCharges());
		salesorderDTO.setManufacturing(salesorder.getManufacturing());
		salesorderDTO.setSalesorderCode(salesorder.getSalesorderCode());
		salesorderDTO.setRevalidate(salesorder.getRevalidate());
		
		try{
			List<MarketingDetailsDTO> marketings = marketingService.getMarketingDetailsForSalesOrder(salesorder.getSalesorderId()) ;
			if(marketings!=null && !marketings.isEmpty())
				salesorderDTO.setMarketing(marketings);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		salesorderDTO.setOrderDate(salesorder.getOrderDate());
		salesorderDTO.setProductType(salesorder.getProductType());
		
		try {
			List<QuotationEnquiryMappingDTO> mappingDTO = 
					quotSalesOrderMapping.getQuotationEnquiryMappingBySalesOrderId(salesorder.getSalesorderId());
			
			List<QuotationForSalesOrderDTO> quotationForSales = new ArrayList<>();
			if(mappingDTO!=null && !mappingDTO.isEmpty()) {
				for(QuotationEnquiryMappingDTO dto : mappingDTO) {
					QuotationDTO quotation = quotationService.getQuotationById(dto.getQuotationId());
					QuotationForSalesOrderDTO dtoEmpty = new QuotationForSalesOrderDTO();
					dtoEmpty.setQuotationCode(quotation.getQuotationCode());
					dtoEmpty.setQuotationId(quotation.getQuotationId());
					quotationForSales.add(dtoEmpty);
				}
			}
			salesorderDTO.setQuotation(quotationForSales);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		salesorderDTO.setRegdOfficeAddr(salesorder.getRegdOfficeAddr());
		salesorderDTO.setRoyalty(salesorder.getRoyalty());
		salesorderDTO.setSgst(salesorder.getSgst());
		salesorderDTO.setValidityDate(salesorder.getValidityDate());
		salesorderDTO.setPkg(salesorder.getPkg());
		salesorderDTO.setOtherCharges(salesorder.getOtherCharges());
		salesorderDTO.setOutStanding(salesorder.getOutStanding());
		salesorderDTO.setPkg(salesorder.getPkg());
		salesorderDTO.setPkgPer(salesorder.getPkgPer());
		salesorderDTO.setPurchase(salesorder.getPurchase());
		salesorderDTO.setStatus(salesorder.getStatus());
		
		salesorderDTO.setSalesorderStatus(salesorder.getSalesorderStatus());
		
		List<AgentEnquiryQuotationSalesOrderMappingDTO> agentMappingDTOs = 
				agentMappingService.getMappingByCodeAndType(salesorder.getSalesorderCode(), "salesOrder");
		
		List<AgentDetailsDTO> agentDTOs = new ArrayList<>();
		try {
			if(agentMappingDTOs!=null && !agentMappingDTOs.isEmpty()) {
				for(AgentEnquiryQuotationSalesOrderMappingDTO agentMappingDTO : agentMappingDTOs) {
					if(agentMappingDTO.getAgentId()!=null) {
						AgentDetailsDTO agentDTO = agentService.getAgentDetailsById(agentMappingDTO.getAgentId());
						agentDTOs.add(agentDTO);
					}
				}
			}
			salesorderDTO.setAgent(agentDTOs);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(salesorder.getRegion()!=null) {
			salesorderDTO.setRegion(salesorder.getRegion());
		}
		
		if(salesorder.getDivision()!=null) {
			salesorderDTO.setDivision(salesorder.getDivision());
		}
		
		try {
			if(salesorder.getCustomer()!=null) {
				CustomerMasterDTO customer = customerService.getCustomerMasterById(Integer.valueOf(salesorder.getCustomer()));
				CustomerForSalesDTO customerDTO = new CustomerForSalesDTO();
				customerDTO.setCustomerCode(customer.getCustomerCode());
				customerDTO.setCustomerId(customer.getCustomerId());
				customerDTO.setCustomerName(customer.getCustomerName());
				salesorderDTO.setCustomer(customerDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		List<SalesorderDetailsDTO> salesorderDetailsDTO = new ArrayList<>();
		try {
			List<SalesorderDetails> salesorderDetails = salesorderDetailsDao.findBySoid(salesorder.getSalesorderId());;
			if(salesorderDetails!=null && !salesorderDetails.isEmpty()) {
				for(SalesorderDetails soDetails : salesorderDetails) {
					SalesorderDetailsDTO soDetailsDTO = salesOrderDetailsEntityDTOConversionService.prepareSalesorderDetailsDTO(soDetails);
					salesorderDetailsDTO.add(soDetailsDTO);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			salesorderDTO.setSalesorderDetails(salesorderDetailsDTO);
		
			salesorderDTO.setIgstPer(salesorder.getIgstPer());
			salesorderDTO.setCgstPer(salesorder.getCgstPer());
			salesorderDTO.setSgstPer(salesorder.getSgstPer());
			salesorderDTO.setFreightPer(salesorder.getFreightPer());
			salesorderDTO.setRoyaltyPer(salesorder.getRoyaltyPer());
			salesorderDTO.setPkgPer(salesorder.getPkgPer());
			
			salesorderDTO.setLst(salesorder.getLst());
			salesorderDTO.setPoReference(salesorder.getPoReference());
			salesorderDTO.setRateList(salesorder.getRateList());
			salesorderDTO.setAccessibleValue(salesorder.getAccessibleValue());
			
			salesorderDTO.setJobber(salesorder.getJobber());
			salesorderDTO.setAmendmentDate(salesorder.getAmendmentDate());
			salesorderDTO.setFreightType(salesorder.getFreightType());
			salesorderDTO.setAdvance(salesorder.getAdvance());
			salesorderDTO.setBalance(salesorder.getBalance());
			salesorderDTO.setPackingType(salesorder.getPackingType());
			
			if(salesorder.getBookedBy()!=null) {
				salesorderDTO.setBookedBy(salesorder.getBookedBy());
			}else {
				salesorderDTO.setBookedBy("");
			}
			
			if(salesorder.getBookedBy()!=null) {
				salesorderDTO.setNotes(salesorder.getNotes());
			}else {
				salesorderDTO.setNotes("");
			}
			
			try {
				DeliveryTermsForSalesDTO deliveryTermsMasterforVendorDTO = new DeliveryTermsForSalesDTO();
				if(salesorder.getDeliveryTermsId()!=null) {
					Optional<DeliveryTermsMasterforVendor> deliveryTermsO = deliveryMasterDao.findById(salesorder.getDeliveryTermsId());
					
					if(deliveryTermsO.isPresent()) {
						DeliveryTermsMasterforVendor DeliveryTermsMasterControllerforVendor = deliveryTermsO.get();
						deliveryTermsMasterforVendorDTO.setDeliveryTermsCode(DeliveryTermsMasterControllerforVendor.getDeliveryTermsCode());
						deliveryTermsMasterforVendorDTO.setDescription(DeliveryTermsMasterControllerforVendor.getDescription());
						deliveryTermsMasterforVendorDTO.setId(DeliveryTermsMasterControllerforVendor.getId());
						
						salesorderDTO.setDeliveryTerms(deliveryTermsMasterforVendorDTO);
					}else {
						deliveryTermsMasterforVendorDTO.setDeliveryTermsCode("");
						deliveryTermsMasterforVendorDTO.setDescription("");
						deliveryTermsMasterforVendorDTO.setId(0);
						
						salesorderDTO.setDeliveryTerms(deliveryTermsMasterforVendorDTO);
					}
					
					JurisdictionForSalesDTO jurisdictionMasterForVendor = new JurisdictionForSalesDTO();
					if(salesorder.getJurisdictionId()!=null) {
						Optional<JurisdictionMasterForVendor> juridictionO = juridictionDao.findById(salesorder.getJurisdictionId());
						if(juridictionO.isPresent()) {
							JurisdictionMasterForVendor juridiction = juridictionO.get();
							jurisdictionMasterForVendor.setDescription(juridiction.getDescription());
							jurisdictionMasterForVendor.setId(juridiction.getId());
							jurisdictionMasterForVendor.setJurisdictionCode(juridiction.getJurisdictionCode());
							
							salesorderDTO.setJurisdiction(jurisdictionMasterForVendor);
						}else {
							jurisdictionMasterForVendor.setDescription("");
							jurisdictionMasterForVendor.setId(0);
							jurisdictionMasterForVendor.setJurisdictionCode("");
							
							salesorderDTO.setJurisdiction(jurisdictionMasterForVendor);
						}
					}
					
					PaymentMethodForSalesDTO paymentMethodMasterforVendorDTO = new PaymentMethodForSalesDTO();
					if(salesorder.getPaymentMethodId()!=null) {
						Optional<PaymentMethodMasterforVendor> paymentMethodO = paymentMethodDao.findById(salesorder.getPaymentMethodId()) ;
						if(paymentMethodO.isPresent()) {
							PaymentMethodMasterforVendor masterforVendor = paymentMethodO.get();
							paymentMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
							paymentMethodMasterforVendorDTO.setId(masterforVendor.getId());
							paymentMethodMasterforVendorDTO.setPaymentMethodCode(masterforVendor.getPaymentMethodCode());
							
							salesorderDTO.setPaymentMethod(paymentMethodMasterforVendorDTO);
						}else {
							paymentMethodMasterforVendorDTO.setDescription("");
							paymentMethodMasterforVendorDTO.setId(0);
							paymentMethodMasterforVendorDTO.setPaymentMethodCode("");
							
							salesorderDTO.setPaymentMethod(paymentMethodMasterforVendorDTO);
						}
					}
					
					
					PaymentTermsForSalesDTO paymentTermsMasterforVendorDTO = new PaymentTermsForSalesDTO();
					if(salesorder.getPaymentTermsId()!=null) {
						Optional<PaymentTermsMasterforVendor> paymentTermsO = paymentTermsDao.findById(salesorder.getPaymentTermsId());
						if(paymentTermsO.isPresent()) {
							PaymentTermsMasterforVendor masterforVendor = paymentTermsO.get();
							paymentTermsMasterforVendorDTO.setDays(masterforVendor.getDays());
							paymentTermsMasterforVendorDTO.setDescription(masterforVendor.getDescription());
							paymentTermsMasterforVendorDTO.setDiscAmt(masterforVendor.getDisc_amt());
							paymentTermsMasterforVendorDTO.setId(masterforVendor.getId());
							paymentTermsMasterforVendorDTO.setPaymentTermsCode(masterforVendor.getPaymentTermsCode());
							
							salesorderDTO.setPaymentTerms(paymentTermsMasterforVendorDTO);
						}else {
							paymentTermsMasterforVendorDTO.setDays(0);
							paymentTermsMasterforVendorDTO.setDescription("");
							paymentTermsMasterforVendorDTO.setDiscAmt(0.0);
							paymentTermsMasterforVendorDTO.setId(0);
							paymentTermsMasterforVendorDTO.setPaymentTermsCode("");
							
							salesorderDTO.setPaymentTerms(paymentTermsMasterforVendorDTO);
						}
					}
					
					
				
				  ReminderTermsForSalesDTO reminderTermsMasterForVendorDTO = new ReminderTermsForSalesDTO(); 
				  if(salesorder.getReminderTerms()!=null) { 
					  Optional<ReminderTermsMasterForVendor> reminderO = reminderMasterDao.findById(salesorder.getReminderTerms());
					  if(reminderO.isPresent()) { 
						  ReminderTermsMasterForVendor forVendor = reminderO.get();
						  reminderTermsMasterForVendorDTO.setDescription(forVendor.getDescription());
						  reminderTermsMasterForVendorDTO.setId(forVendor.getId());
						  reminderTermsMasterForVendorDTO.setMaxReminder(forVendor.getMaxReminder());
						  reminderTermsMasterForVendorDTO.setReminderTermsCode(forVendor.getReminderTermsCode());
					  
						  salesorderDTO.setReminderTerms(reminderTermsMasterForVendorDTO); 
					  }else {
						  reminderTermsMasterForVendorDTO.setDescription("");
						  reminderTermsMasterForVendorDTO.setId(0);
						  reminderTermsMasterForVendorDTO.setMaxReminder(0);
						  reminderTermsMasterForVendorDTO.setReminderTermsCode("");
					  
						  salesorderDTO.setReminderTerms(reminderTermsMasterForVendorDTO);
					  }
				  }
				 
					
					
					ShippingMethodForSalesDTO shippingMethodMasterforVendorDTO = new ShippingMethodForSalesDTO();
					if(salesorder.getShippingMethodId()!=null) {
						Optional<ShippingMethodMasterforVendor> shippingO = shippingDao.findById(salesorder.getShippingMethodId());
						if(shippingO.isPresent()) {
							ShippingMethodMasterforVendor masterforVendor = shippingO.get();
							shippingMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
							shippingMethodMasterforVendorDTO.setId(masterforVendor.getId());
							shippingMethodMasterforVendorDTO.setShippingMethodCode(masterforVendor.getShippingMethodCode());
							
							salesorderDTO.setShippingMethod(shippingMethodMasterforVendorDTO);
						}else {
							shippingMethodMasterforVendorDTO.setDescription("");
							shippingMethodMasterforVendorDTO.setId(0);
							shippingMethodMasterforVendorDTO.setShippingMethodCode("");
							
							salesorderDTO.setShippingMethod(shippingMethodMasterforVendorDTO);
						}
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		
		return salesorderDTO;
	}

	
	/*
	 * @Param SalesorderDTO salesorderDTO
	 * 
	 * This method is used to convert SalesorderDTO to Salesorder objects. It accepts SalesorderDTO object as param and returns Salesorder object. If the salesorderDTO consists
	 *  salesorder id as null then it'll create a new object i.e it'll be used for saving purpose and if the salesorder id is present then it'll fetch the salesorder
	 * table by it's salesorder id and then replaces it by the DTO fields. That means it is used for updating.
	 * 
	 * @Returns Quotation
	 */
	@Override
	public Salesorder prepareSalesorderEntity(SalesorderDTO salesorderDTO) {
		Salesorder salesorder = new Salesorder();
		
		if(salesorderDTO.getSalesOrderId()!=null) {
			Optional<Salesorder> salesorderO = salesorderDao.findById(salesorderDTO.getSalesOrderId());
			if(salesorderO.isPresent()) {
				salesorder = salesorderO.get();
			}
		}
		
		if(salesorderDTO.getSalesOrderId()==null) {
			salesorder.setAccepted(0);
			salesorder.setSalesorderStatus(0);
			salesorder.setAuthorise("0");
		}
		
		if(salesorderDTO.getCgst()!=null) {
			salesorder.setCgst(salesorderDTO.getCgst());
		}else {
			salesorder.setCgst(0.0);
		}
		
		salesorder.setDeliveryDate(salesorderDTO.getDeliveryDate());
		
		salesorder.setSalesService(salesorderDTO.getSalesService());
		
		if(salesorderDTO.getFreight()!=null) {
			salesorder.setFreight(salesorderDTO.getFreight());
		}else {
			salesorder.setFreight(salesorderDTO.getFreight());
		}
		
		if(salesorderDTO.getGrandTotal()!=null) {
			salesorder.setGrandTotal(salesorderDTO.getGrandTotal());
		}else {
			salesorder.setGrandTotal(0.0);
		}
		
//		purchase.setGst(purchaseDTO.getGst());
		if(salesorderDTO.getIgst()!=null) {
			salesorder.setIgst(salesorderDTO.getIgst());
		}else {
			salesorder.setIgst(0.0);
		}
		salesorder.setAccepted(salesorderDTO.getAccepted());
		salesorder.setBillingAddr(salesorderDTO.getBillingAddr());
		
		if(salesorderDTO.getCgstPer()!=null) {
			salesorder.setCgstPer(salesorderDTO.getCgstPer());
		}else {
			salesorder.setCgstPer(0.0);
		}
		
		if(salesorderDTO.getIgstPer()!=null) {
			salesorder.setIgstPer(salesorderDTO.getIgstPer());
		}else {
			salesorder.setIgstPer(0.0);
		}
		
		if(salesorderDTO.getCreditLimit()!=null) {
			salesorder.setCreditLimit(salesorderDTO.getCreditLimit());
		}else {
			salesorder.setCreditLimit(0.0);
		}
		
		salesorder.setPurchaseDate(salesorderDTO.getPurchaseDate());
		salesorder.setDeliveryDate(salesorder.getDeliveryDate());
		
		if(salesorderDTO.getAccessibleValue()!=null) {
			salesorder.setAccessibleValue(salesorderDTO.getAccessibleValue());
		}else {
			salesorder.setAccessibleValue(0.0);
		}
		
		if(salesorderDTO.getInsurance()!=null) {
			salesorder.setInsurance(salesorderDTO.getInsurance());
		}else {
			salesorder.setInsurance("0");
		}
		
		salesorder.setIsActive(1);
		salesorder.setOrderDate(salesorderDTO.getOrderDate());
		
		if(salesorderDTO.getOtherCharges()!=null) {
			salesorder.setOtherCharges(salesorderDTO.getOtherCharges());
		}else {
			salesorder.setOtherCharges(0.0);
		}
		
		salesorder.setRegdOfficeAddr(salesorderDTO.getRegdOfficeAddr());
		
		if(salesorderDTO.getRoyalty()!=null) {
			salesorder.setRoyalty(salesorderDTO.getRoyalty());
		}else {
			salesorder.setRoyalty(0.0);
		}
		
		if(salesorderDTO.getSgst()!=null) {
			salesorder.setSgst(salesorderDTO.getSgst());
		}else {
			salesorder.setSgst(0.0);
		}
		
		salesorder.setValidityDate(salesorderDTO.getValidityDate());
		
		if(salesorderDTO.getBookedBy()!=null) {
			salesorder.setBookedBy(salesorderDTO.getBookedBy());
		}else {
			salesorder.setBookedBy("");
		}
		
		if(salesorderDTO.getBookedBy()!=null) {
			salesorder.setNotes(salesorderDTO.getNotes());
		}else {
			salesorder.setNotes("");
		}
		
		List<SalesorderDetailsDTO> salesorderDetailsDTOs = salesorderDTO.getSalesorderDetails();
		List<SalesorderDetails> salesorderDetailsEntitys = new ArrayList<>();
		for(SalesorderDetailsDTO soDetailsDTO : salesorderDetailsDTOs) {
			SalesorderDetails soDetails = salesOrderDetailsEntityDTOConversionService.prepareSalesorderDetailsEntity(soDetailsDTO);
			salesorderDetailsEntitys.add(soDetails);
		}
		salesorder.setSalesorderDetails(salesorderDetailsEntitys);
		
		
//		salesorder.setQuotation(salesorderDTO.getQuotation().getQuotationId());
			
		if(salesorderDTO.getPkg()!=null) {
			salesorder.setPkg(salesorderDTO.getPkg());
		}else {
			salesorder.setPkg(0.0);
		}
		
		salesorder.setCreatedDate(new Date());
		salesorder.setBillingAddr(salesorderDTO.getBillingAddr());
		salesorder.setPurchaseDate(salesorderDTO.getPurchaseDate());
		salesorder.setDeliveryDate(salesorderDTO.getDeliveryDate());
		
		if(salesorderDTO.getFreight()!=null) {
			salesorder.setFreight(salesorderDTO.getFreight());
		}else {
			salesorder.setFreight(0.0);
		}
		
		if(salesorderDTO.getGrandTotal()!=null)
			salesorder.setGrandTotal(salesorderDTO.getGrandTotal());
		else
			salesorder.setGrandTotal(0.0);
		
		if(salesorderDTO.getIgst()!=null) {
			salesorder.setIgst(salesorderDTO.getIgst());
		}else {
			salesorder.setIgst(0.0);
		}
		
		salesorder.setInsurance(salesorderDTO.getInsurance());
		salesorder.setIsActive(1);
		salesorder.setManufacturing(salesorderDTO.getManufacturing());
		salesorder.setOrderDate(salesorderDTO.getOrderDate());
		
		if(salesorderDTO.getOtherCharges()!=null) {
			salesorder.setOtherCharges(salesorderDTO.getOtherCharges());
		}else {
			salesorder.setOtherCharges(0.0);
		}
		
		salesorder.setOutStanding(salesorderDTO.getOutStanding());
		
		if(salesorderDTO.getPkg()!=null) {
			salesorder.setPkg(salesorderDTO.getPkg());
		}else {
			salesorder.setPkg(0.0);
		}
		
		salesorder.setProductType(salesorderDTO.getProductType());
		salesorder.setPurchase(salesorderDTO.getPurchase());
		salesorder.setPurchaseCode(salesorderDTO.getPurchaseCode());
		
//		salesorder.setMarketing(salesorderDTO.getMarketing());
		
		salesorder.setStatus(salesorderDTO.getStatus());
		
		if(salesorderDTO.getSgstPer()!=null) {
			salesorder.setSgstPer(salesorderDTO.getSgstPer());
		}else {
			salesorder.setSgstPer(0.0);
		}
		
		if(salesorderDTO.getFreightPer()!=null) {
			salesorder.setFreightPer(salesorderDTO.getFreightPer());
		}else {
			salesorder.setFreightPer(0.0);
		}
		
		if(salesorderDTO.getRoyaltyPer()!=null) {
			salesorder.setRoyaltyPer(salesorderDTO.getRoyaltyPer());
		}else {
			salesorder.setRoyaltyPer(0.0);
		}
		
		if(salesorderDTO.getPkgPer()!=null) {
			salesorder.setPkgPer(salesorderDTO.getPkgPer());
		}else {
			salesorder.setPkgPer(0.0);
		}
		
		salesorder.setRegion(salesorderDTO.getRegion());
		salesorder.setDivision(salesorderDTO.getDivision());
		
		if(salesorderDTO.getPaymentMethod()!=null )
			salesorder.setPaymentMethodId(salesorderDTO.getPaymentMethod().getId());
		else
			salesorder.setPaymentMethodId(0);
		
		if(salesorderDTO.getPaymentTerms()!=null)
			salesorder.setPaymentTermsId(salesorderDTO.getPaymentTerms().getId());
		else
			salesorder.setPaymentTermsId(0);
		
		if(salesorderDTO.getDeliveryTerms()!=null)
			salesorder.setDeliveryTermsId(salesorderDTO.getDeliveryTerms().getId());
		else
			salesorder.setDeliveryTermsId(0);
		
		if(salesorderDTO.getJurisdiction()!=null)
			salesorder.setJurisdictionId(salesorderDTO.getJurisdiction().getId());
		else
			salesorder.setJurisdictionId(0);
		
		if(salesorderDTO.getShippingMethod()!=null)
			salesorder.setShippingMethodId(salesorderDTO.getShippingMethod().getId());
		else
			salesorder.setShippingMethodId(0);
		
		if(salesorderDTO.getReminderTerms()!=null)
			salesorder.setReminderTerms(salesorderDTO.getReminderTerms().getId());
		else
			salesorder.setReminderTerms(0);
		
//		salesorder.setMarketing(salesorderDTO.getMarketing());
		
		if(salesorderDTO.getCustomer()!=null)
			salesorder.setCustomer(String.valueOf(salesorderDTO.getCustomer().getCustomerId()));
		else
			salesorder.setCustomer("");
		
		salesorder.setLst(salesorderDTO.getLst());
		salesorder.setPoReference(salesorderDTO.getPoReference());
		salesorder.setRateList(salesorderDTO.getRateList());
		salesorder.setJobber(salesorderDTO.getJobber());
		salesorder.setAmendmentDate(salesorderDTO.getAmendmentDate());
		salesorder.setFreightType(salesorderDTO.getFreightType());
		salesorder.setAdvance(salesorderDTO.getAdvance());
		salesorder.setBalance(salesorderDTO.getBalance());
		salesorder.setPackingType(salesorderDTO.getPackingType());
		
		return salesorder;
	}

}
