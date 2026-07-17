package Selenium26_FluentWaitPageReadyState;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElements01 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		By footerLinks = By.xpath("//footer//a");

		// presenceOfAllElementsLocatedBy: An expectation for checking that there is at
		// least one element present on a web page.

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> footerList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(footerLinks));
		System.out.println(footerList.size());

		// An expectation for checking that all elements present on the web page that match the locator are visible.
		// Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
		List<WebElement> footerLinksList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerLinks));
		System.out.println(footerLinksList.size());

	}

}
