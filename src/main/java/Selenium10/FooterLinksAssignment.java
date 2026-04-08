package Selenium10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterLinksAssignment {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		List<WebElement> footerList =driver.findElements(By.xpath("//footer//div[@class='row']//li"));
		System.out.println(footerList.size());
		
		for(WebElement e: footerList) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains("Delivery Information")) {
				e.click();
				break;
			}
		}

	}

}
