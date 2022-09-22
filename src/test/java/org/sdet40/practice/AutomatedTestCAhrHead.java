package org.sdet40.practice;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sdet40.GenericUtility.BaseClassTestNG;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.FileUtility;
import org.sdet40.GenericUtility.IconstantPath;
import org.sdet40.GenericUtility.JavaUtility;
import org.sdet40.GenericUtility.WebDriverUtility;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AutomatedTestCAhrHead extends BaseClassTestNG{
	@Test
		public void hrheadTest() throws EncryptedDocumentException, IOException, AWTException {
			
			  WebDriverUtility webdriverUtil = new WebDriverUtility();
			  JavaUtility javaUtil = new JavaUtility();
			  ExcelUtility excelutil = new ExcelUtility();
			  FileUtility fileUtil = new FileUtility();
			  excelutil.initializeExcel(IconstantPath.EXCEL_PATH);
			  String username = fileUtil.getDataFromProprtyFile(IconstantPath.PROPERTY_FILE_PATH,"username");
			  String password = fileUtil.getDataFromProprtyFile(IconstantPath.PROPERTY_FILE_PATH,"password");
			  String url = fileUtil.getDataFromProprtyFile(IconstantPath.PROPERTY_FILE_PATH,"url");
			  String browser=fileUtil.getDataFromProprtyFile(IconstantPath.PROPERTY_FILE_PATH,"browser");
			  

			  
			  
			  String searchvalue = excelutil.getDataFromExcel( "Sheet1", 1, 3);
			  String newvalue = excelutil.getDataFromExcel( "Sheet1", 1, 4);
			  
			  // WebDriverUtility.launchBrowser(browser);

			  WebDriver driver = webdriverUtil.openBrowserWithApplication(browser, 3, url);

			  driver.findElement(By.name("hr_email")).sendKeys(username);
			  driver.findElement(By.name("hr_password")).sendKeys(password);
			 

			  WebElement ele = driver.findElement(By.id("hr_type"));
			  webdriverUtil.dropDownList(ele, "→ HR Head");

			  driver.findElement(By.name("login_hr")).click();
			  

			  webdriverUtil.alertPopup(driver);

			  driver.findElement(By.xpath("//p[contains(text(),'ADMIN')]")).click();
			  

			  driver.findElement(By.xpath("//p[contains(text(),'Add Admin')]")).click();

			  driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(searchvalue);

			  fileUtil.robotAction();
			  

			  driver.findElement(By.xpath("//i[@class='fa fa-edit']")).click(); // click on edit icon
			  driver.findElement(By.xpath("//input[@value='+9663870389']")).clear(); // clear the data present in the field
			  driver.findElement(By.xpath("//input[@value='+9663870389']")).sendKeys(newvalue); // to write new value

			  driver.findElement(By.xpath("//button[@name='hr_admin']")).click();

			  webdriverUtil.alertPopup(driver);

			  webdriverUtil.closeBrowser(driver);
			 }

	
	
	
	

			



	}


