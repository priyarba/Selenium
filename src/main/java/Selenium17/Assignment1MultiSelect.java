package Selenium17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1MultiSelect {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		Thread.sleep(2000);

		By choice = By.xpath("//input[@id='justAnInputBox1']");
		By choiceList = By
				.xpath("(//div[@class='comboTreeDropDownContainer'])[2]//li/span[@class='comboTreeItemTitle']");

		//selectChoice(choice, choiceList, "choice 6 2 2");
		selectChoice(choice, choiceList, "all");
	}

	public static void selectChoice(By choice, By choiceList, String... choiceValue) throws InterruptedException {
		driver.findElement(choice).click();

		// List size
		// Press Ctrl + 2 then L (hold Ctrl, press 2, release, then press L).
		List<WebElement> choices = driver.findElements(choiceList);
		System.out.println(choices.size());
		// Select all the options
		if (choiceValue[0].equalsIgnoreCase("ALL")) {
			for (WebElement e : choices) {
				e.click();
			}
		} else {

			// print list of choices
			for (WebElement e : choices) {
				String text = e.getText();
				System.out.println(text);
				// select a value
				for (String value : choiceValue) {
					if (text.trim().equals(value)) {
						e.click();
						break;
					}
				}
			}
		}
	}
}
