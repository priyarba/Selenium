package Selenium19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AmazonAccessibilitySearchTest05 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
//		Actions act = new Actions(driver);
//		Action searchAction = act
//				.sendKeys(Keys.TAB)
//				.pause(200)
//				.sendKeys(Keys.TAB)
//				.pause(200)
//				.sendKeys(Keys.TAB)
//				.pause(200)
//				.sendKeys(Keys.TAB)
//				.pause(200)
//				.sendKeys(Keys.TAB)
//				.pause(200)
//				.sendKeys("macbook pro")
//				.pause(200)
//				.sendKeys(Keys.ENTER)
//				.build();
//		
//		searchAction.perform();
		performAction(createAmazonSearchAction("macbook pro"));
	}
	
	public static Action createAmazonSearchAction(String value) {
		Actions act = new Actions(driver);
		return act
				.sendKeys(Keys.TAB)
				.pause(200)
				.sendKeys(Keys.TAB)
				.pause(200)
				.sendKeys(Keys.TAB)
				.pause(200)
				.sendKeys(Keys.TAB)
				.pause(200)
				.sendKeys(Keys.TAB)
				.pause(200)
				.sendKeys("macbook pro")
				.pause(200)
				.sendKeys(Keys.ENTER)
				.build();	
	}
	
	public static void performAction(Action action) {
		action.perform();
	}

}
