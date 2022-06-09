package nopCommerce.StepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.*;
import nopCommerce.Base.SelenuimBase;
import nopCommerce.Design.Locators;

public class DuplicateLead extends SelenuimBase {
	public String name = "";

	@Given("Click on Email")
	public void clickOnEmail() {
		click(locateElement(Locators.XPATH, "//span[text()='Email']"));

	}

	@Given("Enter Email as {string}")
	public void enterEmail(String email) {
		type(locateElement(Locators.XPATH, "//input[@name='emailAddress']"), email);
	}

	@Given("Click find leads button")
	public void clickFindLeadsButton() {
		click(locateElement(Locators.XPATH, "//button[text()='Find Leads']"));
	}

	@Given("Capture name of First Resulting lead")
	public void CaptureNameofFirstResultingLead() {
		List<WebElement> tables = getDriver().findElements(By.cssSelector(".x-grid3-row-table"));
		for (int i = 0; i < tables.size(); i++) {
			List<WebElement> rows = tables.get(0).findElements(By.tagName("tr"));
			for (int j = 0; j < rows.size(); j++) {
				List<WebElement> col = rows.get(0).findElements(By.tagName("td"));
				for (int k = 0; k < col.size(); k++) {
					name = col.get(3).getText();
				}
			}
		}
	}

	@Given("Click First Resulting lead")
	public void clickFirstRecord() {
		try {
			List<WebElement> tables = getDriver().findElements(By.cssSelector(".x-grid3-row-table"));
			for (int i = 0; i < tables.size(); i++) {
				List<WebElement> rows = tables.get(0).findElements(By.tagName("tr"));
				for (int j = 0; j < rows.size(); j++) {
					List<WebElement> col = rows.get(0).findElements(By.tagName("td"));
					for (int k = 0; k < col.size(); k++) {
						col.get(0).findElement(By.tagName("a")).click();
					}
				}
			}

		} catch (StaleElementReferenceException e) {
			List<WebElement> tables = getDriver().findElements(By.cssSelector(".x-grid3-row-table"));
			for (int i = 0; i < tables.size(); i++) {
				List<WebElement> rows = tables.get(0).findElements(By.tagName("tr"));
				for (int j = 0; j < rows.size(); j++) {
					List<WebElement> col = rows.get(0).findElements(By.tagName("td"));
					for (int k = 0; k < col.size(); k++) {
						col.get(0).findElement(By.tagName("a")).click();
					}
				}
			}
		}

	}

	@Given("Click Duplicate Lead")
	public void clickOnDuplicateLead() {
		click(locateElement(Locators.XPATH, "//a[text()='Duplicate Lead']"));
	}

	@Given("Verify the title as {string}")
	public void confirmTitle(String title) {
		String title1 = getDriver().getTitle();
		Assert.assertTrue(title1.contains(title));

	}

	@Given("Click Create Lead")
	public void clickCreateLead() {
		click(locateElement(Locators.XPATH, "//input[@value='Create Lead']"));
	}

	@Given("Confirm the duplicated lead name is same as captured name")
	public void confirmDuplictaeLeadName() {
		String name2 = getDriver().findElement(By.cssSelector("##viewLead_firstName_sp")).getText();
		Assert.assertEquals(name2, name);
	}

}
