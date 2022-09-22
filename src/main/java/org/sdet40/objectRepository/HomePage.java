package org.sdet40.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage{
	//declaration
	public class homePage {
		 @FindBy (xpath="//p[contains(text(),'ADMIN')]") private WebElement adminComponent;
		 @FindBy(xpath="//p[contains(text(),'Add Admin')]") private WebElement clickOnAddAdmin;
		 
		 
		public homePage(WebDriver driver)
		{
		 PageFactory.initElements(driver, this); 
		}
		 public void adminClickAction() {
		  adminComponent.click();
		  clickOnAddAdmin.click();
		 }
	}

	public void adminClickAction() {
		// TODO Auto-generated method stub
		
	}
}

		



