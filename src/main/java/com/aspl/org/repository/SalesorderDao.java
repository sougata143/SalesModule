package com.aspl.org.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.SalesorderDTO;
import com.aspl.org.entity.Salesorder;

@Repository
public interface SalesorderDao extends JpaRepository<Salesorder, Integer> {
	
	@Transactional
	@Modifying
	@Query("update Salesorder ai set ai.accepted=1 where ai.id=?1")
	void salesorderAuthorised(int iId);

	
	@Transactional
	@Modifying
	@Query("update Salesorder ai set ai.accepted=0 where ai.id=?1")
	void salesorderUnauthorised(int iId);

	@Query("Select ai from Salesorder ai where ai.accepted=0 and ai.salesorderCode=?1")//indentCode
	Salesorder findBySalesorderCode(String salesorderCode);
	
	List<Salesorder> findByQuotation(Integer quotation);
	
	List<Salesorder> findByAccepted(Integer accepted);
	List<Salesorder> findByIsActive(Integer isActive);
	List<Salesorder> findByCreatedDateBetween(Date startDate, Date endDate);
	
	List<Salesorder> findBySalesorderStatusOrSalesorderStatusOrSalesorderStatus(Integer pendingStatus, Integer partiallyAcceptedStatus,
			Integer partiallyRejectedStatus);
	List<Salesorder> findBySalesorderStatus(Integer purchaseStatus);
	List<Salesorder> findBySalesorderStatusAndIsActive(Integer purchaseStatus, Integer isActive);


	SalesorderDTO save(SalesorderDTO salesorderEntity);

}
