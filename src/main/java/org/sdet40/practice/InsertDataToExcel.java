package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1: convert physical file into java readable object
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/Book1.xlsx");
		//step2: open excel workbook
		Workbook wb = WorkbookFactory.create(fisExcel);
		
		//step3: get control on sheet
		Sheet sheet = wb.getSheet("Sheet2");
		
		//step4: get control on row for new row
		 Row row = sheet.getRow(7);//createRow() will delete other data of same row and change old data to given data
		 
		 //step5: create the cell
		 Cell cell = row.getCell(2);
		 
		 //step6: update the status/set the data
		 cell.setCellValue("fail");
		 FileOutputStream fos=new FileOutputStream("./src/test/resources/Book1.xlsx");
		 
		 //write data into excel
		 wb.write(fos);
		 System.out.println("Data updated successfully");
		 
		 //step8: close the workbook
		 wb.close();
	}

}
