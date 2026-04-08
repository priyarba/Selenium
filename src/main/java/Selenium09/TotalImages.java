package Selenium09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		List<WebElement> imagesList =driver.findElements(By.tagName("img"));
		
		System.out.println(imagesList.size());
		
		for(WebElement e : imagesList) {
			
			//Thsi is called web scraping
			String altVal = e.getDomAttribute("alt");
			String scrVal = e.getDomAttribute("src");
			
			System.out.println(altVal +"="+ scrVal);
		}
		

		
	}

}
