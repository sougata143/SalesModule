package com.aspl.org.report.service.impl;

/***/
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspl.org.dto.QuotationDetailsReportDTO;
import com.aspl.org.dto.QuotationReportDTO;
import com.aspl.org.report.CrawleyQuotationReportGenerator;
import com.aspl.org.report.service.QuotationReportService;
import com.aspl.org.service.SalesReportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class QuotationReportServiceImpl implements QuotationReportService {

	static Date date = new java.util.Date();
	static long time = date.getTime();
	static int randNum = (int) ((int) Math.random() + time);
	String fileName = "invReport";

	@Autowired
	SalesReportService salesReportService;
	
	@Override
	public Map<String, Object> getQuotationReport(HttpServletRequest request, String quotationId, String message) {

		Map<String, String> param = new HashMap<String, String>();
		Map<String, Object> returnData = new HashMap<String, Object>();

		String RESULT_FILE = request.getServletContext().getRealPath("resources/static/pdf");

		
		try {

			Document document = new Document();

			document.setPageSize(PageSize.A4);
			document.setMargins(15, 15, 15, 15);

			PdfWriter writer;
//			System.out.println("Result path "+RESULT_FILE);
			try {
				writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdf/crawley_quotation_report" + ".pdf"));
//				writer = PdfWriter.getInstance(document, new FileOutputStream("/home/pdf/crawley_quotation_report" + ".pdf"));
				writer.setPdfVersion(PdfWriter.VERSION_1_7);

			} catch (DocumentException e1) {

				e1.printStackTrace();

			} catch (IOException e1) {

				e1.printStackTrace();

			}

			document.open();

			QuotationReportDTO report = new QuotationReportDTO();
			List<QuotationDetailsReportDTO> reportLines = new ArrayList<>();

			if (!quotationId.isEmpty() || quotationId != null || quotationId != "") {

				report = salesReportService.getQuotationReport(Integer.valueOf(quotationId));
				reportLines = report.getQuotationItems();

			}

			boolean newPage = true;

			
			int lineindex = 0;

			

			//if (numberOfPage <= 1) {

				/////////////////////////// For Single Page ///////////////////////
				document.newPage();

				///////////////// TAX INVOICE TITLE ////////////////////////

				// INVOICE TITLE
				
				// Header 1
				PdfPTable headerTable1 = CrawleyQuotationReportGenerator.createHeader1();
				document.add(headerTable1);

				String contactPerson = "";
				
				if(report.getCustomer().getContactDetails()!=null) {
					if(!report.getCustomer().getContactDetails().isEmpty()) {
						contactPerson = report.getCustomer().getContactDetails().get(0).getContactPerson();
					}
				}
				
				// Header 2
				PdfPTable headerTable2 = CrawleyQuotationReportGenerator.createHeader2(
							report.getCustomer().getCustomerName(),
							report.getCustomer().getAddress1(),
							report.getCustomer().getAddress2(),
							report.getCustomer().getCity(),
							report.getCustomer().getState(),
							report.getCustomer().getCountry(),
							report.getCustomer().getCustomerCode(),
							contactPerson,
							report.getQuotationCode(),
							report.getQuotationDate(),
							report.getValidationDate()
						);
				document.add(headerTable2);
				
				PdfPTable headerTable3 = CrawleyQuotationReportGenerator.createHeader3(
							message
						);
				document.add(headerTable3);
				
				PdfPTable headerTable4 = CrawleyQuotationReportGenerator.createHeader4(
							report.getProductType()
						);
				document.add(headerTable4);
				

				// Description Header
				PdfPTable descHeader = CrawleyQuotationReportGenerator.createDescriptionTableHead();
				document.add(descHeader);
				
				Double totalValueD = 0.0;
				Double taxEightPercent = 0.0;
				Double taxTwoPercent = 0.0;
				Double taxOnePercent = 0.0;
				
				// Description Table
				for (int i = lineindex; i < reportLines.size(); i++) {

					QuotationDetailsReportDTO reportitems = reportLines.get(i);
					
					PdfPTable listItems = CrawleyQuotationReportGenerator.createDescriptionTable(
								(i+1),
								reportitems.getItem().getItemCode(),
								reportitems.getItem().getItemName(),
								reportitems.getDrawingNo(),
								reportitems.getUnit(),
								reportitems.getQty(),
								reportitems.getUnitPrice(),
								reportitems.getTotal()
							);

					document.add(listItems);
					
					if(reportitems.getTotal()!=null)
						totalValueD = totalValueD + reportitems.getTotal();
					
				}
				
				if(totalValueD!=0.0) {
					taxEightPercent = (totalValueD/100)*8;
					taxTwoPercent = (totalValueD/100)*2;
					taxOnePercent = (totalValueD/100)*1;
				}
				
				Double grandTotal = 0.0;
				if(taxOnePercent!=null && taxTwoPercent!=null && taxEightPercent!=null && totalValueD != null)
					grandTotal = taxOnePercent + taxTwoPercent + taxEightPercent + totalValueD;
				
				//Basic value section 
				PdfPTable totalValue = CrawleyQuotationReportGenerator.createTotalValue(totalValueD);
				document.add(totalValue);

				PdfPTable packageValue = CrawleyQuotationReportGenerator.createPackageValue(report.getPkg());
				document.add(packageValue);
				
				PdfPTable taxEightPercentValue = CrawleyQuotationReportGenerator.createTaxEightPercentValue(taxEightPercent); 
				document.add(taxEightPercentValue);
				  
				PdfPTable taxTwoPercentValue = CrawleyQuotationReportGenerator.createTaxTwoPercentValue(taxTwoPercent); 
				document.add(taxTwoPercentValue);
				 
				PdfPTable taxOnePercentValue = CrawleyQuotationReportGenerator.createTaxOnePercentValue(taxOnePercent);
				document.add(taxOnePercentValue);
				
//				PdfPTable cstValue = CrawleyQuotationReportGenerator.createCSTValue();
//				document.add(cstValue);
				
				PdfPTable grandTotalLine = CrawleyQuotationReportGenerator.createGrandTotalLine(grandTotal);
				document.add(grandTotalLine);
				
				PdfPTable payTermsLine = CrawleyQuotationReportGenerator.createPayTermsLine(report.getPaymentTerms());
				document.add(payTermsLine);
				
				PdfPTable deliveryTermsLine = CrawleyQuotationReportGenerator.createDeliveryTermsLine(report.getDeliveryTerms());
				document.add(deliveryTermsLine);
				
				PdfPTable shippingModeLine = CrawleyQuotationReportGenerator.createShippingModeLine(report.getShippingMethod());
				document.add(shippingModeLine);
				
				PdfPTable paymentMethodLine = CrawleyQuotationReportGenerator.createPaymentMethodLine(report.getPaymentMethod());
				document.add(paymentMethodLine);
				
				PdfPTable packingTypeLine = CrawleyQuotationReportGenerator.createPackingTypeLine();
				document.add(packingTypeLine);
				
				PdfPTable packingValueLine = CrawleyQuotationReportGenerator.createPackingValueLine();
				document.add(packingValueLine);
				
				PdfPTable jurisdictionLine = CrawleyQuotationReportGenerator.createJurisdictionLine(report.getJurisdiction());
				document.add(jurisdictionLine);
				
				String remarks = "";
				if(!reportLines.isEmpty()) {
					remarks = reportLines.get(0).getRemarks();
				}
				PdfPTable remarksLine = CrawleyQuotationReportGenerator.createRemarksLine(remarks);
				document.add(remarksLine);
				
				PdfPTable notesLine = CrawleyQuotationReportGenerator.createNotesLine(
							
						);
				document.add(notesLine);
				
				PdfPTable notesLine1 = CrawleyQuotationReportGenerator.createNotesLine1(
						report.getMarketing()
					);
			document.add(notesLine1);
				
				PdfPTable annexureLine = CrawleyQuotationReportGenerator.createAnnexureLine();
				document.add(annexureLine);
				
				PdfPTable signatureLine = CrawleyQuotationReportGenerator.createSignatureLine();
				document.add(signatureLine);
				

			//} else {}

			document.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		returnData.put("fileName", "crawley_purchase_order.pdf");
		returnData.put("status", true);
		
		return returnData;
	}

	

}
