package Selenium21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserBlankWindowTab04 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// ParentID
		String parentWindowID = driver.getWindowHandle();
		// selenium 4.x:

		// Open a new blank tab and enter the url
		driver.switchTo().newWindow(WindowType.TAB); // to open a new tab
		driver.switchTo().newWindow(WindowType.WINDOW); // to open a new window
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.close();

		// Switch to parentwindow
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getTitle());

		/**
		 * How to handle random popups? -- We cannot handle such scenarios -- SUch
		 * popups appear only in env like prod -- In the background we can use listeners
		 * by implementing the DOM dispatcher events, by writing heavy javaScripts.
		 * but those are not reliable.
		 * 
		 * Popups like accept cookie, login does not need switching
		 * These popups are part of main window and can be handles as other webelements of the same window
		 */

	}

}
