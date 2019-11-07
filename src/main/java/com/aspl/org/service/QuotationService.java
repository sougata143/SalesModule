package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.QuotationDTO;
import com.aspl.org.dto.QuotationReportDTO;
import com.aspl.org.entity.Quotation;
import com.aspl.org.entity.ResponseDetails;

public interface QuotationService {

	public List<QuotationDTO> getAllQuotation();
	public QuotationDTO getQuotationById(Integer quotId);
	public List<QuotationDTO> getAllUnAuthorisedQuotation();
//	public List<QuotationDTO> getAllAuthorisedQuotation();
	public List<QuotationDTO> getAllAuthorisedQuotation(String weight, String gst);
//	public List<QuotationDTO> getAllAuthorisedQuotationWithWeight();
//	public List<QuotationDTO> getAllAuthorisedQuotationWithoutWeight();
	
	public ResponseDetails saveQuotation(QuotationDTO quotationDTO);
	public ResponseDetails updateQuotation(QuotationDTO quotationDTO);
	public ResponseDetails softDeleteQuotation(Integer quotId);
	public ResponseDetails authoriseQuotation(QuotationDTO quotationDTO);
	public ResponseDetails unAuthoriseQuotation(QuotationDTO quotationDTO);
	
//	public QuotationDTO prepareQuotationDTO(Quotation quotation, String authorisationStatus);
//	public Quotation prepeareQuotationEntity(QuotationDTO quotationDTO);
	
//	List<QuotationDTO> getAllAuthorisedQuotationWithWeightAndWithOutGst();
//	List<QuotationDTO> getAllAuthorisedQuotationWithWeightAndGst();
	public List<QuotationDTO> getAllQuotationByCustomer(Integer customerId);
	
	
}
