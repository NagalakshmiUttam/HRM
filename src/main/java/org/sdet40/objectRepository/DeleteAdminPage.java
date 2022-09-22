package org.sdet40.objectRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.GenericUtility.JavaUtility;


public class DeleteAdminPage {
	WebDriver driver;
	@FindBy(xpath="//input[@Class='form-control form-control-sm']")
	private WebElement searchField;
	
	@FindBy (xpath="//table[@id='example']/tbody/tr[1]/td/i[@class='fa fa-trash']")
	private WebElement deleteIcon;
	
	@FindBy(name="delete_admin")
	private WebElement deleteButton;
	
	public DeleteAdminPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	public void deleteAdminPage(String adminName, JavaUtility javautil) throws AWTException {
		searchField.sendKeys(adminName);
		javautil.robotAction();
		deleteIcon.click();
		deleteButton.click();
	}

}
