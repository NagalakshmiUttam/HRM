package org.sdet40.GenericUtility;

public interface IconstantPath {
	 // variable method name=camelCase
	 // interface, classname ,enum,annotation=PascalCase
	 // static final member = CAPITAL

	 String PROJECT_PATH = System.getProperty("user.dir");
	 String EXCEL_PATH = PROJECT_PATH + "/src/test/resources/Worksheet.xlsx";
	 String PROPERTY_FILE_PATH = PROJECT_PATH + "/src/test/resources/Commondata.Properties";
	 String DB_URL="jdbc:mysql://localhost:3306/tyss";
	 String PHOTO_PATH=PROJECT_PATH + "/src/test/resources/photo";

	}

