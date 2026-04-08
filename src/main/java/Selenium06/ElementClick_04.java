package Selenium06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementClick_04 {
	
	static WebDriver driver;
	
	public static void main(String args[]) {
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//Create webelement + action (click)
		//Click can be button, link, checkbox, image
		
//		driver.findElement(By.linkText("Register")).click();
//		driver.findElement(By.name("agree")).click();
		
		By registerLink = By.linkText("Register");
		By agreeCheckBox = By.name("agree");
		
		doClick(registerLink);
		doClick(agreeCheckBox); ;
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator); 
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}

}
