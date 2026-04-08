package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchTest_04 {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "c://Users//rajes//chromedriver.exe");
		//after selenium 4.6, setProperty is not required to be used. exe files gets updated automatically through selenium Manager
		
		WebDriver driver = new ChromeDriver(); //session id 123
		driver = new ChromeDriver();// 345
		driver = new ChromeDriver(); //567
		//3 different browsers will be launched
		
		driver.get("https://www.google.com"); //567 - url will be entered in 3rd instance
		driver.quit(); //567 - 3rd instance will be closed
		driver.quit(); //no error/Exception will be thrown here; But session ID is null
	}
	
	

}
