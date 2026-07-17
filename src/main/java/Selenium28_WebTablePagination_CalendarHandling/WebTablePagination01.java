package Selenium28_WebTablePagination_CalendarHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination01 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);
		
		//multi selection:
		while(true) {
			if(driver.findElements(By.xpath("//td[text()='India']")).size()>0) {
				System.out.println("Country is found");
				selectMultipleCountry("India"); //break should not be applied for multiselect
			}
			//else is not applied as it will never go inside the else part
			//pagination logic: click next
			WebElement next = driver.findElement(By.cssSelector("button.next"));
			if(next.getDomAttribute("class").contains("disabled")) {
				System.out.println("Pagination is over... Country is not found...");
				break;
			}
			
			next.click();
			Thread.sleep(1000);
			
		}
		

//		// single selection:
//		while (true) {
//			if (driver.findElements(By.xpath("//td[text()='naveen']")).size() > 0) {
//				System.out.println("Country is found");
//				selectCountry("Naveen");
//				break;
//			}
//			else {
//				//pagination logic:
//				//click on next
//				WebElement next =driver.findElement(By.cssSelector("button.next"));
//				if(next.getDomAttribute("class").contains("disabled")) {
//					System.out.println("Pagination is over... Country is not found...");
//					break;
//				}
//				next.click();
//				Thread.sleep(1000);
//			}
//		}

	}
	
	public static void selectMultipleCountry(String countryName) {
		List<WebElement> countryList = driver.findElements(By.xpath("//td[text()='"+countryName+"']/preceding-sibling::td/input[@type='checkbox']"));
		for(WebElement e : countryList) {
			e.click();
		}
	}

	public static void selectCountry(String countryName) {
		driver.findElement(
				By.xpath("//td[text()='" + countryName + "']/preceding-sibling::td/input[@type='checkbox']")).click();
	}

}
