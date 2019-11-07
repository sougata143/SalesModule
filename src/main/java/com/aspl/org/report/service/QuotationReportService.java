package com.aspl.org.report.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface QuotationReportService {
  
	public Map<String, Object> getQuotationReport(HttpServletRequest request, String quotationId, String message);
	
}
