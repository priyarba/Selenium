package Selenium05;

import org.openqa.selenium.WebDriver;

public class OpenCartAppTest {

	public static void main(String[] args) {
		
		BrowserUtils bu= new BrowserUtils();
		WebDriver driver = bu.initDriver("chrome");
		bu.launchURL("https://naveenautomationlabs.com/");
		
		//Title
		String actualTitle= bu.getPageTitle();
		if(actualTitle.equals("Account Login")) {
			System.out.println("title is correct -- PASS");
		}
		else {
			System.out.println("Title is not correct -- FAIL");
		}
		
		//URL
		String actualUrl=bu.getPageURL();
		if(actualUrl.contains("naveenautomationlabs")) {
			System.out.println("Login page URL is correct -- PASS");
		}
		else {
			System.out.println("Login page url is incorrect -- FAIL");
		}
		
		bu.quitBrowser();
	}
	
	

}
