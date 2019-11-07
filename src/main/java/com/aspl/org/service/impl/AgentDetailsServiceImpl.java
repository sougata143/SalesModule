package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.AgentDetailsDTO;
import com.aspl.org.entity.AgentDetails;
import com.aspl.org.entity.ResponseDetails;
import com.aspl.org.repository.AgentDetailsRepository;
import com.aspl.org.service.AgentDetailsService;


@Service
@Transactional
public class AgentDetailsServiceImpl implements AgentDetailsService {

	@Autowired
	AgentDetailsRepository agentRepo;
	
	@Override
	public List<AgentDetailsDTO> getAllAgents() {
		List<AgentDetailsDTO> agentDTOs = new ArrayList<>();
		
		try {
			List<AgentDetails> agents = agentRepo.findByStatus(1);
			for(AgentDetails ag : agents) {
				AgentDetailsDTO agDTO = prepareAgentDetailsDTO(ag);
				agentDTOs.add(agDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return agentDTOs;
	}

	@Override
	public AgentDetailsDTO getAgentDetailsById(Integer agentId) {
		AgentDetailsDTO agDTO = new AgentDetailsDTO();
		try {
			AgentDetails agent = agentRepo.findById(agentId).get();
			agDTO = prepareAgentDetailsDTO(agent);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return agDTO;
	}

	@Override
	public ResponseDetails saveAgentDetails(AgentDetailsDTO agentDetailsDTO) {
		try {
			AgentDetails agent = prepareAgentDetailsEntity(agentDetailsDTO);
			
			//Generating agentCode start
			/*String agentCode = "";
			Long agentCount = agentRepo.count(); //getting total number of indents currently present in the indent table
			
			DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime()); //Getting the current year's last two digits
//			(formattedDate);
			Integer currYear = Integer.valueOf(formattedDate);
			Integer nextYear = currYear+1;
			agentCode = "AGT/"+(agentCount+1)+"/"+currYear+"-"+nextYear;*/
			//Generating agentCode end
			
			agent.setStatus(1);
			agent.setAgentCode(agentDetailsDTO.getAgentCode());
			
			agentRepo.save(agent);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "successfully saved agent", "200");
	}

	@Override
	public ResponseDetails updateAgentDetailsDTO(AgentDetailsDTO agentDetailsDTO) {
		try {
			AgentDetails agent = prepareAgentDetailsEntity(agentDetailsDTO);
			agentRepo.save(agent);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "successfully saved agent", "200");
	}

	@Override
	public ResponseDetails softDelete(Integer agentId) {
		try {
		AgentDetails agent = agentRepo.findById(agentId).get();
			agent.setStatus(0);
			agentRepo.save(agent);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDetails(new Date(), "successfully saved agent", "200");
	}
	
	@Override
	public AgentDetailsDTO prepareAgentDetailsDTO(AgentDetails AgentDetails) {
		AgentDetailsDTO agentDTO = new AgentDetailsDTO();
		
		try {
			agentDTO.setAgentCity(AgentDetails.getAgentCity());
			agentDTO.setAgentCode(AgentDetails.getAgentCode());
			agentDTO.setAgentCommission(AgentDetails.getAgentCommission());
			agentDTO.setAgentId(AgentDetails.getAgentId());
			agentDTO.setAgentName(AgentDetails.getAgentName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return agentDTO;
	}
	
	@Override
	public AgentDetails prepareAgentDetailsEntity(AgentDetailsDTO agentDetailsDTO) {
		AgentDetails agent = new AgentDetails();
		
		try {
			
			if(agentDetailsDTO.getAgentId()!=null) {
				agent = agentRepo.findById(agentDetailsDTO.getAgentId()).get();
			}
			
			agent.setAgentCity(agentDetailsDTO.getAgentCity());
			agent.setAgentCommission(agentDetailsDTO.getAgentCommission());
			agent.setAgentName(agentDetailsDTO.getAgentName());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return agent;
	}


}
