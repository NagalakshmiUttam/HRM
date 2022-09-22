package org.sdet40.practice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetcgDataBasedOnKeyINExcelUsingWhile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("CommonData");
		DataFormatter df=new DataFormatter();
		String value=null;//to make it global variable because we cannot access local variable
		int i=0;
		while(i<=sheet.getLastRowNum()) {
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(key.equalsIgnoreCase("os"))
			{
				 value=df.formatCellValue(sheet.getRow(i).getCell(1));
				 break;
	
			}
		
			i++;
		}
		
			System.out.println(value);
		
	}
	

}
