package Selenium19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsRegistrationFormFillWithTabSequence04{
	
	//Accessibility testing
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		
		Actions act = new Actions(driver);
		Action regFormAction = act.sendKeys(firstName, "Priya")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys("Biradar")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys("priya123@gmail.com")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys("87878676544")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys("Test@123")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys("Test@123")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.SPACE)  //to select the checkbox
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER)
		.build();
		
		//regFormAction.perform();
		performAction(regFormAction);
	}
	
	public static void performAction(Action action) {
		action.perform();
	}

}
