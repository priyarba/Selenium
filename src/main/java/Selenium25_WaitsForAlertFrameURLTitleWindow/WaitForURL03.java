package Selenium25_WaitsForAlertFrameURLTitleWindow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForURL03 {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com");
		driver.findElement(By.xpath("//button[contains(text(), 'Book a Free Demo')]")).click();
		String url = waitForURLContains("book-a-free-demo",5);
		System.out.println(url);

	}
	
	//fraction URL: urlContains()
		public static String waitForURLContains(String fractionURL, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			try {
				wait.until(ExpectedConditions.urlContains(fractionURL));
				return driver.getCurrentUrl();
			} catch (TimeoutException e) {
				return null;
			}		
		}
		
		//urlToBe(url)
		public static String waitForURLIs(String url, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			try {
				wait.until(ExpectedConditions.urlToBe(url));
				return driver.getCurrentUrl();
			} catch (TimeoutException e) {
				return null;
			}		
		}


}
