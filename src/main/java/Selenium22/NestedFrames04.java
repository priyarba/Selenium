package Selenium22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames04 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-scenario/");
		Thread.sleep(2000);
		//frame1
		driver.switchTo().frame("pact1");
		driver.findElement(By.id("inp_val")).sendKeys("Testing");
		
		//frame2
		driver.switchTo().frame("pact2");
		driver.findElement(By.id("jex")).sendKeys("automation");
		
		//frame3
		driver.switchTo().frame("pact3");
		driver.findElement(By.id("glaf")).sendKeys("Google");
		
		//frame3 -> frame2
		driver.switchTo().parentFrame();
		driver.findElement(By.id("jex")).sendKeys(" with selenium");
		
		//frame2 -> frame1
		driver.switchTo().parentFrame();
		driver.findElement(By.id("inp_val")).sendKeys(" in NAL");
		
		//frame1 -> page (defaultContent)
//		driver.switchTo().defaultContent();
//		String header = driver.findElement(By.tagName("h6")).getText();
//		System.out.println(header);
		
		// or we can also do frame1 -> page(parentFrame)
		driver.switchTo().parentFrame();
		String header = driver.findElement(By.tagName("h6")).getText();
		System.out.println(header);
		
		//Switching of frames has to happen in a sequence
		//page --> frame2: invalid
		driver.switchTo().frame("pact2");
		driver.findElement(By.id("jex")).sendKeys(" Cypress");
		
		//Other way of switching between frames
		//page -> frame1 -> frame2 -> frame3 -> element
//		driver.switchTo().frame("pact1")
//			.switchTo().frame("pact2")
//				.switchTo().frame("pact3")
//						.findElement(By.id("glaf")).sendKeys("Google");

	}

}
