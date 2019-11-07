package com.aspl.org.report.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface WorkOrderReportService {

	Map<String, Object> getWorkOrderReport(HttpServletRequest request, String workOrderId);

	/*
	 * Map<String, Object> getroadforwordingnotes(HttpServletRequest request, String
	 * invoice);
	 * 
	 * Map<String, Object> getSubStockistInvoiceReport(HttpServletRequest request,
	 * String profID);
	 */
}
