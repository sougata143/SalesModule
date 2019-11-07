package com.aspl.org.service;

import com.aspl.org.dto.SalesorderDetailsDTO;
import com.aspl.org.dto.WorkOrderDetailsDTO;
import com.aspl.org.entity.WorkOrderDetails;

public interface WorkOrderDetailsEntityDTOConversionService {

	public WorkOrderDetailsDTO prepareWorkOrderDetailsDTO(WorkOrderDetails workOrder);
	public WorkOrderDetails prepareWorkOrderDetailsEntity(WorkOrderDetailsDTO workOrderDTO);
	public WorkOrderDetailsDTO prepareWorkOrderDetailsFromSalesOrderDetails(SalesorderDetailsDTO soDetailsDTO, Integer workOrderId, Integer salesOrderDetailsId);
	
}
