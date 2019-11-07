package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aspl.org.dto.EnquiryDetailsDTO;
import com.aspl.org.entity.EnquiryDetails;
import com.aspl.org.entity.ResponseDetails;
@Service
public interface EnquiryDetailsService {
	
	public List<EnquiryDetailsDTO> getAllEnquiryDetails();
	public EnquiryDetailsDTO getEnquiryDetailsById(Integer id);
	public EnquiryDetails saveEnquiryDetails(EnquiryDetailsDTO enquiryDetailsDTO);
	public EnquiryDetails updateEnquiryDetails(EnquiryDetailsDTO enquiryDetailsDTO);
	public ResponseDetails softDelete(Integer id);
	public List<EnquiryDetailsDTO> getAllEnquiryDetailsByEnquiryId(Integer enquiryId);
	public List<EnquiryDetailsDTO> getAllEnquiryDetailsByEnquiryIdAndStatus(Integer enquiryId, Integer status);
	public EnquiryDetailsDTO prepareEnquiryDetailsDTO(EnquiryDetails enquiryDetails);
	public EnquiryDetails prepareEnquiryDetailsEntity(EnquiryDetailsDTO enquiryDetailsDTO);

}
