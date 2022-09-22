package org.sdet40.practice;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.FileUtility;
import org.sdet40.GenericUtility.IconstantPath;
import org.sdet40.GenericUtility.JavaUtility;
import org.sdet40.GenericUtility.WebDriverUtility;
import org.sdet40.objectRepository.HomePage;
//import org.sdet40.objectRepository.CommonPag
import org.sdet40.objectRepository.LoginPage;
//import org.sdet40.GenericUtility.fileUtility;



public class AutomatedTCusingPOM  {

	public static void main(String[] args, String newPhnNum) throws EncryptedDocumentException, IOException, AWTException {

		  WebDriverUtility webdriverUtil = new WebDriverUtility();
		  JavaUtility javaUtil = new JavaUtility();
		  ExcelUtility excelutil = new ExcelUtility();
		  FileUtility fileUtil = new FileUtility();

		  //initializing the execl paath
		  excelutil.initializeExcel(IconstantPath.EXCEL_PATH);
		  
		  //Excel data 
		  String username = excelutil.getDataFromExcel("CommonData1",1,1);
		  String password = excelutil.getDataFromExcel("CommonData1",2,1);
		  String url = excelutil.getDataFromExcel("CommonData1",0,1);
		  String browser = excelutil.getDataFromExcel("CommonData1",3,1);
		 
		  WebDriver driver = webdriverUtil.openBrowserWithApplication(browser, 3, url);

		// Initialize all object repository class
		  LoginPage loginPage = new LoginPage(driver);

		  // script--->test steps
		  loginPage.loginAction(username, password);
		  loginPage.hrtype();
		  loginPage.login();
		  webdriverUtil.alertPopup(driver);
		  HomePage hm=new HomePage();
		  //commonPage common=new commonPage(driver);
		  //common.clickRequiredTab( TabNames.CORPORATE, webdriverUtil);
		  hm.adminClickAction(); 
		  
		 
	}
}

		

