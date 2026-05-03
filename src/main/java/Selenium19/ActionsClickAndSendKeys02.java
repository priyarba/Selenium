package Selenium19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickAndSendKeys02 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		Actions act = new Actions(driver);
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		WebElement checkBox = driver.findElement(By.name("agree"));
		
		//Equivalent to calling: Actions.click(element).sendKeys(keysToSend).
		act.sendKeys(firstName, "Priya").perform();
		
		//Clicks in the middle of the given element.
		//Equivalent to: Actions.moveToElement(onElement).click()
		//Actions class click is useful when there is an overlap issue of webelements and gives error 'ElementNotInteractable'
		//if it still doesn't work , use javascript executor
		act.click(checkBox).perform();

	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
