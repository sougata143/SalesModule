package com.aspl.org.service;

import com.aspl.org.dto.QuotationDTO;
import com.aspl.org.entity.Quotation;

public interface QuotationDTOEntityConversionService {

	public QuotationDTO prepareQuotationDTO(Quotation quotation, String authorisationStatus);
	public Quotation prepeareQuotationEntity(QuotationDTO quotationDTO);
	
}
