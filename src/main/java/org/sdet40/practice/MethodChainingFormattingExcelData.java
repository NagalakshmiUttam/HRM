package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MethodChainingFormattingExcelData {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
		try
		{
			Sheet sheet = wb.getSheet("Sheet3");
			Cell cell = sheet.getRow(0).getCell(0);
			String data = df.formatCellValue(cell);
			System.out.println(data);
			
		}
		finally
		{
			wb.close();
		}
		
	}

}
