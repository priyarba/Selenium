package Selenium21;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentMultipleWindowHandler03 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/"); // parent
		Thread.sleep(2000);
		String parentWindowID = driver.getWindowHandle();

		// cookie popup
		driver.findElement(By.xpath("//button[text()='Allow all']")).click();

		// scroll to the bottom:
		Actions act = new Actions(driver);
		act.sendKeys(Keys.END).perform();
		Thread.sleep(2000);

		// xpaths for all the logos
		WebElement facebook = driver.findElement(By.xpath("//img[@alt='facebook']"));
		WebElement linkedIn = driver.findElement(By.xpath("//img[@alt='linkedin']"));
		WebElement youTube = driver.findElement(By.xpath("//img[@alt='youtube']"));

		// click on the logos
		facebook.click();
		linkedIn.click();
		youTube.click();

		// Switch work
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			System.out.println(driver.getTitle());
			if (!windowID.equals(parentWindowID)) {
				driver.close();
			}
			driver.switchTo().window(parentWindowID);
			System.out.println("Switched to Parent Window: "+ driver.getTitle());
		}
	}

}
