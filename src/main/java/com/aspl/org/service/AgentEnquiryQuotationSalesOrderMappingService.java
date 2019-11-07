package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.AgentEnquiryQuotationSalesOrderMappingDTO;
import com.aspl.org.entity.AgentEnquiryQuotationSalesOrderMapping;

public interface AgentEnquiryQuotationSalesOrderMappingService {

	List<AgentEnquiryQuotationSalesOrderMappingDTO> getAllMapping();
	List<AgentEnquiryQuotationSalesOrderMappingDTO> getMappingByCodeAndType(String code, String type);
	AgentEnquiryQuotationSalesOrderMappingDTO getMappingByCodeAndTypeAndAgentId(String code, String type, Integer agentId);
	AgentEnquiryQuotationSalesOrderMappingDTO getMappingByMappingId(Integer mappingId);
//	List<AgentEnquiryQuotationSalesOrderMappingDTO> getMappingQuotationId(String quotationCode);
//	List<AgentEnquiryQuotationSalesOrderMappingDTO> getMappingSalesOrderId(String salesOrderCode);
	
	AgentEnquiryQuotationSalesOrderMapping saveAgentEnquiryQuotationSalesOrderMapping(
			AgentEnquiryQuotationSalesOrderMappingDTO agentEnquiryQuotationSalesOrderMapping);
	
	AgentEnquiryQuotationSalesOrderMapping updateAgentEnquiryQuotationSalesOrderMapping(
			AgentEnquiryQuotationSalesOrderMappingDTO agentEnquiryQuotationSalesOrderMapping);
	
	AgentEnquiryQuotationSalesOrderMappingDTO prepareAgentEnquiryQuotationSalesOrderMappingDTO(
			AgentEnquiryQuotationSalesOrderMapping agentEnquiryQuotationSalesOrderMapping);
	
	AgentEnquiryQuotationSalesOrderMapping prepareAgentEnquiryQuotationSalesOrderMappingEntity(
			AgentEnquiryQuotationSalesOrderMappingDTO AgentEnquiryQuotationSalesOrderMapping);
	
	
}
