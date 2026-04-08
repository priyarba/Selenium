package Selenium12;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		Thread.sleep(5000);

		// 1.parent to child:
		// parentTag[@attr='value']/childTag[@attr='value']
		// parentTag[@attr='value']/childTag[@attr='value']

		// parentTag[@attr='value']/child::childTag[@attr='value']

		// 2.child to parent:
		// input[@id='input-email']/../../..
		// input[@id='input-email']/parent::div/parent::form

		// 3. child to grandparent
		// input[@id='input-email']/ancestor::form/ancestor::div[@id='content']

		// 4. Sibling
		// input[@id='input-email']/preceding-sibling::label
		// label[@for='input-email']/following-sibling::input

		// 1st path
		// a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']
		// a[text()='John.Smith']/parent::td/preceding-sibling::td/input[@type='checkbox']

		// 2nd path
		// a[text()='John.Smith']/ancestor::tr//input[@type='checkbox']
		// a[text()='John.Smith']/ancestor::tr//input[@type='checkbox']

//		driver.findElement(By.xpath("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
//		driver.findElement(By.xpath("//a[text()='John.Smith']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();

		selectUser("Joe.Root");
		selectUser("John.Smith");

		getUserDetails("Joe.Root");
		
		if(getUserDetails("John.Smith").contains("Enabled")) {
			System.out.println("PASS");
		}
		

	}
	
	public static List<String> getUserDetails(String userName) {
		List<WebElement> list = driver
				.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
		System.out.println(list.size());
		
		List<String> colList =new ArrayList<String>();
		for(WebElement e: list) {
			String text = e.getText();
			System.out.println(text);
			colList.add(text);
			
		}
		return colList;
	}

	public static void selectUser(String userName) {
		driver.findElement(
				By.xpath("//a[text()='" + userName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

}
