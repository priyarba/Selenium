package Selenium28_WebTablePagination_CalendarHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling02 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		Thread.sleep(2000);

		driver.findElement(By.id("datepicker")).click();
		futureDate("February 2027", "28");
	}

	public static void futureDate(String expMonthYear, String day) {

		// conditions : Corner cases
		if(expMonthYear.contains("February") && Integer.parseInt(day)>29) {
			System.out.println("Wrong day is passed, please pass the day range between 1 to 31");
			return;
		}
		
		if (Integer.parseInt(day) > 31) {
			System.out.println("Wrong day is passed, please pass the day range between 1 to 31");
			return; //return with nothing
		}
		
		if(Integer.parseInt(day)<=0) {
			System.out.println("Wrong day is passed, please pass the day range between 1 to 31");
		}
		

		String actMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(actMonthYear); // current month

		while (!actMonthYear.equalsIgnoreCase(expMonthYear)) {
			// click on next icon
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println(actMonthYear);
		}
		driver.findElement(By.linkText(day)).click();
	}
}
