package Selenium22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle01 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//frames are developed for data security or webelement security
		driver = new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		Thread.sleep(3000);
		
		//total number of frames:
		int frameCount = driver.findElements(By.tagName("frame")).size();
		System.out.println(frameCount);
		
		//switch driver to frame : 3 ways
		//driver.switchTo().frame(2); // By index
		//driver.switchTo().frame("main"); // By name
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']"))); // By WebElement
		
		String header =driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);

	}

}
