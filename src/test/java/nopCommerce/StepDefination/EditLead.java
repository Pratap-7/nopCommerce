package nopCommerce.StepDefination;

import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.*;
import nopCommerce.Base.SelenuimBase;
import nopCommerce.Design.Locators;

public class EditLead extends SelenuimBase {

	@Given("Click Leads link")
	public void leadLink() {
		click(locateElement(Locators.XPATH, "//a[text()='Leads']"));

	}

	@Given("Click Find leads")
	public void findLeads() {
		click(locateElement(Locators.XPATH, "//a[text()='Find Leads']"));
	}

	@Given("Enter first name as {string}")
	public void firstName(String fname) {
		type(locateElement(Locators.XPATH,
				"//div[@class='x-form-element']/input[@name='id']/following::div/div/input[@name='firstName']"), fname);
	}

	@Given("Click on Find leads button")
	public void clickFindLeadsButton() {
		click(locateElement(Locators.XPATH, "//button[text()='Find Leads']"));
	}

	@Given("Click on first resulting lead")
	public void clickOnFirstRecord() {
		try {
			List<WebElement> Table = getDriver().findElements(By.cssSelector(".x-grid3-row-table"));
			for (int i = 0; i < Table.size();) {
				List<WebElement> rows = Table.get(10).findElements(By.tagName("tr"));
				for (int j = 0; j < rows.size();) {
					List<WebElement> col = rows.get(0).findElements(By.tagName("td"));
					for (int k = 0; k < col.size();) {
						col.get(0).findElement(By.tagName("a")).click();
						break;
					}
					break;
				}
				break;
			}

		} catch (StaleElementReferenceException e) {
			List<WebElement> Table = getDriver().findElements(By.cssSelector(".x-grid3-row-table"));
			for (int i = 0; i < Table.size();) {
				List<WebElement> rows = Table.get(10).findElements(By.tagName("tr"));
				for (int j = 0; j < rows.size();) {
					List<WebElement> col = rows.get(0).findElements(By.tagName("td"));
					for (int k = 0; k < col.size();) {
						col.get(0).findElement(By.tagName("a")).click();
						break;
					}
					break;
				}
				break;
			}
		}
	}

	@Given("Verify title of the page")
	public void verifyTitle() {
		//verifyTitle("View Lead | opentaps CRM");
		String title=getDriver().getTitle();
		Assert.assertEquals(title, "View Lead | opentaps CRM");
	}

	@Given("Click Edit")
	public void clickEdit() {
		click(locateElement(Locators.XPATH, "//a[text()='Edit']"));
	}

	@Given("Change the company name as {string}")
	public void chaneCompanyName(String cname) {
		type(locateElement(Locators.CSS, "#updateLeadForm_companyName"), cname);
	}

	@Given("Click Update")
	public void clickOnUpdate() {
		click(locateElement(Locators.XPATH, "//input[@value='Update']"));
	}

	@Given("Confirm the changed name appears")
	public void verifyCompanyName() {
		String value1="TCS";
		String value2=getDriver().findElement(By.cssSelector("#viewLead_companyName_sp")).getText();
		//Assert.assertTrue(value2.contains(value1),"Failure message");
		Assert.assertEquals(value2.contains(value1),"Failure message");
	}
}
