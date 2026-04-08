package Selenium16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectionDropDown01 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		
		WebElement multiSelectAttr = driver.findElement(By.xpath("//select[@multiple]"));
		//Multiple attribute should be there for multiple select to be possible
		Select select = new Select(multiSelectAttr);
		System.out.println(select.isMultiple());
		if(select.isMultiple()) {
			System.out.println("Multi select is possible");
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Andean flamingo");
			select.selectByVisibleText("Chilean flamingo");
			select.selectByVisibleText("Greater flamingo");
		}
		select.deselectByVisibleText("American flamingo");
		select.deselectAll();
	}

}
