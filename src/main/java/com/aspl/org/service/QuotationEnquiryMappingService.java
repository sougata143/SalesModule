package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.QuotationEnquiryMappingDTO;
import com.aspl.org.entity.QuotationEnquiryMapping;

public interface QuotationEnquiryMappingService {

	public List<QuotationEnquiryMappingDTO> getAllActiveQuotationEnquiryMapping();
	
	public List<QuotationEnquiryMappingDTO> getQuotationEnquiryMappingByEnquiry(Integer enquiryId);
	public List<QuotationEnquiryMappingDTO> getQuotationEnquiryMappingByQuotationId(Integer quotationId);
	public List<QuotationEnquiryMappingDTO> getQuotationEnquiryMappingBySalesOrderId(Integer salesOrderId);
	
	public List<QuotationEnquiryMappingDTO> getQuotationEnquiryMappingByQuotationIdAndEnquiryId(Integer quotationId, Integer enquiryId);
	public List<QuotationEnquiryMappingDTO> getQuotationEnquiryMappingBySalesOrderIdAndQuotationId(Integer salesOrderId, Integer quotationId);
	
	public QuotationEnquiryMappingDTO getQuotationEnquiryMappingByMappingId(Integer mappingId);
	
	public QuotationEnquiryMapping saveQuotationEnquiryMapping(QuotationEnquiryMappingDTO quotationEnquiryMappingDTO);
	public QuotationEnquiryMapping sofDeleteQuotationEnquiryMapping(Integer enqQuotMappingId);
	
}
