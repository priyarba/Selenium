package Selenium05;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtils {
	
	//press ctrl+o on the class name . it will give you list of methods available withing the class

	private WebDriver driver;

	/**
	 * this is used to initialize the driver on the basis of given browser name:
	 * chrome, firefox, edge, safari
	 * 
	 * @param browserName
	 * @return it returns webdriver
	 */

	public WebDriver initDriver(String browserName) {
		System.out.println("Browser name: " + browserName);

		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Please enter the correct browser: " + browserName);
			throw new BrowserException("====INVALID BROWSER========");
		}
		return driver; //this is used to supply the driver in other utilities
	}

	public void launchURL(String url) {
		nullCheck(url);
		lengthCheck(url);
		httpCheck(url);
		driver.get(url);
	}

	public void launchUrl(URL url) {

		String appUrl = String.valueOf(url);
		
		nullCheck(appUrl);
		lengthCheck(appUrl);
		httpCheck(appUrl);
		driver.navigate().to(url);
	}
	//These are wrapper functions
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("The page title is: " + title);
		return title;
	}

	public String getPageURL() {
		String pageURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + pageURL);
		return pageURL;
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();
			System.out.println("Browser is closing");
		}
	}
	
	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser is closing");
		}
	}

	private void lengthCheck(String value) {
		if (value.length() == 0) {
			System.out.println("Please pass the right url.." + value);
			throw new BrowserException("===== Empty URL ====");
		}
	}

	private void httpCheck(String urlValue) {
		if (urlValue.indexOf("http") != 0) {
			System.out.println("http is missing in the url" + urlValue);
			throw new BrowserException("===== Invalid URL ====");
		}
	}
	
	private void nullCheck(String value) {
		if(value == null) {
			System.out.println("value cannot be null..." + value);
			throw new BrowserException("===== Value is null ====");
		}
	}

}
