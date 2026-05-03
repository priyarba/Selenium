package Selenium20;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertPopupHandling01 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		/**
		 * Alert javaScript popup 1. alert : cannot be inspected 2. prompt 3. confirm --> Alert API is used to handle the alert popups
		 * 
		 * Browser window popup: 1. tab 2. window 3. advertisement
		 * 
		 * File upload
		 * 
		 * Auth popup
		 */

		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// 1. alertJS:
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		Thread.sleep(2000);
//		Alert alert =driver.switchTo().alert();
//		//Switches to the currently active modal dialog(JS alert) for this particular driver instance.
		//After alert is close, it will automatically switch to the main window
//		
//		String text = alert.getText();
//		System.out.println(text);
//		
//		//alert.accept(); //click on ok
//		alert.dismiss(); //cancel the alert

		// 2. confirm JS:
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		// alert.accept();
//		alert.dismiss();
		
		//3. Prompt JS:
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		//text field
		alert.sendKeys("SDET");
		Thread.sleep(4000);
		alert.accept();
		

	}

}
