package com.aspl.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.dto.WorkOrderDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.WorkOrder;
import com.aspl.org.service.WorkOrderService;

@RestController
@RequestMapping(path = "/workOrder")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WorkOrderController {

	@Autowired
	WorkOrderService workOrderService;
	
	@GetMapping("getAllWorkOrder")
	public List<WorkOrderDTO> getAllWorkOrder() {
		return workOrderService.getAllWorkOrder();
	}
	
	@GetMapping("getWorkOrderById/{workOrderId}")
	public WorkOrderDTO getAllWorkOrderByWorkOrderId(@PathVariable("workOrderId") String workOrderId) {
		return workOrderService.getWorkOrderById(Integer.valueOf(workOrderId));
	}
	
	@GetMapping("getAllUnathorisedWorkOrder")
	public List<WorkOrderDTO> getAllUnathorisedWorkOrder() {
		return workOrderService.getAllUnAuthorisedWorkOrder();
	}
	
	@GetMapping("getAllAthorisedWorkOrder")
	public List<WorkOrderDTO> getAthorisedWorkOrder() {
		return workOrderService.getAllAuthorisedWorkOrder();
	}
	
	@PostMapping("saveWorkOrder")
	public WorkOrder saveWorkOrder(@RequestBody WorkOrderDTO workOrderDTO) {
		return workOrderService.saveWorkOrder(workOrderDTO);
	}
	
	@PutMapping("updateWorkOrder")
	public ResponseDetails updateWorkOrder(@RequestBody WorkOrderDTO workOrderDTO) {
		return workOrderService.updateWorkOrder(workOrderDTO);
	}
	
	@PutMapping("authoriseWorkOrder")
	public ResponseDetails authoriseWorkOrder(@RequestBody WorkOrderDTO workOrderDTO) {
		return workOrderService.authoriseWorkOrder(workOrderDTO);
	}
	
	@PutMapping("unAuthoriseWorkOrder")
	public ResponseDetails unauthoriseWorkOrder(@RequestBody WorkOrderDTO workOrderDTO) {
		return workOrderService.unAuthoriseWorkOrder(workOrderDTO);
	}
	
}
