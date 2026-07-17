package Selenium06;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil_02 {

	private WebDriver driver;
	private Actions act;

	public ElementUtil_02(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
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
			System.out.println("Please pass the correct locator type" + locator);
			break;
		}
		return locator;
	}

	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	// findElement with wait
	public WebElement getElementWithWait(By locator, int timeOut) {
		return waitForElementVisibility(locator, timeOut);
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

	// *******************Dropdown Utils - without using
	// select**********************

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

	// *******************Dropdown Util -- Non Select
	// Based**************************
	public void selectChoice(By choice, By choiceList, String... choiceValue) throws InterruptedException {
		doClick(choice);
		Thread.sleep(2000);

		// String
		// xpath="(//div[@class='comboTreeDropDownContainer'])[1]//li/span[@class='comboTreeItemTitle']";
		List<WebElement> choices = getElements(choiceList);
		System.out.println(choices.size());

		// logic to select all the options
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

	// *************************Actions Utils
	// ***************************************

	public void doMoveToElement(By locator) throws InterruptedException {
		act.moveToElement(getElement(locator)).build().perform();
		Thread.sleep(2000);
	}

	// Generic method to perform mouse action
	public void handleParentSubMenu(By parentMenu, By subMenu) throws InterruptedException {
		doMoveToElement(parentMenu);
		doClick(subMenu);
	}

	// Generic method to perform for 4 level Menu
	public void handle4LevelMenuHandle(By level1Menu, By level2Menu, By level3Menu, By level4Menu)
			throws InterruptedException {
		getElement(level1Menu).click();
		// doClick(level1Menu);
		Thread.sleep(2000);
		doMoveToElement(level2Menu);
		doMoveToElement(level3Menu);
		getElement(level4Menu).click();
		// doClick(level4Menu);
	}

	// Actions: SendKeys
	public void doActionsSendKeys(By locator, String value) {
		act.sendKeys(getElement(locator), value).perform();
	}

	// Actions: Click
	public void doActionsClick(By locator) {
		act.click(getElement(locator)).perform();
	}

	public void doSendKeysWithPause(By locator, String value, long pauseTime) {
		// convert to char array
		char val[] = value.toCharArray();
		for (char ch : val) { // 'n' -> "n"
			act.sendKeys(getElement(locator), String.valueOf(ch)).pause(pauseTime).perform();
		}
	}

	// ************************ Wait Utils *****************************************
	/**
	 * 1. presenceOfElementLocated 2. presenceOfAllElementsLocatedBy 3.
	 * visibilityOfElementLocated 4. visibilityOfAllElementsLocatedBy 3.
	 * elementToBeClickable 4. alertIsPresent 5. titleContains 6. titleIs 7.
	 * urlContains 8. urlToBe 9. frameToBeAvailableAndSwitchToIt 10.
	 * numberOfWindowsToBe
	 *
	 */

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that there is at least one element present on a
	 * web page.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public List<WebElement> waitForAllElementsPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementVisibility(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that all elements present on the web page that match the locator are visible. 
	 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForAllElementsVisibility(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 * 
	 * @param locator
	 * @param timeOut
	 */
	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	// click with timeout
	public void clickWithWait(By locator, int timeOut) {
		waitForElementVisibility(locator, timeOut).click();
	}

	// sendKeys with timeout
	public void sendKeysWithWait(By locator, int timeOut, CharSequence... value) {
		waitForElementVisibility(locator, timeOut).sendKeys(value);
	}

	// ********************************** Wait for Alert(JavaScript popup
	// )******************************
	// apply timeout on Alert and switch to alert
	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	// Accept alert
	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	// Cancel Alert
	public void dismissAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}

	// Get alert text
	public void getTextAlert(int timeout) {
		waitForAlert(timeout).getText();
	}

	// Enter text on alert popup
	public void sendKeysAlert(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
	}

	// ******************** Wait for Title ************************************

	// fraction title: titleContains()
	public String waitForTitleContains(String fractionTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleContains(fractionTitle));
			return driver.getTitle();
		} catch (TimeoutException e) {
			return null;
		}
	}

	// titleIs()
	public String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleIs(title));
			return driver.getTitle();
		} catch (TimeoutException e) {
			return null;
		}
	}

	// ********************** Wait for URL **********************************
	// fraction URL: urlContains()
	public String waitForURLContains(String fractionURL, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlContains(fractionURL));
			return driver.getCurrentUrl();
		} catch (TimeoutException e) {
			return null;
		}
	}

	// urlToBe(url)
	public String waitForURLIs(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.urlToBe(url));
			return driver.getCurrentUrl();
		} catch (TimeoutException e) {
			return null;
		}
	}

	// ************************** Wait for Frame ***********************************

	public void waitForFrameAndSwitchToIt(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFrameAndSwitchToIt(String frameNameOrID, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
	}

	public void waitForFrameAndSwitchToIt(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameAndSwitchToIt(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	// ******************* Wait for Windows *******************************
	public boolean waitForWindow(int timeOut, int expectedNumberOfWindows) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			return wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
		} catch (Exception e) {
			System.out.println("Expected number of windows are not correct");
			return false;
		}
	}
	
	//********************* With Fluent Wait *****************************
	
	//FluentWait : visibilityOfElementLocated
	public WebElement waitForElementVisibleWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("===Element Not Found===");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
	}
	
	//FluentWait : presenceOfElementLocated
	public void waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
				.withMessage("===Element Not Found");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	//**************** PageReadyState *******************************
	public boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'")).toString();
		return Boolean.parseBoolean(flag);
	}

}
