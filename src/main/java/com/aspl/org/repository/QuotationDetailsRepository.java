package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.QuotationDetails;

@Repository
public interface QuotationDetailsRepository extends JpaRepository<QuotationDetails, Integer>{

	List<QuotationDetails> findByQuotationId(Integer quotId);
	List<QuotationDetails> findByStatus(Integer status);
	List<QuotationDetails> findByQuotationIdAndStatus(Integer quotId, Integer status);
	
}
