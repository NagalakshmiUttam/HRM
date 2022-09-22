package org.sdet40.GenericUtility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.sdet40.objectRepository.CommonPage;
import org.sdet40.objectRepository.CreateAdminPage;
import org.sdet40.objectRepository.CreateBranchPage;
import org.sdet40.objectRepository.DeleteAdminPage;
import org.sdet40.objectRepository.EditAdminPage;
import org.sdet40.objectRepository.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClassTestNG {
 
 //Declaration of all the utility class references
 protected WebDriverUtility webdriverUtility;
 protected ExcelUtility excelutil;
 protected FileUtility fileUtil;
 protected JavaUtility javaUtil;
 protected WebDriver driver;
 public static JavaUtility sjavautility; //screenshot
 public static WebDriver sdriver; //screenshot
 protected EditAdminPage editAdminPage;
 protected CreateBranchPage createbranch;
 protected DeleteAdminPage delete;
 protected CreateAdminPage create;
 protected LoginPage log;
 protected CommonPage common;
 protected String url;
 protected String username;
 protected String password;
 private String browser;
 private String timeout;
 protected String oldPhnNum;
 protected String newPhnNum;
 protected Map<String,String> map;
 protected String Classname; //screenshot
 protected String companyId;
 protected String firstName;
 protected String lastName;
 protected String midName;
 protected String email;
 protected String userpassword;
 protected String contactnum;
 protected String branchname;
 public String adminName;
 protected String className;
 
 /**
  * Initializing all the
  * 
  * @throws IOException
  * @throws EncryptedDocumentException
  * 
  */
 @BeforeClass
 public void ClassSetup() throws EncryptedDocumentException, IOException {
  // create instance for the Generic Utility
  webdriverUtility = new WebDriverUtility();
  javaUtil = new JavaUtility();
  sjavautility=javaUtility();
  excelutil = new ExcelUtility();
  fileUtil = new FileUtility();
  
  create = new CreateAdminPage(driver);
  delete=new DeleteAdminPage(driver);
  createbranch = new CreateBranchPage(driver);
  
  
  sdriver=driver;
  
  fileUtil.initializepropertyFile(IconstantPath.PROPERTY_FILE_PATH);
  url = fileUtil.getDataFrompropertyFile("url");
  browser = fileUtil.getDataFrompropertyFile("browser");
  username = fileUtil.getDataFrompropertyFile("username");
  password = fileUtil.getDataFrompropertyFile("password");
  timeout =fileUtil.getDataFrompropertyFile("timeout");
  
  long wait=(long) javaUtil.convertStringToAnyDataType(timeout, DataType.LONG);
  driver = webdriverUtility.openBrowserWithApplication(browser, wait, url);
  
  excelutil.initializeExcel(IconstantPath.EXCEL_PATH);
  oldPhnNum = excelutil.getDataFromExcel("Sheet1", 1, 3);
  newPhnNum = excelutil.getDataFromExcel("Sheet1", 1, 4);
  companyId = excelutil.getDataFromExcel("Sheet1", 6, 1);
  firstName = excelutil.getDataFromExcel("Sheet1", 7, 1);
  midName = excelutil.getDataFromExcel("Sheet1", 8, 1);
  lastName = excelutil.getDataFromExcel("Sheet1", 9, 1);
  contactnum = excelutil.getDataFromExcel("Sheet1", 10, 1);
  email = excelutil.getDataFromExcel("Sheet1", 11, 1);
  userpassword = excelutil.getDataFromExcel("Sheet1", 12, 1); 
  adminName=excelutil.getDataFromExcel("Sheet1", 14, 1);
  branchname=excelutil.getDataFromExcel("Sheet1",15,1);
 
 }

 private JavaUtility javaUtility() {
	// TODO Auto-generated method stub
	return null;
}

@BeforeMethod
 public void methodsetUp() {
  editAdminPage = new EditAdminPage(driver);
  log = new LoginPage(driver);
  log.loginAction(username,password);
  log.hrtype();
  log.login();
  webdriverUtility.alertPopup(driver);
  common = new CommonPage(driver);
  
 }

 @AfterMethod
 public void methodTearDown() throws FileNotFoundException, IOException {
 common.signOut(driver);
 excelutil.saveDataIntoExcel(browser);
 }

 @AfterClass
 public void classTeardown() throws IOException {
 webdriverUtility.closeBrowser(driver);
 excelutil.closeExcelWorkBoook();
 }

}