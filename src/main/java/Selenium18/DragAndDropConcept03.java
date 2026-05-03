package Selenium18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept03 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		// Switch to the demo iframe
		driver.switchTo().frame(0);
		
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));
		//.build() : Generates a composite action containing all actions so far, ready to be performed
		
		//Difference between Actions and Action
		//Actions is a class; Builds a CompositeAction containing all actions specified by the method calls.
		//Action is an Interface representing a single user-interaction action.
		Actions act = new Actions(driver);
//		Action myAction = act.clickAndHold(sourceElement).moveToElement(targetElement)
//				.release()
//				.build(); 
//		myAction.perform();		
		
		//newly method
		act.dragAndDrop(sourceElement, targetElement).perform();

	}

}
