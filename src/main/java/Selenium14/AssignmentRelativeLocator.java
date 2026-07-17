package Selenium14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class AssignmentRelativeLocator {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		//1. above
//		WebElement returningCustomer = driver.findElement(By.xpath("//strong[contains(text(),'I am a returning customer')]"));
//		String aboveText = driver.findElement(with(By.tagName("h2")).above(returningCustomer)).getText();
//		
//		System.out.println(aboveText);
//		
		
		//2. below
//		String belowText = driver.findElement(with(By.tagName("label")).below(returningCustomer)).getText();
//		System.out.println(belowText);
		
		WebElement 	agreeElement = driver.findElement(By.xpath("//b[text()='Privacy Policy']"));
		
		boolean rightElement = driver.findElement(with(By.tagName("input"))).isSelected();
		System.out.println(rightElement);
		
		
		//3. near
		String nearElement = driver.findElement(with(By.tagName("input")).near(agreeElement)).getText();
		
		
		

	}

}
