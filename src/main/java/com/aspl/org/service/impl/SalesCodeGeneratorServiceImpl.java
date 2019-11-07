package com.aspl.org.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.SalesOrderCodeDTO;
import com.aspl.org.repository.EnquiryDao;
import com.aspl.org.repository.QuotationRepository;
import com.aspl.org.repository.SalesorderDao;
import com.aspl.org.service.SalesCodeGeneratorService;


@Service
@Transactional
public class SalesCodeGeneratorServiceImpl implements SalesCodeGeneratorService {

	@Autowired
	SalesorderDao salesOrderRepo;
	
	@Autowired
	EnquiryDao enquiryRepo;
	
	@Autowired
	QuotationRepository quotationRepo;
	
	@Override
	public SalesOrderCodeDTO generateSalesOrderCode(String customerCode) {
		// TODO Auto-generated method stub
		SalesOrderCodeDTO soCode = new SalesOrderCodeDTO();
		try {
			Integer soCount = Integer.valueOf(String.valueOf(salesOrderRepo.count()));
			soCode.setCustomerCode(customerCode);
			soCode.setCountSalesOrder(soCount+1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return soCode;
	}

	@Override
	public String generateEnquiryCode() {
		// TODO Auto-generated method stub
		String enquiryCode = "";
		try {
			Long enquiryCount = enquiryRepo.count();
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
			Integer currYear = Integer.valueOf(formattedDate);
			Integer nextYear = currYear+1;
			enquiryCode = "ENQ/"+(enquiryCount+1)+"/"+currYear+"-"+nextYear;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return enquiryCode;
	}

	@Override
	public String generateQuotationCode() {
		// TODO Auto-generated method stub
		String quotationCode = "";
		try {
			Long quotationCount = quotationRepo.count();
			
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//			(formattedDate);
			Integer currYear = Integer.valueOf(formattedDate);
			Integer nextYear = currYear+1;
			quotationCode = "CR/QTN/"+(quotationCount+1)+"/"+currYear+"-"+nextYear;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quotationCode;
	}

}
