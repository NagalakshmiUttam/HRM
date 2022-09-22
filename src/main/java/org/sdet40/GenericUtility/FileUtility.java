package org.sdet40.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
 Properties property;
 String key;

 /*
  * This method is used to initialize property file
  */
 public void initializepropertyFile(String propertFilePth) {
  
  FileInputStream fis = null;
  try {
   fis = new FileInputStream(propertFilePth);
  } catch (FileNotFoundException e) {

   e.printStackTrace();
  }
  property = new Properties();
  try {
   property.load(fis);
  } catch (IOException e) {
   
   e.printStackTrace();
  }

}
 public String getDataFrompropertyFile(String key) {
  return property.getProperty(key);
 }


public void robotAction() throws AWTException {
	Robot r=new Robot();
    r.keyPress(KeyEvent.VK_CONTROL);
    r.keyPress(KeyEvent.VK_MINUS);
    r.keyPress(KeyEvent.VK_MINUS);
    
    r.keyRelease(KeyEvent.VK_CONTROL);
    r.keyRelease(KeyEvent.VK_MINUS);
    r.keyRelease(KeyEvent.VK_MINUS);
    
}
public String getDataFromProprtyFile(String propertyFilePath, String string) {
	// TODO Auto-generated method stub
	return null;
}

}



	