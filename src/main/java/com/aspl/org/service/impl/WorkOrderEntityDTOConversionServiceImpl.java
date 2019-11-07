package com.aspl.org.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.CustomerForSalesDTO;
import com.aspl.org.dto.CustomerMasterDTO;
import com.aspl.org.dto.DeliveryTermsForSalesDTO;
import com.aspl.org.dto.JurisdictionForSalesDTO;
import com.aspl.org.dto.PaymentMethodForSalesDTO;
import com.aspl.org.dto.PaymentTermsForSalesDTO;
import com.aspl.org.dto.SalesorderDTO;
import com.aspl.org.dto.ShippingMethodForSalesDTO;
import com.aspl.org.dto.WorkOrderDTO;
import com.aspl.org.dto.WorkOrderDetailsDTO;
import com.aspl.org.entity.DeliveryTermsMasterforVendor;
import com.aspl.org.entity.JurisdictionMasterForVendor;
import com.aspl.org.entity.PaymentMethodMasterforVendor;
import com.aspl.org.entity.PaymentTermsMasterforVendor;
import com.aspl.org.entity.ShippingMethodMasterforVendor;
import com.aspl.org.entity.WorkOrder;
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
import com.aspl.org.service.WorkOrderDetailsService;
import com.aspl.org.service.WorkOrderEntityDTOConversionService;


@Service
@Transactional
public class WorkOrderEntityDTOConversionServiceImpl implements WorkOrderEntityDTOConversionService {

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
	
	@Override
	public WorkOrderDTO prepareWorkOrderDTO(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		WorkOrderDTO workOrderDTO = new WorkOrderDTO();
		
		workOrderDTO.setCustPo(workOrder.getCustPo());
		workOrderDTO.setCustPoDate(workOrder.getCustPoDate());
		workOrderDTO.setDeliveryDate(workOrder.getDeliveryDate());
		
		if(workOrder.getDivision()!=null) {
			workOrderDTO.setDivision(workOrder.getDivision());
		}
		
		workOrderDTO.setOrderType(workOrder.getOrderType());
		workOrderDTO.setPackingType(workOrder.getPackingType());
		
		if(workOrder.getRegion()!=null) {
			workOrderDTO.setRegion(workOrder.getRegion());
		}
		
		workOrderDTO.setValidityDate(workOrder.getValidityDate());
		
		if(workOrder.getCustomerId()!=null) {
			CustomerMasterDTO customer = customerService.getCustomerMasterById(workOrder.getCustomerId());
			workOrderDTO.setCustomerId(customer);
		}
		
		workOrderDTO.setWorkOrderCode(workOrder.getWorkOrderCode());
		workOrderDTO.setWorkOrderDate(workOrder.getWorkOrderDate());
		workOrderDTO.setWorkOrderId(workOrder.getWorkOrderId());
		
		DeliveryTermsForSalesDTO deliveryTermsMasterforVendorDTO = new DeliveryTermsForSalesDTO();
		if(workOrder.getDeliveryTerms()!=null && !workOrder.getDeliveryTerms().equalsIgnoreCase("null")) {
			Optional<DeliveryTermsMasterforVendor> deliveryTermsO = deliveryMasterDao.findById(Integer.valueOf(workOrder.getDeliveryTerms()));
			
			if(deliveryTermsO.isPresent()) {
				DeliveryTermsMasterforVendor DeliveryTermsMasterControllerforVendor = deliveryTermsO.get();
				deliveryTermsMasterforVendorDTO.setDeliveryTermsCode(DeliveryTermsMasterControllerforVendor.getDeliveryTermsCode());
				deliveryTermsMasterforVendorDTO.setDescription(DeliveryTermsMasterControllerforVendor.getDescription());
				deliveryTermsMasterforVendorDTO.setId(DeliveryTermsMasterControllerforVendor.getId());
				
				workOrderDTO.setDeliveryTerms(deliveryTermsMasterforVendorDTO);
			}
					
		}
		
		
		JurisdictionForSalesDTO jurisdictionMasterForVendor = new JurisdictionForSalesDTO();
		if(workOrder.getJurisdiction()!=null && !workOrder.getJurisdiction().equalsIgnoreCase("null")) {
			Optional<JurisdictionMasterForVendor> juridictionO = juridictionDao.findById(Integer.valueOf(workOrder.getJurisdiction()));
			if(juridictionO.isPresent()) {
				JurisdictionMasterForVendor juridiction = juridictionO.get();
				jurisdictionMasterForVendor.setDescription(juridiction.getDescription());
				jurisdictionMasterForVendor.setId(juridiction.getId());
				jurisdictionMasterForVendor.setJurisdictionCode(juridiction.getJurisdictionCode());
				
				workOrderDTO.setJurisdiction(jurisdictionMasterForVendor);
			}
		}
		
		
		PaymentMethodForSalesDTO paymentMethodMasterforVendorDTO = new PaymentMethodForSalesDTO();
		if(workOrder.getPayMethod()!=null && !workOrder.getPayMethod().equalsIgnoreCase("null")) {
			Optional<PaymentMethodMasterforVendor> paymentMethodO = paymentMethodDao.findById(Integer.valueOf(workOrder.getPayMethod())) ;
			if(paymentMethodO.isPresent()) {
				PaymentMethodMasterforVendor masterforVendor = paymentMethodO.get();
				paymentMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				paymentMethodMasterforVendorDTO.setId(masterforVendor.getId());
				paymentMethodMasterforVendorDTO.setPaymentMethodCode(masterforVendor.getPaymentMethodCode());
				
				workOrderDTO.setPaymentMethod(paymentMethodMasterforVendorDTO);
			}
		}
		
		
		PaymentTermsForSalesDTO paymentTermsMasterforVendorDTO = new PaymentTermsForSalesDTO();
		if(workOrder.getPayTerms()!=null && !workOrder.getPayTerms().equalsIgnoreCase("null")) {
			Optional<PaymentTermsMasterforVendor> paymentTermsO = paymentTermsDao.findById(Integer.valueOf(workOrder.getPayTerms()));
			if(paymentTermsO.isPresent()) {
				PaymentTermsMasterforVendor masterforVendor = paymentTermsO.get();
				paymentTermsMasterforVendorDTO.setDays(masterforVendor.getDays());
				paymentTermsMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				paymentTermsMasterforVendorDTO.setDiscAmt(masterforVendor.getDisc_amt());
				paymentTermsMasterforVendorDTO.setId(masterforVendor.getId());
				paymentTermsMasterforVendorDTO.setPaymentTermsCode(masterforVendor.getPaymentTermsCode());
				
				workOrderDTO.setPaymentTerms(paymentTermsMasterforVendorDTO);
			}
		}
		
		ShippingMethodForSalesDTO shippingMethodMasterforVendorDTO = new ShippingMethodForSalesDTO();
		if(workOrder.getShippingMethod()!=null && !workOrder.getShippingMethod().equalsIgnoreCase("null")) {
			Optional<ShippingMethodMasterforVendor> shippingO = shippingDao.findById(Integer.valueOf(workOrder.getShippingMethod()));
			if(shippingO.isPresent()) {
				ShippingMethodMasterforVendor masterforVendor = shippingO.get();
				shippingMethodMasterforVendorDTO.setDescription(masterforVendor.getDescription());
				shippingMethodMasterforVendorDTO.setId(masterforVendor.getId());
				shippingMethodMasterforVendorDTO.setShippingMethodCode(masterforVendor.getShippingMethodCode());
				
				workOrderDTO.setShippingMethod(shippingMethodMasterforVendorDTO);
			}
		}
		
		List<WorkOrderDetailsDTO> workOrderDetailsDTO = new ArrayList<>();
		List<WorkOrderDetailsDTO> workOrderDetails = workOrderDetailsService.getAllWorkOrderByWorkOrderId(workOrder.getWorkOrderId());
		
		workOrderDetails.forEach(wo->{
			workOrderDetailsDTO.add(wo);
		});
		
		workOrderDTO.setWorkOrderDetailsDTO(workOrderDetailsDTO);
		
		workOrderDTO.setBillingAddr(workOrder.getBillingAddr());
		workOrderDTO.setShippingAddr(workOrder.getShippingAddr());
		
		if(workOrder.getCustomerId()!=null) {
			CustomerMasterDTO customerDTO = customerService.getCustomerMasterById(workOrder.getCustomerId());
			CustomerForSalesDTO customer = new CustomerForSalesDTO();
			customer.setCustomerCode(customerDTO.getCustomerCode());
			customer.setCustomerId(customerDTO.getCustomerId());
			customer.setCustomerName(customerDTO.getCustomerName());
			workOrderDTO.setCustomer(customer);
		}
		
		return workOrderDTO;
	}

	@Override
	public WorkOrder prepareWorkOrderEntity(WorkOrderDTO workOrderDTO) {
		// TODO Auto-generated method stub
		WorkOrder workOrder = new WorkOrder();
		
		String workOrderCode = "";
		if(workOrderDTO.getWorkOrderId()!=null) {
			workOrder = workOrderRepo.findById(workOrderDTO.getWorkOrderId()).get();
			workOrder.setStatus(Integer.valueOf(workOrderDTO.getStatus()));
		}else {
			//Generating QuotationCode start
			Long workOrderCount = workOrderRepo.count();
			
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//			(formattedDate);
			Integer currYear = Integer.valueOf(formattedDate);
			Integer nextYear = currYear+1;
			workOrderCode = "WO/"+(workOrderCount+1)+"/"+currYear+"-"+nextYear;
			//Generating QuotationCode end
			
			workOrder.setWorkOrderCode(workOrderCode);
			
		}
		
		workOrder.setCustPo(workOrderDTO.getCustPo());
		workOrder.setCustPoDate(workOrderDTO.getCustPoDate());
		workOrder.setDeliveryDate(workOrderDTO.getDeliveryDate());
		workOrder.setSalesOrderId(workOrderDTO.getSalesOrderId());
		
		if(workOrder.getCustomerId()!=null) {
			workOrder.setCustomerId(Integer.valueOf(String.valueOf(workOrderDTO.getCustomer().getCustomerId())));
		}
		
		if(workOrderDTO.getDeliveryTerms()!=null)
			workOrder.setDeliveryTerms(String.valueOf(workOrderDTO.getDeliveryTerms().getId()));
		
		workOrder.setDivision(workOrderDTO.getDivision());
		
		if(workOrderDTO.getJurisdiction()!=null)
			workOrder.setJurisdiction(String.valueOf(workOrderDTO.getJurisdiction().getId()));
		
		workOrder.setOrderType(workOrderDTO.getOrderType());
		workOrder.setPackingType(workOrderDTO.getPackingType());
		
		if(workOrderDTO.getPaymentMethod()!=null)
			workOrder.setPayMethod(String.valueOf(workOrderDTO.getPaymentMethod().getId()));
		
		if(workOrderDTO.getPackingType()!=null)
			workOrder.setPackingType(workOrderDTO.getPackingType());
		
		if(workOrderDTO.getPaymentTerms()!=null)
			workOrder.setPayTerms(String.valueOf(workOrderDTO.getPaymentTerms().getId()));
		
		if(workOrderDTO.getRegion()!=null)
			workOrder.setRegion(workOrderDTO.getRegion());
		
		if(workOrderDTO.getShippingMethod()!=null)
			workOrder.setShippingMethod(String.valueOf(workOrderDTO.getShippingMethod().getId()));
		
		workOrder.setValidityDate(workOrderDTO.getValidityDate());
		
		if(workOrderDTO.getCustomerId()!=null)
			workOrder.setCustomerId(workOrderDTO.getCustomerId().getCustomerId());
		
		workOrder.setWorkOrderDate(workOrderDTO.getWorkOrderDate());
		
		workOrder.setBillingAddr(workOrderDTO.getBillingAddr());
		workOrder.setShippingAddr(workOrderDTO.getShippingAddr());
		workOrder.setIsActive(1);
		
		
		return workOrder;
	}

	@Override
	public WorkOrderDTO prepareWorkOrderFromSalesOrder(SalesorderDTO salesorderDTO, Integer salesOrderId) {
		// TODO Auto-generated method stub
		WorkOrderDTO workOrder = new WorkOrderDTO();
		
		if(salesOrderId!=null) {
			List<WorkOrder> workOrderEntityList = workOrderRepo.findBySalesOrderId(salesOrderId);
			WorkOrder workOrderEntity = new WorkOrder();
			if(!workOrderEntityList.isEmpty()) {
				workOrderEntity = workOrderEntityList.get(0);
			}
			workOrder = prepareWorkOrderDTO(workOrderEntity);
		}
		
		workOrder.setBillingAddr(salesorderDTO.getBillingAddr());
		workOrder.setSalesOrderId(salesOrderId);
		workOrder.setCustomer(salesorderDTO.getCustomer());
		workOrder.setCustPo(salesorderDTO.getPoReference());
		workOrder.setCustPoDate(salesorderDTO.getPurchaseDate());
		workOrder.setDeliveryDate(salesorderDTO.getDeliveryDate());
		workOrder.setDeliveryTerms(salesorderDTO.getDeliveryTerms());
		workOrder.setDivision(salesorderDTO.getDivision());
		workOrder.setIsActive("1");
		workOrder.setJurisdiction(salesorderDTO.getJurisdiction());
		workOrder.setOrderType(salesorderDTO.getProductType());
		workOrder.setPackingType(salesorderDTO.getPackingType());
		workOrder.setPaymentMethod(salesorderDTO.getPaymentMethod());
		workOrder.setPaymentTerms(salesorderDTO.getPaymentTerms());
		workOrder.setRegion(salesorderDTO.getRegion());
		workOrder.setShippingAddr(salesorderDTO.getRegdOfficeAddr());
		workOrder.setShippingMethod(salesorderDTO.getShippingMethod());
		workOrder.setStatus("0");
		workOrder.setValidityDate(salesorderDTO.getValidityDate());
		workOrder.setCustomer(salesorderDTO.getCustomer());
//		workOrder.setWorkOrderCode(workOrderCode);
		workOrder.setWorkOrderDate(salesorderDTO.getOrderDate());
		
		return workOrder;
	}

}
