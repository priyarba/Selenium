package Selenium10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLanguageTest02 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		By langLocator = By.xpath("//div[@id='SIvCob']/a");
		clickElement(langLocator ,"Français" );

	}
	
	public static void clickElement(By locator, String value) {
		
		List<WebElement> eleList = driver.findElements(locator);
		System.out.println("Total no. of elements:"+ eleList.size());
		
		for(WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
		
	}

}
