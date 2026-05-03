package Selenium20;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AuthenticationPopUp04 {
	static WebDriver driver;

//Authentication popup/ Auth popup
	public static void main(String[] args) {

		driver = new ChromeDriver();
		// driver = new EdgeDriver();
		// user: admin ; password : admin

		// Handle authentication popup:
		// Basic authentication: username/Password
		// Username and password should be given in url.
		// Disadvantage: If password has @ , it will consider the url whatever is after @

		// 1. approach
		// driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String username = "admin";
		String password = "admin";
		// driver.get("https://" + username + ":"+ password + "@" +
		// "the-internet.herokuapp.com/basic_auth");

		// selenium 4.x
		// to overcome the limitation:
		((HasAuthentication) driver).register(() -> new UsernameAndPassword(username, password));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		String msg = driver.findElement(By.xpath("//div[@id='content']//p")).getText();
		System.out.println(msg);

	}

}
