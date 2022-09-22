package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {



	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("MakeMyTrip");
		String fromCityCode = sheet.getRow(3).getCell(0).getStringCellValue();
		String toCityCode = sheet.getRow(3).getCell(1).getStringCellValue();
		
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/");
		//driver.findElement(By.xpath("//span[@class='chNavText darkGreyText']/preceding::span[@class='chNavIcon appendBottom2 chSprite chFlights active']")).click();
		//WebElement ele = driver.findElement(By.xpath("//span[text()='From']"));
		
		//driver.findElement(By.xpath("//span[text()='From']")).click();
		 //List<WebElement> ele = driver.findElements(By.xpath("(//div[@class='calc60'])[1]"));
		 
		 //driver.findElement(By.xpath("//body[@class='desktop in webp']")).click();
		//String fromCityCode1="BOM";
		//String toCityCode1="DEL";		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromCityCode);
		driver.findElement(By.xpath("//div[text()='"+fromCityCode+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(toCityCode);
		driver.findElement(By.xpath("//div[text()='"+toCityCode+"']")).click();
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("By.xpath(\"//div[text()='\"+toCityCode+\"']\")).click();");
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		
		
		}

}
