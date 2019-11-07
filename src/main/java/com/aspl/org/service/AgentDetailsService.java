package com.aspl.org.service;

import java.util.List;

import com.aspl.org.dto.AgentDetailsDTO;
import com.aspl.org.entity.AgentDetails;
import com.aspl.org.entity.ResponseDetails;

public interface AgentDetailsService {

	public List<AgentDetailsDTO> getAllAgents();
	public AgentDetailsDTO getAgentDetailsById(Integer agentId);
	
	public ResponseDetails saveAgentDetails(AgentDetailsDTO agentDetailsDTO);
	public ResponseDetails updateAgentDetailsDTO(AgentDetailsDTO agentDetailsDTO);
	public ResponseDetails softDelete(Integer agentId);
	
	AgentDetails prepareAgentDetailsEntity(AgentDetailsDTO agentDetailsDTO);
	AgentDetailsDTO prepareAgentDetailsDTO(AgentDetails AgentDetails);
	
}
