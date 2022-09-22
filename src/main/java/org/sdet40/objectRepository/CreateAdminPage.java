package org.sdet40.objectRepository;


	import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.WebDriverUtility;
	/**
	 * 
	 * @author Nagalakshmi S
	 *
	 */
	public class CreateAdminPage {
	  WebDriver driver;
	  
	  @FindBy(xpath = "//button[contains(text(),'Add Admin')]")
	  private WebElement addAdminButton;
	  
	  @FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_companyid']")
	  private WebElement companyIdButton;
	  
	  @FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_firstname']")
	  private WebElement firstNameButton;
	  
	  @FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_middlename']")
	  private WebElement middleNameButton;

	  @FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_lastname']")
	  private WebElement lastNameButton;
	  
	  @FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_contactno']")
	  private WebElement contactNoButton;
	  
	  @FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//select[@name='hr_type']")
	  private WebElement positionButton;
	  
	  @FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_email']")
	  private WebElement emailButton;
	  
	  @FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_password']")
	  private WebElement passwordButton;
	  
	  @FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']/following::button[@name='hr_admin']")
	  private WebElement saveButton;
	  
	  @FindBy(xpath="//div[@class='card-body']//div[@id='example_length']/following::th[text()='HR CompanyID']/following::td[text()='1006']")
	  private WebElement actualvalue;
	  
	  @FindBy(xpath="//a[text()='Next']")
	  private WebElement nextbutton;
	  
	  public CreateAdminPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
	  }
	  

//	  public void creatingNwAdmin(String compid, String firsname, String lastname, String midname, String contactnum,
//	    String email, String password, WebDriverUtility webdriver) {
//	   addAdminButton.click();
//	   companyIdButton.sendKeys(compid);
//	   firstNameButton.sendKeys(firsname);
//	   lastNameButton.sendKeys(lastname);
//	   middleNameButton.sendKeys(midname);
//	   contactNoButton.sendKeys(contactnum);

	  public Map<String, String> addAdminDetails(WebDriverUtility webdriverutil, ExcelUtility excelutil) throws EncryptedDocumentException, IOException{
		  addAdminButton.click();
		  Map<String, String> map=excelutil.getDataFromExcelBasedonKey("Sheet1","NewAdmin");
		  companyIdButton.sendKeys(map.get("companyId"));
		  firstNameButton.sendKeys(map.get("firstName"));
		  lastNameButton.sendKeys(map.get("lastName"));
		  middleNameButton.sendKeys(map.get("midName"));
		  contactNoButton.sendKeys(map.get("contactNum"));
	   webdriverutil.dropDownList(positionButton, "→ HR Head");
	   emailButton.sendKeys(map.get("email"));
	   passwordButton.sendKeys(map.get("userpassword"));
	   saveButton.click();
	   return map;
	   
	  }


	public WebElement getActualvalue() {
		return actualvalue;
	}


	public void setActualvalue(WebElement actualvalue) {
		this.actualvalue = actualvalue;
	}


	
	}
	

	
		


	
	
	 
	


