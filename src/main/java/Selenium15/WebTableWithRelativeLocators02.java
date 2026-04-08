package Selenium15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

public class WebTableWithRelativeLocators02 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(4000);
		
		WebElement username = driver.findElement(By.linkText("Joe.Root"));
		
		//click on the left checkbox --toLeftOf
		driver.findElement(with(By.tagName("td")).toLeftOf(username)).click();
		
		//print all elements to the right of Joe.Root
		//Note: findElements is not suitable with relativeLocators 
		//as it gives the all the elements to the right of username
		
		List<WebElement> eleList=driver.findElements(with(By.tagName("td")).toRightOf(username));
		
		for(WebElement e : eleList) {
			String text =e.getText();
			System.out.println(text);
		}
		
		

	}

}
