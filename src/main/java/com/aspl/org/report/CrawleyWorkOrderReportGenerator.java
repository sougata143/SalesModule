package com.aspl.org.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import com.aspl.org.dto.CustomerMasterDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CrawleyWorkOrderReportGenerator {

	///////////////// GENERATED PDF PATH ///////////////////////////////////////////////////////////////////////////////////////////
	static Date date = new java.util.Date();
	
	static long time = date.getTime();
	
	static int randNum = (int) ((int) Math.random() + time);
	
	static String fileName = "crawley-work-order-report";
	
	//public static final String RESULT = "D:/ABHIRUP/emcee_workspace/erpa-v2/src/main/webapp/WEB-INF/pdf/" + fileName + "_" + randNum + ".pdf";
	
	public static final String RESULT = "D:/ABHIRUP/emcee_workspace/erpa-v2/src/main/webapp/WEB-INF/crawley-report/purchase/" + fileName + ".pdf";

	///////////////// HEADER CONSTANT /////////////////////////////////////////////////////////////////////////////////////////////
	
	static String companyName		= "CRAWLEY & RAY (FOUNDERS AND ENGINEERS) PRIVATE LTD.";
	static String compAddress   	= "32, Foreshore Road, Howrah - 711103, West Bengal";
	static String phoneNo			= "(033) 26684845";
	static String faxNo				= "(033) 26680487";
	static String emailId			= "crawnray@vsnl.com";	
	static String reportName 		= "WORK ORDER";
	
	static String partyNameAdd    	= "M/s SUPRIYA BARUI \n" + 
									  "38/2, BANGLAPARA 1ST BYE LANE, SHIBPUR, \n" + 
									  "HOWRAH - 711104, \n" + 
									  "WEST BENGAL";
	static String billingAdd      	= "Crawley & Ray (Founders and Engineers) Pvt. Ltd.\n" + 
									  "32, Foreshore Road,\n" + 
									  "HOwrah - 711103 \n" + 
									  "West Bengal";
	static String shippingAdd      	= "Crawley & Ray (Founders and Engineers) Pvt. Ltd.\n" + 
			  						  "32, Foreshore Road,\n" + 
			  						  "HOwrah - 711103 \n" + 
			  						  "West Bengal";
	static String notes				= "NEO METALIKS LTD. \n" + 
									  "STATE BANK OF INDIA.\n" + 
									  "COMMERCIAL BRANCH.KOLKATA-16.\n" + 
									  "A/C NO. 30414216418.\n" + 
									  "IFSC NO. SBIN 0007502.";


	///////////////// END OF HEADER CONSTANT //////////////////////////////////////////////////////////////////////////////////////

	///////////////// REQUIRED FONTS //////////////////////////////////////////////////////////////////////////////////////////////
	private static Font Font5 = new Font(Font.FontFamily.HELVETICA, 5, Font.NORMAL);
	private static Font Font5Bold = new Font(Font.FontFamily.HELVETICA, 5, Font.BOLD);
	private static Font Font6 = new Font(Font.FontFamily.HELVETICA, 6, Font.NORMAL);
	private static Font Font6Bold = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD);
	private static Font Font7 = new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL);
	private static Font Font7Bold = new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD);
	private static Font Font8 = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL);
	private static Font Font8Bold = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
	private static Font Font9 = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);
	private static Font Font9Bold = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
	private static Font Font10 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
	private static Font Font10Bold = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
	private static Font Font12Red = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
	private static Font Font12Bold = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	
	public static void main(String[] args) throws DocumentException, IOException {
		
		Document document = new Document();

		document.setPageSize(PageSize.A4);
		document.setMargins(10, 10, 10, 10);

		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));

		writer.setPdfVersion(PdfWriter.VERSION_1_7);

		document.open();
		
//		PdfPTable header1 = createHeader1();
//		document.add(header1);
//		
//		PdfPTable header2 = createHeader2();
//		document.add(header2);
//		
//		PdfPTable header3 = createHeader3();
//		document.add(header3);
//		
//		PdfPTable header4 = createHeader4();
//		document.add(header4);
//		
//		PdfPTable descriptionTableHead1 = createDescriptionTableHead1();
//		document.add(descriptionTableHead1);
//		
//		PdfPTable listItems = createDescriptionTable();
//		document.add(listItems);
//		
//		PdfPTable totalLine = createTotalLine();
//		document.add(totalLine);
//		
//		PdfPTable basicValue = createBasicValue();
//		document.add(basicValue);
//		
//		PdfPTable amtInWordsLine = createAmtInWordsLine();
//		document.add(amtInWordsLine);
//		
//		PdfPTable payTermsLine = createPayTermsLine();
//		document.add(payTermsLine);
//		
//		PdfPTable deliveryTermsLine = createDeliveryTermsLine();
//		document.add(deliveryTermsLine);
//		
//		PdfPTable shippingModeLine = createShippingModeLine();
//		document.add(shippingModeLine);
//		
//		PdfPTable paymentMethodLine = createPaymentMethodLine();
//		document.add(paymentMethodLine);
//		
//		PdfPTable packingTypeLine = createPackingTypeLine();
//		document.add(packingTypeLine);
//		
//		PdfPTable jurisdictionLine = createJurisdictionLine();
//		document.add(jurisdictionLine);
//		
//		PdfPTable notesLine = createNotesLine();
//		document.add(notesLine);
//		
//		PdfPTable signatoryLine = createSignatoryLine();
//		document.add(signatoryLine);
//		
//		/*PdfPTable headerBlankLine = createHeaderBlankLine();
//		document.add(headerBlankLine);*/
//		
//		PdfPTable signatureLine = createSignatureLine();
//		document.add(signatureLine);
		
		document.close();
		
		System.out.println("Report Name : " + reportName + "\nPDF has been generated successfully in this path : \n" + RESULT);
		
	}
	
	public static PdfPTable createHeader1() throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(companyName, Font9Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(compAddress, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Phone : " + phoneNo, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Fax : " + faxNo, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Email : " + emailId, Font8));
			
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(50f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader2() throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(reportName, Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(4);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader3(CustomerMasterDTO customerMasterDTO, String billingAddr, String woCode, Date woDate, Date validityDate, Date deliveryDate,
			Date custPoDate, String custPoNo, String division, String region) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[]{2, 2, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Party Name & Address : \n", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			if(customerMasterDTO!=null) {
				if(customerMasterDTO.getCustomerName()!=null)
					para_1.add(new Chunk(customerMasterDTO.getCustomerName(), Font8));
				else
					para_1.add(new Chunk("", Font8));
				para_1.add(Chunk.NEWLINE);
				
				if(customerMasterDTO.getAddress1()!=null)
					para_1.add(new Chunk(customerMasterDTO.getAddress1(), Font8));
				else
					para_1.add(new Chunk("", Font8));
				
				para_1.add(Chunk.NEWLINE);
				
				if(customerMasterDTO.getAddress2()!=null)
					para_1.add(new Chunk(customerMasterDTO.getAddress2(), Font8));
				else
					para_1.add(new Chunk("", Font8));
				
				para_1.add(Chunk.NEWLINE);
				
				if(customerMasterDTO.getState()!=null)
					para_1.add(new Chunk(customerMasterDTO.getState() + ", ", Font8));
				else
					para_1.add(new Chunk(" ", Font8));
				
				if(customerMasterDTO.getCity()!=null)
					para_1.add(new Chunk(customerMasterDTO.getCity(), Font8));
				else
					para_1.add(new Chunk("", Font8));
				
				para_1.add(Chunk.NEWLINE);
				
				if(customerMasterDTO.getCountry()!=null)
					para_1.add(new Chunk(customerMasterDTO.getCountry(), Font8));
				else
					para_1.add(new Chunk(" ", Font8));
				
				para_1.add(Chunk.NEWLINE);
			}else {
				para_1.add(new Chunk("", Font8));
				para_1.add(Chunk.NEWLINE);
				para_1.add(new Chunk("", Font8));
				para_1.add(Chunk.NEWLINE);
				para_1.add(new Chunk("", Font8));
				para_1.add(Chunk.NEWLINE);
				para_1.add(new Chunk("" + ", ", Font8));
				para_1.add(new Chunk("", Font8));
				para_1.add(Chunk.NEWLINE);
				para_1.add(new Chunk("", Font8));
				para_1.add(Chunk.NEWLINE);
			}
			
			
//			if(customerMasterDTO!=null && !customerMasterDTO.getContactDetails().isEmpty()) {
//				para_1.add(new Chunk("\nKind Attn. : ", Font8Bold));
//				para_1.add(new Chunk(customerMasterDTO.getContactDetails().get(0).getContactPerson(), Font8));
//				para_1.add(Chunk.NEWLINE);
//				para_1.add(new Chunk("Phone : ", Font8Bold));
//				para_1.add(new Chunk(customerMasterDTO.getContactDetails().get(0).getContactNo(), Font8));
//				para_1.add(Chunk.NEWLINE);
//				para_1.add(new Chunk("Fax : ", Font8Bold));
//				para_1.add(new Chunk(customerMasterDTO.getContactDetails().get(0).getFaxNo(), Font9));
//				para_1.add(Chunk.NEWLINE);
//			}else {
				para_1.add(new Chunk("\nKind Attn. : ", Font8Bold));
				para_1.add(new Chunk("", Font8));
				para_1.add(Chunk.NEWLINE);
				para_1.add(new Chunk("Phone : ", Font8Bold));
				para_1.add(new Chunk("", Font8));
				para_1.add(Chunk.NEWLINE);
				para_1.add(new Chunk("Fax : ", Font8Bold));
				para_1.add(new Chunk("", Font9));
				para_1.add(Chunk.NEWLINE);
//			}
			
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(90f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Billing Address : \n", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(billingAddr,Font8));
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(90f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("W/O Ref ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Date ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Validity ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Delv. Date ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Cust PO Dt. ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Cust PO ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Division ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Region ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(90f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(": "+woCode, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+String.valueOf(woDate).split("\\s")[0], Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+String.valueOf(validityDate).split("\\s")[0], Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+String.valueOf(deliveryDate).split("\\s")[0], Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+String.valueOf(custPoDate).split("\\s")[0], Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+custPoNo, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+division, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+region, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(90f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader4(CustomerMasterDTO customerMasterDTO, String type) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1, 1, 1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("LST : ", Font8Bold));
			para_1.add(new Chunk("", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("GST : ", Font8Bold));
			
			if(customerMasterDTO.getGst()!=null)
				para_1.add(new Chunk(customerMasterDTO.getGst(), Font8));
			else
				para_1.add(new Chunk(" ", Font8));
			
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(30f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(30f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Type : ", Font8Bold));
			para_1.add(new Chunk(type, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(30f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeaderBlankLine() throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1});

		PdfPCell cell_1;

		Paragraph para_1 = new Paragraph();
		para_1.add(new Chunk("", Font9Bold));
		para_1.add(Chunk.NEWLINE);
		para_1.setSpacingBefore(10);
		para_1.setSpacingAfter(10);

		cell_1 = new PdfPCell(para_1);
		cell_1.setPadding(2);
		cell_1.setBorder(Rectangle.NO_BORDER);
		cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell_1);

		return table;
	}
	
	public static PdfPTable createDescriptionTableHead1() throws DocumentException {
		PdfPTable dataTable = new PdfPTable(9);

		dataTable.setTotalWidth(550);
		dataTable.setLockedWidth(true);
		dataTable.setWidths(new float[]{(float) 0.5, 2, 3, 1, (float) 0.5, 1, 1, 1, 1});
		
		String[] headersLabels = {"SL NO","Item Code/ Item Name / Cust part Name","Item Description","Quantity","Unit","Each Wt","Total Wt","Rate","Total"};
		
		for (int index = 0; index < headersLabels.length ; index++) {
			
    		PdfPCell cell;
			
			Paragraph headerParagraph = new Paragraph(headersLabels[index], Font7Bold);
			
			cell = new PdfPCell(headerParagraph);
			cell.setPadding(3);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			//cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			
			dataTable.addCell(cell);
			
		}
		
		return dataTable;
	}
	
	public static PdfPTable createDescriptionTable(int j, String itemCode, String itemDescription, String custPartName, Double qunatity, String unit, Double eachWt, String totalWt, Double rate, Double total) throws DocumentException {
		PdfPTable dataTable = new PdfPTable(9);

		dataTable.setTotalWidth(550);
		dataTable.setLockedWidth(true);
		dataTable.setWidths(new float[]{(float) 0.5, 2, 3, 1, (float) 0.5, 1, 1, 1, 1});
		
		PdfPCell cell;
		
		////////////// ITEM DETAILS ////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		
//		for(int i=1; i<=18; i++) {
			
			cell_1: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(j + "", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_2: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(itemCode+" "+custPartName , Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_3: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(itemDescription, Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_4: {
				
				Paragraph para_2 = new Paragraph();
				
				if(String.valueOf(qunatity)!=null)
					para_2.add(new Chunk(String.valueOf(qunatity), Font7));
				else
					para_2.add(new Chunk("", Font7));
				
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_5: {
				
				Paragraph para_2 = new Paragraph();
				if(unit!=null)
					para_2.add(new Chunk(unit, Font7));
				else
					para_2.add(new Chunk("", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_6: {
				
				Paragraph para_2 = new Paragraph();
				
				if(eachWt!=null)
					para_2.add(new Chunk(String.valueOf(eachWt), Font7));
				else
					para_2.add(new Chunk("", Font7));
				
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_7: {
				
				Paragraph para_2 = new Paragraph();
				
				if(totalWt!=null)
					para_2.add(new Chunk(String.valueOf(totalWt), Font7));
				else
					para_2.add(new Chunk("", Font7));
				
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_8: {
				
				Paragraph para_2 = new Paragraph();
				
				if(rate!=null)
					para_2.add(new Chunk(String.valueOf(rate), Font7));
				else
					para_2.add(new Chunk("", Font7));
				
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_9: {
				
				Paragraph para_2 = new Paragraph();
				
				if(qunatity!=null && rate!=null)
					para_2.add(new Chunk(String.valueOf(qunatity*rate), Font7));
				else
					para_2.add(new Chunk(" ", Font7));
				
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
		
//		}

		return dataTable;
	}
	
	public static PdfPTable createTotalLine(Double totalQnt, Double totalWt) throws DocumentException {
		PdfPTable dataTable = new PdfPTable(9);

		dataTable.setTotalWidth(550);
		dataTable.setLockedWidth(true);
		dataTable.setWidths(new float[]{(float) 0.5, 2, 3, 1, (float) 0.5, 1, 1, 1, 1});
		
		PdfPCell cell;
		
		////////////// TOTAL LINE ////////////////////////////////////
		/////////////////////////////////////////////////////////////
					
			cell_1: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk("Total : ", Font7Bold));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setColspan(3);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_2: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(String.valueOf(totalQnt), Font7Bold));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_3: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk("", Font7Bold));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_4: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk("", Font7Bold));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_5: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(String.valueOf(totalWt), Font7Bold));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_6: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk("", Font7Bold));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_7: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk("", Font7Bold));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}

		return dataTable;
	}
	
	public static PdfPTable createBasicValue(Double basicValue) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Basic Value ", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(":", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_4:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(String.valueOf(basicValue), Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createAmtInWordsLine(String amtInWords) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {2, 8});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Amount In Words", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(4);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(" : "+amtInWords, Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createPayTermsLine(String payTerms) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {2, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Pay terms ", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			
			if(payTerms!=null)
				para_1.add(new Chunk(" : "+payTerms, Font7Bold));
			else
				para_1.add(new Chunk(" : ", Font7Bold));
			
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createDeliveryTermsLine(String deliveryTerms) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {2, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Delivery Terms ", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			
			if(deliveryTerms!=null)
				para_1.add(new Chunk(" : "+deliveryTerms, Font7Bold));
			else
				para_1.add(new Chunk(" : ", Font7Bold));
			
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createShippingModeLine(String shippingMethod) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {2, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Shipping Mode ", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			
			if(shippingMethod!=null)
				para_1.add(new Chunk(" : "+shippingMethod, Font7Bold));
			else
				para_1.add(new Chunk(" : ", Font7Bold));
			
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createPaymentMethodLine(String payMethod) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {2, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Payment method ", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			
			if(payMethod!=null)
				para_1.add(new Chunk(" : "+payMethod, Font7Bold));
			else
				para_1.add(new Chunk(" : ", Font7Bold));
			
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createPackingTypeLine(String packingType) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {2, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Packing Type ", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			
			if(packingType!=null)
				para_1.add(new Chunk(" : "+packingType, Font7Bold));
			else
				para_1.add(new Chunk(" : ", Font7Bold));
			
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createJurisdictionLine(String jurisdiction) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {2, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Jurisdiction ", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.BOTTOM | Rectangle.LEFT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			
			if(jurisdiction!=null)
				para_1.add(new Chunk(" : "+jurisdiction, Font7Bold));
			else
				para_1.add(new Chunk(" : ", Font7Bold));
			
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createNotesLine() throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Notes :", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("", Font10Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(4);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createSignatoryLine() throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 1, 1});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Prepared By", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Checked By", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Authorized By", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createSignatureLine() throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1, 1, 1});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Signature", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(45f);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Signature", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(45f);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Signature", Font7Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(45f);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
}
