package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.MarketingDetailsDTO;
import com.aspl.org.entity.MarketingDetails;

public interface MarketingDetailsService {

	public MarketingDetails saveMarketingDetails(MarketingDetailsDTO marketingDetailsDTO);
	
	public List<MarketingDetailsDTO> getMarketingDetailsForQuotation(Integer quotationId);
	public List<MarketingDetailsDTO> getMarketingDetailsForSalesOrder(Integer salesOrderId);
	public MarketingDetailsDTO getMarketingDetailsByMarketingId(Integer marketingId);
	
}
