package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.WorkOrderDetails;

@Repository
public interface WorkOrderDetailsRepository extends JpaRepository<WorkOrderDetails, Integer> {

	List<WorkOrderDetails> findByStatus(Integer status);
	List<WorkOrderDetails> findByWorkOrderId(Integer workOrderId);
	List<WorkOrderDetails> findBySalesOrderDetailsId(Integer salesOrderDetailsId);
	
}
 