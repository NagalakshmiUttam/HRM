package TestNG;

import org.sdet40.GenericUtility.BaseClassTestNG;
import org.sdet40.objectRepository.TabNames;
import org.testng.annotations.Test;

public class CreateBranchTest extends BaseClassTestNG {
	@Test
	public void createBranch() {
		common.clickRequiredTabforBranches(TabNames.BRANCH, webdriverUtility, driver);
		
		createbranch.CreateBranchAction(branchname);
	}

}
