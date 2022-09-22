package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyfile {

	public static void main(String[] args) throws IOException {
		//step1 convert physical file into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/Commondata.properties");
		
		//step2 create object for the property file
		Properties property=new Properties();
		
		//step 3 load all the keys
		property.load(fis);
		
		//fetch the data
		//String url=property.getProperty("url").trim();
		//String browser=property.getProperty("browser").trim();
		//String un = property.getProperty("username");
			
	//System.out.println(url);
	//System.out.println(browser);
    //System.out.println(un.trim());
		
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Commondata.properties",true);
		property.store(fos,"url address updated");
	}

}
