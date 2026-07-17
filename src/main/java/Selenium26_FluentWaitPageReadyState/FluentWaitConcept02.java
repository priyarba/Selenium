package Selenium26_FluentWaitPageReadyState;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept02 {
	static WebDriver driver;
	public static void main(String[] args) {
		// Fluent wait is the parent class of WebDriverWait class
		/**
		 *  WebDriverWait(C): no methods of its own, inherits from parent
		 *  extends FluentWait(C):(until(), other methods) 
		 *  implements Wait(I) : until();
		 *  
		 *  Hence WebDriverWait IS - A FluentWait
		 */

		driver = new ChromeDriver(); //topcasting
		driver.get("https://classic.crmpro.com/");
		By userName = By.name("username");
		
		//TopCasting
		//Default polling time is 500 milliseconds
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2))
//				.ignoring(NoSuchElementException.class)
//				.ignoring(StaleElementReferenceException.class)
//				.withMessage("===Element not found===");
//		WebElement username_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
//		username_ele.sendKeys("Priya");
		waitForElementVisibleWithFluentWait(userName, 10, 2).sendKeys("Priya");
		
	}
	
	//FluentWait : visibilityOfElementLocated
	public static WebElement waitForElementVisibleWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("===Element Not Found===");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
	}
	
	//FluentWait : presenceOfElementLocated
	public static void waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
				.withMessage("===Element Not Found");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
