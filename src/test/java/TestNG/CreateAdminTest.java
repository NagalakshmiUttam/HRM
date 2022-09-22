package TestNG;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.sdet40.GenericUtility.BaseClassTestNG;
import org.sdet40.objectRepository.TabNames;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class CreateAdminTest  extends BaseClassTestNG{
	 @Test

	 public void createAdminTest() throws EncryptedDocumentException, IOException {
	 common.clickRequiredTabforBranches(TabNames.ADMIN, webdriverUtility, driver); 
	 Map<String, String> map=create.addAdminDetails(webdriverUtility,excelutil);
	 webdriverUtility.alertPopup(driver);
	 webdriverUtility.screenShot(driver,javaUtil, Classname);
	 String expected=map.get("Company_Id");
	 String actualvalue=create.getActualvalue().getText();
	 Assert.assertEquals(actualvalue, expected,"values are not macthing");
			  
			  
			  
			 } 
			}




