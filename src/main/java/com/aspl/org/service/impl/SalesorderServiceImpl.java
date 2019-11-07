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
import com.aspl.org.dto.MarketingDetailsDTO;
import com.aspl.org.dto.QuotationEnquiryMappingDTO;
import com.aspl.org.dto.QuotationForSalesOrderDTO;
import com.aspl.org.dto.SalesorderDTO;
import com.aspl.org.dto.SalesorderDetailsDTO;
import com.aspl.org.dto.WorkOrderDTO;
import com.aspl.org.dto.WorkOrderDetailsDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.Salesorder;
import com.aspl.org.entity.SalesorderDetails;
import com.aspl.org.entity.WorkOrder;
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
import com.aspl.org.service.SalesorderService;
import com.aspl.org.service.UomMasterService;
import com.aspl.org.service.WorkOrderDetailsEntityDTOConversionService;
import com.aspl.org.service.WorkOrderDetailsService;
import com.aspl.org.service.WorkOrderEntityDTOConversionService;
import com.aspl.org.service.WorkOrderService;
import com.aspl.org.utils.GlobalDefine;

@Service
@Transactional
public class SalesorderServiceImpl implements SalesorderService {
	
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
	SalesOrderDTOEntityConversionService salesOrderDTOEntityConversionService;
	
	@Autowired
	SalesOrderDetailsEntityDTOConversionService salesOrderDetailsEntityDTOConversionService;
	
	@Autowired
	WorkOrderEntityDTOConversionService workOrderEntityDTOConversionService;
	
	@Autowired
	WorkOrderDetailsEntityDTOConversionService workOrderDetailsEntityDTOConversionService;
	
	

	/*
	 * @Patam SalesorderDTO salesorderDTOs
	 * 
	 * This method is used to save salesorder and Workorder. This method receives a salesorder DTO and then saves it. It calls 
	 * prepareSalesorderEntity method to convert the salesorder dto to salesorder entity. prepareSalesorderEntity method takes salesorder dto 
	 * as param and returns salesorder entity object. After saving the salesorder header table it also saves salesorder details table and also 
	 * WorkOrder and workorderDetails table. Thereafter one work order acceptance and sales order have to be created referring the quotation,
	 * and it has a ref no of purchase order also
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails salesorderSave(SalesorderDTO salesorderDTO){
		
		try {

			
			Salesorder salesorder = new Salesorder();
			SalesorderDetails serDetails = new SalesorderDetails();
			
			List<QuotationForSalesOrderDTO> quotationsDTO = salesorderDTO.getQuotation();
			List<QuotationForSalesOrderDTO> quotationsDTOs = new ArrayList<>();
			for(QuotationForSalesOrderDTO dto : quotationsDTO) {
				quotationsDTOs.add(dto);
			}
			
			/*String salesOrderCode = "";
			
			Long salesOrderCount = salesorderDao.count();
			
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//			(formattedDate);
			Integer currYear = Integer.valueOf(formattedDate);
			Integer nextYear = currYear+1;
			salesOrderCode = "WAE/"+(salesOrderCount+1)+"/"+currYear+"-"+nextYear;*/
		
			
			if(salesorderDTO!=null) {

				List<MarketingDetailsDTO> marketingDTOs = new ArrayList<>();
				if(salesorderDTO.getMarketing()!=null && !salesorderDTO.getMarketing().isEmpty()) {
					for(MarketingDetailsDTO dto : salesorderDTO.getMarketing()) {
						marketingDTOs.add(dto);
					}
				}
				
				//if (String.valueOf(serviceorderDTO.getVendor().getStateCode()).equals("19")) 
				salesorderDTO.setSgst(salesorderDTO.getSgst());
				salesorderDTO.setCgst(salesorderDTO.getCgst());
				salesorderDTO.setIgst(salesorderDTO.getIgst());
				
				salesorderDTO.setSalesorderCode(salesorderDTO.getSalesorderCode());
					
				Salesorder salesorderEntity = salesOrderDTOEntityConversionService.prepareSalesorderEntity(salesorderDTO);
				
				salesorderEntity.setSalesorderStatus(GlobalDefine.orderPending);
				salesorderEntity.setAccepted(GlobalDefine.orderPending);
				salesorderEntity.setSalesorderCode(salesorderDTO.getSalesorderCode());
				salesorderEntity.setIsActive(1);
					
				salesorder = salesorderDao.save(salesorderEntity);
					
				
				//Saving service order header end
				WorkOrder workOrderSave = new WorkOrder();
				if(salesorder!=null) {
					WorkOrderDTO workOrder = new WorkOrderDTO();
					
					workOrder = workOrderEntityDTOConversionService.prepareWorkOrderFromSalesOrder(salesorderDTO, salesorder.getSalesorderId());
					
					workOrderSave = workOrderService.saveWorkOrder(workOrder);
				}
				
				for (SalesorderDetailsDTO soDetailsDTO : salesorderDTO.getSalesorderDetails()) {
					SalesorderDetails toGetItemCode = salesOrderDetailsEntityDTOConversionService.prepareSalesorderDetailsEntity( soDetailsDTO);
					//if (String.valueOf(salesorderDTO.getVendor().getStateCode()).equals("19")) {
					//("purchase: "+purchase.getId());
					toGetItemCode.setSoid(salesorder.getSalesorderId());
					toGetItemCode.setIsActive(1);
					toGetItemCode.setSoDetailsStaus(GlobalDefine.orderPending);
					serDetails = salesorderDetailsDao.save(toGetItemCode);
					
					if(salesorder!=null && serDetails!=null) {
						WorkOrderDetailsDTO detailsDTO = new WorkOrderDetailsDTO();
						
						detailsDTO = workOrderDetailsEntityDTOConversionService
								.prepareWorkOrderDetailsFromSalesOrderDetails(soDetailsDTO, workOrderSave.getWorkOrderId(), serDetails.getSalesOrderDetailsId());
						
						workOrderDetailsService.saveWorkOrder(detailsDTO);
					}
						
				}
				
				if(salesorder!=null && serDetails!=null) {
					
					for(AgentDetailsDTO agent : salesorderDTO.getAgent()) {
						AgentEnquiryQuotationSalesOrderMappingDTO agentMappingDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
						
						agentMappingDTO.setAgentId(agent.getAgentId());
						agentMappingDTO.setEnquiryCode("");
						agentMappingDTO.setIsActive(1);
						agentMappingDTO.setQuotationCode("");
						agentMappingDTO.setSalesOrderCode(salesorderDTO.getSalesorderCode());
						
						agentMappingService.saveAgentEnquiryQuotationSalesOrderMapping(agentMappingDTO);
					}
					
					List<QuotationEnquiryMappingDTO> mappingDTOs = new ArrayList<>(); 
					for(QuotationForSalesOrderDTO dto : quotationsDTOs) {
						List<QuotationEnquiryMappingDTO> mappingDTO = 
								quotSalesOrderMapping.getQuotationEnquiryMappingByQuotationId(dto.getQuotationId());
						for(QuotationEnquiryMappingDTO mapdto : mappingDTO) {
							mappingDTOs.add(mapdto);
						}
					}
					
					for(QuotationEnquiryMappingDTO map : mappingDTOs) {
						map.setSalesOrderId(salesorder.getSalesorderId());
						map.setIsActive(1);
						quotSalesOrderMapping.saveQuotationEnquiryMapping(map);
					}
					
				}
				
				if(salesorder!=null && serDetails!=null) {
					for(MarketingDetailsDTO dto : marketingDTOs) {
						dto.setSalesOrderId(salesorder.getSalesorderId());
						marketingService.saveMarketingDetails(dto);
					}
				}
			
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseDetails(new Date(), "We have created your sales order successfully", null, 1);
	}

	
	/*
	 * @Param SalesorderDTO salesorderDTO
	 * 
	 * This method is used to update salesorder. This method receives a object of salesorderDTO and then updates it. It calls 
	 * prepareSalesorderEntity method to convert the salesorder dto to salesorder entity. prepareSalesorderEntity
	 * method takes salesorder dto as param and returns salesorder entity object. It calls 
	 * prepareSalesorderDetailsEntity method to convert the salesorder details dto to salesorder details entity. prepareSalesorderDetailsEntity
	 * method takes soDetailsDTO  as param and returns salesorderDetails  entity object. After updating the salesorder header table it also saves
	 * salesorder details table.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails salesorderUpdate(SalesorderDTO salesorderDTO) {
		Salesorder salesorder = new Salesorder();
		WorkOrder workOrderSave = new WorkOrder();
		try {
			Optional<Salesorder> salesO = salesorderDao.findById(salesorderDTO.getSalesOrderId());
			Salesorder salesOrderEntity = new Salesorder();
			
			List<QuotationForSalesOrderDTO> quotationsDTO = salesorderDTO.getQuotation();
			List<QuotationForSalesOrderDTO> quotationsDTOs = new ArrayList<>();
			for(QuotationForSalesOrderDTO dto : quotationsDTO) {
				quotationsDTOs.add(dto);
			}
			
			List<AgentDetailsDTO> agentsDTO = salesorderDTO.getAgent();
			List<AgentDetailsDTO> agents = new ArrayList<>();
			for(AgentDetailsDTO agent : agentsDTO) {
				agents.add(agent);
			}
			
			List<MarketingDetailsDTO> marketingDetails = new ArrayList<>();
			for(MarketingDetailsDTO market : salesorderDTO.getMarketing()) {
				
				MarketingDetailsDTO marketDTO = new MarketingDetailsDTO();
				
				marketDTO.setDescription(market.getDescription());
				marketDTO.setMarketingId(market.getMarketingId());
				marketDTO.setQuotationId(market.getQuotationId());
				marketDTO.setSalesOrderId(market.getSalesOrderId());
				marketDTO.setTerms(market.getTerms());
				
				marketingDetails.add(marketDTO);
			}
			
			if(salesO.isPresent()) {
				salesorder = salesO.get();
			}
			if(salesorderDTO.getSalesOrderId()!=null) {
				salesOrderEntity = salesorderDao.save(salesOrderDTOEntityConversionService.prepareSalesorderEntity(salesorderDTO));
				
				List<WorkOrderDTO> workOrders = workOrderService.getAllWorkOrderBySaleOrder(salesorderDTO.getSalesOrderId()); 
				WorkOrderDTO workOrder = new WorkOrderDTO();
				if(!workOrders.isEmpty()) {
					workOrder = workOrders.get(0);
				}
				workOrder = workOrderEntityDTOConversionService.prepareWorkOrderFromSalesOrder(salesorderDTO, salesOrderEntity.getSalesorderId());
									
				workOrderSave = workOrderService.saveWorkOrder(workOrder);
			}
			
			SalesorderDetails salesorderDetailsReturn = new SalesorderDetails();
			for (SalesorderDetailsDTO soDetailsDTO : salesorderDTO.getSalesorderDetails()) {
				if(soDetailsDTO.getSalesOrderDetailsId() == null) {
					SalesorderDetails salesorderDetails = new SalesorderDetails();

					salesorderDetails = salesOrderDetailsEntityDTOConversionService.prepareSalesorderDetailsEntity( soDetailsDTO);
					//if (String.valueOf(salesorderDTO.getVendor().getStateCode()).equals("19")) {
					//("purchase: "+purchase.getId());
					salesorderDetails.setSoid(salesorder.getSalesorderId());
					salesorderDetails.setSoDetailsStaus(0);
					salesorderDetailsReturn = salesorderDetailsDao.save(salesorderDetails);
					
					WorkOrderDetailsDTO detailsDTO = new WorkOrderDetailsDTO();
					
					detailsDTO = workOrderDetailsEntityDTOConversionService
							.prepareWorkOrderDetailsFromSalesOrderDetails(soDetailsDTO, workOrderSave.getWorkOrderId(),
									salesorderDetailsReturn.getSalesOrderDetailsId());
					
					workOrderDetailsService.saveWorkOrder(detailsDTO);
					
				}else {
					SalesorderDetails soDetails = salesorderDetailsDao.findById(soDetailsDTO.getSalesOrderDetailsId()).get();
					SalesorderDetailsDTO soDetailsUpdateDTO = 
							salesOrderDetailsEntityDTOConversionService.prepareSalesorderDetailsDTO(soDetails);
					SalesorderDetails soDetailsUpdate = 
							salesOrderDetailsEntityDTOConversionService.prepareSalesorderDetailsEntity(soDetailsUpdateDTO);
					
					WorkOrderDetailsDTO detailsDTO = new WorkOrderDetailsDTO();
					List<WorkOrderDetailsDTO> detailsDTOs = 
							workOrderDetailsService.getAllWorkOrderBySalesOrderDetails(soDetails.getSalesOrderDetailsId());
					
					if(!detailsDTOs.isEmpty()) {
						detailsDTO = detailsDTOs.get(0);
					}
					
					detailsDTO = workOrderDetailsEntityDTOConversionService
							.prepareWorkOrderDetailsFromSalesOrderDetails(soDetailsDTO, workOrderSave.getWorkOrderId(), soDetails.getSalesOrderDetailsId());
					
					workOrderDetailsService.saveWorkOrder(detailsDTO);
					soDetailsUpdate.setSoDetailsStaus(soDetailsDTO.getSoDetailsStaus());
					salesorderDetailsDao.save(soDetailsUpdate);
				}
			}
			
			for(AgentDetailsDTO agent : agents) {
				AgentEnquiryQuotationSalesOrderMappingDTO agentMappingDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
				agentMappingDTO = agentMappingService.getMappingByCodeAndTypeAndAgentId(salesorderDTO.getSalesorderCode(), 
						"salesOrder", agent.getAgentId());
				
				if(agentMappingDTO==null) {
					agentMappingDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
				}
				
				agentMappingDTO.setAgentId(agent.getAgentId());
				agentMappingDTO.setEnquiryCode(agentMappingDTO.getEnquiryCode());
				agentMappingDTO.setIsActive(1);
				agentMappingDTO.setQuotationCode(agentMappingDTO.getQuotationCode());
				agentMappingDTO.setSalesOrderCode(salesorderDTO.getSalesorderCode());
				
				agentMappingService.saveAgentEnquiryQuotationSalesOrderMapping(agentMappingDTO);
				
			}
			
			List<QuotationEnquiryMappingDTO> mappingDTOs = new ArrayList<>(); 
			for(QuotationForSalesOrderDTO dto : quotationsDTOs) {
				QuotationEnquiryMappingDTO mappingDTO = new QuotationEnquiryMappingDTO();
				
				if(dto.getQuotationId()!=null) {
					mappingDTO = quotSalesOrderMapping.getQuotationEnquiryMappingBySalesOrderIdAndQuotationId(salesorderDTO.getSalesOrderId(), dto.getQuotationId()).get(0);
					mappingDTO.setEnquiryId(mappingDTO.getEnquiryId());
				}
				
				mappingDTO.setSalesOrderId(salesorder.getSalesorderId());
				if(mappingDTO!=null) {
					mappingDTO.setEnquiryId(0);
				}
				mappingDTO.setQuotationId(dto.getQuotationId());
				mappingDTO.setIsActive(1);
				
				quotSalesOrderMapping.saveQuotationEnquiryMapping(mappingDTO);
			}
			
			/*
			 * for(QuotationEnquiryMappingDTO map : mappingDTOs) {
			 * map.setSalesOrderId(salesorder.getSalesorderId()); map.setIsActive(1);
			 * quotSalesOrderMapping.saveQuotationEnquiryMapping(map); }
			 */
			
			List<MarketingDetailsDTO> marketingDTOs = marketingService.getMarketingDetailsForSalesOrder(salesorderDTO.getSalesOrderId());
			if(!marketingDTOs.isEmpty()){
				for(MarketingDetailsDTO market : marketingDetails) {
					MarketingDetailsDTO marketDTO = new MarketingDetailsDTO();
					if(market.getMarketingId()!=null && market.getMarketingId()!=0) {
						marketDTO = marketingService.getMarketingDetailsByMarketingId(market.getMarketingId());
					}
					marketDTO.setDescription(market.getDescription());
					marketDTO.setQuotationId(market.getQuotationId());
					marketDTO.setSalesOrderId(salesOrderEntity.getSalesorderId());
					marketDTO.setTerms(market.getTerms());
					marketingService.saveMarketingDetails(marketDTO);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "Sales order updated successfully", salesorder.toString());
	}

	
	/*
	 * @Param SalesorderDTO salesorderDTO
	 * 
	 * This method is used to authorize salesorder. It takes SalesorderDTO as param and updates the status to 2.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails salesorderAuthorised(SalesorderDTO salesorderDTO) {
		Salesorder salesorder = new Salesorder();
		try {
			List<SalesorderDetails> salesorderDetailsList =  
					salesorderDetailsDao.findBySoidAndSoDetailsStausOrSoDetailsStausOrSoDetailsStaus(salesorderDTO.getSalesOrderId(), 0, 1, 4); 
			
			Integer dtoSize = salesorderDTO.getSalesorderDetails().size();
			Integer entitySize = salesorderDetailsList.size();
			
			if(dtoSize == entitySize) {
				salesorder = salesorderDao.findById(salesorderDTO.getSalesOrderId()).get();
				
				salesorder.setSalesorderStatus(GlobalDefine.orderAccept);
				
				
				for(SalesorderDetails sd : salesorderDetailsList) {
					SalesorderDetails salDetails = salesorderDetailsDao.findById(sd.getSalesOrderDetailsId()).get();
					salDetails.setSoDetailsStaus(GlobalDefine.orderAccept);
					
					salesorderDetailsDao.save(salDetails);
				}
				
				salesorder = salesorderDao.save(salesorder);
				
			}
			
			if(dtoSize < entitySize) {
				salesorder = salesorderDao.findById(salesorderDTO.getSalesOrderId()).get();
				
				salesorder.setSalesorderStatus(GlobalDefine.orderPartlyAccept);
				
				for(SalesorderDetailsDTO sd : salesorderDTO.getSalesorderDetails()) {
					
					SalesorderDetails salDetails = salesorderDetailsDao.findById(sd.getSalesOrderDetailsId()).get();
					salDetails.setSoDetailsStaus(GlobalDefine.orderAccept);
					
					salesorderDetailsDao.save(salDetails);
				}
				
				salesorder = salesorderDao.save(salesorder);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseDetails(new Date(), "Purchase Order authorised.", salesorder.toString());
	}

	
	/*
	 * @Param SalesorderDTO salesorderDTO
	 * 
	 * This method is used to unauthorize salesorder. It takes SalesorderDTO as param and updates the status to 0.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails salesorderUnauthorised(SalesorderDTO salesorderDTO) {
		Salesorder salesorder = new Salesorder();
		try {
			List<SalesorderDetails> salesorderDetailsList = salesorderDetailsDao.findBySoid(salesorderDTO.getSalesOrderId());
			Integer dtoSize = salesorderDTO.getSalesorderDetails().size();
			Integer entitySize = salesorderDetailsList.size();
			
			if(dtoSize == entitySize) {
				salesorder = salesOrderDTOEntityConversionService.prepareSalesorderEntity(salesorderDTO);
				salesorder.setSalesorderStatus(GlobalDefine.orderReject);
				
				for(SalesorderDetails pd : salesorderDetailsList) {
					pd.setSoDetailsStaus(GlobalDefine.orderReject);
					
					salesorderDetailsDao.save(pd);
				}
				
				salesorder = salesorderDao.save(salesorder);
				
			}
			
			if(dtoSize < entitySize) {
				salesorder = salesOrderDTOEntityConversionService.prepareSalesorderEntity(salesorderDTO);
				salesorderDTO.setSalesorderStatus(GlobalDefine.orderPartlyAccept);
				
				for(SalesorderDetails pd : salesorderDetailsList) {
					pd.setSoDetailsStaus(GlobalDefine.orderPartlyAccept);
					
					salesorderDetailsDao.save(pd);
				}
				
				salesorder = salesorderDao.save(salesorder);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseDetails(new Date(), "Indent authorised.", salesorder.toString());
		//return indentDao.indentAuthorised(iId);
	}
	

	/*
	 * @Param salesorderCode
	 * 
	 * This method is used for fetching salesorder by salesorder code. It calls prepareSalesorderDTO method to convert the fetched entity
	 * object to DTO object. prepareSalesorderDTO method accepts Salesorder entity object as param and returns SalesorderDTO object.
	 * 
	 * @Return SalesorderDTO
	 */
	@Override
	public SalesorderDTO findBySalesorderCode(String salesorderCode) {
		SalesorderDTO salesDTO = new SalesorderDTO();
		try {
			Salesorder sales = salesorderDao.findBySalesorderCode(salesorderCode);
			salesDTO = salesOrderDTOEntityConversionService.prepareSalesorderDTO(sales, "none");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return salesDTO;
	}

	
	/*
	 * @Param salesorderId
	 * 
	 * This method is used for fetching salesorder by salesorder id. It calls prepareSalesorderDTO method to convert the fetched entity
	 * object to DTO object. prepareSalesorderDTO method accepts Salesorder entity object as param and returns SalesorderDTO object.
	 * 
	 * @Retrun SalesorderDTO
	 */
	@Override
	public SalesorderDTO findBySalesorderId(Integer salesorderId) {
		SalesorderDTO salesDTO = new SalesorderDTO();
		try {
			Optional<Salesorder> salO = salesorderDao.findById(salesorderId);
			Salesorder sales = new Salesorder();
			if(salO.isPresent()) {
				sales = salO.get();
			}
			salesDTO = salesOrderDTOEntityConversionService.prepareSalesorderDTO(sales, "none");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return salesDTO;
	}

	
	/*
	 * Method for fetching all the salesorders for authorisation. i.e all the salesorder will accepted as 0
	 * 
	 * @Return List<SalesorderDTO>
	 * 
	 */
	@Override
	public List<SalesorderDTO> getAllSalesorderForAuthorisation() {
		List<SalesorderDTO> salesDTOs = new ArrayList<>();
		SalesorderDTO purDTO = new SalesorderDTO();
		
		try {
//			List<Salesorder> sales = salesorderDao.findBySalesorderStatusOrSalesorderStatusOrSalesorderStatus(0, 1, 4);
			List<Salesorder> sales = salesorderDao.findBySalesorderStatusAndIsActive(0, 1);
			for(Salesorder sal : sales) {
				purDTO = salesOrderDTOEntityConversionService.prepareSalesorderDTO(sal, "unauthorized");
				salesDTOs.add(purDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return salesDTOs;
	}

	
	/*
	 *This method is used for fetching all the unauthorized quotations which has status as 0 i.e fetching all the active salesorder.
	 *It calls prepareSalesorderDTO for converting the entity class to DTO class. prepareSalesorderDTO method takes two params, 
	 *first is the salesorder entity and the second param is the type of salesorder.
	 *
	 *@Return List<SalesorderDTO>
	 */
	@Override
	public List<SalesorderDTO> getAllUnAuthorisedSalesorder() {
		List<SalesorderDTO> salesDTOs = new ArrayList<>();
		SalesorderDTO salesDTO = new SalesorderDTO();
		
		try {
			List<Salesorder> sales = salesorderDao.findBySalesorderStatusOrSalesorderStatusOrSalesorderStatus(0, 1, 4);
			for(Salesorder sale : sales) {
				salesDTO = salesOrderDTOEntityConversionService.prepareSalesorderDTO(sale, "unauthorized");
				salesDTOs.add(salesDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return salesDTOs;
	}

	
	/*
	 *This method is used for fetching all the authorized salesorder which has status as 1 i.e fetching all the active salesorder.
	 *It calls prepareSalesorderDTO for converting the entity class to DTO class. prepareSalesorderDTO method takes two params, 
	 *first is the sales entity and the second param is the type of salesorder.
	 *
	 *@Return List<SalesorderDTO>
	 */
	@Override
	public List<SalesorderDTO> getAllAuthorisedSalesOrder() {
		List<SalesorderDTO> salesorderDTOs = new ArrayList<>();
		SalesorderDTO salesDTO = new SalesorderDTO();
		
		try {
			List<Salesorder> sales = salesorderDao.findBySalesorderStatus(2);
			for(Salesorder sale : sales) {
				salesDTO = salesOrderDTOEntityConversionService.prepareSalesorderDTO(sale, "authorized");
				salesorderDTOs.add(salesDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return salesorderDTOs;
	}

	
	/*
	 *This method is used for fetching all the salesorder which has isActvive status as 1 i.e fetching all the active salesorder.
	 *It calls prepareSalesorderDTO for converting the entity class to DTO class. prepareSalesorderDTO method takes a param, which is 
	 the salesorder entity 
	 *
	 *@Return List<SalesorderDTO>
	 */
	@Override
	public List<SalesorderDTO> getAllActiveSalesOrder() {
		List<SalesorderDTO> salesorderDTOs = new ArrayList<>();
		SalesorderDTO salesDTO = new SalesorderDTO();
		
		try {
			List<Salesorder> sales = salesorderDao.findByIsActive(1);
			for(Salesorder sale : sales) {
				salesDTO = salesOrderDTOEntityConversionService.prepareSalesorderDTO(sale, "none");
				salesorderDTOs.add(salesDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return salesorderDTOs;
	}

	
	/*
	 * @Param Integer salesorderId
	 * 
	 * This method is used to delete salesorder. This deletion is soft delete that means it only changes the is active status to 0.
	 * 
	 * @Return ResponseDetails
	 */
	@Override
	public ResponseDetails softDeleteSalesOrder(Integer salesorderId) {
		try {
			Salesorder order = salesorderDao.findById(salesorderId).get();
			order.setIsActive(0);
			salesorderDao.save(order);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "order placed successfully", "200");
		}


	@Override
	public ResponseDetails authoriseSalesorder(SalesorderDTO salesorderDTO) {
		// TODO Auto-generated method stub
				try {
					
					Salesorder sales = salesorderDao.findById(salesorderDTO.getSalesOrderId()).get();
					List<SalesorderDetails> salesorderDetails = 
							salesorderDetailsDao.findBySoidAndSoDetailsStaus(salesorderDTO.getSalesOrderId(), 0);
//					List<SalesorderDetailsDTO> salesDetailsDTO = salesorderDTO.getSalesorderDetails();
					
//					Integer entityList = salesorderDetails.size();
//					Integer dtoSize = salesDetailsDTO.size();
					
//					if(entityList == dtoSize) {
						sales.setStatus(GlobalDefine.quotAccept);
						sales.setRevalidate(salesorderDTO.getRevalidate());
//					}
					
//					if(entityList > dtoSize) {
//						sales.setStatus(GlobalDefine.quotPartlyAcept);
//					}
					
					salesorderDao.save(sales);
					
//					for(SalesorderDetailsDTO salesItem : salesorderDTO.getSalesorderDetails()) {
//						SalesorderDetails salesDetail = salesOrderDetailsEntityDTOConversionService.prepareSalesorderDetailsEntity(salesItem);
//						salesDetail.setStatus(GlobalDefine.quotAccept);
//						salesorderDetailsDao.save(salesDetail);
//					}
					
					for(SalesorderDetails salesItem : salesorderDetails) {
						salesItem.setStatus(GlobalDefine.quotAccept);
						salesorderDetailsDao.save(salesItem);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				return new ResponseDetails(new Date(), "sales order accepted successfully", "200");
			}
	}
	


