package com.aspl.org.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.dto.QuotationDTO;
import com.aspl.org.dto.SalesorderDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.SalesorderService;



@RestController
@RequestMapping(path = "/sales")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalesorderController {
	public static final Logger logger = LoggerFactory.getLogger(SalesorderController.class);

	@Autowired
	SalesorderService salesorderService;
	

	@PostMapping("/salesOrdersSave")	
	public ResponseDetails salesorderSave(@RequestBody SalesorderDTO salesorderDTO) throws Exception{
		logger.info("ordersSave: " +salesorderDTO.toString());
		ResponseDetails responseDetails=salesorderService.salesorderSave(salesorderDTO);
			
		return responseDetails;
		
	}
	
	
	
	@GetMapping(path="/getAllSalesorderForAuthorisation", produces = "application/json")
	public List<SalesorderDTO>  getAllSalesorderForAuthorisation() throws Exception{
		
		List<SalesorderDTO> salesorderList = salesorderService.getAllSalesorderForAuthorisation();
			
		return salesorderList;
	}
	
	@PostMapping(path="/getSalesorderForAuthorisation", produces = "application/json")
	public SalesorderDTO  getSalesorderForAuthorisation(@RequestBody String salesorderCode) throws Exception{
		
		SalesorderDTO salesOrder = salesorderService.findBySalesorderCode(salesorderCode);
			
		return salesOrder;
		
	}
	
	@PutMapping("authoriseSalesorder")
	public ResponseDetails authoriseSalesorder(@RequestBody SalesorderDTO salesorderDTO) {
		return salesorderService.authoriseSalesorder(salesorderDTO);
	}
		
	
	@GetMapping("getAllActiveSalesOrder")
	public List<SalesorderDTO> getAllActiveSalesOrder(){
		return salesorderService.getAllActiveSalesOrder();
	}
	
	@GetMapping("getAllAuthorisedSalesOrder")
	public List<SalesorderDTO> getAllAuthorisedSalesOrder(){
		return salesorderService.getAllAuthorisedSalesOrder();
	}
	
	@GetMapping("getSalesOrderById/{salesOrderId}") 
	public SalesorderDTO getSalesOrderById(@PathVariable("salesOrderId") Integer salesOrderId){ 
		  
		return salesorderService.findBySalesorderId(salesOrderId); 
	}
	
	@PutMapping("softDeleteSalesorder/{salesOrderId}")
	public ResponseDetails softDeleteSalesorder(@PathVariable("salesOrderId") Integer salesOrderId) {
		return salesorderService.softDeleteSalesOrder(salesOrderId);
	}
	
	@PutMapping("updateSalesOrder")
	public ResponseDetails updateSalesOrder(@RequestBody SalesorderDTO salesorderDTO) throws Exception {
		return salesorderService.salesorderUpdate(salesorderDTO);
	}

	 
}

