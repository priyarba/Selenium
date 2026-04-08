package Selenium08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysWithDisabledElement {
	
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		WebElement password = driver.findElement(By.id("pass"));
		//password.sendKeys("Testing");
		
		//ElementNotInteractable: 
		//this element is disbaled
		
		//Perform click on disabled element
		password.click(); // it will not give any error.
		
	}

}
