package Selenium26_FluentWaitPageReadyState;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForPageLoading05 {
	static WebDriver driver;
	public static void main(String[] args) {
		// go to console of F12 page: type >> document.readyState >> Complete
		driver = new ChromeDriver(); //topcasting
		driver.get("https://classic.crmpro.com/");
		
		/**
		 * Interview Question:
		 * document.ready state: has 3 stages
		 * 1. loading : page is still loading
		 * 2. interactive : Doc/Page has finished loading, but sub-resourse like scripts, images, frames etc are still loading.
		 * 3. complete : Document and all sub-resourses have finished loading.
		 */
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
		
		if(isPageLoaded(5)) {
			System.out.println("Page is loaded completely");
		}
		
	}
	
	public static boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'")).toString();
		return Boolean.parseBoolean(flag);
	}

}
