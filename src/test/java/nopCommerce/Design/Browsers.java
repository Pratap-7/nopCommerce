package nopCommerce.Design;

import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.WebElement;

public interface Browsers {

	/**
	 * This method will launch the Chrome browser and maximise the browser and set
	 * the wait for 30 seconds and load the url
	 * 
	 * @param url - This will load the specified url `
	 */
	public void launchApp(String url, boolean headless);

	/**
	 * This method will launch the specific browser and maximise the browser and set
	 * the wait for 30 seconds and load the url
	 * 
	 * @param url - This will load the specified url `
	 */
	public void launchApp(String browser, String url, boolean headless);

	/**
	 * This method will locate the element using any given locator
	 */
	public WebElement locateElement(Locators LocatorType, String value);

	/**
	 * This method will locate the element using ID locator
	 * @return 
	 */
	public WebElement locateElement(String value);

	/**
	 * This method will locate the list of matching elements using any given locator
	 */
	public List<WebElement> locateElements(Locators LocatorType, String value);

	/**
	 * This method will Switch to Alert
	 */
	public void swithToAlert();

	/**
	 * This method will accept the alert opened
	 */
	public void acceptAlert();

	/**
	 * This method will dismiss the alert opened
	 */
	public void dismissAlert();

	/**
	 * This method will get the text from alert opened
	 */
	public void getAlertText();

	/**
	 * This method will enter the data in the alert opened
	 */
	public void typeAlert(String data);

	/**
	 * This method will Switch to window using index
	 */
	public void switchToWindow(int index);

	/**
	 * This method will Switch to window using title
	 */
	public void switchToWindow(String title);

	/**
	 * This method will Switch to frame using index
	 */
	public void switchToFrame(int index);

	/**
	 * This method will Switch to frame using web element
	 */
	public void switchToFrame(WebElement ele);

	/**
	 * This method will Switch to frame using idOrName
	 */
	public void switchToFrame(String idOrName);

	/**
	 * This method will Switch to first frame on the page
	 */
	public void defaultContent();

	/**
	 * This method will verify the url
	 */
	public boolean verifyurl(String url);

	/**
	 * This method will verify the title
	 */
	public boolean verifyTitle(String title);

	/**
	 * This method will close the active browser
	 */
	public void close();

	/**
	 * This method will close the all browser
	 */
	public void quit();

}
