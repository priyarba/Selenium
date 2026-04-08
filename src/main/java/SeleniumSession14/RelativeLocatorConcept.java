package SeleniumSession14;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;;

public class RelativeLocatorConcept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		
		Thread.sleep(20000);

		//selenium 4.x:
//                  above		
//		              |
//		 left <----- ele-----> right
//		              |
//		            below
		            
		 //near element
		WebElement ele = driver.findElement(By.xpath("//p[text()='St Albert']"));
		
		//driver.findElement(RelativeLocator.with(By.tagName("p")));
		//you can also write this as
		
		String leftRank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(leftRank);
		
		String rightAQIStatus = driver.findElement(with(By.cssSelector("div.aqi-status")).toRightOf(ele)).getText();
		System.out.println(rightAQIStatus);
		
		
	}

}
