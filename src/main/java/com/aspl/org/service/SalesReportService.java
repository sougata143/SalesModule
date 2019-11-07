package com.aspl.org.service;

import com.aspl.org.dto.QuotationDTO;
import com.aspl.org.dto.QuotationDetailsDTO;
import com.aspl.org.dto.QuotationDetailsReportDTO;
import com.aspl.org.dto.QuotationReportDTO;
import com.aspl.org.dto.WorkOrderReportDTO;

public interface SalesReportService {

	public QuotationReportDTO getQuotationReport(Integer quotationId);
	public QuotationReportDTO prepareQuotationReportDTO(QuotationDTO quotationDTO);
	QuotationDetailsReportDTO prepareQuotationReportDetailsDTO(QuotationDetailsDTO quotationDetailsDTO);
	
	public WorkOrderReportDTO getWorkOrderReport(Integer workOrderId);
	
	
}
