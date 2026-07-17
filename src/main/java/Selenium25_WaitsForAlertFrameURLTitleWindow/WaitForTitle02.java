package Selenium25_WaitsForAlertFrameURLTitleWindow;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitle02 {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com");
		//before fetching the title
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.titleContains("OrangeHRM"));
//		
//		System.out.println(driver.getTitle());
		String title =waitForTitleContains("OrangeHRM", 10);
		System.out.println(title);
	}
	
	//fraction title: titleContains()
	public static String waitForTitleContains(String fractionTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleContains(fractionTitle));
			return driver.getTitle();
		} catch (TimeoutException e) {
			return null;
		}		
	}
	
	//titleIs()
	public static String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.titleIs(title));
			return driver.getTitle();
		} catch (TimeoutException e) {
			return null;
		}		
	}

}
