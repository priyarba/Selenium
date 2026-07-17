package Selenium27_SVGElement_ShadowDOM_PseudoElement_StaleElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceException04 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register"); //page DOM v1
		
		//DOM v1
		WebElement firstName = driver.findElement(By.id("input-firstname"));

		//DOM v1
		firstName.sendKeys("Priya");

		driver.navigate().refresh(); //DOM v2
		//refresh, back, forward: the DOM gets refreshed in these cases.
		
		//DOM v1
		//firstName.sendKeys("Biradar"); // StaleElementReferenceException
		
		//to overcome this the WebElement should be re-initialized again
		firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Biradar");
		
		//We generally dont use refresh() in the middle of execution for this reason.
		//Note:New Session ID is created after refresh. the older one is skipped, but not expired.
		// StaleElement can be handled using FluentWait
	}

}
