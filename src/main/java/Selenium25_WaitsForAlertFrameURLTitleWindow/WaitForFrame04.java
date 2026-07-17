package Selenium25_WaitsForAlertFrameURLTitleWindow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame04 {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");		
		//driver.findElement(By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']")).click();
		By image = By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']");
		By frame = By.xpath("//iframe[contains(@id,'frame-one')]");
		By name = By.id("RESULT_TextField-1");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(image)).click();
		
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		waitForFrameAndSwitchToIt(frame, 5);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys("Naveen");
		
		driver.switchTo().defaultContent();
		
		String header = driver.findElement(By.cssSelector("h3.details__form-preview-title")).getText();
		System.out.println(header);
	}
	
	public static void waitForFrameAndSwitchToIt(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public static void waitForFrameAndSwitchToIt(String frameNameOrID, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
	}
	
	public static void waitForFrameAndSwitchToIt(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public static void waitForFrameAndSwitchToIt(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

}
