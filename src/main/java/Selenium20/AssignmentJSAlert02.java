package Selenium20;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentJSAlert02 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(2000);
		
		Alert alert =driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		
		alert.accept();

	}

}
