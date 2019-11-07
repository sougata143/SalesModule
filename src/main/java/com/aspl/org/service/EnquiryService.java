package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aspl.org.dto.EnquiryDTO;
import com.aspl.org.entity.ResponseDetails;


@Service
public interface EnquiryService {
	
	ResponseDetails enquirySave(EnquiryDTO enquiryDTO) throws Exception;
	ResponseDetails enquiryUpdate(EnquiryDTO enquiryDTO) throws Exception;
	
	List<EnquiryDTO> getAllEnquiry();
	EnquiryDTO findByEnquiryId(Integer enquiryId);
	
	ResponseDetails softDeleteEnquiry(Integer enquiryId);
	List<EnquiryDTO> getEnquiryByCustomer(Integer customer);

}
