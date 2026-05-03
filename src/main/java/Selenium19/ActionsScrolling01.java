package Selenium19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling01 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");

		Actions act = new Actions(driver);

		// Partial scrolling
		// 1. Keys.PAGE_DOWN
		act.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);

		// 2. Keys.PAGE_UP
		act.sendKeys(Keys.PAGE_UP).perform();
		Thread.sleep(2000);

		// Go to the end of the page: FOOTER
		// windows: Keys.CONTROL
		// mac: Keys.COMMAND

		act.sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		// OR
		// act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		// Both are working

		// Go to the top of the page
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		Thread.sleep(2000);

		// scroll to Element
		act
		.scrollToElement(driver.findElement(By.linkText("About Us")))
		.pause(200)
		.click(driver.findElement(By.linkText("About Us")))
		.perform();

	}

}
