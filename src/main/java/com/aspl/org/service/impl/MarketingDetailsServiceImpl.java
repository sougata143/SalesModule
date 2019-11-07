package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.MarketingDetailsDTO;
import com.aspl.org.entity.MarketingDetails;
import com.aspl.org.repository.MarketingDetailsRepository;
import com.aspl.org.service.MarketingDetailsService;


@Service
@Transactional
public class MarketingDetailsServiceImpl implements MarketingDetailsService {

	@Autowired
	MarketingDetailsRepository marketingRepo;
	
	@Override
	public MarketingDetails saveMarketingDetails(MarketingDetailsDTO marketingDetailsDTO) {
		
		MarketingDetails marketing = new MarketingDetails();
		MarketingDetails marketingEntity = new MarketingDetails();
		try {
			
			if(marketingDetailsDTO.getMarketingId()!=null && marketingDetailsDTO.getMarketingId()!=0) {
				marketing = marketingRepo.findById(marketingDetailsDTO.getMarketingId()).get();
			}
			
			marketing.setDescription(marketingDetailsDTO.getDescription());
			
			if(marketingDetailsDTO.getQuotationId()!=null)
				marketing.setQuotationId(marketingDetailsDTO.getQuotationId());
			else
				marketing.setQuotationId(0);
			
			if(marketingDetailsDTO.getSalesOrderId()!=null)
				marketing.setSalesOrderId(marketingDetailsDTO.getSalesOrderId());
			else
				marketing.setSalesOrderId(0);
			
			marketing.setTerms(marketingDetailsDTO.getTerms());
			
			marketingEntity = marketingRepo.save(marketing);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return marketingEntity;
	}

	@Override
	public List<MarketingDetailsDTO> getMarketingDetailsForQuotation(Integer quotationId) {
		
		List<MarketingDetailsDTO> marketingDTOs = new ArrayList<>();
		try {
			List<MarketingDetails> marketingDetailsEntity = marketingRepo.findByQuotationId(quotationId);
			for(MarketingDetails market : marketingDetailsEntity) {
				MarketingDetailsDTO marketingDTO = new MarketingDetailsDTO();
				
				marketingDTO.setDescription(market.getDescription());
				marketingDTO.setMarketingId(market.getMarketingId());
				marketingDTO.setQuotationId(market.getQuotationId());
				marketingDTO.setSalesOrderId(market.getSalesOrderId());
				marketingDTO.setTerms(market.getTerms());
				
				marketingDTOs.add(marketingDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return marketingDTOs;
	}

	@Override
	public List<MarketingDetailsDTO> getMarketingDetailsForSalesOrder(Integer salesOrderId) {
	
		List<MarketingDetailsDTO> marketingDTOs = new ArrayList<>();
		try {
			List<MarketingDetails> marketingDetailsEntity = marketingRepo.findBySalesOrderId(salesOrderId);
			for(MarketingDetails market : marketingDetailsEntity) {
				MarketingDetailsDTO marketingDTO = new MarketingDetailsDTO();
				
				marketingDTO.setDescription(market.getDescription());
				marketingDTO.setMarketingId(market.getMarketingId());
				marketingDTO.setQuotationId(market.getQuotationId());
				marketingDTO.setSalesOrderId(market.getSalesOrderId());
				marketingDTO.setTerms(market.getTerms());
				
				marketingDTOs.add(marketingDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return marketingDTOs;
	}

	@Override
	public MarketingDetailsDTO getMarketingDetailsByMarketingId(Integer marketingId) {
		
		MarketingDetailsDTO marketingDTO = new MarketingDetailsDTO();
		try {
			MarketingDetails market = marketingRepo.findById(marketingId).get();
			
			marketingDTO.setDescription(market.getDescription());
			marketingDTO.setMarketingId(market.getMarketingId());
			marketingDTO.setQuotationId(market.getQuotationId());
			marketingDTO.setSalesOrderId(market.getSalesOrderId());
			marketingDTO.setTerms(market.getTerms());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return marketingDTO;
	}

}
