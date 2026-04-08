package Selenium17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Selenium06.ElementUtil_02;

public class StringLocator {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		String firstname_ID ="input-firstname";
		String lastname_ID ="input-lastname";
		String email_name ="email";
		String telephone_xpath = "//input[@placeholder='Telephone']";
		String checkBox_name = "agree";
		
		//getElement(getBy("ID", firstname_ID));
		//getElement("ID",firstname_ID ).sendKeys("Priya");
		
		Thread.sleep(3000);
		
		ElementUtil_02 element = new ElementUtil_02(driver);
		element.doClick("NAME", checkBox_name);
		//element.doClick(element.getBy("NAME", checkBox_name));
		
		element.doSendKeys("ID", firstname_ID, "Priya");
		element.doSendKeys("ID", lastname_ID, "Biradar");
		element.doSendKeys("NAME", email_name, "XYZ@gmail.com");
		element.doSendKeys("XPATH", telephone_xpath, "234556777");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType,locatorValue));
	}
	
	public static By getBy(String locatorType, String locatorValue) {
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
	
	

}
