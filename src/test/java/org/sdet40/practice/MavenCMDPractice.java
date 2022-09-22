package org.sdet40.practice;

import org.openqa.selenium.WebDriver;
import org.sdet40.GenericUtility.WebDriverUtility;
import org.testng.annotations.Test;

public class MavenCMDPractice {
	@Test 
	public void test1() {
		String browser=System.getProperty("browser");
		String url=System.getProperty("url");
		WebDriverUtility webdriver=new WebDriverUtility();
		WebDriver driver = webdriver.launchBrowser(browser);
		webdriver.maximizeBrowser(driver);
		webdriver.navigateApplication(driver,url);
		webdriver.waitTillPageLoads(driver,10l);
		
		
	}

}
