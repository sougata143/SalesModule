package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.dto.SalesorderDetailsDTO;
import com.aspl.org.entity.SalesorderDetails;

@Repository

public interface SalesorderDetailsDao extends JpaRepository<SalesorderDetails, Integer> {

	List<SalesorderDetails> findBySoid(Integer soId);
	List<SalesorderDetails> findByItemCode(String itemCode);
	
	List<SalesorderDetails> findByItemId(Integer itemId);
	
//	List<PurchaseDetails> findByItemIdAndCreatedDateBetween(Date startDate, Date endDate);
	
	List<SalesorderDetails> findBySoidAndSoDetailsStaus(Integer soId, Integer soDetailsStaus);
	
	List<SalesorderDetails> findBySoidAndSoDetailsStausOrSoDetailsStausOrSoDetailsStaus(Integer soId, 
			Integer pendingSoDetailsStaus, Integer partlyAcceptedSoDetailsStaus, Integer partlyRejectedSoDetailsStaus);
	SalesorderDetailsDTO save(SalesorderDetailsDTO soDetails);
	
}
