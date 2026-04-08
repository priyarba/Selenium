package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods_06 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		//get : Synonym for org.openqa.selenium.WebDriver.Navigation.to(String).
		// get() and navigate.to() are doing the same thing
		//Internally navigate.to() calls get() method
		//get() method is not overloaded; to() method is overloaded
		
		System.out.println(driver.getTitle());
		
		//navigate to amazon.com
		driver.navigate().to("https://www.amazon.com");
		
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh(); //refresh the page  
		//navigate() method does not perform click, it simulates the action
		
		
	}

}
