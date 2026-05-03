package Selenium18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class contextClickConcept04 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		// Right click on browser cannot be automated as they are not webelements and
		// cannot be inspected

		WebElement rightClickElement = driver.findElement(By.xpath("//span[text()='right click me']"));

		// to Right click on the element
		Actions act = new Actions(driver);
		act.contextClick(rightClickElement).perform();

		// Print the list for right click menu
		// Shortcut to assign to local variable: ctrl+2 -> select 'Assign to local
		// variable'
		List<WebElement> optionList = driver
				.findElements(By.cssSelector("ul.context-menu-list>li.context-menu-icon>span"));
//		
//		//size
//		System.out.println(optionsList.size());
//		
//		for(WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//			// to click on the option
//			if(text.equals("Copy")) {
//				e.click();
//				break;
//			}
//		}

		// 2nd Way: easy
		driver.findElement(By.xpath("//span[text()='Copy']")).click();

	}

}
