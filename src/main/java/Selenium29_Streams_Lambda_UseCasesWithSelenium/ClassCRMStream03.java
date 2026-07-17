package Selenium29_Streams_Lambda_UseCasesWithSelenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassCRMStream03 {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		//All Paragraphs
		//List<WebElement> paragraphs =driver.findElements(By.cssSelector("section#details p"));
		
		//All Headers
		//List<WebElement> headers =driver.findElements(By.cssSelector("section#details h3"));
		
		//String allPara = headers.stream().map(e -> e.getText()).collect(Collectors.joining("||"));
		//System.out.println(allPara);
		
		//if you dont want to use map + to get TagName
		
		//headers.stream().forEach(e -> System.out.println(e.getText() + "--" + e.getTagName()));
		
		By headers = By.cssSelector("section#details h3");
		//getHeadersList(headers);
		
		if(getHeadersList(headers).contains("Marketing Campaigns")) {
			System.out.println("PASS");
		}
	}
	
	public static void printHeadersList(By locator) {
		driver.findElements(locator).stream().forEach(e -> System.out.println(e.getText()));
	}
	
	public static List<String> getHeadersList(By locator) {
		return driver.findElements(locator).stream().map(e -> e.getText()).collect(Collectors.toList());
	}

}
