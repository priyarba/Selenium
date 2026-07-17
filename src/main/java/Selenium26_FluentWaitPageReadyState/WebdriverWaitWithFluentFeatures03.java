package Selenium26_FluentWaitPageReadyState;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWaitWithFluentFeatures03 {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver(); //topcasting
		driver.get("https://classic.crmpro.com/");
		
		/**
		 * Difference between FluentWait and WebDriverWait?
		 * There is no difference. WebDriverWait can do whatever the FluentWait can do.
		 * WebDriverWait has no methods of its own; hence it inherits all the methods from fluentWait.
		 * Its not necessary to use fluentWait, as we can do the same implementation using WebDriverWait
		 * 
		 * 1. In Java, we always create an object of the lowest child, hence WebDriverWait is preferred over FluentWait
		 * 2. Say in future when java wants to implement new class, it will extend Fluent wait.
		 * 
		 */
		By userName = By.name("username");
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2))
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.withMessage("===Element not found===");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).sendKeys("Priya");
				

	}

}
