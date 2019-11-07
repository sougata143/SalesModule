package com.aspl.org.controller;

import java.util.ArrayList;
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

import com.aspl.org.dto.EnquiryDTO;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.service.EnquiryService;


@RestController
@RequestMapping("/enquirySales")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnquiryController {
	
		public static final Logger logger = LoggerFactory.getLogger(EnquiryController.class);
		
		@Autowired EnquiryService enquiryService;

		@PostMapping("/enquirySave")	
		public ResponseDetails enquirySave(@RequestBody EnquiryDTO enquiryDTO) throws Exception{
			logger.info("enquirySave: " +enquiryDTO.toString());
			ResponseDetails responseDetails=enquiryService.enquirySave(enquiryDTO);
				
			return responseDetails;
			
		}
			
		
		@GetMapping(path="/getAllEnquiry", produces = "application/json")
		public List<EnquiryDTO>  getAllEnquiry() throws Exception{
			
			List<EnquiryDTO> enquiryList = enquiryService.getAllEnquiry();
				
			return enquiryList;
		}
		
		@GetMapping("/getAllEnquiryByCustomer/{customer}")
		public List<EnquiryDTO>  getAllEnquiry(@PathVariable("customer") Integer customer){
			
			List<EnquiryDTO> enquiryList = new ArrayList<>();
			try {
				enquiryList = enquiryService.getEnquiryByCustomer(customer);
			}catch(Exception e) {
				e.printStackTrace();
			}
				
			return enquiryList;
		}
	
		
		@GetMapping("getEnquiryById/{id}") 
		public EnquiryDTO getEnquiryById(@PathVariable("id") Integer id){ 
			  
			return enquiryService.findByEnquiryId(id); 
		}
		
		@PutMapping("softDeleteEnquiry/{enquiryId}")
		public ResponseDetails softDeleteEnquiry(@PathVariable("enquiryId") String enquiryId) {
			return enquiryService.softDeleteEnquiry(Integer.valueOf(enquiryId));
		}
		
		@PutMapping("updateEnquiry")
		public ResponseDetails updateEnquiry(@RequestBody EnquiryDTO enquiryDTO) throws Exception {
			return enquiryService.enquiryUpdate(enquiryDTO);
		}
}
