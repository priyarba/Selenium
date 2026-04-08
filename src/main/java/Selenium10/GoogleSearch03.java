package Selenium10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch03 {
 
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		//driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		
		By eleList = By.name("q");
		doSendKeys(eleList, "Selenium Automation" );
		
		Thread.sleep(5000);
		
		List<WebElement> suggList= driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));
		System.out.println();
		
		for(WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains("jobs")) {
				e.click();
				break;
			}
			
		}
		

	}
	
	public static void suggListOption() {
		
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
