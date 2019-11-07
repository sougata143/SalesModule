package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.WorkOrderDTO;
import com.aspl.org.dto.WorkOrderDetailsDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.entity.WorkOrder;
import com.aspl.org.entity.WorkOrderDetails;
import com.aspl.org.repository.DeliveryTermsMasterDao;
import com.aspl.org.repository.JurisdictionMasterDao;
import com.aspl.org.repository.PaymentMethodMasterDao;
import com.aspl.org.repository.PaymentTermsMasterDao;
import com.aspl.org.repository.ReminderTermsMasterDao;
import com.aspl.org.repository.ShippingMethodMasterDao;
import com.aspl.org.repository.WorkOrderDetailsRepository;
import com.aspl.org.repository.WorkOrderRepository;
import com.aspl.org.service.CustomerMasterService;
import com.aspl.org.service.VendormasterService;
import com.aspl.org.service.WorkOrderDetailsEntityDTOConversionService;
import com.aspl.org.service.WorkOrderDetailsService;
import com.aspl.org.service.WorkOrderEntityDTOConversionService;
import com.aspl.org.service.WorkOrderService;
import com.aspl.org.utils.GlobalDefine;


/*
 * Service class for creating work order CRUD operations and logical operations.
 */
@Service
@Transactional
public class WorkOrderServiceImpl implements WorkOrderService {

	@Autowired
	WorkOrderRepository workOrderRepo;
	
	@Autowired
	JurisdictionMasterDao juridictionDao;
	
	@Autowired
	PaymentMethodMasterDao paymentMethodDao;
	
	@Autowired
	PaymentTermsMasterDao paymentTermsDao;
	
	@Autowired
	ReminderTermsMasterDao reminderMasterDao;
	
	@Autowired
	ShippingMethodMasterDao shippingDao;
	
	@Autowired
	DeliveryTermsMasterDao deliveryMasterDao;
	
	@Autowired
	VendormasterService vendorService;
	
	@Autowired
	WorkOrderDetailsService workOrderDetailsService;
	
	@Autowired
	WorkOrderDetailsRepository workOrderDetailsRepo;
	
	@Autowired
	CustomerMasterService customerService;
	
	@Autowired
	WorkOrderEntityDTOConversionService workOrderEntityDTOConversionService;
	
	@Autowired
	WorkOrderDetailsEntityDTOConversionService workOrderDetailsEntityDTOConversionService;
	
	
	/*
	 * This method is used to fetch active work orders. It'll call
	 */
	@Override
	public List<WorkOrderDTO> getAllWorkOrder() {
		// TODO Auto-generated method stub
		List<WorkOrderDTO> workOrderDTOs = new ArrayList<>();
		try {
			List<WorkOrder> workOrders = workOrderRepo.findByIsActive(1);
			for(WorkOrder wo : workOrders) {
				WorkOrderDTO orderDTO = new WorkOrderDTO();
				orderDTO = workOrderEntityDTOConversionService.prepareWorkOrderDTO(wo);
				workOrderDTOs.add(orderDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return workOrderDTOs;
	}

	@Override
	public WorkOrderDTO getWorkOrderById(Integer workOrderId) {
		// TODO Auto-generated method stub
		WorkOrderDTO orderDTO = new WorkOrderDTO();
		try {
			WorkOrder wo = workOrderRepo.findById(workOrderId).get();
			orderDTO = workOrderEntityDTOConversionService.prepareWorkOrderDTO(wo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderDTO;
	}

	@Override
	public WorkOrder saveWorkOrder(WorkOrderDTO workOrderDTO) {
		// TODO Auto-generated method stub
		WorkOrder orderEntity = new WorkOrder();
		try {
			WorkOrder order = workOrderEntityDTOConversionService.prepareWorkOrderEntity(workOrderDTO);
			order.setStatus(0);
			orderEntity = workOrderRepo.save(order);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderEntity;
	}

	@Override
	public ResponseDetails updateWorkOrder(WorkOrderDTO workOrderDTO) {
		// TODO Auto-generated method stub
		try {
			WorkOrder order = workOrderEntityDTOConversionService.prepareWorkOrderEntity(workOrderDTO);
			workOrderRepo.save(order);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "order updated successfully", "200");
	}

	@Override
	public ResponseDetails sofDeleteWorkOrder(Integer workOrderId) {
		// TODO Auto-generated method stub
		try {
			WorkOrder order = workOrderRepo.findById(workOrderId).get();
			order.setStatus(0);
			workOrderRepo.save(order);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "order placed successfully", "200");
	}
	
	

	@Override
	public List<WorkOrderDTO> getAllAuthorisedWorkOrder() {
		// TODO Auto-generated method stub
		List<WorkOrderDTO> workOrderDTOs = new ArrayList<>();
		try {
			List<WorkOrder> workOrders = workOrderRepo.findByIsActiveAndStatus(1, 2);
			for(WorkOrder wo : workOrders) {
				WorkOrderDTO orderDTO = new WorkOrderDTO();
				orderDTO = workOrderEntityDTOConversionService.prepareWorkOrderDTO(wo);
				workOrderDTOs.add(orderDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return workOrderDTOs;
	}

	@Override
	public List<WorkOrderDTO> getAllUnAuthorisedWorkOrder() {
		// TODO Auto-generated method stub
		List<WorkOrderDTO> workOrderDTOs = new ArrayList<>();
		try {
			List<WorkOrder> workOrders = workOrderRepo.findByIsActiveAndStatusOrStatus(1, 0, 1);
			for(WorkOrder wo : workOrders) {
				WorkOrderDTO orderDTO = new WorkOrderDTO();
				orderDTO = workOrderEntityDTOConversionService.prepareWorkOrderDTO(wo);
				workOrderDTOs.add(orderDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return workOrderDTOs;
	}

	@Override
	public ResponseDetails authoriseWorkOrder(WorkOrderDTO workOrderDTO) {
		// TODO Auto-generated method stub
		try {
			WorkOrder order = new WorkOrder();
			if(workOrderDTO!=null) {
				order = workOrderRepo.findById(workOrderDTO.getWorkOrderId()).get();
			}
			
			List<WorkOrderDetailsDTO> orderDetails = workOrderDetailsService.getAllWorkOrderByWorkOrderId(workOrderDTO.getWorkOrderId());
			List<WorkOrderDetailsDTO> orderDetailsForDTO = workOrderDTO.getWorkOrderDetailsDTO();
			
			Integer entitySize = orderDetails.size();
			Integer dtoSize = orderDetailsForDTO.size();
			
			if(entitySize == dtoSize) {
				order.setStatus(GlobalDefine.woAccept);
			}
			
			if(entitySize > dtoSize) {
				order.setStatus(GlobalDefine.woPartlyAcept);
			}
			
			for(WorkOrderDetailsDTO woDetails : orderDetailsForDTO) {
				
				WorkOrderDetails workOrderDetailsEntity = workOrderDetailsEntityDTOConversionService.prepareWorkOrderDetailsEntity(woDetails);
				workOrderDetailsEntity.setStatus(GlobalDefine.woAccept);
				
				workOrderDetailsRepo.save(workOrderDetailsEntity);
			}
			
			workOrderRepo.save(order);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "order authorised successfully", "200");
	}

	@Override
	public ResponseDetails unAuthoriseWorkOrder(WorkOrderDTO workOrderDTO) {
		// TODO Auto-generated method stub
		try {
			WorkOrder order = new WorkOrder();
			if(workOrderDTO!=null) {
				order = workOrderRepo.findById(workOrderDTO.getWorkOrderId()).get();
			}
			
			List<WorkOrderDetailsDTO> orderDetails = workOrderDetailsService.getAllWorkOrderByWorkOrderId(workOrderDTO.getWorkOrderId());
			List<WorkOrderDetailsDTO> orderDetailsForDTO = workOrderDTO.getWorkOrderDetailsDTO();
			
			Integer entitySize = orderDetails.size();
			Integer dtoSize = orderDetailsForDTO.size();
			
			if(entitySize == dtoSize) {
				order.setStatus(GlobalDefine.woReject);
			}
			
			if(entitySize > dtoSize) {
				order.setStatus(GlobalDefine.woPartlyAcept);
			}
			
			for(WorkOrderDetailsDTO woDetails : orderDetailsForDTO) {
				
				WorkOrderDetails workOrderDetailsEntity = workOrderDetailsEntityDTOConversionService.prepareWorkOrderDetailsEntity(woDetails);
				workOrderDetailsEntity.setStatus(GlobalDefine.woReject);
				
				workOrderDetailsRepo.save(workOrderDetailsEntity);
			}
			
			workOrderRepo.save(order);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "order unauthorised successfully", "200");
	}

	@Override
	public List<WorkOrderDTO> getAllWorkOrderBySaleOrder(Integer salesOrderId) {
		// TODO Auto-generated method stub
		List<WorkOrderDTO> workOrderDTOs = new ArrayList<>();
		try {
			List<WorkOrder> workOrders = workOrderRepo.findBySalesOrderId(salesOrderId);
			for(WorkOrder wo : workOrders) {
				WorkOrderDTO orderDTO = new WorkOrderDTO();
				orderDTO = workOrderEntityDTOConversionService.prepareWorkOrderDTO(wo);
				workOrderDTOs.add(orderDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return workOrderDTOs;
	}

}
