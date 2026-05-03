package Selenium23;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept01 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Selenium + Java --> JavaScriptExecutor -- inject JS code into the browser
		// RemoteWebDriver implements JavaScript executor and WebDriver
		// in order to implement we need to use downcasting method

		/**
		 * So the reference type is WebDriver.
		 * 
		 * But the actual object is ChromeDriver, and ChromeDriver implements
		 * JavascriptExecutor.
		 * 
		 * Java only lets you call methods that exist on the reference type. Since
		 * WebDriver does not have executeScript(), you must cast it to an interface
		 * that does.
		 * 
		 * So you explicitly cast:
		 */

		// Console ->clear -> type document.title

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// Console ->clear -> type document.title
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String title = js.executeScript("return document.title;").toString();
//		System.out.println(title);
//		
//		String url = js.executeScript("return document.URL;").toString();
//		System.out.println(url);
		
		JavascriptExecutorUtil02 jsUtil = new JavascriptExecutorUtil02(driver);
//		String title = jsUtil.getTitleByJavascript();
//		System.out.println(title);
//		
//		String url = jsUtil.getURLByJavascript();
//		System.out.println(url);
		
		//jsUtil.generateJSAlert("This is a test popup");
		
		//get page text
//		String pageText = jsUtil.getPageInnerText();
//		System.out.println(pageText);
		
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
		
		WebElement element =driver.findElement(By.xpath("//a[text()='Continue']"));
//		jsUtil.drawBorder(element);
		
//		WebElement email = driver.findElement(By.name("email"));
//		jsUtil.flash(email);

		jsUtil.clickElementByJS(element);
	}

}
