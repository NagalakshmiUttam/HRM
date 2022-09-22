package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FetchDataFromExcel {

	public static void main(String[] args) throws IOException {
		// step1: convert physical file into java readable file
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/Book1.xlsx");
		
		//step2: open the excel workbook
		Workbook wb=WorkbookFactory.create(fisExcel);
		
		//step3: get the control on sheet
		//String username = wb.getSheet("CommonData").getRow(1).getCell(1).getStringCellValue();	  	 
	  	
		//System.out.println(username);
		
		//step7: close the workbook
		//wb.close();
		
		//step3: get control on sheet
		 Sheet sheet = wb.getSheet("CommonData");	
		 
		 
		Row row = sheet.getRow(1);
		
		
		Cell cel = row.getCell(1);
		
		
		String usn = cel.getStringCellValue();
		
		System.out.println(usn);
		
		wb.close();
		
		 
		 
		 
		 
	}
}
		
		
		
		
	

	
