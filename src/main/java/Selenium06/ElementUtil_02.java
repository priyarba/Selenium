package Selenium06;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil_02 {

	WebDriver driver;

	public ElementUtil_02(WebDriver driver) {
		this.driver = driver;
	}

	// why are static not allowed in ElementUtil
	// problem with static: parallel execution is not possible
	// static methods goes to CMA
	// if there are multiple users accessing the method(multi thread), and if the
	// method is made static,
	// the method will be stored in CMA, which will do sequential all execution as
	// there is only 1 driver available

	// null check method:
	private void nullCheck(CharSequence... value) {
		if (value == null) {
			throw new RuntimeException("=== Value cannot be NULL");
		}
	}

	// Single string value
	public void doSendKeys(By locator, String value) {
//		if(value == null) {
//			throw new RuntimeException("=== Value cannot be NULL");
//		}
		nullCheck(value);
		getElement(locator).sendKeys(value);
	}
	
	public void doSendKeys(String locatorType, String locatorValue, String value) {
		nullCheck(value);
		getElement(locatorType, locatorValue).sendKeys(value);
	}

	// suitable for array of strings
	public void doSendKeys(By locator, CharSequence... value) {
		nullCheck(value);
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doClick(String locatorType, String locatorValue) {
		getElement(locatorType, locatorValue).click();
	}

	public String doGetText(By locator) {
		String elementText = getElement(locator).getText();
		System.out.println("Element Text: " + elementText);
		return elementText;
	}

	// get attribute
	public String getElementDOMAttributeValue(By locator, String attribute) {
		nullCheck(attribute);
		return getElement(locator).getDomAttribute(attribute);
	}

	// get property
	public String getElementDOMPropertyvalue(By locator, String property) {
		nullCheck(property);
		return getElement(locator).getDomAttribute(property);
	}

	// isDisplayed
	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			// e.printStackTrace();
			System.out.println("element is not present on the page: " + locator);
			return false;
		}
	}
	
	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toUpperCase()) {
		case "ID":
			locator = By.id(locatorValue);
			break;
		case "NAME":
			locator = By.name(locatorValue);
			break;
		case "CLASSNAME":
			locator = By.className(locatorValue);
			break;
		case "XPATH":
			locator = By.xpath(locatorValue);
			break;
		case "LINKTEXT":
			locator = By.linkText(locatorValue);
			break;
		case "PARTIALLINKTEXT":
			locator = By.partialLinkText(locatorValue);
			break;
		case "CSS":
			locator = By.cssSelector(locatorValue);
			break;
		case "TAGNAME":
			locator = By.tagName(locatorValue);
			break;
		default:
			System.out.println("Please pass the correct locator type"+ locator);
			break;
		}		
		return locator;
	}
	
	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType,locatorValue));
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	// ***************************FindElements Utils***************************
	// For loop
	public List<String> getElementTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>(); // pc=0
		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println(text);
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	// size
	public int getElementsCount(By locator) {
		int eleCount = getElements(locator).size();
		System.out.println("Element count is: " + eleCount);
		return eleCount;
	}

	// Element displayed 1 time on the page
	public boolean checkElementDisplayed(By locator) {
		if (getElements(locator).size() == 1) {
			System.out.println("Element: " + locator + "is displayed on the page once");
			return true;
		}
		return false;
	}

	// Element displayed more than 1 time on the page
	public boolean checkElementDisplayed(By locator, int expectedElementCount) {
		if (getElements(locator).size() == expectedElementCount) {
			System.out.println("Element: " + locator + "is displayed on the page " + expectedElementCount + "times");
			return true;
		}
		return false;
	}

	public void clickElement(By locator, String value) {

		List<WebElement> eleList = getElements(locator);
		System.out.println("Total no. of elements:" + eleList.size());

		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(value)) { // not using equals, in case there is a space between words
				e.click();
				break;
			}
		}

	}

	// findElements
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	// *******************Dropdown Utils - without using select**********************

	public void noSelectDropdown(By locator, String value) {
		List<WebElement> eleList = getElements(locator);

		System.out.println(eleList.size());

		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	// **********************Dropdown Utils - select based
	// dropdown***********************

	public boolean doSelectDropdownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByIndex(index);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(index + "is not present in the dropdown");
			return false;
		}
	}

	// Interview Qstn: how will you make sure the element is selected from dropdown
	public boolean doSelectDropdownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByVisibleText(visibleText);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(visibleText + "is not present in the dropdown");
			return false;
		}
	}

	public boolean doSelectDropdownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByValue(value);
			return true;
		} catch (Exception e) {
			System.out.println(value + "is not present in the dropdown");
			return false;
		}
	}

	public boolean selectDropdownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		// gives all options in the dropdown
		List<WebElement> eleList = select.getOptions();
		System.out.println(eleList.size());
		boolean flag = false;
		// to print the options
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			// to click the element and break the loop
			if (text.equals(value)) {
				e.click();
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println(value + "is selected");
			return true;
		} else {
			System.out.println(value + "is not selected");
			return false;
		}
	}

	public List<String> getDropdownValueList(By locator) {

		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		List<String> optionsValList = new ArrayList<String>();
		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsValList.add(text.trim());
		}
		return optionsValList;
	}

	public boolean getDropdownValueList(By locator, List<String> expOptionsList) {

		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		List<String> optionsValList = new ArrayList<String>();
		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsValList.add(text.trim());
		}
		if (optionsValList.containsAll(expOptionsList)) {
			return true;
		} else {
			return false;
		}
	}
	
	//*******************Dropdown Util -- Non Select Based**************************
	public void selectChoice(By choice, By choiceList, String... choiceValue) throws InterruptedException {
		doClick(choice);
		Thread.sleep(2000);

		// String
		// xpath="(//div[@class='comboTreeDropDownContainer'])[1]//li/span[@class='comboTreeItemTitle']";
		List<WebElement> choices = getElements(choiceList);
		System.out.println(choices.size());

		//logic to select all the options
		if (choiceValue[0].equalsIgnoreCase("ALL")) {
			for (WebElement e : choices) {
				e.click();
			}
		} else {

			for (WebElement e : choices) {
				String text = e.getText();
				System.out.println(text);

				for (String value : choiceValue) {
					if (text.trim().equals(value)) {
						e.click();
						break;
					}
				}
			}
		}
	}
}
