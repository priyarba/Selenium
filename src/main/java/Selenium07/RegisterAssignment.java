package Selenium07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Selenium05.BrowserUtils;
import Selenium06.ElementUtil_02;

public class RegisterAssignment {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
//		driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		BrowserUtils bu = new BrowserUtils();
		bu.initDriver("chrome");	
		
		bu.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//Firstname
		//locator : id
		By firstName = By.id("input-firstname");
		ElementUtil_02 eu = new ElementUtil_02(driver);
		eu.doSendKeys(firstName, "tom");
		
		//Lastname
		//locator : name
		By lastName = By.name("lastname");
		eu.doSendKeys(lastName, "jerry");
		
		//email
		//locator : xpath
		By email = By.xpath("//*[@id=\"input-email\"]");
		eu.doSendKeys(email, "truck1@gmail.com");
		
		//telephone
		By phone = By.id("input-telephone");
		eu.doSendKeys(phone, "182648688234");
		
		//password
		By password = By.xpath("//*[@id=\"input-password\"]");
		eu.doSendKeys(password, "test@123");
		
		//confirm password
		By confirmPwd = By.xpath("//*[@id=\"input-confirm\"]");
		eu.doSendKeys(confirmPwd, "test@123");
		
		//checkbox
		By clickCheckBox = By.name("agree");
		eu.doClick(clickCheckBox);
		
		//click continue
		By continueButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		eu.doClick(continueButton);
		
		//Validations
		//1. verify text
		By successMessage = By.tagName("h1");
		String message = eu.doGetText(successMessage);
		System.out.println(message);
		if(message.equals("Your Account Has Been Created!")) {
			System.out.println("Account creation successfull -- PASS");
		}
		
		//2. verify url
//		String currentUrl = driver.getCurrentUrl();
//		if(currentUrl.contains("success")) {
//			 System.out.println("URL contains success");
//		}
		
		String currentUrl = bu.getPageURL();
		if(currentUrl.contains("success")) {
			 System.out.println("URL contains success");
		}
		
		//3. getPage title
		String pageTitle = bu.getPageTitle();
		System.out.println(pageTitle);
		
		//4. check logout link
		By logoutLink = By.linkText("Logout");
		eu.doClick(logoutLink);
		System.out.println("Account is logged out");
		
		
		//close browser
		bu.quitBrowser();
	}

}
