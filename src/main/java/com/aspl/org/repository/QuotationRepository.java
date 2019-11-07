package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.Quotation;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Integer>{
	
	List<Quotation> findByStatus(Integer status);
	List<Quotation> findByIsActive(Integer isActive);
	List<Quotation> findByStatusOrStatusOrAndIsActive(Integer pendingStatus, Integer partlyPendingStatus, Integer isActive);
	List<Quotation> findByStatusAndIsActive(Integer pendingStatus, Integer isActive);
	
	@Query(value="select * from quotation where status = 2 and is_active = 1 and ( igst is not null or (cgst is not null and sgst is not null))", nativeQuery=true)
	List<Quotation> findByStatusOrAndIsActiveWithGST();
	
	@Query(value="select * from quotation where status = 2 and is_active = 1 and ( igst is null or (cgst is null and sgst is null))", nativeQuery=true)
	List<Quotation> findByStatusOrAndIsActiveWithOutGST();
	
	List<Quotation> findByCustomer(String customer);
}
