package TestNG;



import java.awt.AWTException;

import org.sdet40.GenericUtility.BaseClassTestNG;
import org.sdet40.objectRepository.TabNames;
import org.testng.annotations.Test;


public class DeleteAdminTest extends BaseClassTestNG {
	
	@Test
	public void DeleteAdminTest() throws AWTException {
	common.clickRequiredTabforBranches(TabNames.ADMIN, webdriverUtility, driver);
	delete.deleteAdminPage(adminName,javaUtil);
	webdriverUtility.alertPopup(driver);

}
}
