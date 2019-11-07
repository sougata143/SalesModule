package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.WorkOrderDetailsDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.WorkOrderDetails;
import com.aspl.org.repository.WorkOrderDetailsRepository;
import com.aspl.org.service.ItemMasterService;
import com.aspl.org.service.WorkOrderDetailsEntityDTOConversionService;
import com.aspl.org.service.WorkOrderDetailsService;


@Service
@Transactional
public class WorkOrderDetailsServiceImpl implements WorkOrderDetailsService {

	@Autowired
	WorkOrderDetailsRepository workOrderRepository;
	
	@Autowired
	ItemMasterService itemService;
	
	@Autowired
	WorkOrderDetailsEntityDTOConversionService workOrderDetailsEntityDTOConversionService;

	@Override
	public List<WorkOrderDetailsDTO> getAllWorkOrder() {
		List<WorkOrderDetailsDTO> orderDetailsDTOs = new ArrayList<>();
		try {
			List<WorkOrderDetails> orderDetails = workOrderRepository.findAll();
			for(WorkOrderDetails details : orderDetails) {
				WorkOrderDetailsDTO orderDTO = workOrderDetailsEntityDTOConversionService.prepareWorkOrderDetailsDTO(details);
				orderDetailsDTOs.add(orderDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderDetailsDTOs;
	}

	@Override
	public WorkOrderDetailsDTO getWorkOrderById(Integer workOrderDetailsId) {
		// TODO Auto-generated method stub
		WorkOrderDetailsDTO orderDetailsDTOs = new WorkOrderDetailsDTO();
		try {
			WorkOrderDetails orderDetails = workOrderRepository.findById(workOrderDetailsId).get();
			orderDetailsDTOs = workOrderDetailsEntityDTOConversionService.prepareWorkOrderDetailsDTO(orderDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderDetailsDTOs;
	}

	@Override
	public ResponseDetails saveWorkOrder(WorkOrderDetailsDTO workOrderDTO) {
		// TODO Auto-generated method stub
		try {
			WorkOrderDetails orderDetails = workOrderDetailsEntityDTOConversionService.prepareWorkOrderDetailsEntity(workOrderDTO);
			workOrderRepository.save(orderDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "work order items saved successfully", "200");
	}

	@Override
	public ResponseDetails updateWorkOrder(WorkOrderDetailsDTO workOrderDTO) {
		// TODO Auto-generated method stub
		try {
			WorkOrderDetails orderDetails = workOrderDetailsEntityDTOConversionService.prepareWorkOrderDetailsEntity(workOrderDTO);
			workOrderRepository.save(orderDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "work order items saved successfully", "200");
	}

	@Override
	public ResponseDetails sofDeleteWorkOrder(Integer workOrderId) {
		// TODO Auto-generated method stub
		try {
			WorkOrderDetails orderDetails = workOrderRepository.findById(workOrderId).get();
			orderDetails.setStatus(0);
			workOrderRepository.save(orderDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "work order items saved successfully", "200");
	}
	
	@Override
	public List<WorkOrderDetailsDTO> getAllWorkOrderByWorkOrderId(Integer workOrder) {
		// TODO Auto-generated method stub
		List<WorkOrderDetailsDTO> workOrderDTOs = new ArrayList<>();
		try {
			List<WorkOrderDetails> workOrders = workOrderRepository.findByWorkOrderId(1);
			for(WorkOrderDetails wo : workOrders) {
				WorkOrderDetailsDTO orderDTO = new WorkOrderDetailsDTO();
				orderDTO = workOrderDetailsEntityDTOConversionService.prepareWorkOrderDetailsDTO(wo);
				workOrderDTOs.add(orderDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return workOrderDTOs;
	}

	@Override
	public List<WorkOrderDetailsDTO> getAllWorkOrderBySalesOrderDetails(Integer salesOrderDetailsId) {
		// TODO Auto-generated method stub
		List<WorkOrderDetailsDTO> orderDetailsDTOs = new ArrayList<>();
		try {
			List<WorkOrderDetails> orderDetails = workOrderRepository.findAll();
			for(WorkOrderDetails details : orderDetails) {
				WorkOrderDetailsDTO orderDTO = workOrderDetailsEntityDTOConversionService.prepareWorkOrderDetailsDTO(details);
				orderDetailsDTOs.add(orderDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderDetailsDTOs;
	}

	

}
