package com.aspl.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dto.AgentEnquiryQuotationSalesOrderMappingDTO;
import com.aspl.org.entity.AgentEnquiryQuotationSalesOrderMapping;
import com.aspl.org.repository.AgentEnquiryQuotationSalesOrderMappingRepository;
import com.aspl.org.service.AgentEnquiryQuotationSalesOrderMappingService;

@Service
@Transactional
public class AgentEnquiryQuotationSalesOrderMappingServiceImpl
		implements AgentEnquiryQuotationSalesOrderMappingService {

	@Autowired
	AgentEnquiryQuotationSalesOrderMappingRepository agentMappingRepo;
	
	@Override
	public List<AgentEnquiryQuotationSalesOrderMappingDTO> getAllMapping() {
		List<AgentEnquiryQuotationSalesOrderMappingDTO> agentDTOs = new ArrayList<>();
		try {
			List<AgentEnquiryQuotationSalesOrderMapping> agents = agentMappingRepo.findByIsActive(1);
			for(AgentEnquiryQuotationSalesOrderMapping agent : agents) {
				AgentEnquiryQuotationSalesOrderMappingDTO agentDTO = prepareAgentEnquiryQuotationSalesOrderMappingDTO(agent);
				agentDTOs.add(agentDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return agentDTOs;
	}

	/*@Override
	public List<AgentEnquiryQuotationSalesOrderMappingDTO> getMappingByEnquiryId(String enquiryCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<AgentEnquiryQuotationSalesOrderMappingDTO> getMappingQuotationId(String quotationCode) {
			return null;
	}
	
	@Override
	public List<AgentEnquiryQuotationSalesOrderMappingDTO> getMappingSalesOrderId(String salesOrderCode) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	@Override
	public AgentEnquiryQuotationSalesOrderMapping saveAgentEnquiryQuotationSalesOrderMapping(
			AgentEnquiryQuotationSalesOrderMappingDTO agentEnquiryQuotationSalesOrderMapping) {
		
		AgentEnquiryQuotationSalesOrderMapping agent = new AgentEnquiryQuotationSalesOrderMapping();
		try {
			agent = prepareAgentEnquiryQuotationSalesOrderMappingEntity(agentEnquiryQuotationSalesOrderMapping);
			agentMappingRepo.save(agent);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return agent;
	}

	@Override
	public AgentEnquiryQuotationSalesOrderMapping updateAgentEnquiryQuotationSalesOrderMapping(
			AgentEnquiryQuotationSalesOrderMappingDTO agentEnquiryQuotationSalesOrderMapping) {
		
		AgentEnquiryQuotationSalesOrderMapping agent = new AgentEnquiryQuotationSalesOrderMapping();
		try {
			agent = prepareAgentEnquiryQuotationSalesOrderMappingEntity(agentEnquiryQuotationSalesOrderMapping);
			agentMappingRepo.save(agent);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return agent;
	}

	@Override
	public AgentEnquiryQuotationSalesOrderMappingDTO prepareAgentEnquiryQuotationSalesOrderMappingDTO(
			AgentEnquiryQuotationSalesOrderMapping agent) {
		
		AgentEnquiryQuotationSalesOrderMappingDTO agentDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
		
		agentDTO.setAgentId(agent.getAgentId());
		agentDTO.setAgentMappingId(agent.getAgentMappingId());
		agentDTO.setEnquiryCode(agent.getEnquiryCode());
		agentDTO.setIsActive(agent.getIsActive());
		agentDTO.setQuotationCode(agent.getQuotationCode());
		agentDTO.setSalesOrderCode(agent.getSalesOrderCode());
		
		return agentDTO;
	}

	@Override
	public AgentEnquiryQuotationSalesOrderMapping prepareAgentEnquiryQuotationSalesOrderMappingEntity(
			AgentEnquiryQuotationSalesOrderMappingDTO agentDTO) {
		
		AgentEnquiryQuotationSalesOrderMapping agent = new AgentEnquiryQuotationSalesOrderMapping();
		
		if(agentDTO.getAgentMappingId()!=null) {
			agent = agentMappingRepo.findById(agentDTO.getAgentMappingId()).get();
		}
		
		agent.setAgentId(agentDTO.getAgentId());
		agent.setAgentMappingId(agentDTO.getAgentMappingId());
		agent.setEnquiryCode(agentDTO.getEnquiryCode());
		agent.setIsActive(agentDTO.getIsActive());
		agent.setQuotationCode(agentDTO.getQuotationCode());
		agent.setSalesOrderCode(agentDTO.getSalesOrderCode());
		
		return agent;
	}

	@Override
	public List<AgentEnquiryQuotationSalesOrderMappingDTO> getMappingByCodeAndType(String code, String type) {
		
		List<AgentEnquiryQuotationSalesOrderMappingDTO> agentMappingDTOs = new ArrayList<>();
		try {
			List<AgentEnquiryQuotationSalesOrderMapping> agentMappings = new ArrayList<>();
			
			if(type.equalsIgnoreCase("enquiry"))
				agentMappings = agentMappingRepo.findByEnquiryCode(code);
			if(type.equalsIgnoreCase("quotation"))
				agentMappings = agentMappingRepo.findByQuotationCode(code);
			if(type.equalsIgnoreCase("salesOrder"))
				agentMappings = agentMappingRepo.findBySalesOrderCode(code);
			
			for(AgentEnquiryQuotationSalesOrderMapping agent : agentMappings) {
				AgentEnquiryQuotationSalesOrderMappingDTO agentMappingDTO = prepareAgentEnquiryQuotationSalesOrderMappingDTO(agent);
				agentMappingDTOs.add(agentMappingDTO);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return agentMappingDTOs;
	}

	@Override
	public AgentEnquiryQuotationSalesOrderMappingDTO getMappingByMappingId(Integer mappingId) {
		
		AgentEnquiryQuotationSalesOrderMappingDTO agentDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
		try {
			AgentEnquiryQuotationSalesOrderMapping agent = agentMappingRepo.findById(mappingId).get();
			agentDTO = prepareAgentEnquiryQuotationSalesOrderMappingDTO(agent);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return agentDTO;
	}

	@Override
	public AgentEnquiryQuotationSalesOrderMappingDTO getMappingByCodeAndTypeAndAgentId(String code, String type,
			Integer agentId) {
		AgentEnquiryQuotationSalesOrderMappingDTO agentMappingDTO = new AgentEnquiryQuotationSalesOrderMappingDTO();
		List<AgentEnquiryQuotationSalesOrderMappingDTO> agentMappingDTOs = new ArrayList<>();
		try {
			List<AgentEnquiryQuotationSalesOrderMapping> agentMappings = new ArrayList<>();
			AgentEnquiryQuotationSalesOrderMapping agentMapping = new AgentEnquiryQuotationSalesOrderMapping();
			
			if(type.equalsIgnoreCase("enquiry")) {
				agentMappings = agentMappingRepo.findByEnquiryCodeAndAgentId(code, agentId);
				if(!agentMappings.isEmpty()) {
					agentMapping = agentMappings.get(0);
				}
			}
			if(type.equalsIgnoreCase("quotation")) {
				agentMappings = agentMappingRepo.findByQuotationCodeAndAgentId(code, agentId);
				if(!agentMappings.isEmpty()) {
					agentMapping = agentMappings.get(0);
				}
			}
			if(type.equalsIgnoreCase("salesOrder")) {
				agentMappings = agentMappingRepo.findBySalesOrderCodeAndAgentId(code, agentId);
				if(!agentMappings.isEmpty()) {
					agentMapping = agentMappings.get(0);
				}
			}
			
			agentMappingDTO = prepareAgentEnquiryQuotationSalesOrderMappingDTO(agentMapping);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return agentMappingDTO;
	}

}
