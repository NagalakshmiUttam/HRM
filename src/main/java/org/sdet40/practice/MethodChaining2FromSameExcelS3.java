package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MethodChaining2FromSameExcelS3 
{

	public static void main(String[] args) throws IOException {
		  FileInputStream fis =new  FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		  
		  Workbook wb = WorkbookFactory.create(fis);
		  try
		  {
			  Sheet sheet = wb.getSheet("Sheet1");
			  double data = sheet.getRow(0).getCell(0).getNumericCellValue();
			  int data1 = (int)data;
			  
			  System.out.println(data1);
		  }
			  
			  finally
			  {
			  
				  wb.close();
			  }
		  
			  
			  
		  
		  
	

}
	}

