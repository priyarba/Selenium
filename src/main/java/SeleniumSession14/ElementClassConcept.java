package SeleniumSession14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementClassConcept {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login/legacy");
		
		//When there are 2 class names for a single attribute
		
		//1. Invalid: InvalidSelectorException
		//driver.findElement(By.className("TextInput__StyledInput-sc-1vx01eh-0 bUtxmd")).sendKeys("test@gmail.com");
	
	//2.Valid 
		//driver.findElement(By.cssSelector("input.TextInput__StyledInput-sc-1vx01eh-0.bUtxmd")).sendKeys("text@gmail.com");
	
	//3. valid
		//driver.findElement(By.xpath("//input[@class='TextInput__StyledInput-sc-1vx01eh-0 bUtxmd']")).sendKeys("test@gmail.com");
		
		//4. valid
		//driver.findElement(By.className("TextInput__StyledInput-sc-1vx01eh-0")).sendKeys("test@gmail.com");
		
		//5.Invalid: InvalidSelectorException
		driver.findElement(By.xpath("///[@@id='username']")).sendKeys("test@gmail.com");

	}

}
