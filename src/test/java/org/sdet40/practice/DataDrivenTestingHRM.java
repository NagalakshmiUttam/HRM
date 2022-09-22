package org.sdet40.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTestingHRM {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TC.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("sheet1");
		String username = sheet.getRow(1).getCell(1).toString();
		String password = sheet.getRow(1).getCell(2).toString();
		String searchdata = sheet.getRow(1).getCell(3).toString();
		String newvalue = sheet.getRow(1).getCell(4).toString();	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/");
		driver.findElement(By.xpath("//atext()='HRM_System/")).click();//inspec hrm on server
		driver.findElement(By.name("hr_email")).sendKeys(username);
		driver.findElement(By.name("hr_password")).sendKeys(password);
		
		WebElement ele = driver.findElement(By.id("hr_type"));
		Select s=new Select(ele);
		s.selectByVisibleText("→ HR Head");
		driver.findElement(By.name("login_hr")).click();
		Thread.sleep(5000);
		
		Alert a = driver.switchTo().alert();
		a.accept();
		
		WebElement ele1=driver.findElement(By.xpath("(//a[@class='nav-link'])[5]"));
        Actions a1=new Actions(driver);
        a1.moveToElement(ele1);
        ele1.click();
        
        
        WebElement ele2 = driver.findElement(By.xpath("//a[@href='Add_braches.php']"));
         Actions a2=new Actions(driver);
         a2.moveToElement(ele2);
         ele2.click();
         
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(searchdata);
      		  
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_MINUS);
        r.keyPress(KeyEvent.VK_MINUS);
        
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_MINUS);
        r.keyRelease(KeyEvent.VK_MINUS);
        
        driver.findElement(By.xpath("//button[text()='Edit']")).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("(//input[@type='text'])[20]")).clear();
         driver.findElement(By.xpath("(//input[@name='branches_name'])[20]")).sendKeys(newvalue);
        driver.findElement( By.xpath("(//button[text()='Update'])[10]")).click();
        Thread.sleep(3000);
        
       Alert a21=driver.switchTo().alert();
       a21.accept();
       Thread.sleep(5000);
       driver.close();
        
		
		
		
	}
}
		
		
		
		
		


