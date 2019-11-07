package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.CustomerMasterDTO;
import com.aspl.org.dto.MarketingDetailsDTO;
import com.aspl.org.dto.QuotationDTO;
import com.aspl.org.dto.QuotationDetailsDTO;
import com.aspl.org.dto.QuotationDetailsReportDTO;
import com.aspl.org.dto.QuotationReportDTO;
import com.aspl.org.dto.WorkOrderDTO;
import com.aspl.org.dto.WorkOrderDetailsDTO;
import com.aspl.org.dto.WorkOrderReportDTO;
import com.aspl.org.dto.WorkOrderReportDetailsDTO;
import com.aspl.org.entity.CompanyMaster;
import com.aspl.org.service.CompanymasterService;
import com.aspl.org.service.CustomerMasterService;
import com.aspl.org.service.MarketingDetailsService;
import com.aspl.org.service.QuotationDetailsService;
import com.aspl.org.service.QuotationService;
import com.aspl.org.service.SalesReportService;
import com.aspl.org.service.UtilService;
import com.aspl.org.service.WorkOrderDetailsService;
import com.aspl.org.service.WorkOrderService;
import com.aspl.org.utils.PurchaseUtil;

@Service
@Transactional
public class SalesReportServiceImpl implements SalesReportService {

	@Autowired
	QuotationService quotationService;
	
	@Autowired
	QuotationDetailsService quotationDetailsService;
	
	@Autowired
	WorkOrderService workOrderService;
	
	@Autowired
	WorkOrderDetailsService workOrderDetailsService;
	
	@Autowired
	CustomerMasterService customerService;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	MarketingDetailsService marketingService;
	
	@Autowired
	CompanymasterService companyMasterService;
	
	
	@Override
	public QuotationReportDTO getQuotationReport(Integer quotationId) {
		// TODO Auto-generated method stub
		QuotationReportDTO quotationReportDTO = new QuotationReportDTO();
		try {
			QuotationDTO quotationDTO = quotationService.getQuotationById(quotationId);
			quotationReportDTO = prepareQuotationReportDTO(quotationDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotationReportDTO;
	}

	@Override
	public QuotationReportDTO prepareQuotationReportDTO(QuotationDTO quotationDTO) {
		// TODO Auto-generated method stub
		QuotationReportDTO quotationReportDTO = new QuotationReportDTO();
		
		quotationReportDTO.setAssesableValue(quotationDTO.getAssesableValue());
		quotationReportDTO.setBillTo(quotationDTO.getBillTo());
		quotationReportDTO.setCgst(quotationDTO.getCgst());
		quotationReportDTO.setCreditLimit(quotationDTO.getCreditLimit());
		
		CustomerMasterDTO customer = customerService.getCustomerMasterById(quotationDTO.getCustomer().getCustomerId());
		quotationReportDTO.setCustomer(customer);
		
		if(quotationDTO.getDeliveryTerms()!=null)
			quotationReportDTO.setDeliveryTerms(quotationDTO.getDeliveryTerms().getDescription());
		
		if(quotationDTO.getDivision()!=null)
			quotationReportDTO.setDivision(quotationDTO.getDivision());
		
		
//		quotationReportDTO.setEnquiryId(enquiryId);
		quotationReportDTO.setFreightType(quotationDTO.getFreightType());
		quotationReportDTO.setGrandTotal(quotationDTO.getGrandTotal());
		quotationReportDTO.setIgst(quotationDTO.getIgst());
		quotationReportDTO.setInsurance(quotationDTO.getInsurance());
		
		if(quotationDTO.getJurisdiction()!=null)
			quotationReportDTO.setJurisdiction(quotationDTO.getJurisdiction().getDescription());
		
		quotationReportDTO.setLst(quotationDTO.getLst());
		
		quotationReportDTO.setMarketing(quotationDTO.getMarketingDetails());
		
		quotationReportDTO.setOtherCharges(quotationDTO.getOtherCharges());
		quotationReportDTO.setOutStanding(quotationDTO.getOutStanding());
		quotationReportDTO.setRateList(quotationDTO.getRateList());
		
		if(quotationDTO.getRegion()!=null)
			quotationReportDTO.setRegion(quotationDTO.getRegion());
		
//		if(quotationDTO.getAgent()!=null)
//			quotationReportDTO.setAgent(quotationDTO.getAgent());
		
		quotationReportDTO.setSgst(quotationDTO.getSgst());
		
		if(quotationDTO.getShippingMethod()!=null)
			quotationReportDTO.setShippingMethod(quotationDTO.getShippingMethod().getDescription());
		
		if(quotationDTO.getPaymentMethod()!=null)
			quotationReportDTO.setPaymentMethod(quotationDTO.getPaymentMethod().getDescription());
		
		if(quotationDTO.getPaymentTerms()!=null)
			quotationReportDTO.setPaymentTerms(quotationDTO.getPaymentTerms().getDescription());
		
		quotationReportDTO.setShipTo(quotationDTO.getShipTo());
		quotationReportDTO.setValidationDate(quotationDTO.getValidationDate());
		quotationReportDTO.setQuotationCode(quotationDTO.getQuotationCode());
		quotationReportDTO.setQuotationDate(quotationDTO.getQuotationDate());

		List<QuotationDetailsDTO> quotDetails = quotationDTO.getQuotationItems();
		List<QuotationDetailsReportDTO> quotationDetailsReportDTO = new ArrayList<>();
		for(QuotationDetailsDTO qd : quotDetails) {
			QuotationDetailsReportDTO quoReportDTO = prepareQuotationReportDetailsDTO(qd);
			quotationDetailsReportDTO.add(quoReportDTO);
		}
		quotationReportDTO.setQuotationItems(quotationDetailsReportDTO);
		
		List<MarketingDetailsDTO> marketing = marketingService.getMarketingDetailsForQuotation(quotationDTO.getQuotationId());
		quotationReportDTO.setMarketing(marketing);
		
		return quotationReportDTO;
	}
	
	@Override
	public QuotationDetailsReportDTO prepareQuotationReportDetailsDTO(QuotationDetailsDTO quotationDetailsDTO) {
		QuotationDetailsReportDTO quotationDetails = new QuotationDetailsReportDTO();
		
//		quotationDetails.setAgent(quotationDetailsDTO.getAgent());
		quotationDetails.setAmortisationQty(quotationDetailsDTO.getAmortisationQty());
		quotationDetails.setAmortisationValue(quotationDetailsDTO.getAmortisationValue());
		quotationDetails.setAssessibleValue(quotationDetailsDTO.getAssessibleValue());
		quotationDetails.setCustPartName(quotationDetailsDTO.getCustPartName());
		quotationDetails.setCustPartNo(quotationDetailsDTO.getCustPartNo());
		quotationDetails.setDiscount(quotationDetailsDTO.getDiscount());
		quotationDetails.setDrawingNo(quotationDetailsDTO.getDrawingNo());
		quotationDetails.setItem(quotationDetailsDTO.getItem());
		quotationDetails.setMachiningCostPerPiece(quotationDetailsDTO.getMachiningCostPerPiece());
		quotationDetails.setMachiningToolingCost(quotationDetailsDTO.getMachiningToolingCost());
		quotationDetails.setMaterial(quotationDetailsDTO.getMaterial());
		quotationDetails.setNotes(quotationDetailsDTO.getNotes());
		quotationDetails.setPreparedBy(quotationDetailsDTO.getPreparedBy());
		quotationDetails.setQty(quotationDetailsDTO.getQty());
		quotationDetails.setRateType(quotationDetailsDTO.getRateType());
		quotationDetails.setRemarks(quotationDetailsDTO.getRemarks());
		quotationDetails.setRevisionNo(quotationDetailsDTO.getRevisionNo());
		quotationDetails.setRoundOff(quotationDetailsDTO.getRoundOff());
		quotationDetails.setSellingPrice(quotationDetailsDTO.getSellingPrice());
		quotationDetails.setTotal(quotationDetailsDTO.getTotal());
		quotationDetails.setTotalMachiningCost(quotationDetailsDTO.getTotalMachiningCost());
		quotationDetails.setTotalWeight(quotationDetailsDTO.getTotalWeight());
		quotationDetails.setUnit(quotationDetailsDTO.getUnit());
		quotationDetails.setUnitPrice(quotationDetailsDTO.getUnitPrice());
		quotationDetails.setWeight(quotationDetailsDTO.getWeight());
		
		return quotationDetails;
	}

	@Override
	public WorkOrderReportDTO getWorkOrderReport(Integer workOrderId) {
		// TODO Auto-generated method stub
		WorkOrderReportDTO workOrderReportDTO = new WorkOrderReportDTO();
		
		WorkOrderDTO wo = workOrderService.getWorkOrderById(workOrderId);
		
		workOrderReportDTO.setCustPoDate(wo.getCustPoDate());
		workOrderReportDTO.setCustPoNumber(wo.getCustPo());
		workOrderReportDTO.setDeliveryDate(wo.getDeliveryDate());
		
		if(wo.getDeliveryTerms()!=null)
			workOrderReportDTO.setDeliveryTerms(wo.getDeliveryTerms().getDescription());
		
		workOrderReportDTO.setDivision(wo.getDivision());
		
		if(wo.getJurisdiction()!=null)
			workOrderReportDTO.setJurisdiction(wo.getJurisdiction().getDescription());
		
		CustomerMasterDTO customer = new CustomerMasterDTO();
		if(wo.getCustomer()!=null) {
			customer = customerService.getCustomerMasterById(wo.getCustomer().getCustomerId());
			
			if(customer.getContactDetails()!=null && !customer.getContactDetails().isEmpty())
				workOrderReportDTO.setKindAttn(customer.getContactDetails().get(0).getContactPerson());
			
			workOrderReportDTO.setPartyAddress(customer.getAddress1()+customer.getAddress2()+customer.getState()+customer.getCity());
			
			if(customer.getContactDetails()!=null && !customer.getContactDetails().isEmpty())
				workOrderReportDTO.setPartyFax(customer.getContactDetails().get(0).getFaxNo());
			
			workOrderReportDTO.setPartyName(wo.getCustomer().getCustomerName());
			workOrderReportDTO.setPartyPhone(wo.getCustomer().getCustomerName());
		}
		else {
			workOrderReportDTO.setKindAttn("");
			workOrderReportDTO.setKindAttn("");
			workOrderReportDTO.setPartyFax("");
			workOrderReportDTO.setPartyName("");
			workOrderReportDTO.setPartyPhone("");
		}
		
		workOrderReportDTO.setPackingType(wo.getPackingType());
		
		if(wo.getPaymentMethod()!=null)
			workOrderReportDTO.setPaymentMethod(wo.getPaymentMethod().getDescription());
		
		if(wo.getPaymentTerms()!=null)
			workOrderReportDTO.setPayTerms(wo.getPaymentTerms().getDescription());
		
		if(wo.getRegion()!=null)
			workOrderReportDTO.setRegion(wo.getRegion());
		
		if(wo.getShippingMethod()!=null)
			workOrderReportDTO.setShippingMethod(wo.getShippingMethod().getDescription());
		
		workOrderReportDTO.setType(wo.getOrderType());
		workOrderReportDTO.setValidateDate(wo.getValidityDate());
		workOrderReportDTO.setWorkOrderCode(wo.getWorkOrderCode());
		workOrderReportDTO.setWorkOrderDate(wo.getWorkOrderDate());
		
		workOrderReportDTO.setCustomer(customer);
		
		Optional<CompanyMaster> billingCompanyO = companyMasterService.findbyidcompanymaster(Integer.valueOf(wo.getBillingAddr()));
		CompanyMaster billingCompany = new CompanyMaster();
		if(billingCompanyO.isPresent()) {
			billingCompany = companyMasterService.findbyidcompanymaster(Integer.valueOf(wo.getBillingAddr())).get();
			workOrderReportDTO.setBillingAddr(billingCompany.getRegdOfficeAddr());
		}
		
		Optional<CompanyMaster> shippingCompanyO = companyMasterService.findbyidcompanymaster(Integer.valueOf(wo.getBillingAddr()));
		CompanyMaster shippingCompany = new CompanyMaster();
		if(shippingCompanyO.isPresent()) {
			shippingCompany = companyMasterService.findbyidcompanymaster(Integer.valueOf(wo.getShippingAddr())).get();
			workOrderReportDTO.setShippingAddr(wo.getShippingAddr());
		}
		
		List<WorkOrderReportDetailsDTO> woDetailsDTOs = new ArrayList<>();
		List<WorkOrderDetailsDTO> workOrderDetailsDTOs = workOrderDetailsService.getAllWorkOrderByWorkOrderId(wo.getWorkOrderId());
		
		Double totalQnt = 0.0;
		Double totalWt = 0.0;
		Double wtTotal = 0.0;
		Double basicValue = 0.0;
		
		for(WorkOrderDetailsDTO woDetails : workOrderDetailsDTOs) {
			WorkOrderReportDetailsDTO detailsReportDTO = new WorkOrderReportDetailsDTO();
			
			detailsReportDTO.setEachWt(woDetails.getEachWt());
			detailsReportDTO.setItemCode(woDetails.getItem().getItemCode()+" "+woDetails.getItem().getItemName());
			detailsReportDTO.setItemDescription(woDetails.getItem().getItemName());
			detailsReportDTO.setQuantity(woDetails.getQuantity());
			detailsReportDTO.setRate(woDetails.getRate());
			
			Double total = 0.0;
			if(woDetails.getRate()!=null && woDetails.getQuantity()!=null) {
				total = woDetails.getRate() * woDetails.getQuantity();
				detailsReportDTO.setTotal(total);
			}
			
			wtTotal = woDetails.getQuantity() * woDetails.getEachWt();
			
			detailsReportDTO.setTotalWt(String.valueOf(wtTotal));
			detailsReportDTO.setUnit(woDetails.getUnit());
			detailsReportDTO.setCustPartName(woDetails.getCustPartName());
			detailsReportDTO.setItemName(woDetails.getItem().getItemName());
			
			totalQnt = totalQnt + woDetails.getQuantity();
			totalWt = totalWt + wtTotal;
			basicValue = basicValue + total;
			
			woDetailsDTOs.add(detailsReportDTO);
		}
		
		workOrderReportDTO.setTotalQnt(totalQnt);
		workOrderReportDTO.setTotalWt(totalWt);
		workOrderReportDTO.setBasicValue(basicValue);
		
		String amount = PurchaseUtil.convertToWords(basicValue).toUpperCase()+" ONLY";
		workOrderReportDTO.setAmountInWords(amount);
		
		workOrderReportDTO.setWorkOrderDetails(woDetailsDTOs);
		
		return workOrderReportDTO;
	}

}
