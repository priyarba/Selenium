package SeleniumSessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser_01 {

	public static void main(String[] args) {
		//Launch browser: chrome
		//ChromeDriver driver=new ChromeDriver();
		//FirefoxDriver driver=new FirefoxDriver();
		EdgeDriver driver=new EdgeDriver();
		
		//Enter the url:
		driver.get("https://www.google.com");
		
		//get the title of the page
		String title=driver.getTitle();
		System.out.println("page title: "+title);
		
		//checkpoint/validation point/ assertion:
		if(title.equals("Google")) {
			System.out.println("Title is correct: PASS");
		}
		else {
			System.out.println("Title is incorrect: FAIL");
		}
		
		//Close the browser:
		driver.quit();
	}
}
