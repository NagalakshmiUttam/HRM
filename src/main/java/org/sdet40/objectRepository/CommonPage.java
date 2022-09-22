package org.sdet40.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.GenericUtility.WebDriverUtility;

public class CommonPage {
 @FindBy
 private String dynamicxpath = "//p[contains(.,'%s')]";
 
 @FindBy(xpath = "ADMIN")
 private WebElement corporateButton;
 
 @FindBy (xpath=" //p[.='Add Admin']") 
 private WebElement addadminbutton;
 
 @FindBy(xpath="//p[text()='Add Branches']")
 private WebElement addBranchButton;

 
 @FindBy(xpath="//b[.='Welcome!,']") 
 private WebElement welcomeButton;
 
 @FindBy(xpath = "//a[@href='log_out.php']")
 private WebElement signOutbutton;
 
 // initialization of all elements
 
 public CommonPage(WebDriver driver) {
  
  PageFactory.initElements(driver, this);

 }

 // business library

 public void clickRequiredTabforBranches(TabNames tabName, WebDriverUtility webdriverUtility, WebDriver driver) {
  webdriverUtility.convertDynamicXpathIntoWebElement(dynamicxpath, tabName.getTabName(), driver).click();
  addadminbutton.click();
 }

 public void signOut(WebDriver driver) {
  welcomeButton.click();
  signOutbutton.click();
 }


	
}





