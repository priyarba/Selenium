package Selenium16;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownMiddleValue04 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		By country =By.id("Form_getForm_Country");
		
		Select select = new Select(driver.findElement(country));
		
		//Select middle value
		int middleIndex =select.getOptions().size()/2;
		select.selectByIndex(middleIndex);
		
		//select last value
		int lastIndex = select.getOptions().size()-1;
		select.selectByIndex(lastIndex);
		
		//select first value
		//select.selectByIndex(0);
		
		//
		List<WebElement> selectedOptions = select.getAllSelectedOptions();// list of all preselected values
		System.out.println(selectedOptions.size()); //1
		
		//first selected option -- single webelement
		String defaultValue = select.getFirstSelectedOption().getText();
		System.out.println(defaultValue);
		
		//ContainsVisibleText
		select.selectByContainsVisibleText("Antigua");

	}

}
