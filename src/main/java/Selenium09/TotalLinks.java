package Selenium09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Selenium06.ElementUtil_02;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		// find total number of links on the page
		// print text of each link on the console
		// html tag <a>
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		
		By links = By.tagName("a");
		ElementUtil_02 eleUtil =new ElementUtil_02(driver);
		
		//count
		if(eleUtil.getElementsCount(links)>300) {
			System.out.println("Proper Links are present");
		}
		
		//get link text
		List<String> linksTextList = eleUtil.getElementTextList(links);
		if(linksTextList.contains("Corporate Information")) {
			System.out.println("PASS");
		}

//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		System.out.println("total links: " + links.size());
//		
//		System.out.println("-------------------------");

		// index loop:
//		for (int i = 0; i < links.size(); i++) {
//			String text = links.get(i).getText();
//			if (text.length() != 0) {
//				System.out.println(i + "=" + text);
//			}
//		}
		
		//Using for each loop
		
//		for(WebElement e : links) {
//			String text = e.getText();
//			if(text.length()!=0) {
//				System.out.println(text);
//			}
//		}

	}

}
