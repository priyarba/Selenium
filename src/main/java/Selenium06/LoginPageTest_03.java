package Selenium06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Selenium05.BrowserUtils;

public class LoginPageTest_03 {

	public static void main(String[] args) {
		
		BrowserUtils bu = new BrowserUtils();
		
		//Initialize driver method
		WebDriver driver = bu.initDriver("chrome");
		
		//launch url method
		bu.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		System.out.println(bu.getPageTitle());
		
		By emailField = By.id("input-email");
		By passwordField = By.id("input-password");
		
		ElementUtil_02 eu = new ElementUtil_02(driver); //this driver is returned form initDriver method of BrowserUtils class
		eu.doSendKeys(emailField, "tom@gmail.com");
		eu.doSendKeys(passwordField, "tom@123");
		
		//bu.closeBrowser();
		bu.quitBrowser();
		
		//Search for file(ctrl+shift+r)

	}

}
