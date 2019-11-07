package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aspl.org.entity.Enquiry;

public interface EnquiryDao extends JpaRepository<Enquiry, Integer> {
	
	@Query("Select ai from Enquiry ai where ai.accepted=0 and ai.enquiryCode=?1")
	Enquiry findByEnquiryCode(String enquiryCode);
	
	List<Enquiry> findByAccepted(Integer accepted);
	List<Enquiry> findByIsActive(Integer isActive);
	
	List<Enquiry> findByCustomer(Integer customer);
 

 }
