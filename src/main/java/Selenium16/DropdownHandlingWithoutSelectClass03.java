package Selenium16;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownHandlingWithoutSelectClass03 {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		// No select class
		By countryOptions = By.cssSelector("select#Form_getForm_Country>option");

		// List<WebElement> eleList
		// =driver.findElements(By.cssSelector("select#Form_getForm_Country>option"));
		
		noSelectDropdown(countryOptions, "Mexico");

	}

	public static void noSelectDropdown(By locator, String value) {
		List<WebElement> eleList= getElements(locator);
		
		System.out.println(eleList.size());

		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
