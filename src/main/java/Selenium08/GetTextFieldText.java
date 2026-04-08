package Selenium08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextFieldText {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		WebElement emailID = driver.findElement(By.id("input-email"));
		emailID.sendKeys("xyz@gmail.com");
		
		String emailValue = emailID.getDomProperty("value");
		System.out.println(emailValue);
		
		//DOM attribute
		//DOM property
		

		
	}

}
