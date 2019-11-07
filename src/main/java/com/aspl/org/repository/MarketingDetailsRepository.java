package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.MarketingDetails;

@Repository
public interface MarketingDetailsRepository extends JpaRepository<MarketingDetails, Integer> {

	List<MarketingDetails> findByQuotationId(Integer quotationId);
	List<MarketingDetails> findBySalesOrderId(Integer salesOrderId);
	
}
