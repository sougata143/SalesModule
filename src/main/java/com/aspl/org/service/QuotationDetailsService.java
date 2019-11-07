package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.QuotationDetailsDTO;
import com.aspl.org.entity.QuotationDetails;
import com.aspl.org.entity.ResponseDetails;

public interface QuotationDetailsService {

	public List<QuotationDetailsDTO> getAllQuotationDetails();
	public QuotationDetailsDTO getQuotationDetailsById(Integer id);
	public QuotationDetails saveQuotationDetails(QuotationDetailsDTO quotationDetailsDTO);
	public QuotationDetails updateQuotationDetails(QuotationDetailsDTO uotationDetailsDTO);
	public ResponseDetails softDelete(Integer id);
	public List<QuotationDetailsDTO> getAllQuotationDetailsByQuotationId(Integer quoId);
	public List<QuotationDetailsDTO> getAllQuotationDetailsByQuotationIdAndStatus(Integer quoId, Integer status);
	public QuotationDetailsDTO prepareQuotationDetailsDTO(QuotationDetails quotationDetails);
	public QuotationDetails prepareQuotationDetailsEntity(QuotationDetailsDTO quotationDetailsDTO);
	
}
