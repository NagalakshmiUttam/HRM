package org.sdet40.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRM_hrHeadAutomation_TC

{

public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/HRM_System");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("hr_email")).sendKeys("hrhead@gmail.com");
		driver.findElement(By.name("hr_password")).sendKeys("hrhead@123");
		
		 WebElement ele= driver.findElement(By.id("hr_type"));
		 Select s=new Select(ele);
		 s.selectByVisibleText("→ HR Head");
         driver.findElement(By.name("login_hr")).click();
         Thread.sleep(3000);
         
         Alert a=driver.switchTo().alert();
         a.accept();
         
          WebElement ele1=driver.findElement(By.xpath("(//a[@class='nav-link'])[5]"));
          Actions a1=new Actions(driver);
          a1.moveToElement(ele1);
          ele1.click();
          
          
          WebElement ele2 = driver.findElement(By.xpath("//a[@href='Add_braches.php']"));
           Actions a2=new Actions(driver);
           a2.moveToElement(ele2);
           ele2.click();
           
          driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Mysore JPnagar");
        		  
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
           driver.findElement(By.xpath("(//input[@name='branches_name'])[20]")).sendKeys("Mysore main");
          driver.findElement( By.xpath("(//button[text()='Update'])[10]")).click();
          
}

}
         