package org.sdet40.GenericUtility;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	/**
	 * This method is used to get screenshot of failed testcase
	 * @param driver
	 */
	
		public void getScreenshot(WebDriver driver) {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(IconstantPath.PHOTO_PATH+".png");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}





