package Selenium18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept01 {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
		//Actions class for mouse actions -- stimulates the mouse action
		//MoveToElement will scroll the mouse to the middle of the element.
		//.build() -- collect the particular action for the element 
		//.perform() -- perform the built action
		
		//XPATHS
		By addOns = By.xpath("//div[text()='Add-ons']");
		By visaServices = By.xpath("//div[text()='Visa Services']");
		
		By spiceClub = By.xpath("//div[text()='SpiceClub']");
		By benefits = By.xpath("//div[text()='Benefits']");
		
		//handleParentSubMenu(addOns,visaServices);
		handleParentSubMenu(spiceClub,benefits);

	}
	
	//Generic method to perform mouse action
	public static void handleParentSubMenu(By parentMenu, By subMenu) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(parentMenu)).build().perform();
		Thread.sleep(2000);
		getElement(subMenu).click();
	}
	
	
	//findElement method
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
