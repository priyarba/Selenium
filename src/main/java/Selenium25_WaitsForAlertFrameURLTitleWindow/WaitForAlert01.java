package Selenium25_WaitsForAlertFrameURLTitleWindow;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlert01 {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		Alert alert =wait.until(ExpectedConditions.alertIsPresent());
//		//we dont need to write driver.switchTo.alert
//		System.out.println(alert.getText());
//		alert.accept();

	}
	
	//apply timeout on Alert and switch to alert
	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	//Accept alert
	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	//Cancel Alert
	public static void dismissAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}
	
	//Get alert text
	public static void getTextAlert(int timeout) {
		waitForAlert(timeout).getText();
	}
	
	//Enter text on alert popup
	public static void sendKeysAlert(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
	}

}
