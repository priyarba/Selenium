package Selenium17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropdownHandle01 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		Thread.sleep(2000);

		By choice = By.id("justAnInputBox");
		By choiceList = By
				.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//li/span[@class='comboTreeItemTitle']");

		// TC1: single selection: you have to call this method again and again for
		// multiple selection
//		selectChoice(choice, choiceList, "choice 2");
//		selectChoice(choice, choiceList, "choice 3");
//		selectChoice(choice, choiceList, "choice 2 1");

		// TC2:Multi selection:
		// selectChoice(choice, choiceList, "choice 2");
		selectChoice(choice, choiceList, "choice 2", "choice 3", "choice 2 1");

		// TC3: All selections:
		selectChoice(choice, choiceList, "all");

	}
	/**
	 *  /** enter
	 */
	
	/**
	 * this method is used to select the choices with 3 different use cases:
	 * 1. single selection : selectChoice(choice, choiceList, "choice 2");
	 * 2. Multi selection : selectChoice(choice, choiceList, "choice 2", "choice 3", "choice 2 1");
	 * 3. All selection : use all/ALL to select all the choices
	 * @param choice
	 * @param choiceList
	 * @param choiceValue
	 * @throws InterruptedException
	 */

	public static void selectChoice(By choice, By choiceList, String... choiceValue) throws InterruptedException {
		driver.findElement(choice).click();
		Thread.sleep(2000);

		// String
		// xpath="(//div[@class='comboTreeDropDownContainer'])[1]//li/span[@class='comboTreeItemTitle']";
		List<WebElement> choices = driver.findElements(choiceList);
		System.out.println(choices.size());

		//logic to select all the options
		if (choiceValue[0].equalsIgnoreCase("ALL")) {
			for (WebElement e : choices) {
				e.click();
			}
		} else {

			for (WebElement e : choices) {
				String text = e.getText();
				System.out.println(text);

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
