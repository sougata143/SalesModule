package com.aspl.org.service;

import com.aspl.org.dto.SalesOrderCodeDTO;

public interface SalesCodeGeneratorService {

	public SalesOrderCodeDTO generateSalesOrderCode(String customerCode);
	public String generateEnquiryCode();
	public String generateQuotationCode();
	
}
