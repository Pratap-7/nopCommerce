package nopCommerce.StepDefination;

import io.cucumber.java.en.*;
import nopCommerce.Base.SelenuimBase;
import nopCommerce.Design.Locators;

public class CreateLead extends SelenuimBase {

	@Given("Click on contacts Button")
	public void contacts() {
		click(locateElement(Locators.XPATH, "//a[text()='Contacts']"));
	}

	@Given("Click on Create Contact")
	public void createcontact() {
		click(locateElement(Locators.XPATH, "//a[text()='Create Contact']"));
	}

	@Given("Enter FirstName Field as {string}")
	public void firstName(String Fname) {
		type(locateElement(Locators.CSS, "#firstNameField"), Fname);

	}

	@Given("Enter LastName Field as {string}")
	public void lastName(String lname) {
		type(locateElement(Locators.CSS, "#lastNameField"), lname);
	}

	@Given("Enter FirstLocal Field as {string}")
	public void firstNameLocal(String fnamelocal) {
		type(locateElement(Locators.CSS, "#createContactForm_firstNameLocal"), fnamelocal);
	}

	@Given("Enter LastLocal Field as {string}")
	public void lastNameLocal(String lnamelocal) {
		type(locateElement(Locators.CSS, "#createContactForm_lastNameLocal"), lnamelocal);
	}

	@Given("Enter Department Field as {string}")
	public void department(String dept) {
		type(locateElement(Locators.CSS, "#createContactForm_departmentName"), dept);
	}

	@Given("Enter Description Field as {string}")
	public void description(String description) {
		type(locateElement(Locators.CSS, "#createContactForm_description"), description);
	}

	@Given("Enter your email in the E-mail address Field as {string}")
	public void email(String email) {
		type(locateElement(Locators.CSS, "#createContactForm_primaryEmail"), email);
	}

	@Given("Select StateProvince as {string}")
	public void state(String state) {
		selectDropDownUsingText(locateElement(Locators.ID,"createContactForm_generalStateProvinceGeoId"), state);
	}

	@Given("Click on Add Contact")
	public void ADDContact() {
		click(locateElement(Locators.XPATH, "//input[@type='submit']"));
	}

	@Given("Click on edit button")
	public void clickOnEditButton() {
		click(locateElement(Locators.XPATH, "//a[text()='Edit']"));
	}

	@Given("Clear the Description Field")
	public void clearDescription() {
		clear(locateElement(Locators.CSS, "#updateContactForm_description"));
	}

	@Given("Fill ImportantNote Field as {string}")
	public void importantNote(String notes) {
		type(locateElement(Locators.CSS, "#updateContactForm_importantNote"), notes);
	}

	@Given("Click on update button")
	public void clickOnUpdateButton() {
		click(locateElement(Locators.XPATH, "//input[@value='Update']"));
	}

	@Given("Get the Title of Resulting Page")
	public void getTitle() {
		String title = getDriver().getTitle();
		System.out.println(title);
	}

}
