package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateURL_07 {

	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");

		// navigate to amazon.com
		driver.navigate().to("https://www.amazon.com"); // String parameter
		driver.navigate().to(new URL("https://www.amazon.com")); // URL parameter

		// get : Synonym for org.openqa.selenium.WebDriver.Navigation.to(String).
		// get() and navigate.to() are doing the same thing
		// Internally navigate.to() calls get() method
		// get() method is not overloaded; to() method is overloaded
	}

}
