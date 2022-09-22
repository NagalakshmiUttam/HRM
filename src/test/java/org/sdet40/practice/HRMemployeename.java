package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.sdet40.GenericUtility.BaseClassTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMemployeename extends BaseClassTestNG {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TC.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		String username=sheet.getRow(1).getCell(1).toString();
		String password = sheet.getRow(1).getCell(2).toString();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//sdriver=driver;
		
		
		driver.get("https://rmgtestingserver/domain/HRM_System");
		driver.findElement(By.xpath("//a[text()='HRM_System/']")).click(); //inspect HRM link on server
		driver.findElement(By.name("hr_email")).sendKeys(username);
		driver.findElement(By.name("hr_password")).sendKeys(password);
		WebElement ele = driver.findElement(By.id("hr_type"));
		Select s=new Select(ele);
		s.selectByVisibleText("→ HR Head");
		driver.findElement(By.name("login_hr")).click();
		
		
		//webdriverUtility.screenShot(driver,sjavautility,Classname);
		
		
		
	}

}
