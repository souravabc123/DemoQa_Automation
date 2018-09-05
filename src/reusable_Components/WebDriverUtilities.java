/**
 * 
 */
package reusable_Components;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sourav
 *
 */
public class WebDriverUtilities implements Constants {

	
	public static WebDriver driver;
	
	//Resuable Methods
	
	public static void launchBrowser(String browser){
		
		switch (browser){
		
		case "chrome": 	System.setProperty(chromedriver_property, chromeDriver_Path);
						driver = new ChromeDriver();
						driver.manage().window().maximize();
						System.out.println("Launched " +browser.toUpperCase());
						break;				
					
		}
		
	}
	public static void navigateToPage(){
		System.out.println("Opening PAGE with URL : " + Constants.url);
		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
		driver.get(Constants.url);
	}
	public static void quitBrowser(){
		if(driver!=null){
			driver.quit();
			System.out.println( "Closed the browser");
		}
	}
	
	
	
	public static void type(WebElement element,String data){
		clear(element);
		element.sendKeys(data);
		System.out.println("Typed to : "+element);

		
	}
	
	public static void clear(WebElement element){
		waitForElement(element);
		element.clear();
		System.out.println("Cleared  : "+element);

	}
	
	public static void click(WebElement element){
		waitForElement(element);
		element.click();
		System.out.println("Clicked on : "+element);
	}
	
	public static String showtext(WebElement element){
		if (verifyElementIsDisplayed(element)) {
			return element.getText().trim();
			
		}
		else
			return null;
		
	}
	
	public static void waitForElement(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, TimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void Wait(int time){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean verifyElementIsDisplayed(WebElement element){
		if(element.isDisplayed())
			return true;
		else
			return false;
		
	}
	

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
