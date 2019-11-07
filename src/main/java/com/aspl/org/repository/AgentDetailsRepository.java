package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aspl.org.entity.AgentDetails;

public interface AgentDetailsRepository extends JpaRepository<AgentDetails, Integer> {

	List<AgentDetails> findByStatus(Integer status);
	
}
