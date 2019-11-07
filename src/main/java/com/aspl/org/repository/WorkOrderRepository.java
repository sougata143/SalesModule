package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.WorkOrder;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer> {

	List<WorkOrder> findByIsActiveAndStatus(Integer isActive, Integer status);
	List<WorkOrder> findByIsActive(Integer isActive);
	List<WorkOrder> findByIsActiveAndStatusOrStatus(Integer isActive, Integer status, Integer partlyAccpet);
	List<WorkOrder> findBySalesOrderId(Integer salesOrderId);
	
}
