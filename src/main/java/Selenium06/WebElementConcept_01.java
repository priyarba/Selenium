package Selenium06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept_01 {
	
	static WebDriver driver;
	
	//All the elements present on webpage are Webelements: Textbox, checkbox, button, hyperlink etc
	//Browser features are not webelements: page refresh, forward/back arrow, url, bookmark.
	
	public static void main(String args[]) {
		 driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//Create a webelement(FindElement) + perform action(click, Sendkeys isDisplayed, getText ..)
		
		//1.
//		driver.findElement(By.id("input-email")).sendKeys("tom@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("tom@123");
		
		
		//2. 
//		WebElement email = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		email.sendKeys("tom@gmail.com");
//		password.sendKeys("tom@123");
		
		//3. By locators : Object repository
		//this approach is better as By is not hitting any driver.
		//In the 2nd approch it hits the server/driver whenever the xpath is defined
//		By emailField = By.id("input-email");
//		By passwordField = By.id("tom@123");
//		
//		WebElement email = driver.findElement(emailField);
//		WebElement password = driver.findElement(passwordField);
//		
//		email.sendKeys("tom@gmail.com");
//		password.sendKeys("tom@123");
//		
		
		//4. By locator +generic function to get the element
//		By emailField = By.id("input-email");
//		By passwordField = By.id("input-password");
//		
//		getElement(emailField).sendKeys("tom@gmail.com");
//		getElement(passwordField).sendKeys("tom@123");
		
		//5. By locator + generic function to get the element and perform action
//		By emailField = By.id("input-email");
//		By passwordField = By.id("input-password");
//		
//		doSendKeys(emailField,"tom@gmail.com");
//		doSendKeys(passwordField,"tom@123");
		
		//6. By locator + generic function to get the element and perform action - ElementUtil
		By emailField = By.id("input-email");
		By passwordField = By.id("input-password");
		
		ElementUtil_02 util = new ElementUtil_02(driver);
		util.doSendKeys(emailField, "tom@gmail.com");
		util.doSendKeys(passwordField, "tom@123");
		
		//7. BrowserUtil + ElementUtil --> Webelement + action
		
		
		
		
	}
	//method reusability
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	

}
