   package Selenium08;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDisplayed {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//Wrong locator
//		WebElement firstName = driver.findElement(By.id("input-firstname11"));//NoSuchElementException
//		
//		boolean b1 = firstName.isDisplayed();
//		System.out.println(b1); 
		
//		boolean b1 = driver.findElement(By.id("input-firstname11")).isDisplayed();
//		System.out.println(b1);
		
		//This will not give false; it will give NoSuchElementException
		//Bcoz before reaching the isDisplayed method, it will verify the xpath.
		
		//Using By locator : will still give null pointer exception
		
		By fn = By.id("input-firstname");
		if(isElementDisplayed(fn)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		//Check the logo
		By logo = By.className("img-responsive");
		System.out.println(isElementDisplayed(logo));
		
	}
	
	public static boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			//e.printStackTrace();
			System.out.println("element is not present on the page: "+locator);
			return false;
		}
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	//Basically, if element is displayed, it will give true
	//If element is not present, it will give NoSuchElementException
	//If you want to return false , do exception handling using try catch block

}
