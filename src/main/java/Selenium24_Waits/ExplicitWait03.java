package Selenium24_Waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait03 {
	static WebDriver driver;

	public static void main(String[] args) {
		//Explicit Wait
		
		//Wait(I): until(); <---- implemented by FluentWait(C) : until() + other methods 
		//<----- extended by WebDriverWait(C): no methods
		
		//ctrl + o to check the content of the method.
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// sel 4.x
//		WebElement emailElement =wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
//		emailElement.sendKeys("naveen@gmail.com");
//		
//		driver.findElement(password).sendKeys("test@123");
//		driver.findElement(loginBtn).click();
		
		waitForElementPresence(emailId, 10).sendKeys("naveen@gmail.com");
		getElement(password).sendKeys("test@2020");
		getElement(loginBtn).click();

	}
	
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
