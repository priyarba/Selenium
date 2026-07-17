package Selenium29_Streams_Lambda_UseCasesWithSelenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceLabsStreams02 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");

		// login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		// Capture the prize of all the listings
		List<WebElement> pricesList = driver.findElements(By.cssSelector("div.inventory_item_price"));

		// Output: $29.99 $9.99 $15.99 $49.99 $7.99 $15.99
		// pricesList.stream().forEach(e -> System.out.println(e.getText()));

		// To get an output without $ : 29.99 9.99 15.99 49.99 7.99 15.99
//		pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1))).forEach(e-> System.out.println(e));

		// Instead of printing using for-each loop we can use Collectors
		// sorted order
//		List<Double> sorted_prices =pricesList
//		.stream()
//		.map(e -> Double.parseDouble(e.getText().substring(1)))
//		.sorted()
//		.collect(Collectors.toList());
//		
//		System.out.println(sorted_prices);

		// To capture in decending order:

//		List<Double> sorted_prices_desc =pricesList
//		.stream()
//		.map(e -> Double.parseDouble(e.getText().substring(1)))
//		.sorted(Comparator.reverseOrder()) 
//		.collect(Collectors.toList());
//		
//		System.out.println(sorted_prices_desc);

		// To capture the first value : findFirst()
		double firstPrice = pricesList
				.stream()
				.map(e -> Double.parseDouble(e.getText().substring(1)))
				.findFirst().get();
		System.out.println(firstPrice);

		// To capture the last value : reduce()
		double lastPrice = pricesList
				.stream()
				.map(e -> Double.parseDouble(e.getText().substring(1)))
				.reduce((first, second) -> second).get();
		System.out.println(lastPrice);
		
		//To print the maximum value
		double maxPrice = pricesList
				.stream()
				.map(e -> Double.parseDouble(e.getText().substring(1)))
				.max(Double::compareTo).get();
		System.out.println(maxPrice);
		
		//To print minimum price
		double minPrice = pricesList
				.stream()
				.map(e -> Double.parseDouble(e.getText().substring(1)))
				.min(Double::compareTo).get();
		System.out.println(minPrice);

	}

}
