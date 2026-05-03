package Selenium19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendKeysWithPause03 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//charSequence: String, StringBuffer, StringBuilder
//		Actions act = new Actions(driver);
//		WebElement firstName = driver.findElement(By.id("input-firstname"));
//		String value = "Naveen Automation";
//		
//		//convert to char array
//		char val[] = value.toCharArray();
//		for(char ch : val) {
//			act
//			.sendKeys(firstName, String.valueOf(ch))
//			.pause(200)
//			.perform();
//		}
		
		By firstName = By.id("input-firstname");
		doSendKeysWithPause(firstName, "Priya Biradar", 200);

	}
	
	public static void doSendKeysWithPause(By locator, String value, long pauseTime) {
		Actions act = new Actions(driver);
		//convert to char array
		char val[] = value.toCharArray();
		for(char ch : val) { //'n' -> "n"
			act
			.sendKeys(getElement(locator), String.valueOf(ch))
			.pause(pauseTime)
			.perform();
		}
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
