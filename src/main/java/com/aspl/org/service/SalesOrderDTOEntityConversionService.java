package com.aspl.org.service;

import com.aspl.org.dto.SalesorderDTO;
import com.aspl.org.dto.WorkOrderDTO;
import com.aspl.org.entity.Salesorder;

public interface SalesOrderDTOEntityConversionService {

	Salesorder prepareSalesorderEntity(SalesorderDTO salesorderDTO);
	SalesorderDTO prepareSalesorderDTO(Salesorder salesorder, String authorization);
	
}
