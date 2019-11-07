package com.aspl.org.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.EnquiryDetails;

@Repository
public interface EnquiryDetailsDao extends JpaRepository<EnquiryDetails, Integer> {
	List<EnquiryDetails> findByEnquiryId(Integer enquiryId);
	List<EnquiryDetails> findByStatus(Integer status);
	List<EnquiryDetails> findByEnquiryIdAndStatus(Integer enquiryId, Integer status);

}
