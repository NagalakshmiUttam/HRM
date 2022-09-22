package org.sdet40.practice;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.FileUtility;
import org.sdet40.GenericUtility.IconstantPath;
import org.sdet40.GenericUtility.JavaUtility;
import org.sdet40.GenericUtility.WebDriverUtility;

	public class AutomatedTestCaseEditAdmin  {

	 public static void main(String[] args) throws EncryptedDocumentException, IOException, AWTException {

	  WebDriverUtility webdriverUtil = new WebDriverUtility();
	   JavaUtility javaUtil = new JavaUtility();
	   ExcelUtility excelutil = new ExcelUtility();
	   FileUtility fileUtil = new FileUtility();
	   WebDriver driver=null;
	   String url=null;
	   String browser=null;
	   String username=null;
	   String password=null;
	   fileUtil.initializepropertyFile(IconstantPath.PROPERTY_FILE_PATH);
	  url= fileUtil.getDataFrompropertyFile("url");
	  browser= fileUtil.getDataFrompropertyFile("browser");
	  driver=webdriverUtil.openBrowserWithApplication(browser, 3, url);
	  username= fileUtil.getDataFrompropertyFile("username");
	  password= fileUtil.getDataFrompropertyFile("password");
	  
	  excelutil.initializeExcel(IconstantPath.EXCEL_PATH);
	  String oldPhnNum=excelutil.getDataFromExcel("Sheet1", 1, 3);
	  String newPhnNum=excelutil.getDataFromExcel("Sheet1", 1, 4);

	  driver.findElement(By.name("hr_email")).sendKeys(username);
	  driver.findElement(By.name("hr_password")).sendKeys(password);

	  WebElement ele = driver.findElement(By.id("hr_type"));
	  webdriverUtil.dropDownList(ele, "→ HR Head");

	  driver.findElement(By.name("login_hr")).click();

	  webdriverUtil.alertPopup(driver);

	  driver.findElement(By.xpath("//p[contains(text(),'ADMIN')]")).click();

	  driver.findElement(By.xpath("//p[contains(text(),'Add Admin')]")).click();
	  
	  driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(oldPhnNum);

	  javaUtil.robotAction();

	  driver.findElement(By.xpath("//i[@class='fa fa-edit']")).click(); // click on edit icon
	  driver.findElement(By.xpath("//input[@value='+9663870389']")).clear(); // clear the data present in the field
	  driver.findElement(By.xpath("//input[@value='+9663870389']")).sendKeys(newPhnNum); // to write new value

	  driver.findElement(By.xpath("//div[@class='modal fade show']/descendant::button[@name='hredit_admin']")).click();
	    

	//  String expected = driver.findElement(By.xpath("//td[text()='+9035346156'])[2]")).toString();
	//  webdriverUtil.alertPopup(driver);
	//  
	//  if(expected.equals(newPhnNum)) {
	//   System.out.println("TC pass");
	//  }
	//  else
	//  {
	//   System.out.println("Tc faile");
	//  }
	  
	  driver.findElement(By.xpath("//b[.='Welcome!,']")).click();
	  driver.findElement(By.xpath("//a[@href=\"log_out.php\"]")).click();
	 }

	}


