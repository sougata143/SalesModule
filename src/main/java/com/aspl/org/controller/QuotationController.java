package com.aspl.org.controller;

import java.util.List;

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
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.QuotationService;

@RestController
@RequestMapping("quotation/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuotationController {

	@Autowired
	QuotationService quotationService;
	
	@GetMapping("getAllQuotation")
	public List<QuotationDTO> getAllQuotation(){
		return quotationService.getAllQuotation();
	}
	
	@GetMapping("getAllQuotationByCustomer/{customerId}")
	public List<QuotationDTO> getAllQuotationByCustomer(@PathVariable("customerId") Integer customerId){
		return quotationService.getAllQuotationByCustomer(customerId);
	}
	
	@GetMapping("getAllUnAuthorisedQuotation")
	public List<QuotationDTO> getAllUnAthorisedQuotation(){
		return quotationService.getAllUnAuthorisedQuotation();
	}
	
	@GetMapping("getAllAuthorisedQuotationWithWeight")
	public List<QuotationDTO> getAllAthorisedQuotationWithWeight(){
		return quotationService.getAllAuthorisedQuotation("weight", null);
	}
	
	@GetMapping("getAllAuthorisedQuotationWithOutWeight")
	public List<QuotationDTO> getAllAthorisedQuotationWitOuthWeight(){
		return quotationService.getAllAuthorisedQuotation(null, null);
	}
	
	@GetMapping("getAllAuthorisedQuotation")
	public List<QuotationDTO> getAllAthorisedQuotation(){
		return quotationService.getAllAuthorisedQuotation("all", "all");
	}
	
	@GetMapping("getAllAuthorisedQuotationWithWeightAndGst")
	public List<QuotationDTO> getAllAuthorisedQuotationWithWeightAndGst(){
		return quotationService.getAllAuthorisedQuotation("weight", "gst");
	}
	
	@GetMapping("getAllAuthorisedQuotationWithWeightAndWithoutGst")
	public List<QuotationDTO> getAllAuthorisedQuotationWithWeightAndWithoutGst(){
		return quotationService.getAllAuthorisedQuotation("weight" , null);
	}
	
	@GetMapping("getQuotationById/{quotationId}")
	public QuotationDTO getQuotationById(@PathVariable("quotationId") Integer quotationId) {
		return quotationService.getQuotationById(quotationId);
	}
	
	@PostMapping("saveQuotation")
	public ResponseDetails saveQuotation(@RequestBody QuotationDTO quotationDTO) {
		return quotationService.saveQuotation(quotationDTO);
	}
	
	@PutMapping("updateQuotation")
	public ResponseDetails updateQuotation(@RequestBody QuotationDTO quotationDTO) {
		return quotationService.updateQuotation(quotationDTO);
	}
	
	@PutMapping("authoriseQuotation")
	public ResponseDetails authoriseQuotation(@RequestBody QuotationDTO quotationDTO) {
		return quotationService.authoriseQuotation(quotationDTO);
	}
	
	@PutMapping("softDeleteQuotation/")
	public ResponseDetails softDeleteQuotation(@RequestBody Integer quotationId) {
		return quotationService.softDeleteQuotation(quotationId);
	}
	
}
