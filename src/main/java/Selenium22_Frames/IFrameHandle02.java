package Selenium22_Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandle02 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']")).click();
		Thread.sleep(5000);
		
		//switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Testing");
		
		//switch back to the main page:
		driver.switchTo().defaultContent();
		
		String header = driver.findElement(By.cssSelector("h3.details__form-preview-title")).getText();
		System.out.println(header);

	}

}
