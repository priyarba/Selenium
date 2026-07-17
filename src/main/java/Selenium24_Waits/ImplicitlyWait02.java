package Selenium24_Waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWait02 {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //sel 3.x -- TimeUnit has been deprecated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //sel 4.x
		
		//Drawbacks:
		//implicitly wait is global wait; it will be applied to all the webElements
		//We need to override it whenever we need to increase or decrease the timeout.
		//Its not recommended to use implicitly wait
		//It does not work for non Web elements: title, url, alert popups, windows
		
		//LOGIN PAGE:
		driver.get("");

	}

}
