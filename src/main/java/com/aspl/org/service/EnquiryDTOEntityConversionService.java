package com.aspl.org.service;

import com.aspl.org.dto.EnquiryDTO;
import com.aspl.org.entity.Enquiry;

public interface EnquiryDTOEntityConversionService {

	EnquiryDTO prepareEnquiryDTO(Enquiry enquiry);
	Enquiry prepareEnquiryEntity(EnquiryDTO enquiryDTO);
	
}
