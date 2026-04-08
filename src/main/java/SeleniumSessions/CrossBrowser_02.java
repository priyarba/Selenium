package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser_02 {
	
	static WebDriver driver;

	public static void main(String[] args) {

		String browser = "Chrome";

//		WebDriver driver = new ChromeDriver();// top casting
//
//		driver.get("https://www.google.com");
		
		switch (browser.trim().toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			driver=new FirefoxDriver();
			break;
			
		case "Edge":
			driver=new EdgeDriver();
			break;

		default:
			System.out.println("Please enter correct browser: "+ browser);
			throw new RuntimeException("Invalid Browser");
		}

		// get the title of the page
		String title = driver.getTitle();
		System.out.println("page title: " + title);

		// checkpoint/validation point/ assertion:
		if (title.equals("Google")) {
			System.out.println("Title is correct: PASS");
		} else {
			System.out.println("Title is incorrect: FAIL");
		}

		// Close the browser:
		driver.quit();
	}

}
