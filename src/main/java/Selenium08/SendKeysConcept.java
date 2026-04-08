package Selenium08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		
		String fName = "Testing";
		String lName = "Automation";
		StringBuilder sb = new StringBuilder("Selenium");
		StringBuilder sbf = new StringBuilder("Learning");
		
		firstName.sendKeys(fName," ", lName,",", sb,"-",sbf); //Testing Automation,Selenium-Learning
		
		//send keys can take and enter more than one string which acts as array
		//Allows character sequence
		//Allows String, char, String buffer, String builder
		
		lastName.sendKeys(null); //IllegalArgumentException
		
		

	}

}
