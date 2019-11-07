package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.QuotationEnquiryMappingDTO;
import com.aspl.org.entity.QuotationEnquiryMapping;
import com.aspl.org.repository.QuotationEnquiryMappingRepository;
import com.aspl.org.service.QuotationEnquiryMappingService;


@Service
@Transactional
public class QuotationEnquiryMappingServiceImpl implements QuotationEnquiryMappingService {

	@Autowired
	QuotationEnquiryMappingRepository mappingRepo;
	
	@Override
	public List<QuotationEnquiryMappingDTO> getAllActiveQuotationEnquiryMapping() {
		// TODO Auto-generated method stub
		List<QuotationEnquiryMappingDTO> mappingDTOs = new ArrayList<>();
		try {
			List<QuotationEnquiryMapping> mappings = mappingRepo.findByIsActive(1);
			for(QuotationEnquiryMapping mapping : mappings) {
				QuotationEnquiryMappingDTO dto = new QuotationEnquiryMappingDTO();
				dto.setEnquiryId(mapping.getEnquiryId());
				dto.setIsActive(mapping.getIsActive());
				dto.setQuotationId(mapping.getQuotationId());
				dto.setQuotEnqMappingId(mapping.getQuotEnqMappingId());
				dto.setSalesOrderId(mapping.getSalesOrderId());
				mappingDTOs.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mappingDTOs;
	}

	@Override
	public List<QuotationEnquiryMappingDTO> getQuotationEnquiryMappingByEnquiry(Integer enquiryId) {
		// TODO Auto-generated method stub
		List<QuotationEnquiryMappingDTO> mappingDTOs = new ArrayList<>();
		try {
			List<QuotationEnquiryMapping> mappings = mappingRepo.findByEnquiryId(enquiryId);
			for(QuotationEnquiryMapping mapping : mappings) {
				QuotationEnquiryMappingDTO dto = new QuotationEnquiryMappingDTO();
				dto.setEnquiryId(mapping.getEnquiryId());
				dto.setIsActive(mapping.getIsActive());
				dto.setQuotationId(mapping.getQuotationId());
				dto.setQuotEnqMappingId(mapping.getQuotEnqMappingId());
				dto.setSalesOrderId(mapping.getSalesOrderId());
				mappingDTOs.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mappingDTOs;
	}

	@Override
	public List<QuotationEnquiryMappingDTO> getQuotationEnquiryMappingByQuotationId(Integer quotationId) {
		// TODO Auto-generated method stub
		List<QuotationEnquiryMappingDTO> mappingDTOs = new ArrayList<>();
		try {
			List<QuotationEnquiryMapping> mappings = mappingRepo.findByQuotationId(quotationId);
			for(QuotationEnquiryMapping mapping : mappings) {
				QuotationEnquiryMappingDTO dto = new QuotationEnquiryMappingDTO();
				dto.setEnquiryId(mapping.getEnquiryId());
				dto.setIsActive(mapping.getIsActive());
				dto.setQuotationId(mapping.getQuotationId());
				dto.setQuotEnqMappingId(mapping.getQuotEnqMappingId());
				dto.setSalesOrderId(mapping.getSalesOrderId());
				mappingDTOs.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mappingDTOs;
	}

	@Override
	public List<QuotationEnquiryMappingDTO> getQuotationEnquiryMappingBySalesOrderId(Integer salesOrderId) {
		// TODO Auto-generated method stub
		List<QuotationEnquiryMappingDTO> mappingDTOs = new ArrayList<>();
		try {
			List<QuotationEnquiryMapping> mappings = mappingRepo.findBySalesOrderId(salesOrderId);
			for(QuotationEnquiryMapping mapping : mappings) {
				QuotationEnquiryMappingDTO dto = new QuotationEnquiryMappingDTO();
				dto.setEnquiryId(mapping.getEnquiryId());
				dto.setIsActive(mapping.getIsActive());
				dto.setQuotationId(mapping.getQuotationId());
				dto.setQuotEnqMappingId(mapping.getQuotEnqMappingId());
				dto.setSalesOrderId(mapping.getSalesOrderId());
				mappingDTOs.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mappingDTOs;
	}

	@Override
	public QuotationEnquiryMapping saveQuotationEnquiryMapping(QuotationEnquiryMappingDTO quotationEnquiryMappingDTO) {
		// TODO Auto-generated method stub
		QuotationEnquiryMapping mapping = new QuotationEnquiryMapping();
		try {
			mapping.setEnquiryId(quotationEnquiryMappingDTO.getEnquiryId());
			mapping.setIsActive(quotationEnquiryMappingDTO.getIsActive());
			mapping.setQuotationId(quotationEnquiryMappingDTO.getQuotationId());
			mapping.setQuotEnqMappingId(quotationEnquiryMappingDTO.getQuotEnqMappingId());
			mapping.setSalesOrderId(quotationEnquiryMappingDTO.getSalesOrderId());
			mappingRepo.save(mapping);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mapping;
	}

	@Override
	public QuotationEnquiryMapping sofDeleteQuotationEnquiryMapping(Integer enqQuotMappingId) {
		// TODO Auto-generated method stub
		QuotationEnquiryMapping mapping = new QuotationEnquiryMapping();
		try {
			mapping = mappingRepo.findById(enqQuotMappingId).get();
			mapping.setIsActive(0);
			mappingRepo.save(mapping);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mapping;
	}

	@Override
	public QuotationEnquiryMappingDTO getQuotationEnquiryMappingByMappingId(Integer mappingId) {
		// TODO Auto-generated method stub
		QuotationEnquiryMappingDTO dto = new QuotationEnquiryMappingDTO();
		try {
			QuotationEnquiryMapping mapping = mappingRepo.findById(mappingId).get();
			dto.setEnquiryId(mapping.getEnquiryId());
			dto.setIsActive(mapping.getIsActive());
			dto.setQuotationId(mapping.getQuotationId());
			dto.setQuotEnqMappingId(mapping.getQuotEnqMappingId());
			dto.setSalesOrderId(mapping.getSalesOrderId());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<QuotationEnquiryMappingDTO> getQuotationEnquiryMappingByQuotationIdAndEnquiryId(Integer quotationId,
			Integer enquiryId) {
		// TODO Auto-generated method stub
		List<QuotationEnquiryMappingDTO> dtos = new ArrayList<>();
		try {
			List<QuotationEnquiryMapping> mappings = mappingRepo.findByQuotationIdAndEnquiryId(quotationId, enquiryId);
			for(QuotationEnquiryMapping mapping : mappings) {
				QuotationEnquiryMappingDTO dto = new QuotationEnquiryMappingDTO();
				
				dto.setEnquiryId(mapping.getEnquiryId());
				dto.setIsActive(mapping.getIsActive());
				dto.setQuotationId(mapping.getQuotationId());
				dto.setQuotEnqMappingId(mapping.getQuotEnqMappingId());
				dto.setSalesOrderId(mapping.getSalesOrderId());
				
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public List<QuotationEnquiryMappingDTO> getQuotationEnquiryMappingBySalesOrderIdAndQuotationId(Integer salesOrderId,
			Integer quotationId) {
		// TODO Auto-generated method stub
		List<QuotationEnquiryMappingDTO> dtos = new ArrayList<>();
		try {
			List<QuotationEnquiryMapping> mappings = mappingRepo.findByQuotationIdAndEnquiryId(salesOrderId, quotationId);
			for(QuotationEnquiryMapping mapping : mappings) {
				QuotationEnquiryMappingDTO dto = new QuotationEnquiryMappingDTO();
				
				dto.setEnquiryId(mapping.getEnquiryId());
				dto.setIsActive(mapping.getIsActive());
				dto.setQuotationId(mapping.getQuotationId());
				dto.setQuotEnqMappingId(mapping.getQuotEnqMappingId());
				dto.setSalesOrderId(mapping.getSalesOrderId());
				
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

}
