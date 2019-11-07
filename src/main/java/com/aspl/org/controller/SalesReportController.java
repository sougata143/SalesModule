package com.aspl.org.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.report.service.QuotationReportService;
import com.aspl.org.report.service.WorkOrderReportService;

@RestController
@RequestMapping("quotationReport/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalesReportController {

	@Autowired
	QuotationReportService quotationService;
	
	@Autowired
	WorkOrderReportService workOrderReportService;
	
	@PostMapping("quotationReport/{quotationId}")
	public Map<String, Object> getQuotationReport(HttpServletRequest request, @PathVariable("quotationId") String quotationId,
			@RequestBody String message) {
		return quotationService.getQuotationReport(request, quotationId, message);
	}
	
	@GetMapping("workOrderReport/{workOrderId}")
	public Map<String, Object> getWorkOrderReport(HttpServletRequest request, @PathVariable("workOrderId") String workOrderId) {
		return workOrderReportService.getWorkOrderReport(request, workOrderId);
	}
	
}
