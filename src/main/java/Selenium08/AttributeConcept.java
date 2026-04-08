package Selenium08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		
		//1. First name
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		
//		String placeholderVal = firstName.getAttribute("placeholder"); // getAttribute() has been deprecated
//		System.out.println(placeholderVal);
		
		String placeholderVal = firstName.getDomAttribute("placeholder");
		System.out.println(placeholderVal);
		
		//under properties tab will be fetched
		String tagName = firstName.getDomProperty("checked");
		 System.out.println(tagName);
		

		//Webelement: 2 elements
		//1. DOM attribute
		//2. property:
		
		//2. Continue button
		String isDisabled = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).getDomProperty("disabled");
		System.out.println(isDisabled);
		
	}
	//get attribute
	public static String getElementDOMAttributeValue(By locator, String attribute) {
		return getElement(locator).getDomAttribute(attribute);
	}
	
	//get property
	public static String getElementDOMPropertyvalue(By locator, String property) {
		return getElement(locator).getDomAttribute(property);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
