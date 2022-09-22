package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelMethodChaining {

	public static void main(String[] args) throws IOException {
		
		//convert the data into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		
		//open excel workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		try {
			//method chaining
			Sheet sheet = wb.getSheet("CommonData");
			String url = sheet.getRow(0).getCell(1).getStringCellValue();
			String username = sheet.getRow(1).getCell(1).getStringCellValue();
			String password = sheet.getRow(2).getCell(1).getStringCellValue();
			
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
		}
		 finally {
			 wb.close();
		 }
		

	}

}
