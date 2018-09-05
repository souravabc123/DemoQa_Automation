/**
 * 
 */
package reusable_Components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Sourav
 *
 */
public class FindElement extends WebDriverUtilities {
	
	public static WebElement findElementByXpath(String XpathValue){
		
		if(!XpathValue.isEmpty())
			return driver.findElement(By.xpath(XpathValue.trim()));
		else
			return null;
	}
	
	public static List<WebElement> findElementsByXpath(String XpathValue){
		if(!XpathValue.isEmpty())
			return driver.findElements(By.xpath(XpathValue.trim()));
		else
			return null;
	}
	
	public static WebElement findElementbyCSSSelector(String CssValue){
		if(!CssValue.isEmpty())
			return driver.findElement(By.cssSelector(CssValue.trim()));
		else
			return null;
	}
	
	public static void findElementByLink(){}

}
