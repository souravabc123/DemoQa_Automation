/**
 * 
 */
package test_Scripts;

import org.openqa.selenium.WebElement;

import reusable_Components.Base_Test;
import reusable_Components.PropertyFile;
import reusable_Components.WebDriverUtilities;

/**
 * @author Sourav
 *
 */
public class TC_01_Get_AboutUS_Content_AndDisplay extends WebDriverUtilities {

	public static String LocatorFile="homepage";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Step 1 Launch Browser
		launchBrowser(chromebrowser);
		
		//Step 2 Go To URL 
		navigateToPage();
		
		//Step 3 Verify if About Us is Displayed or not
		
		WebElement About_Us_Header = findElementByXpath(PropertyFile.getProperty(LocatorFile, "about_us_header_xpath"));
		waitForElement(About_Us_Header);
		if (verifyElementIsDisplayed(About_Us_Header)) 
			System.out.println("PASS: About Us is displayed");
		else
			System.out.println("FAIL: About Us is not displayed");
		
		//Step 4 Get The data displayed in About Us and show in console
		System.out.println("Header : " +showtext(About_Us_Header));
		WebElement About_Us_Content = findElementByXpath(PropertyFile.getProperty(LocatorFile, "about_us_content_xpath"));
		System.out.println("Data : " +showtext(About_Us_Content));

		
		//Step 5 Close the Browser
		quitBrowser();
	}

}
