package Selenium15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownHandle {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		//driver.get("https://www.facebook.com/reg/");
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		By month= By.id("month");
		By day= By.id("day");
		By year= By.id("year");
		
//		WebElement selectMonth = driver.findElement(month);
//		WebElement selectDay = driver.findElement(day);
//		WebElement selectYear = driver.findElement(year);
//		
//		//month
//		Select select1 = new Select(selectMonth);
//		select1.selectByIndex(4);
//		
//		//day
//		Select select2 = new Select(selectDay);
//		select2.selectByVisibleText("20");
//		
//		//year
//		Select select3 = new Select(selectYear);
//		select3.selectByValue("2019");
		
//		doSelectDropdownByIndex(month, 5);
//		doSelectDropdownByIndex(day, 10);
//		doSelectDropdownByIndex(year, 9);
		
//		doSelectDropdownByVisibleText(month, "Aug");
//		doSelectDropdownByVisibleText(day, "23");
//		doSelectDropdownByVisibleText(year, "2011");
		
//		doSelectDropdownByValue(month,"5");
//		doSelectDropdownByValue(day,"15");
//		doSelectDropdownByValue(year,"2020");
		
		By country = By.id("Form_getForm_Country");
		boolean flag=doSelectDropdownByVisibleText(country, "India");
		System.out.println(flag);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static boolean doSelectDropdownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByIndex(index);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(index + "is not present in the dropdown");
			return false;
		}
	}
	
	//Interview Qstn: how will you make sure the element is selected from dropdown
	public static boolean doSelectDropdownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByVisibleText(visibleText);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(visibleText + "is not present in the dropdown");
			return false;
		}
	}
	
	public static boolean doSelectDropdownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		try {
			select.selectByValue(value);
			return true;
		} catch (Exception e) {
			System.out.println(value + "is not present in the dropdown");
			return false;
		}
	}

}
