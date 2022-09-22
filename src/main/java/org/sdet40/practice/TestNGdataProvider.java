package org.sdet40.practice;

import org.sdet40.GenericUtility.BaseClassTestNG;
import org.sdet40.GenericUtility.WebDriverUtility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGdataProvider {
	@Test(dataProvider="bookticketTest")
	public void bookticket(String src, String dest, int ticket) {
		System.out.println("From " + src + " To " +dest);
		}

	@DataProvider
	public Object[][] bookticketTest(){
	Object[][] objArr=new Object[5][3];
	objArr[0][0]="Banglore";
	objArr[0][1]="Mysore";
	objArr[0][2]=10;
	
	objArr[1][0]="Banglore";
	objArr[1][1]="Goa";
	objArr[1][2]=10;
	
	objArr[2][0]="Banglore";
	objArr[2][1]="Udupi";
	objArr[2][2]=10;
	
	objArr[3][0]="Banglore";
	objArr[3][1]="Manglore"; 
	objArr[3][2]=10;
	
	objArr[4][0]="Banglore";
	objArr[4][1]="Chitradurga";
	objArr[4][2]=10;
	return objArr;
	
}
	}
