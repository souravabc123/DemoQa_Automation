package reusable_Components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	/**
	 *  Returns the Locator Value of the Web Object 
	 * @param locatorFile
	 * @param locator
	 * @return
	 */
	public static String getProperty(String locatorFile,String locator){
		Properties prop = null;
		String file = Constants.propertyFiles_Path+locatorFile+".properties";
		try {
		FileInputStream fis= new FileInputStream(file);
		prop = new Properties();
			prop.load(fis);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return prop.getProperty(locator); 
		
		
	}
}
