package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.AgentEnquiryQuotationSalesOrderMapping;

@Repository
public interface AgentEnquiryQuotationSalesOrderMappingRepository extends JpaRepository<AgentEnquiryQuotationSalesOrderMapping, Integer> {

	List<AgentEnquiryQuotationSalesOrderMapping> findByEnquiryCode(String enquiryCode);
	List<AgentEnquiryQuotationSalesOrderMapping> findByQuotationCode(String quotationCode);
	List<AgentEnquiryQuotationSalesOrderMapping> findBySalesOrderCode(String salesOrderCode);
	
	List<AgentEnquiryQuotationSalesOrderMapping> findByEnquiryCodeAndAgentId(String enquiryCode, Integer agentId);
	List<AgentEnquiryQuotationSalesOrderMapping> findByQuotationCodeAndAgentId(String quotationCode, Integer agentId);
	List<AgentEnquiryQuotationSalesOrderMapping> findBySalesOrderCodeAndAgentId(String salesOrderCode, Integer agentId);
	
	List<AgentEnquiryQuotationSalesOrderMapping> findByIsActive(Integer isActive);
	
}
