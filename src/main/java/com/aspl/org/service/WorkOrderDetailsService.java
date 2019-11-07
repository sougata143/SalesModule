package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.WorkOrderDetailsDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.WorkOrderDetails;

public interface WorkOrderDetailsService {

	public List<WorkOrderDetailsDTO> getAllWorkOrderByWorkOrderId(Integer workOrder);
	public List<WorkOrderDetailsDTO> getAllWorkOrderBySalesOrderDetails(Integer salesOrderDetailsId);
	public List<WorkOrderDetailsDTO> getAllWorkOrder();
	public WorkOrderDetailsDTO getWorkOrderById(Integer workOrderId);
	public ResponseDetails saveWorkOrder(WorkOrderDetailsDTO workOrderDTO);
	public ResponseDetails updateWorkOrder(WorkOrderDetailsDTO workOrderDTO);
	public ResponseDetails sofDeleteWorkOrder(Integer workOrderId);
	
//	public WorkOrderDetailsDTO prepareWorkOrderDetailsDTO(WorkOrderDetails workOrder);
//	WorkOrderDetails prepareWorkOrderDetailsEntity(WorkOrderDetailsDTO workOrderDTO);
	
}
