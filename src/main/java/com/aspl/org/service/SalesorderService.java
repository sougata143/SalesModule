package com.aspl.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aspl.org.dto.SalesorderDTO;
import com.aspl.org.entity.ResponseDetails;

@Service
public interface SalesorderService {
	
	ResponseDetails salesorderSave(SalesorderDTO salesorderDTO);
	ResponseDetails salesorderUpdate(SalesorderDTO salesorderDTO);
	
	
	ResponseDetails salesorderAuthorised(SalesorderDTO salesorderDTO);
	ResponseDetails salesorderUnauthorised(SalesorderDTO salesorderDTO);
	
	SalesorderDTO findBySalesorderCode(String salesorderCode);
	SalesorderDTO findBySalesorderId(Integer salesorderId);
	List<SalesorderDTO> getAllSalesorderForAuthorisation();
	List<SalesorderDTO> getAllUnAuthorisedSalesorder();
	List<SalesorderDTO> getAllAuthorisedSalesOrder();
	List<SalesorderDTO> getAllActiveSalesOrder();
	ResponseDetails softDeleteSalesOrder(Integer salesorderId);
	ResponseDetails authoriseSalesorder(SalesorderDTO salesorderDTO);

	//SalesorderDTO prepareSalesorderDTO(Salesorder salesorder);
//	Salesorder prepareSalesorderEntity(SalesorderDTO salesorderDTO);
//	
//	SalesorderDetailsDTO prepareSalesorderDetailsDTO(SalesorderDetails salesorderDetails);
//	SalesorderDetails prepareSalesorderDetailsEntity(SalesorderDetailsDTO salesorderDetailsDTO);
	//SalesorderDTO prepareUnauthorisedSalesorderDTO(Salesorder Salesorder);
	//public ResponseDetails unAuthoriseSalesorder(SalesorderDTO salesorderDTO);
//	SalesorderDTO prepareSalesorderDTO(Salesorder salesorder, String authorization);

}
