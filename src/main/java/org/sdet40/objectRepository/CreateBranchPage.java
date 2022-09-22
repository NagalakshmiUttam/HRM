package org.sdet40.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateBranchPage {
	@FindBy (xpath="//button[contains(. ,'Add Branches')]")
	private WebElement addBranchButton;
	
	@FindBy(xpath="//div[@id='modal-overlay']//div[@class='modal-header']/following::form[@action='process/addbranches_process.php']//input[@name='branches_name']")
	private WebElement branchNameTextField;
	
	@FindBy (xpath="//button[text()='Save']")
	private WebElement branchsaveButton;
	
	public CreateBranchPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	public void CreateBranchAction(String branchname) {
		addBranchButton.click();
		branchNameTextField.sendKeys(branchname);
		branchsaveButton.click();
		
		
	}
	
	

}
