package org.sdet40.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Nagalakshmi S
 *
 */
public class JavaUtility {

 /**
  * This method is used to generate random numbers
  * @param limit
  * @return
  */
 public int getRandonNumber(int limit) {
  return new Random().nextInt(limit);
 }
 /**
  * This method is used to convert String to any data type
  * 
  * @param data
  * @return
  * @return
  */
 public Object convertStringToAnyDataType(String data, DataType strategy) {
  Object obj = null;
  if (strategy.toString().equalsIgnoreCase("long")) {
   obj = Long.parseLong(data);
  }
  if (strategy.toString().equalsIgnoreCase("double")) {
   obj = Double.parseDouble(data);
  }
  if (strategy.toString().equalsIgnoreCase("int")) {
   obj = Integer.parseInt(data);
  }
  return obj;
 }
 /**
  * This method is used to Robot class actions 
  * @throws AWTException
  */
 public void robotAction() throws AWTException {
  Robot r = new Robot();
  r.keyPress(KeyEvent.VK_CONTROL); // give control to keyboard so it will click
  r.keyPress(KeyEvent.VK_MINUS); // ctrl+ minus button 2 times
  r.keyPress(KeyEvent.VK_MINUS);

  r.keyRelease(KeyEvent.VK_CONTROL);
  r.keyRelease(KeyEvent.VK_MINUS);
  r.keyRelease(KeyEvent.VK_MINUS);
 }
 /**
  * This method is to set the date format for screenShot
  * @return
  */
 public String currentTime() {
	 Date date=new Date();
	 SimpleDateFormat sdf=new SimpleDateFormat("dd_mm_yyyy_hh_mm_sss");
	 String actualDate=sdf.format(date);
	 return actualDate;
	 
 }

}

