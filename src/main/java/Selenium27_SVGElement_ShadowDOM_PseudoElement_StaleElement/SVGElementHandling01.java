package Selenium27_SVGElement_ShadowDOM_PseudoElement_StaleElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElementHandling01 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver(); //topcasting
//		driver.get("https://www.flipkart.com");
//		Thread.sleep(3000);
//		
		/*
		 * SVG Elements : Scalable vector graphics
		 * XML-based tags used to draw 2D vector graphics directly in web browsers
		 * 
		 * xpath of SVG are slightly different than other webElements; and are difficult to handle
		 *//*[local-name()='svg' and @fill='none'] -- flipKart search icon
		 * you can either use local-name() or name()
		 */
//		
//		driver.findElement(By.name("q")).sendKeys("mackbook");
//		driver.findElement(By.xpath("//*[local-name()='svg' and @fill='none'] ")).click();
		
		
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		Thread.sleep(3000);
		String xpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='g' and @class = 'region']";
		
		//switch to frame
		//map-instance-5816
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'map-instance')]")));
		Thread.sleep(3000);
		
		List<WebElement> regionsList = driver.findElements(By.xpath(xpath));
		
		//Size
		System.out.println(regionsList.size());
		
		//Print all the reqions
		//move the pointer to each region
		Actions action = new Actions(driver);
		for(WebElement e : regionsList) {
			String regionName = e.getDomAttribute("id");
			System.out.println(regionName);
			//move the pointer to each region
			action.moveToElement(e).perform();
			Thread.sleep(500);
		}

	}

}
