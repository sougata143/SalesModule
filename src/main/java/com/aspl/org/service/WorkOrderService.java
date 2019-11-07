package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.WorkOrderDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.WorkOrder;

public interface WorkOrderService {

	public List<WorkOrderDTO> getAllWorkOrder();
	public WorkOrderDTO getWorkOrderById(Integer workOrderId);
	public List<WorkOrderDTO> getAllAuthorisedWorkOrder();
	public List<WorkOrderDTO> getAllUnAuthorisedWorkOrder();
	public List<WorkOrderDTO> getAllWorkOrderBySaleOrder(Integer salesOrderId);
	
	public WorkOrder saveWorkOrder(WorkOrderDTO workOrderDTO);
	public ResponseDetails updateWorkOrder(WorkOrderDTO workOrderDTO);
	public ResponseDetails sofDeleteWorkOrder(Integer workOrderId);
	
	public ResponseDetails authoriseWorkOrder(WorkOrderDTO workOrderDTO);
	public ResponseDetails unAuthoriseWorkOrder(WorkOrderDTO workOrderDTO);
	
//	public WorkOrderDTO prepareWorkOrderDTO(WorkOrder workOrder);
//	WorkOrder prepareWorkOrderEntity(WorkOrderDTO workOrderDTO);
	
}
