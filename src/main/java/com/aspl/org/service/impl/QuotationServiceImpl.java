package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.AgentDetailsDTO;
import com.aspl.org.dto.AgentEnquiryQuotationSalesOrderMappingDTO;
import com.aspl.org.dto.EnquiryForSalesDTO;
import com.aspl.org.dto.MarketingDetailsDTO;
import com.aspl.org.dto.QuotationDTO;
import com.aspl.org.dto.QuotationDetailsDTO;
import com.aspl.org.dto.QuotationEnquiryMappingDTO;
import com.aspl.org.entity.Quotation;
import com.aspl.org.entity.QuotationDetails;
import com.aspl.org.entity.ResponseDetails;
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
import com.aspl.org.service.QuotationService;
import com.aspl.org.utils.GlobalDefine;


/*
 *Service class for Quotation. CRUD Operation on quotation entity is done in this class. 
 */
@Service
@Transactional
public class QuotationServiceImpl implements QuotationService {

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
	
	@Autowired
	QuotationDTOEntityConversionService quotationDTOEntityConversionService;
	
	
	/*
	 *This method is used for fetching all the quotations which has isActvive status as 1 i.e fetching all the active quotations.
	 *It calls prepareQuotationDTO for converting the entity class to DTO class. prepareQuotationDTO method takes two params, 
	 *first is the quotation entity and the second param is the type of quotation.
	 *
	 *@Return List<QuotationDTO>
	 */
	@Override
	public List<QuotationDTO> getAllQuotation() {
		// TODO Auto-generated method stub
		List<QuotationDTO> quotDTOs = new ArrayList<>();
		try {
			List<Quotation> quots = quotationRepo.findByIsActive(1);
			for(Quotation quot : quots) {
				QuotationDTO quotDTO = new QuotationDTO();
				quotDTO = quotationDTOEntityConversionService.prepareQuotationDTO(quot, "all");
				quotDTOs.add(quotDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotDTOs;
	}

	
	/*
	 * @Param quotId
	 * 
	 * This method is used for fetching quotation by quotation id. It calls prepareQuotationDTO method to convert the fetched entity
	 * object to DTO object. prepareQuotationDTO method accepts Quotation entity object as param and returns QuotationDTO object.
	 * 
	 * @Retrun QuotationDTO
	 */
	@Override
	public QuotationDTO getQuotationById(Integer quotId) {
		// TODO Auto-generated method stub
		QuotationDTO quotDTO = new QuotationDTO();
		try {
			
			Quotation quot = quotationRepo.findById(quotId).get();
			quotDTO = quotationDTOEntityConversionService.prepareQuotationDTO(quot, "all");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotDTO;
	}

	
	/*
	 * @Patam List<QuotationDTO> quotationDTOs
	 * 
	 * This method is used to save quotation. This method receives a list of quotation DTOs and then saves it one by one by iterating 
	 * through the list. It calls prepeareQuotationEntity method to convert the quotation dto to quotation entity. prepeareQuotationEntity
	 * method takes quotation dto as param and returns quotation entity object. After saving the quotation header table it also saves
	 * quotation details table and also MarketingDetails table. In marketing details table it consist quotation id to map. There may be
	 * multiple marketing details objects, so it will be a list and save it by iterating through the list.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails saveQuotation(QuotationDTO quotationDTO) {
		// TODO Auto-generated method stub
		try {
			
			if(quotationDTO!=null) {

				Quotation quot = new Quotation();
				List<EnquiryForSalesDTO> enquiryDTOEmpty = new ArrayList<>();
				List<EnquiryForSalesDTO> enquiryDTOs = quotationDTO.getEnquiry();
				for(EnquiryForSalesDTO dto : enquiryDTOs) {
					enquiryDTOEmpty.add(dto);
				}
				List<AgentDetailsDTO> agentsDTO = quotationDTO.getAgent();
				List<AgentDetailsDTO> agents = new ArrayList<>();
				for(AgentDetailsDTO agent : agentsDTO) {
					agents.add(agent);
				}
				
				List<MarketingDetailsDTO> marketingDetails = new ArrayList<>();
				
				if(quotationDTO.getMarketingDetails()!=null && !quotationDTO.getMarketingDetails().isEmpty()) {
					for(MarketingDetailsDTO market : quotationDTO.getMarketingDetails()) {
						
						MarketingDetailsDTO marketDTO = new MarketingDetailsDTO();
						
						marketDTO.setDescription(market.getDescription());
						marketDTO.setMarketingId(market.getMarketingId());
						marketDTO.setQuotationId(market.getQuotationId());
						marketDTO.setSalesOrderId(market.getSalesOrderId());
						marketDTO.setTerms(market.getTerms());
						
						marketingDetails.add(marketDTO);
					}
				}
				
				quot = quotationDTOEntityConversionService.prepeareQuotationEntity(quotationDTO);
				
				quot.setIsActive(1);
				quot.setStatus(GlobalDefine.quotPending);
				
				//Generating QuotationCode start
				/*String quotationCode = "";
				Long quotationCount = quotationRepo.count();
				
				DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
				String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//				(formattedDate);
				Integer currYear = Integer.valueOf(formattedDate);
				Integer nextYear = currYear+1;
				quotationCode = "CR/QTN/"+(quotationCount+1)+"/"+currYear+"-"+nextYear;*/
				//Generating QuotationCode end
				
				quot.setQuotationCode(quotationDTO.getQuotationCode());
				
				Quotation quotationRetrun = quotationRepo.save(quot);
				
				for(QuotationDetailsDTO quotItem : quotationDTO.getQuotationItems()) {
					quotItem.setQuotationId(quotationRetrun.getQuotationId());
					quotationDetailsService.saveQuotationDetails(quotItem);
				}
				
				if(quotationRetrun!=null){
					for(MarketingDetailsDTO market : marketingDetails) {
						market.setQuotationId(quotationRetrun.getQuotationId());
						marketingService.saveMarketingDetails(market);
					}
					
					for(AgentDetailsDTO agent : agents) {
						AgentEnquiryQuotationSalesOrderMappingDTO agentMappingDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
						
						if(agent.getAgentMappingId()!=null && agent.getAgentMappingId()!=0) {
							agentMappingDTO = agentMappingService.getMappingByMappingId(agent.getAgentMappingId());
						}
						
						agentMappingDTO.setAgentId(agent.getAgentId());
						agentMappingDTO.setEnquiryCode("");
						agentMappingDTO.setIsActive(1);
						agentMappingDTO.setQuotationCode(quotationDTO.getQuotationCode());
						agentMappingDTO.setSalesOrderCode("");
						
						agentMappingService.saveAgentEnquiryQuotationSalesOrderMapping(agentMappingDTO);
						
					}
				}
				
				for(EnquiryForSalesDTO enquiryDTO : enquiryDTOEmpty) {
					QuotationEnquiryMappingDTO mappingDTO = new QuotationEnquiryMappingDTO();
					mappingDTO.setEnquiryId(enquiryDTO.getEnquiryId());
					mappingDTO.setQuotationId(quotationRetrun.getQuotationId());
					mappingDTO.setSalesOrderId(0);
					mappingDTO.setIsActive(1);
					quotEnqMappingService.saveQuotationEnquiryMapping(mappingDTO);
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "quotation created successfully", "200");
	}

	
	/*
	 * @Patam QuotationDTO quotationDTO
	 * 
	 * This method is used to update quotation. This method receives a object of quotation DTO and then updates it. It calls 
	 * prepeareQuotationEntity method to convert the quotation dto to quotation entity. prepeareQuotationEntity
	 * method takes quotation dto as param and returns quotation entity object. After updating the quotation header table it also saves
	 * quotation details table and also MarketingDetails table. In marketing details table it consist quotation id to map. There may be
	 * multiple marketing details objects, so it will be a list and save it by iterating through the list.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails updateQuotation(QuotationDTO quotationDTO) {
		// TODO Auto-generated method stub
		try {
			
			Quotation quot = quotationRepo.findById(quotationDTO.getQuotationId()).get();
			
			List<EnquiryForSalesDTO> enquiryDTOEmpty = new ArrayList<>();
			List<EnquiryForSalesDTO> enquiryDTOs = quotationDTO.getEnquiry();
			for(EnquiryForSalesDTO dto : enquiryDTOs) {
				enquiryDTOEmpty.add(dto);
			}
			
			List<AgentDetailsDTO> agentsDTO = quotationDTO.getAgent();
			List<AgentDetailsDTO> agents = new ArrayList<>();
			for(AgentDetailsDTO agent : agentsDTO) {
				agents.add(agent);
			}
			
			List<MarketingDetailsDTO> marketingDetails = new ArrayList<>();
			for(MarketingDetailsDTO market : quotationDTO.getMarketingDetails()) {
				
				MarketingDetailsDTO marketDTO = new MarketingDetailsDTO();
				
				marketDTO.setDescription(market.getDescription());
				marketDTO.setMarketingId(market.getMarketingId());
				marketDTO.setQuotationId(market.getQuotationId());
				marketDTO.setSalesOrderId(market.getSalesOrderId());
				marketDTO.setTerms(market.getTerms());
				
				marketingDetails.add(marketDTO);
			}
			
			quot = quotationDTOEntityConversionService.prepeareQuotationEntity(quotationDTO);
			
			Quotation quotationRetrun = quotationRepo.save(quot);
			
			for(QuotationDetailsDTO quotItem : quotationDTO.getQuotationItems()) {
				quotItem.setQuotationId(quotationRetrun.getQuotationId());
				quotationDetailsService.updateQuotationDetails(quotItem);
			}
			
			for(AgentDetailsDTO agent : agents) {
				AgentEnquiryQuotationSalesOrderMappingDTO agentMappingDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
				agentMappingDTO = agentMappingService.getMappingByCodeAndTypeAndAgentId(quotationDTO.getQuotationCode(), 
						"quotation", agent.getAgentId());
				
				if(agentMappingDTO==null) {
					agentMappingDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
				}
				
				agentMappingDTO.setAgentId(agent.getAgentId());
				agentMappingDTO.setEnquiryCode("");
				agentMappingDTO.setIsActive(1);
				agentMappingDTO.setQuotationCode(quotationDTO.getQuotationCode());
				agentMappingDTO.setSalesOrderCode("");
				
				agentMappingService.saveAgentEnquiryQuotationSalesOrderMapping(agentMappingDTO);
				
			}
			
			List<MarketingDetailsDTO> marketingDTOs = marketingService.getMarketingDetailsForQuotation(quotationDTO.getQuotationId());
			if(!marketingDTOs.isEmpty()){
				for(MarketingDetailsDTO market : marketingDetails) {
					MarketingDetailsDTO marketDTO = new MarketingDetailsDTO();
					if(market.getMarketingId()!=null && market.getMarketingId()!=0) {
						marketDTO = marketingService.getMarketingDetailsByMarketingId(market.getMarketingId());
					}
					marketDTO.setDescription(market.getDescription());
					marketDTO.setQuotationId(quotationRetrun.getQuotationId());
					marketDTO.setSalesOrderId(0);
					marketDTO.setTerms(market.getTerms());
					marketingService.saveMarketingDetails(marketDTO);
				}
			}
			
			for(EnquiryForSalesDTO enquiryDTO : enquiryDTOEmpty) {
				QuotationEnquiryMappingDTO mappingDTO = new QuotationEnquiryMappingDTO();
				
				if(enquiryDTO.getEnquiryId()!=null) {
					List<QuotationEnquiryMappingDTO> mappingDTOList =
							quotEnqMappingService.getQuotationEnquiryMappingByQuotationIdAndEnquiryId(quotationDTO.getQuotationId(), enquiryDTO.getEnquiryId());
					if(!mappingDTOList.isEmpty()) {
						mappingDTO = mappingDTOList.get(0);
					}
				}
				
				mappingDTO.setEnquiryId(enquiryDTO.getEnquiryId());
				mappingDTO.setQuotationId(quotationRetrun.getQuotationId());
				mappingDTO.setSalesOrderId(0);
				mappingDTO.setIsActive(1);
				quotEnqMappingService.saveQuotationEnquiryMapping(mappingDTO);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "quotation updated successfully", "200");
	}

	
	/*
	 * @Param Integer quotId
	 * 
	 * This method is used to delete quotation. This deletion is soft delete that means it only changes the is active status to 0.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails softDeleteQuotation(Integer quotId) {
		// TODO Auto-generated method stub
		try {
			
			Quotation quot = quotationRepo.findById(quotId).get();
			
			quot.setIsActive(0);
			
			quotationRepo.save(quot);
			
			List<QuotationDetails> quotDetails = quotationDetailsRepo.findByQuotationId(quotId);
			
			for(QuotationDetails quotItem : quotDetails) {
				quotItem.setIsActive(0);
				quotationDetailsRepo.save(quotItem);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "quotation updated successfully", "200");
	}

	/*
	 *This method is used for fetching all the unauthorized quotations which has status as 0 i.e fetching all the active quotations.
	 *It calls prepareQuotationDTO for converting the entity class to DTO class. prepareQuotationDTO method takes two params, 
	 *first is the quotation entity and the second param is the type of quotation.
	 *
	 *@Return List<QuotationDTO>
	 */
	@Override
	public List<QuotationDTO> getAllUnAuthorisedQuotation() {
		// TODO Auto-generated method stub
		List<QuotationDTO> quotDTOs = new ArrayList<>();
		try {
			List<Quotation> quots = quotationRepo.findByStatusAndIsActive(0, 1);
			for(Quotation quot : quots) {
				QuotationDTO quotDTO = new QuotationDTO();
				quotDTO = quotationDTOEntityConversionService.prepareQuotationDTO(quot, "unauthorised");
				quotDTOs.add(quotDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotDTOs;
	}
	

	/*
	 *This method is used for fetching all the authorized quotations which has status as 1 i.e fetching all the active quotations.
	 *It calls prepareQuotationDTO for converting the entity class to DTO class. prepareQuotationDTO method takes two params, 
	 *first is the quotation entity and the second param is the type of quotation.
	 *
	 *@Return List<QuotationDTO>
	 */
	@Override
	public List<QuotationDTO> getAllAuthorisedQuotation(String weight, String gst) {
		// TODO Auto-generated method stub
		List<QuotationDTO> quotDTOs = new ArrayList<>();
		try {
			if(weight!=null && gst!=null) {
				if(weight.equalsIgnoreCase("all") && gst.equalsIgnoreCase("all")) {
					List<Quotation> quots = quotationRepo.findByStatusAndIsActive(2, 1);
					for(Quotation quot : quots) {
						QuotationDTO quotDTO = new QuotationDTO();
						quotDTO = quotationDTOEntityConversionService.prepareQuotationDTO(quot, "authorised");
						quotDTOs.add(quotDTO);
					}
				}
			}
			
			if(weight!=null) {
				if(weight.equalsIgnoreCase("weight") && gst==null) {
					List<Quotation> quots = quotationRepo.findByStatusAndIsActive(2, 1);
					for(Quotation quot : quots) {
						QuotationDTO quotDTO = new QuotationDTO();
						
						Boolean flag = false;
						List<QuotationDetails> quotItem = quotationDetailsRepo.findByQuotationId(quot.getQuotationId());
						for(QuotationDetails details : quotItem) {
							if(details.getWeight()!=null && !details.getWeight().equals("null")) {
								flag = true;
							}
						}
						
						quotDTO = quotationDTOEntityConversionService.prepareQuotationDTO(quot, "authorised");
						if(flag==true)
							quotDTOs.add(quotDTO);
					}
				}
			}
			
			if(weight==null && gst==null) {
				List<Quotation> quots = quotationRepo.findByStatusAndIsActive(2, 1);
				for(Quotation quot : quots) {
					QuotationDTO quotDTO = new QuotationDTO();
					
					Boolean flag = false;
					List<QuotationDetails> quotItem = quotationDetailsRepo.findByQuotationId(quot.getQuotationId());
					for(QuotationDetails details : quotItem) {
						if(details.getWeight()==null || details.getWeight().equals("null")) {
							flag = true;
						}
					}
					
					quotDTO = quotationDTOEntityConversionService.prepareQuotationDTO(quot, "authorised");
					if(flag==true)
						quotDTOs.add(quotDTO);
				}
			}
			
			if(weight!=null && gst!=null) {
				if(weight.equalsIgnoreCase("weight") && gst.equalsIgnoreCase("gst")) {
					List<Quotation> quots = quotationRepo.findByStatusOrAndIsActiveWithGST();
					for(Quotation quot : quots) {
						QuotationDTO quotDTO = new QuotationDTO();
						
						Boolean flag = false;
						List<QuotationDetails> quotItem = quotationDetailsRepo.findByQuotationId(quot.getQuotationId());
						for(QuotationDetails details : quotItem) {
							if(details.getWeight()!=null && !details.getWeight().equals("null")) {
								flag = true;
							}
						}
						
						quotDTO = quotationDTOEntityConversionService.prepareQuotationDTO(quot, "authorised");
						if(flag==true)
							quotDTOs.add(quotDTO);
					}
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotDTOs;
	}

	
	/*
	 * @Param QuotationDTO quotationDTO
	 * 
	 * This method is used to authorize quotation. It takes QuotationDTO as param and updates the status to 2.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails authoriseQuotation(QuotationDTO quotationDTO) {
		// TODO Auto-generated method stub
		try {
			
			Quotation quot = quotationRepo.findById(quotationDTO.getQuotationId()).get();
			List<QuotationDetails> quotDetails = quotationDetailsRepo.findByQuotationIdAndStatus(quotationDTO.getQuotationId(), 0);
//			List<QuotationDetailsDTO> quotDetailsDTO = quotationDTO.getQuotationItems();
			
//			Integer entityList = quotDetails.size();
//			Integer dtoSize = quotDetailsDTO.size();
			
//			if(entityList == dtoSize) {
				quot.setStatus(GlobalDefine.quotAccept);
				quot.setRevalidate(quotationDTO.getRevalidate());
//			}
			
//			if(entityList > dtoSize) {
//				quot.setStatus(GlobalDefine.quotPartlyAcept);
//			}
			
			quotationRepo.save(quot);
			
//			for(QuotationDetailsDTO quotItem : quotationDTO.getQuotationItems()) {
//				QuotationDetails quotDetail = quotationDetailsService.prepareQuotationDetailsEntity(quotItem);
//				quotDetail.setStatus(GlobalDefine.quotAccept);
//				quotationDetailsRepo.save(quotDetail);
//			}
			
			for(QuotationDetails quotItem : quotDetails) {
				quotItem.setStatus(GlobalDefine.quotAccept);
				quotationDetailsRepo.save(quotItem);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "quotation accepted successfully", "200");
	}

	
	/*
	 * @Param QuotationDTO quotationDTO
	 * 
	 * This method is used to unauthorize quotation. It takes QuotationDTO as param and updates the status to 0.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails unAuthoriseQuotation(QuotationDTO quotationDTO) {
		// TODO Auto-generated method stub
		try {
			
			Quotation quot = quotationRepo.findById(quotationDTO.getQuotationId()).get();
			List<QuotationDetails> quotDetails = quotationDetailsRepo.findByQuotationId(quotationDTO.getQuotationId());
			List<QuotationDetailsDTO> quotDetailsDTO = quotationDTO.getQuotationItems();
			
			Integer entityList = quotDetails.size();
			Integer dtoSize = quotDetailsDTO.size();
			
			if(entityList == dtoSize) {
				quot.setStatus(GlobalDefine.quotReject);
			}
			
			if(entityList > dtoSize) {
				quot.setStatus(GlobalDefine.quotPartlyAcept);
			}
			
			quotationRepo.save(quot);
			
			for(QuotationDetailsDTO quotItem : quotationDTO.getQuotationItems()) {
				QuotationDetails quotDetail = quotationDetailsService.prepareQuotationDetailsEntity(quotItem);
				quotDetail.setStatus(GlobalDefine.quotReject);
				quotationDetailsRepo.save(quotDetail);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "quotation rejected successfully", "200");
	}

	@Override
	public List<QuotationDTO> getAllQuotationByCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		List<QuotationDTO> quotationDTOs = new ArrayList<>();
		try {
			List<Quotation> quotations = quotationRepo.findByCustomer(String.valueOf(customerId));
			for(Quotation quot : quotations) {
				QuotationDTO quotationDTO = quotationDTOEntityConversionService.prepareQuotationDTO(quot, "all");
				quotationDTOs.add(quotationDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotationDTOs;
	}

}
