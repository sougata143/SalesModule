package com.aspl.org.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.aspl.org.dto.MarketingDetailsDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CrawleyQuotationReportGenerator {

	///////////////// GENERATED PDF PATH ///////////////////////////////////////////////////////////////////////////////////////////
	static Date date = new java.util.Date();
	
	static long time = date.getTime();
	
	static int randNum = (int) ((int) Math.random() + time);
	
	static String fileName = "crawley-quotation-report";
	
	//public static final String RESULT = "D:/ABHIRUP/emcee_workspace/erpa-v2/src/main/webapp/WEB-INF/pdf/" + fileName + "_" + randNum + ".pdf";
	
	public static final String RESULT = "D:/ABHIRUP/emcee_workspace/erpa-v2/src/main/webapp/WEB-INF/crawley-report/purchase/" + fileName + ".pdf";

	///////////////// HEADER CONSTANT /////////////////////////////////////////////////////////////////////////////////////////////
	
	static String companyName		= "CRAWLEY & RAY (FOUNDERS AND ENGINEERS) PRIVATE LTD.";
	static String compAddress   	= "32, Foreshore Road, Howrah - 711103, West Bengal";
	static String phoneNo			= "(033) 26684845";
	static String faxNo				= "(033) 26680487";
	static String emailId			= "crawnray@vsnl.com";	
	static String reportName 		= "QUOTATION / OFFER";
	
	static String partyNameAdd    	= "To,\n" + 
									  "M/s. WELLWORTH ENGINEERING CORPN \n" + 
								      "640/11 NAROTTAM BUILDING \n" + 
									  "KAPASIA BAZAR \n" + 
									  "AHMEDABAD - 380002 \n" + 
									  "GUJRAT";
	
	static String messageBody      	= "Dear Sir,\n\n" +  
			                          "We acknowledge with thanks the receipts of your above mentioned enquiry and have pleasure in submitting our Quotation/Offer letter for the follwing subject to the terms and conditions below and over leaf.";

	static String AnnexureText     = "We look forward to receive your valued order which will take our best \n" + 
									  "attention all times if you need any more clarification/information please do not hesitate to write to us. \n\n" + 
									  "Thanking You,";


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
//		PdfPTable descriptionTableHead = createDescriptionTableHead();
//		document.add(descriptionTableHead);
//		
//		PdfPTable listItems = createDescriptionTable();
//		document.add(listItems);
//
//		PdfPTable totalValue = createTotalValue();
//		document.add(totalValue);
//		
//		PdfPTable packageValue = createPackageValue();
//		document.add(packageValue);
//		
//		PdfPTable taxEightPercentValue = createTaxEightPercentValue(); 
//		document.add(taxEightPercentValue);
//		  
//		PdfPTable taxTwoPercentValue = createTaxTwoPercentValue(); 
//		document.add(taxTwoPercentValue);
//		 
//		PdfPTable taxOnePercentValue = createTaxOnePercentValue();
//		document.add(taxOnePercentValue);
//		
//		PdfPTable cstValue = createCSTValue();
//		document.add(cstValue);
//		
//		PdfPTable grandTotalLine = createGrandTotalLine();
//		document.add(grandTotalLine);
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
//		PdfPTable packingValueLine = createPackingValueLine();
//		document.add(packingValueLine);
//		
//		PdfPTable jurisdictionLine = createJurisdictionLine();
//		document.add(jurisdictionLine);
//		
//		PdfPTable remarksLine = createRemarksLine();
//		document.add(remarksLine);
//		
//		PdfPTable notesLine = createNotesLine();
//		document.add(notesLine);
//		
//		PdfPTable annexureLine = createAnnexureLine();
//		document.add(annexureLine);
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
			para_1.add(new Chunk(reportName, Font9Bold));
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
	
	public static PdfPTable createHeader2(String customerName, String address1, String address2, String city, String state, String country, String customerCode, 
			String contactPerson, String quotationCode, Date quotationDate, Date validity) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[]{8, 2, 2});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(customerName, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(address1, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(address2, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(city + ", " + state, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(country, Font9));
			para_1.add(Chunk.NEWLINE);
			
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.TOP);
			cell_1.setFixedHeight(60f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Our Ref", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Date", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Validity", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Customer Ref", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Date", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Kind Attn.", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setFixedHeight(60f);
			cell_1.setBorder(Rectangle.TOP);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(": "+quotationCode, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+String.valueOf(quotationDate).split("\\s")[0], Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+ String.valueOf(validity).split("\\s")[0], Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+customerCode, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+String.valueOf(quotationDate).split("\\s")[0], Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk(": "+contactPerson, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setFixedHeight(60f);
			cell_1.setBorder(Rectangle.TOP | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	
	public static PdfPTable createHeader3(String message) throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(message, Font9));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			//cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(50f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createHeader4(String productType) throws DocumentException {
		PdfPTable table = new PdfPTable(3);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[]{3, (float)1.5, 8});
		
		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Specification / Product Type", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.LEFT);
			cell_1.setFixedHeight(40f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_2:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(": "+productType, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.NO_BORDER);
			cell_1.setFixedHeight(40f);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		cell_3:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(2);
			cell_1.setBorder(Rectangle.RIGHT);
			cell_1.setFixedHeight(40f);
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
	
	public static PdfPTable createDescriptionTableHead() throws DocumentException {
		PdfPTable dataTable = new PdfPTable(9);

		dataTable.setTotalWidth(550);
		dataTable.setLockedWidth(true);
		dataTable.setWidths(new float[]{1, (float)2.5, (float)2.5, 1, 2, 1, 1, 1, 1});
		
		String[] headersLabels = {"SL NO","Item Code","Item Description","Grade","Drawing No","Unit","Quantity","Rate \n(Rs.)","Total \n(Rs.)"};
		
		for (int index = 0; index < headersLabels.length ; index++) {
			
    		PdfPCell cell;
			
			Paragraph headerParagraph = new Paragraph(headersLabels[index], Font7Bold);
			
			cell = new PdfPCell(headerParagraph);
			cell.setPadding(3);
			if(index == 1) {
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			}else if(index == 2) {
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			}
			else{
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			}
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			//cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			
			dataTable.addCell(cell);
			
		}
		
		return dataTable;
	}
	
	public static PdfPTable createDescriptionTable(Integer sl, String itemCode, String itemName, Integer drawingNo, String unit, Double qnt, Double unitPrice, Double total) throws DocumentException {
		PdfPTable dataTable = new PdfPTable(9);

		dataTable.setTotalWidth(550);
		dataTable.setLockedWidth(true);
		dataTable.setWidths(new float[]{1, (float)2.5, (float)2.5, 1, 2, 1, 1, 1, 1});
		
		PdfPCell cell;
		
		////////////// ITEM DETAILS ////////////////////////////////////
		///////////////////////////////////////////////////////////////
		
//		for(int i=1; i<=20; i++) {
			
			cell_1: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(sl + "", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_2: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(""+itemCode, Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_3: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(""+itemName, Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_4: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk("", Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_5: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(""+drawingNo, Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_6: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(""+unit, Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_7: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(""+qnt, Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_8: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(""+unitPrice, Font7));
				cell = new PdfPCell(para_2);
				cell.setPadding(4);
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				dataTable.addCell(cell);
			
			}
			
			cell_9: {
				
				Paragraph para_2 = new Paragraph();
				para_2.add(new Chunk(""+total, Font7));
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
	
	public static PdfPTable createTotalValue(Double totalValueD) throws DocumentException {
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
			para_1.add(new Chunk("Total ", Font8Bold));
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
			para_1.add(new Chunk(": ", Font8Bold));
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
			para_1.add(new Chunk(String.valueOf(totalValueD), Font8Bold));
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
	
	public static PdfPTable createPackageValue(Double pkgValue) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font7Bold));
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
			para_1.add(new Chunk("Package Value", Font7Bold));
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
			para_1.add(new Chunk(" : ", Font7Bold));
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
			para_1.add(new Chunk(String.valueOf(pkgValue), Font7Bold));
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
	
	public static PdfPTable createTaxEightPercentValue(Double taxEightPercent) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font7Bold));
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
			para_1.add(new Chunk("@ 8.00 %", Font7Bold));
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
			para_1.add(new Chunk(":", Font7Bold));
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
			para_1.add(new Chunk(String.valueOf(taxEightPercent), Font7Bold));
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
	
	public static PdfPTable createTaxTwoPercentValue(Double taxTwoPercent) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font7Bold));
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
			para_1.add(new Chunk("@ 2.00 %", Font7Bold));
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
			para_1.add(new Chunk(":", Font7Bold));
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
			para_1.add(new Chunk(String.valueOf(taxTwoPercent), Font7Bold));
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
	
	public static PdfPTable createTaxOnePercentValue(Double taxOnePercent) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font7Bold));
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
			para_1.add(new Chunk("@ 1.00 %", Font7Bold));
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
			para_1.add(new Chunk(":", Font7Bold));
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
			para_1.add(new Chunk(String.valueOf(taxOnePercent), Font7Bold));
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
	
	public static PdfPTable createCSTValue() throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font7Bold));
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
			para_1.add(new Chunk("CST 2% @2.00%", Font7Bold));
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
			para_1.add(new Chunk(":", Font7Bold));
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
			para_1.add(new Chunk("48600.00", Font7Bold));
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
	
	public static PdfPTable createGrandTotalLine(Double grandTotal) throws DocumentException {
		PdfPTable table = new PdfPTable(4);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {10, (float) 2.5, (float) 0.5, 2});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("", Font7Bold));
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
			para_1.add(new Chunk("Grand Total", Font7Bold));
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
			para_1.add(new Chunk(":", Font7Bold));
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
			para_1.add(new Chunk(String.valueOf(grandTotal), Font7Bold));
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
	
	public static PdfPTable createPayTermsLine(String payTerms) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {(float)1.5, 8});

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
			para_1.add(new Chunk(" : "+payTerms, Font7));
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
		table.setWidths(new float[] {(float)1.5, 8});

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
			para_1.add(new Chunk(" : "+deliveryTerms, Font7));
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
		table.setWidths(new float[] {(float)1.5, 8});

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
			para_1.add(new Chunk(" : "+shippingMethod, Font7));
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
		table.setWidths(new float[] {(float)1.5, 8});

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
			para_1.add(new Chunk(" : "+payMethod, Font7));
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
	
	public static PdfPTable createPackingTypeLine() throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {(float)1.5, 8});

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
			para_1.add(new Chunk(" : Crate", Font7));
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
	
	public static PdfPTable createPackingValueLine() throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {(float)1.5, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Packing Value ", Font7Bold));
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
			para_1.add(new Chunk(" : 554.00", Font7));
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
		table.setWidths(new float[] {(float)1.5, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Jurisdiction ", Font7Bold));
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
			para_1.add(new Chunk(" : "+jurisdiction, Font7));
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
	
	public static PdfPTable createRemarksLine(String remarks) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {(float)1.5, 8});

		PdfPCell cell_1;

		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Remarks ", Font7Bold));
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
			para_1.add(new Chunk(" : "+remarks, Font7));
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
			para_1.add(new Chunk("Marketing Annexture :", Font8Bold));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);
			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(4);
			cell_1.setFixedHeight(20f);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_1);
			
		}
		
		return table;
	}
	
	public static PdfPTable createNotesLine1(java.util.List<MarketingDetailsDTO> marketing) throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[]{1});
		
		PdfPCell cell_1;
		
		Paragraph para_1 = new Paragraph();
		/*para_1.add(new Chunk("Creches", Font10));
		para_1.add(Chunk.NEWLINE);
		para_1.setSpacingBefore(10);
		para_1.setSpacingAfter(10);*/
		if(!marketing.isEmpty()) {
			for(MarketingDetailsDTO market : marketing) {
				para_1.add(new Chunk(market.getTerms(), Font7));
				para_1.add(new Chunk("  :  ", Font8Bold));
				para_1.add(new Chunk(market.getDescription(), Font7));
				para_1.add(Chunk.NEWLINE);
			}
		}else {
			para_1.add(new Chunk("", Font8Bold));
			para_1.add(Chunk.NEWLINE);
		}
		
		cell_1 = new PdfPCell(para_1);
		cell_1.setPaddingTop(5);
		cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell_1.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell_1);
		
		return table;
	}
	
	public static PdfPTable createAnnexureLine() throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1});

		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk(AnnexureText, Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setFixedHeight(60f);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
	public static PdfPTable createSignatureLine() throws DocumentException {
		PdfPTable table = new PdfPTable(1);

		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new float[] {1});

		PdfPCell cell_1;
		
		cell_1:{
			
			Paragraph para_1 = new Paragraph();
			para_1.add(new Chunk("Yours Faithfully,", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.add(Chunk.NEWLINE);
			para_1.add(new Chunk("Authorized Signatory", Font8));
			para_1.add(Chunk.NEWLINE);
			para_1.setSpacingBefore(10);
			para_1.setSpacingAfter(10);

			cell_1 = new PdfPCell(para_1);
			cell_1.setPadding(3);
			cell_1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
			cell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_1.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell_1);
			
		}

		return table;
	}
	
}
