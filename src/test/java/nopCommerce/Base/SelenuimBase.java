package nopCommerce.Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.gherkin.model.Feature;

import io.github.bonigarcia.wdm.WebDriverManager;
import nopCommerce.Design.Browsers;
import nopCommerce.Design.Elements;
import nopCommerce.Design.Locators;

public class SelenuimBase extends DriverInstance implements Browsers, Elements {
	protected Actions act;

	protected void moveToElements(WebElement ele) {
		act = new Actions(getDriver());
		act.moveToElement(ele).perform();
	}

	protected void dragAndDrop(WebElement source, WebElement target) {
		act = new Actions(getDriver());
		act.dragAndDrop(source, target).perform();
	}

	protected void contextclick(WebElement ele) {
		act = new Actions(getDriver());
		act.contextClick(getWait().until(ExpectedConditions.elementToBeClickable(ele))).perform();
	}

	protected void hoverAndClick(WebElement ele) {
		act = new Actions(getDriver());
		act.moveToElement(getWait().until(ExpectedConditions.elementToBeClickable(ele))).perform();
	}

	public void launchApp(String url, boolean headless) {
		try {
			setDriver("chrome", headless);
			WebDriverManager.chromedriver().setup();
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			getDriver().get(url);

		} catch (Exception e) {

		}
	}

	public void launchApp(String browser, String url, boolean headless) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				setDriver("chrome", headless);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				setDriver("firefox", headless);
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				setDriver("edge", headless);
			}
			setWait();
			//getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			getDriver().get(url);
		} catch (Exception e) {

		}

	}

	public WebElement locateElement(Locators LocatorType, String value) {
		try {
			switch (LocatorType) {
			case ID:
				return getDriver().findElement(By.id(value));
			case CLASS_NAME:
				return getDriver().findElement(By.className(value));
			case CSS:
				return getDriver().findElement(By.cssSelector(value));
			case LINK_TEXT:
				return getDriver().findElement(By.linkText(value));
			case NAME:
				return getDriver().findElement(By.name(value));
			case PARTIAL_LINKTEXT:
				return getDriver().findElement(By.partialLinkText(value));
			case TAGNAME:
				return getDriver().findElement(By.tagName(value));
			case XPATH:
				return getDriver().findElement(By.xpath(value));
			default:
				System.err.println("Locator not valid");
				break;
			}
		} catch (Exception e) {

		}

		return null;
	}

	public WebElement locateElement(String value) {
		try {
			WebElement findElementById = getDriver().findElement(By.id(value));
			return findElementById;
		} catch (Exception e) {

		}
		return null;

	}

	public List<WebElement> locateElements(Locators LocatorType, String value) {
		try {
			switch (LocatorType) {
			case ID:
				return getDriver().findElements(By.id(value));
			case CLASS_NAME:
				return getDriver().findElements(By.className(value));
			case CSS:
				return getDriver().findElements(By.cssSelector(value));
			case LINK_TEXT:
				return getDriver().findElements(By.linkText(value));
			case NAME:
				return getDriver().findElements(By.name(value));
			case PARTIAL_LINKTEXT:
				return getDriver().findElements(By.partialLinkText(value));
			case TAGNAME:
				return getDriver().findElements(By.tagName(value));
			case XPATH:
				return getDriver().findElements(By.xpath(value));
			default:
				System.err.println("Locator not valid");
				break;
			}
		} catch (Exception e) {

		}
		return null;
	}

	public void swithToAlert() {
		try {
			getDriver().switchTo().alert();
		} catch (Exception e) {

		}

	}

	public void acceptAlert() {
		try {
			getDriver().switchTo().alert().accept();
		} catch (Exception e) {

		}

	}

	public void dismissAlert() {
		try {
			getDriver().switchTo().alert().dismiss();
		} catch (Exception e) {

		}

	}

	public void getAlertText() {
		try {
			getDriver().switchTo().alert().getText();
		} catch (Exception e) {

		}

	}

	public void typeAlert(String data) {
		try {
			getDriver().switchTo().alert().sendKeys(data);
		} catch (Exception e) {

		}

	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindows = getDriver().getWindowHandles();
			List<String> allhandles = new ArrayList<String>(allWindows);
			System.out.println(allhandles.size());
			getDriver().switchTo().window(allhandles.get(index));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void switchToWindow(String title) {
		try {
			Set<String> allWindows = getDriver().getWindowHandles();
			for (String eachWindow : allWindows) {
				getDriver().switchTo().window(eachWindow);
				if (getDriver().getTitle().equals(title)) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void switchToFrame(int index) {
		try {
			getDriver().switchTo().frame(index);
		} catch (Exception e) {

		}

	}

	public void switchToFrame(WebElement ele) {
		try {
			getDriver().switchTo().frame(ele);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void switchToFrame(String idOrName) {
		try {
			getDriver().switchTo().frame(idOrName);
		} catch (Exception e) {

		}

	}

	public void defaultContent() {
		try {
			getDriver().switchTo().defaultContent();
		} catch (Exception e) {

		}

	}

	public boolean verifyurl(String url) {
		if (getDriver().getCurrentUrl().equals(url)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTitle(String title) {
		if (getDriver().getTitle().equals(title)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyPartialTitle(String title) {
		if (getDriver().getTitle().contains(title)) {
			System.out.println(getDriver().getTitle());
			return true;
		} else {
			return false;
		}
	}

	public void close() {
		try {
			getDriver().close();
		} catch (Exception e) {

		}

	}

	public void quit() {
		try {
			getDriver().quit();
		} catch (Exception e) {

		}

	}

	@Override
	public void click(WebElement ele) {
		try {

			ele.isDisplayed();
		} catch (Exception e) {
			System.out.println(e);
		}
		String text = "";
		try {
			try {
				Thread.sleep(500);
				getWait().until(ExpectedConditions.elementToBeClickable(ele));
				text = ele.getText();
				if (ele.isEnabled()) {
					ele.click();
				} else {
					getDriver().executeScript("arguments[0].click()", ele);
				}

			} catch (Exception e) {
				boolean bFound = false;
				int totalTime = 0;
				while (!bFound && totalTime < 10000) {
					try {
						Thread.sleep(500);
						ele.click();
						bFound = true;
					} catch (Exception e1) {
						bFound = false;
					}
					totalTime = totalTime + 500;
				}
				if (!bFound)
					ele.click();

			}
		} catch (Exception e2) {
			System.out.println("The Element" + text + e2.getMessage());
		}
	}

	public void clickUsingJsElement(WebElement ele) {
		try {
			ele.isDisplayed();
		} catch (Exception e) {
			System.out.println(ele + " is not displayed");
		}
		String text = "";
		try {
			try {
				getDriver().executeScript("arguments[0].click()", ele);
			} catch (Exception e) {
				boolean bFound = false;
				int totalTime = 0;
				while (bFound && totalTime < 10000) {
					try {
						Thread.sleep(500);
						getDriver().executeScript("arguments[0].clcik()", ele);
						bFound = true;
					} catch (Exception e1) {
						bFound = false;
					}
					totalTime = totalTime + 500;
				}
				if (!bFound) {
					getDriver().executeScript("arguments[0].click()", ele);
				}
			}
		} catch (Exception e) {
			System.out.println(text + " is not clickable");
		}
	}

	public void click(Locators locatorType, String value) {
		String text = "";
		WebElement ele = locateElement(locatorType, value);
		try {
			try {
				Thread.sleep(500);
				getWait().until(ExpectedConditions.elementToBeClickable(ele));
				text = ele.getText();
				if (ele.isEnabled()) {
					ele.click();
				} else {
					getDriver().executeScript("arguments[0].click()", ele);
				}
			} catch (Exception e) {
				boolean bFound = false;
				int totalTime = 0;
				while (bFound && totalTime < 10000) {
					try {
						Thread.sleep(500);
						ele = locateElement(locatorType, value);
						ele.click();
						bFound = true;
					} catch (InterruptedException e1) {
						bFound = false;
					}
					totalTime = totalTime + 500;

				}
				if (!bFound)
					ele.click();
			}
		} catch (Exception e) {
			System.out.println(text + " is not clikable");

		}

	}

	@Override
	public void append(WebElement ele, String data) {
		try {
			String attribute = ele.getAttribute("value");
			if (attribute.length() > 1) {
				ele.sendKeys(data);
			} else {
				ele.sendKeys(data);
			}
		} catch (Exception e) {

		}

	}

	@Override
	public void clear(WebElement ele) {
		try {
			ele.clear();
		} catch (Exception e) {

		}

	}

	@Override
	public void clearAndType(WebElement ele, String data) {
		try {
			getWait().until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(data);
		} catch (ElementNotInteractableException e) {

		} catch (WebDriverException e) {
			try {
				Thread.sleep(500);
				ele.sendKeys(data);
			} catch (Exception e1) {

			}

		}

	}

	public void typeAndTab(WebElement ele, String data) {
		try {
			getWait().until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(data, Keys.TAB);
		} catch (Exception e) {

		}
	}

	public void type(WebElement ele, String data) {
		try {
			getWait().until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(data);

		} catch (Exception e) {

		}
	}

	public void typeAndEnter(WebElement ele, String data) {
		try {
			getWait().until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(data, Keys.ENTER);

		} catch (Exception e) {

		}
	}

	@Override
	public String getElementText(WebElement ele) {
		try {
			String text = ele.getText();
			return text;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public String getBackgroundColour(WebElement ele) {
		try {
			String cssValue = ele.getCssValue("colour");
			return cssValue;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public String getTypedText(WebElement ele) {
		try {
			String attributeValue = ele.getAttribute("value");
			return attributeValue;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select sel = new Select(ele);
			sel.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select sel = new Select(ele);
			sel.selectByIndex(index);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select sel = new Select(ele);
			sel.selectByValue(value);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public boolean verifyExactText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			if (text.equals(expectedText)) {
				System.out.println(text + " text is matching");
				return true;
			} else {
				System.out.println(text + " is not matching");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			if (text.equalsIgnoreCase(expectedText)) {
				return true;
			} else {
				System.out.println(text + " is not matching");
			}
		} catch (Exception e) {

		}
		return false;
	}
	
	public String text(WebElement ele) {
		try {
			String text=ele.getText();
			return text;
		}
		catch(Exception e) {
			
		}
		return null;
		
		
	}

	@Override
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if (ele.getAttribute(attribute).equals(value)) {
				return true;
			} else {
				System.out.println("Expected Attribute value not matching");
			}
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public boolean verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if (ele.getAttribute(attribute).equals(value)) {
				return true;
			} else {
				System.out.println("Expected Attribute value not matching");
			}
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public boolean displayed(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				return true;
			} else {
				System.out.println(ele + " is not visible");
			}
		} catch (Exception e) {

		}
		return false;
	}

	public void displayText(WebElement ele) {
		try {
			System.out.println(ele.getText());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public boolean disappear(WebElement ele) {
		try {
			Boolean until = getWait().until(ExpectedConditions.invisibilityOf(ele));
			return until;
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public boolean enabled(WebElement ele) {
		try {
			if (ele.isEnabled()) {
				return true;
			} else {
				System.out.println(ele + " is not enabled");
			}
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public boolean selected(WebElement ele) {
		try {
			if (ele.isSelected()) {
				return true;
			} else {
				System.out.println(ele + " is not selected");
			}
		} catch (Exception e) {

		}
		return false;
	}

	public long takeSnap() {
		long number = (long) (Math.floor(Math.random() * 900000000L) + 10000000L);
		try {
			File Source = getDriver().getScreenshotAs(OutputType.FILE);
			String property = System.getProperty("user.dir");
			File Dest = new File(property + "/snap/" + number + ".jpg");
			FileUtils.copyFile(Source, Dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return number;
	}

}
