package Selenium19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AssignmentAccessibilityLoginPage06 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//		WebElement email = driver.findElement(By.name("email"));
//
//		Actions act = new Actions(driver);
//		Action login = act.sendKeys(email, "priyapiru100@gmail.com").pause(200).sendKeys(Keys.TAB).pause(200)
//				.sendKeys("Test@2020").pause(200).sendKeys(Keys.TAB).pause(200).sendKeys(Keys.TAB).pause(200)
//				.sendKeys(Keys.ENTER).build();
//
//		login.perform();
		
		By emailID = By.name("email");
		performAction(loginDetails(emailID, "priyarba1993@gmail.com", "Test@2020", 200));
		
	}
	
	public static Action loginDetails(By locator,String emailValue, String password, long pauseTime) {
		Actions act = new Actions(driver);
		return act.sendKeys(getElement(locator), emailValue).pause(pauseTime).sendKeys(Keys.TAB).pause(pauseTime)
				.sendKeys(password).pause(pauseTime).sendKeys(Keys.TAB).pause(pauseTime).sendKeys(Keys.TAB).pause(pauseTime)
				.sendKeys(Keys.ENTER).build();
	}
	
	public static void performAction(Action action) {
		action.perform();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
