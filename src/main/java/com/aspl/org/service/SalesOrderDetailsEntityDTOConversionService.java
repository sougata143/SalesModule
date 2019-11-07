package com.aspl.org.service;

import com.aspl.org.dto.SalesorderDetailsDTO;
import com.aspl.org.entity.SalesorderDetails;

public interface SalesOrderDetailsEntityDTOConversionService {

	SalesorderDetailsDTO prepareSalesorderDetailsDTO(SalesorderDetails salesorderDetails);
	SalesorderDetails prepareSalesorderDetailsEntity(SalesorderDetailsDTO salesorderDetailsDTO);
	
}
