package org.sdet40.practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sdet40.GenericUtility.BaseClassTestNG;
import org.sdet40.GenericUtility.WebDriverUtility;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenderpopup1 extends BaseClassTestNG {

	@Test
	public void Calenderpopup1() throws IOException {
		
		String requireddate = "24";
		String requiredmonth = "June";
		String requiredyear = "2024";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverUtility webdriverUtility = new WebDriverUtility();//screenshot not coming
		sdriver=driver;//screenshot not coming
		
		
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		String actualmonthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String []str = actualmonthyear.split(" ");
		String actualmonth = str[0];
		String actualyear = str[1];
		
		while(! (requiredmonth.equals(actualmonth)&&requiredyear.equals(actualyear))) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			actualmonthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = actualmonthyear.split(" ");
			actualmonth = str[0];
			actualyear = str[1];
			
		}
		driver.findElement(By.xpath("//a[text()='"+requireddate+"']")).click();
		
		webdriverUtility.screenShot(driver, sjavautility,getClass().getSimpleName());
		//screenshot not coming
	}
	
	

}

