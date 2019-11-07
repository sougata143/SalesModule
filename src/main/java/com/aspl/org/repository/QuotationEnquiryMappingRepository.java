package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.QuotationEnquiryMapping;

@Repository
public interface QuotationEnquiryMappingRepository extends JpaRepository<QuotationEnquiryMapping, Integer> {

	List<QuotationEnquiryMapping> findByEnquiryId(Integer enquiryId);
	List<QuotationEnquiryMapping> findByQuotationId(Integer quotationId);
	List<QuotationEnquiryMapping> findBySalesOrderId(Integer salesOrderId);
	
	List<QuotationEnquiryMapping> findByQuotationIdAndEnquiryId(Integer quotationId, Integer enquiryId);
	List<QuotationEnquiryMapping> findBySalesOrderIdAndQuotationId(Integer salesOrderId, Integer quotationId);
	
	List<QuotationEnquiryMapping> findByIsActive(Integer isActive);
	
}
