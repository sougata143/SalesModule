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

import com.aspl.org.dto.WorkOrderReportDTO;
import com.aspl.org.dto.WorkOrderReportDetailsDTO;
import com.aspl.org.report.CrawleyWorkOrderReportGenerator;
import com.aspl.org.report.service.WorkOrderReportService;
import com.aspl.org.service.SalesReportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class WorkOrderReportServiceImpl implements WorkOrderReportService {

	static Date date = new java.util.Date();
	static long time = date.getTime();
	static int randNum = (int) ((int) Math.random() + time);
	String fileName = "invReport";

	@Autowired
	SalesReportService salesReportService;
	
	@Override
	public Map<String, Object> getWorkOrderReport(HttpServletRequest request, String workOrderId) {

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
				writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdf/crawley_work_order" + ".pdf"));
//				writer = PdfWriter.getInstance(document, new FileOutputStream("/home/pdf/crawley_work_order" + ".pdf"));
				writer.setPdfVersion(PdfWriter.VERSION_1_7);

			} catch (DocumentException e1) {

				e1.printStackTrace();

			} catch (IOException e1) {

				e1.printStackTrace();

			}

			document.open();

			WorkOrderReportDTO report = new WorkOrderReportDTO();
			List<WorkOrderReportDetailsDTO> reportLines = new ArrayList<>();

			if (!workOrderId.isEmpty() || workOrderId != null || workOrderId != "") {

				report = salesReportService.getWorkOrderReport(Integer.valueOf(workOrderId));
				reportLines = report.getWorkOrderDetails();

			}

			boolean newPage = true;

			
			int lineindex = 0;

			

			//if (numberOfPage <= 1) {

				/////////////////////////// For Single Page ///////////////////////
				document.newPage();

				///////////////// TAX INVOICE TITLE ////////////////////////

				// INVOICE TITLE
				
				// Header 1
				PdfPTable headerTable1 = CrawleyWorkOrderReportGenerator.createHeader1(
							
						);
				document.add(headerTable1);

				// Header 2
				PdfPTable headerTable2 = CrawleyWorkOrderReportGenerator.createHeader2();
				document.add(headerTable2);
				
				PdfPTable headerTable3 = CrawleyWorkOrderReportGenerator.createHeader3(
							report.getCustomer(),
							report.getBillingAddr(),
							report.getWorkOrderCode(),
							report.getWorkOrderDate(),
							report.getValidateDate(),
							report.getDeliveryDate(),
							report.getCustPoDate(),
							report.getCustPoNumber(),
							report.getDivision(),
							report.getRegion()
						);
				document.add(headerTable3);
				
				PdfPTable headerTable4 = CrawleyWorkOrderReportGenerator.createHeader4(
							report.getCustomer(),
							report.getType()
						);
				document.add(headerTable4);
				

				// Description Header
				PdfPTable descHeader = CrawleyWorkOrderReportGenerator.createDescriptionTableHead1();
				document.add(descHeader);
				
				Double basicTotalValue = 0.0;
				// Description Table
				for (int i = lineindex; i < reportLines.size(); i++) {

					WorkOrderReportDetailsDTO reportitems = reportLines.get(i);
					
					PdfPTable listItems = CrawleyWorkOrderReportGenerator.createDescriptionTable(
								 (i+1),
								 reportitems.getItemCode(),
								 reportitems.getItemDescription(),
								 reportitems.getCustPartName(),
								 reportitems.getQuantity(),
								 reportitems.getUnit(),
								 reportitems.getEachWt(),
								 reportitems.getTotalWt(),
								 reportitems.getRate(),
								 reportitems.getTotal()
							);

					document.add(listItems);

					if(reportitems.getTotal()!=null)
						basicTotalValue = basicTotalValue + reportitems.getTotal();
				}
				
				PdfPTable totalLine = CrawleyWorkOrderReportGenerator.createTotalLine(
							report.getTotalQnt(),
							report.getTotalWt()
						);
				document.add(totalLine);
				
				PdfPTable basicValue = CrawleyWorkOrderReportGenerator.createBasicValue(
							report.getBasicValue()
						);
				document.add(basicValue);
				
				PdfPTable amtInWordsLine = CrawleyWorkOrderReportGenerator.createAmtInWordsLine(report.getAmountInWords());
				document.add(amtInWordsLine);
				
				PdfPTable payTermsLine = CrawleyWorkOrderReportGenerator.createPayTermsLine(report.getPayTerms());
				document.add(payTermsLine);
				
				PdfPTable deliveryTermsLine = CrawleyWorkOrderReportGenerator.createDeliveryTermsLine(report.getDeliveryTerms());
				document.add(deliveryTermsLine);
				
				PdfPTable shippingModeLine = CrawleyWorkOrderReportGenerator.createShippingModeLine(report.getShippingMethod());
				document.add(shippingModeLine);
				
				PdfPTable paymentMethodLine = CrawleyWorkOrderReportGenerator.createPaymentMethodLine(report.getPaymentMethod());
				document.add(paymentMethodLine);
				
				PdfPTable packingTypeLine = CrawleyWorkOrderReportGenerator.createPackingTypeLine(report.getPackingType());
				document.add(packingTypeLine);
				
				PdfPTable jurisdictionLine = CrawleyWorkOrderReportGenerator.createJurisdictionLine(report.getJurisdiction());
				document.add(jurisdictionLine);
				
//				PdfPTable notesLine = CrawleyWorkOrderReportGenerator.createNotesLine();
//				document.add(notesLine);
//				
//				PdfPTable signatoryLine = CrawleyWorkOrderReportGenerator.createSignatoryLine();
//				document.add(signatoryLine);
				
				/*PdfPTable headerBlankLine = createHeaderBlankLine();
				document.add(headerBlankLine);*/
				
//				PdfPTable signatureLine = CrawleyWorkOrderReportGenerator.createSignatureLine();
//				document.add(signatureLine);
				

			//} else {}

			document.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		returnData.put("fileName", "crawley_work_order.pdf");
		returnData.put("status", true);
		
		return returnData;
	}

	

}
