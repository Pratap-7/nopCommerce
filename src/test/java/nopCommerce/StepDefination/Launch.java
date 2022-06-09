package nopCommerce.StepDefination;

import io.cucumber.java.en.*;
import nopCommerce.Base.SelenuimBase;
import nopCommerce.Design.Locators;

public class Launch extends SelenuimBase {
	@Given("Enter username as {string}")
	public void userName(String uname) {

		typeAndEnter(locateElement(Locators.ID, "username"), uname);
  type(locateElement(Locators.ID, "username"), uname);
	}

	@Given("Enter password as {string}")
	public void password(String pswd) {
		
		type(locateElement(Locators.ID, "password"), pswd);
	}

	@Given("click on login button")
	public void click() {
		click(locateElement(Locators.XPATH, "//input[@type='submit']"));
	}

	@Given("click on CRMSFA link")
	public void clickonCRMSFA() {
		click(locateElement(Locators.XPATH, "//div[@id='label']/a"));
	}

}
