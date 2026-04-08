package Selenium07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		
		//1. id: unique attribute
		driver.findElement(By.id("input-firstname")).sendKeys("Priya");
		
		//2. name: can be duplicate
		driver.findElement(By.name("lastname")).sendKeys("testing");
		
		
		//3. class name: can be duplicate most of the time
		//driver.findElement(By.className("form-control")).sendKeys("java@gmail.com");
		//form-control --> 1 of 7
		//img-responsive -->1 of 1
		
		// to check the count of class available in inspect DOM window --> ctrl+f --> .img-responsive
		
		//driver.findElement(By.className("img-responsive")).click();
		
		//4. xpath : not an attribute; its address of an element in the DOM
		driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("12333322");
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("tom@gmail.com");
		
		//5. cssSelector: not an attribute
		driver.findElement(By.cssSelector("#input-password")).sendKeys("abc@123");
		driver.findElement(By.cssSelector("#input-confirm")).sendKeys("abc@123");
		
		//6. linkText : works only for links
		//htmlTag : <a>
		driver.findElement(By.linkText("Delivery Information")).click();
		
		//7. partialLinkText : only for links
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		
		
		//8. tagName: only for tags
		//driver.findElement(By.tagName("h2")).getText();
		
		By header = By.tagName("h2");
		String actualHeader = doGetText(header);
		//System.out.println("Actual Header is: "+ actualHeader);
		if(actualHeader.equals("New Customer")) {
			System.out.println("Header is correct -- PASS");
		}
	}
	
	public static String doGetText(By locator) {
		String elementText = getElement(locator).getText();
		System.out.println("Element Text: "+ elementText);
		return elementText;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	

}
