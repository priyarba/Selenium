package Selenium25_WaitsForAlertFrameURLTitleWindow;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWindow05 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com");
		// String parentWindowID = driver.getWindowHandle(); // --- No need to define
		// this while you are using explicit
		// wait

		// full screen
		driver.manage().window().maximize();

		// cookie popup
		driver.findElement(By.xpath("//button[text()='Allow all']")).click();
		Thread.sleep(2000);
		//Actions act = new Actions(driver);
		//act.sendKeys(Keys.END).perform();

		// xpaths for all the logos
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// WebElement facebook = driver.findElement(By.xpath("//img[@alt='facebook']"));
		By facebookLink = By.xpath("//img[@alt='facebook']");
		WebElement facebook = wait.until(ExpectedConditions.visibilityOfElementLocated(facebookLink));
		facebook.click();

		// Explicit wait : numberOfWindowsToBe

		// wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		if (waitForWindow(5, 2)) {
			;

			// 1. get window IDs
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();

			String parentWindowID = it.next();
			System.out.println("parent window ID is: " + parentWindowID);

			String childWindowID = it.next();
			System.out.println("child window ID is: " + childWindowID);

			// 2. Switching work
			driver.switchTo().window(childWindowID);
			System.out.println("Child Window Title: " + driver.getTitle());

			// close the child window:
			driver.close();

			wait.until(ExpectedConditions.numberOfWindowsToBe(1));

			// driver is lost

			// switch back to parent window:
			driver.switchTo().window(parentWindowID);
			System.out.println("Parent window title :" + driver.getTitle());
		}

	}

	public static boolean waitForWindow(int timeOut, int expectedNumberOfWindows) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			return wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
		} catch (Exception e) {
			System.out.println("Expected number of windows are not correct");
			return false;
		}
	}

}
