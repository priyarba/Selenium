package Selenium29_Streams_Lambda_UseCasesWithSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks04 {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		//driver.get("https://classic.crmpro.com/");
		driver.get("https://www.freshworks.com/");
		
		//Instead of stream, we can use parallel stream
		/**
		 * Parallel Stream:
		 * -- Asynchronous process
		 * -- while execution, a seperate stream will be created for each element
		 * -- And execution for each element happens in parallel
		 * -- Faster than stream
		 * 
		 * Stream:
		 * -- Synchronous process
		 * -- hence makes the execution slower
		 * -- Execution of elements happens in a sequence
		 */
		//In parallel stream, process is asynchronous 
		
//		driver.findElements(By.tagName("a"))
//		.parallelStream()
//		.filter(e ->!e.getText().isEmpty())
//		.forEach(e -> System.out.println(e.getText()));
		
		List<String> linksList = new ArrayList<String>();

		List<WebElement> linksAllList = driver.findElements(By.tagName("a"))
				.stream()
				.filter(e ->!e.getText().isEmpty())
				.collect(Collectors.toList());
		
		linksAllList.forEach(e -> linksList.add(e.getText()));
		System.out.println(linksList);
	}

}
