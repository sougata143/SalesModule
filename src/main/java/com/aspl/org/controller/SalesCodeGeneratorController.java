package com.aspl.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.dto.SalesOrderCodeDTO;
import com.aspl.org.service.SalesCodeGeneratorService;

@RestController
@RequestMapping(value="salesCodeGenerator/")
public class SalesCodeGeneratorController {

	@Autowired
	SalesCodeGeneratorService salesCodeGeneratorService;
	
	@GetMapping("getSalesOrderCode/{customerCode}")
	public SalesOrderCodeDTO generateSalesOrderCode(@PathVariable("customerCode") String customerCode) {
		return salesCodeGeneratorService.generateSalesOrderCode(customerCode);
	}
	
	@GetMapping("getEnquiryCode")
	public String generateEnquiryCode() {
		return salesCodeGeneratorService.generateEnquiryCode();
	}
	
	@GetMapping("getQuotationCode")
	public String generateQuotationCode() {
		return salesCodeGeneratorService.generateQuotationCode();
	}
	
}
