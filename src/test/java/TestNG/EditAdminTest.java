package TestNG;

import java.awt.AWTException;
import java.io.IOException;

import org.sdet40.GenericUtility.BaseClassTestNG;
import org.sdet40.objectRepository.TabNames;
import org.testng.annotations.Test;

public class EditAdminTest extends BaseClassTestNG {
	@Test
	public void editAdminTest() throws IOException, AWTException {
	common.clickRequiredTabforBranches(TabNames.ADMIN, webdriverUtility, driver);
	editAdminPage.editingAdminPhoneNumber(oldPhnNum, newPhnNum);
	webdriverUtility.alertPopup(driver);
	webdriverUtility.screenShot(driver,javaUtil,Classname);
	
	webdriverUtility.screenShot(driver,sjavautility,className);
	}
	
	

}

