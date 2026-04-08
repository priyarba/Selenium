package Selenium16;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownGetAllOptions02 {
//Interview Question: how will you select the value w/o using selectByIndex/Value/VisibleText
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");

		By country = By.id("Form_getForm_Country");
		selectDropdownValue(country, "India");

	}

	public static boolean selectDropdownValue(By locator, String value) {
		WebElement countryEle = driver.findElement(locator);

		Select select = new Select(countryEle);
		// gives all options in the dropdown
		List<WebElement> eleList = select.getOptions();
		System.out.println(eleList.size());
		
		boolean flag=false;

		// to print the options
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);

			// to click the element and break the loop
			if (text.equals(value)) {
				e.click();
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println(value + "is selected");
			return true;
		}
		else {
			System.out.println(value + "is not selected");
			return false;
		}
	}

}
