package Selenium16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDorpdownListReturn {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg/");
		
		By month= By.id("month");
		By day= By.id("day");
		By year= By.id("year");
		
		List<String> monthList=getDropdownValueList(month);
		System.out.println(monthList);
		
		//create an expected arrayList
		List<String> expectedMonthList=Arrays.asList("Jan", "Feb","Mar");
		
		if(monthList.containsAll(expectedMonthList)) {
			System.out.println("PASS");
		}
		
	}
	
	public static List<String> getDropdownValueList(By locator) {
		
		Select select = new Select(driver.findElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		
		List<String> optionsValList = new ArrayList<String>();
		
		for(WebElement e : optionsList) {
			String text =e.getText();
			optionsValList.add(text.trim());
		}
		return optionsValList;
	}

}
