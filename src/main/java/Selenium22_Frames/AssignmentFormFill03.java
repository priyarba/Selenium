package Selenium22_Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFormFill03 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(2000);
// click on the image
		driver.findElement(By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		getElement(By.id("RESULT_TextField-1")).sendKeys("Testing");
		getElement(By.id("RESULT_TextField-4")).sendKeys("11/11/2026");
		getElement(By.id("RESULT_TextArea-5")).sendKeys("Testing puropse");
		
		//file upload
		getElement(By.id("RESULT_FileUpload-6")).sendKeys("D:\\Grocery List.xlsx");
		
		getElement(By.id("RESULT_TextField-8")).sendKeys("Tom");
		getElement(By.id("RESULT_TextField-9")).sendKeys("Jerry");
		getElement(By.id("RESULT_TextField-10")).sendKeys("123");
		
		//switch to main content
		driver.switchTo().defaultContent();
		getElement(By.xpath("//a[@title='Get this form']")).click();
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
