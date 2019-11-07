package com.aspl.org.service;

import com.aspl.org.dto.SalesorderDTO;
import com.aspl.org.dto.WorkOrderDTO;
import com.aspl.org.entity.WorkOrder;

public interface WorkOrderEntityDTOConversionService {

	public WorkOrderDTO prepareWorkOrderDTO(WorkOrder workOrder);
	public WorkOrder prepareWorkOrderEntity(WorkOrderDTO workOrderDTO);
	public WorkOrderDTO prepareWorkOrderFromSalesOrder(SalesorderDTO salesorderDTO, Integer salesOrderId);
	
}
