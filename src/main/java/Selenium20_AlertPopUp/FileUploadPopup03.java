package Selenium20_AlertPopUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopup03 {
	static WebDriver driver;
	public static void main(String[] args) {
		
		//File upload pop up
		
		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/upload");
		
		//htmltag can be anything: input, button, div
		//attribute: Type=file should be present, or we cannot automate this scenario. 
		
		//do not use .click() for upload button; only use sendKeys()
		driver.findElement(By.id("fileInput")).sendKeys("D:\\Grocery List.xlsx");
		

	}

}
