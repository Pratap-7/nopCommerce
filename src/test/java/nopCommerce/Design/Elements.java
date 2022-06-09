package nopCommerce.Design;

import org.openqa.selenium.WebElement;

public interface Elements {
	
	/**
	 * This method will click the element
	 */
	void click(WebElement ele);
	
	/**
	 * This method will enter value to the given text field
	 */
	void append(WebElement ele,String data);
	
	/**
	 * This method will clear the data from the given text field
	 */
	void clear(WebElement ele);
	
	/**
	 * This method will clear and enter the data to the given text field
	 */
	void clearAndType(WebElement ele, String data);
	/**
	 * This method will get text from the field
	 */
	
	String  getElementText(WebElement ele);
	
	/**
	 * This method will get the Color values of the element
	 */
	
	String getBackgroundColour(WebElement ele);
	
	/**
	 * This method will get the text of the element textbox
	 */
	String getTypedText(WebElement ele);
	
	/**
	 * This method will select the drop down visible text
	 */
	void selectDropDownUsingText(WebElement ele, String value);
	
	/**
	 * This method will select the drop down using index
	 */
	void selectDropDownUsingIndex(WebElement ele,int index);
	
	/**
	 * This method will select the drop down using value
	 */
	void selectDropDownUsingValue(WebElement ele, String value);
	/**
	*This method will verify exact given text with actual text on the given element
    */
    boolean verifyExactText(WebElement ele, String expectedText);
    /**
	*This method will verify partial  given text with actual text on the given element
    */
    boolean verifyPartialText(WebElement ele, String expectedText);
    
    /**
	*This method will verify exact given attribute's value with actual value on the given element
    */
    boolean verifyExactAttribute(WebElement ele,String attribute ,String value);
    /**
	*This method will verify partial given attribute's value with actual value on the given element
    */
    boolean verifyPartialAttribute(WebElement ele, String attribute, String value);
    /**
	*This method will verify if the element is visible in the DOM
    */
    boolean displayed(WebElement ele);
    /**
	*This method will verify if the element to be invisible
    */
    boolean disappear(WebElement ele);
    /**
	*This method will verify if the element to be enabled
    */
    boolean enabled(WebElement ele);
    
    /**
	*This method will verify if the element is selected
    */
    boolean selected(WebElement ele);
}
