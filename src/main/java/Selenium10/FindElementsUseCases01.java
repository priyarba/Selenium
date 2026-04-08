package Selenium10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsUseCases01 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//WebElement ele = driver.findElement(By.id("firstName"));
		//NoSuchElementException : NSE
		//Return type is a WebElement 
		//Used to return single element
		//----------------------------------------------------------------
//		List<WebElement> eleList = driver.findElements(By.className("test-naveen"));
//		System.out.println(eleList);
//		System.out.println(eleList.size());
		//Used to return more than 1 element
		//Return type is List<WebElement>
		//When element is not present it returns an empty list
		//----------------------------------------------------------------
		
		By emailID = By.id("input-email1");
		System.out.println(checkElementDisplayed(emailID));
		
		By forgotPwdLink = By.linkText("Forgotten Password");
		if(checkElementDisplayed(forgotPwdLink,2)) {
			System.out.println("Forgot pwd is displayed 2 times");
		}
	
	}
	//Element displayed 1 time on the page
	public static boolean checkElementDisplayed(By locator) {
		if(getElements(locator).size()==1) {
			System.out.println("Element: "+ locator + "is displayed on the page once");
			return true;
		}
		return false;
	}
	//Element displayed more than 1 time on the page
	public static boolean checkElementDisplayed(By locator, int expectedElementCount) {
		if(getElements(locator).size()==expectedElementCount) {
			System.out.println("Element: "+ locator + "is displayed on the page " + 
		expectedElementCount +"times");
			return true;
		}
		return false;
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
		
	}

}
