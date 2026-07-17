package Selenium29_Streams_Lambda_UseCasesWithSelenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Streams01 {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		//Streams -> JDK 8
		//lambda ->
		//instead of using for or foreach loop, we can use streams
		//Advantage: Script will me more readable
		
		//Streams will be applied on the array list
		//Streams will be using lambda expressions also.
		
//This will print all the links including blank links
		//Here e is a variable
		//allLinks.stream().forEach(e -> System.out.println(e.getText()));
		
		//to avoid blank links
		//allLinks.stream().filter(e -> !e.getText().isEmpty()).forEach(e-> System.out.println(e.getText()));
		
		//This is a builder pattern
		//Using filter with .startsWith()
//		allLinks
//		.stream()
//		.filter(e -> !e.getText().isEmpty())
//		.filter(e -> e.getText().startsWith("Flipkart"))
//		.forEach(e -> System.out.println(e.getText()));
		
		//.collect: 
		List<WebElement> flipKartLinks = allLinks
		.stream()
		.filter(e -> !e.getText().isEmpty())
		.filter(e -> e.getText().startsWith("Flipkart"))
		.collect(Collectors.toList());
		
		List<String> flipKartLinksText =flipKartLinks.stream().map(e -> e.getText()).collect(Collectors.toList());
		System.out.println(flipKartLinksText);
		System.out.println(flipKartLinksText.size());
	}

}
