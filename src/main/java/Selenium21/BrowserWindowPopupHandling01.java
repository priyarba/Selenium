package Selenium21;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserWindowPopupHandling01 {
	// Window Handler API: tab/window: browser window popup
	// url, title, webelements
	// When the attribute target=blank ; it will always open a new tab
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/"); // parent
		Thread.sleep(2000);
		
		//cookie popup
		driver.findElement(By.xpath("//button[text()='Allow all']")).click();
		// Scroll to the bottom of the page: ElementClickInterceptedException
		Actions act = new Actions(driver);
		act.sendKeys(Keys.END).perform();
		Thread.sleep(4000);
		driver.findElement(By.linkText("About Us")).click(); // child

		// 1. Fetch the window IDs

		// Return a set of window handles which can be used to iterate over all open windows of this WebDriver instance 
		// by passing them to switchTo().Options.window()
		//Why Set? 
		//Bcoz window ID cannot be duplicate.
		//And its pre-defined by Java.
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		//Parent window ID
		String parentWindowID = it.next(); //Returns the next element in the iteration.
		System.out.println("Parent window ID: " + parentWindowID);
		
		//Child window ID
		String childWindowID = it.next();
		System.out.println("Child window ID: " + childWindowID);
		
		//2. switching between windows
		driver.switchTo().window(childWindowID);
		System.out.println("Child Window Title : " + driver.getTitle());
		Thread.sleep(2000);
		
		//close the child window:
		driver.close(); // Close the current window
		
		//driver is lost:
		
		//switch back to parent window:
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent window ID: "+ driver.getTitle());
		Thread.sleep(2000);
		
		//driver.quit(); //Quits this driver, closing every associated window.
	}

}
