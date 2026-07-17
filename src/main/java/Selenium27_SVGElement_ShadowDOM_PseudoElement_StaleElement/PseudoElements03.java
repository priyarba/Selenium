package Selenium27_SVGElement_ShadowDOM_PseudoElement_StaleElement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElements03 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(2000);
		
		/**
		 * Pseudo Elements:
		 * ::before
		 * ::after
		 */
		
		String script = "return window.getComputedStyle(document.querySelector('label[for=\"input-firstname\"]'), '::before').getPropertyValue('content');";
		String colorScript = "return window.getComputedStyle(document.querySelector('label[for=\"input-firstname\"]'), '::before').getPropertyValue('color');";

		
		// lastName : window.getComputedStyle(document.querySelector('label[for="input-lastname"]'), '::before').getPropertyValue('content');
		//telephone: window.getComputedStyle(document.querySelector('label[for="input-telephone"]'), '::before').getPropertyValue('content');
		
		//color property:
		//window.getComputedStyle(document.querySelector('label[for="input-firstname"]'), '::before').getPropertyValue('color');

		//convert driver to javaScriptExecutor
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String content = js.executeScript(script).toString();
		System.out.println(content);
		if(content.contains("*")) {
			System.out.println("This is a mandatory field");
		}
		
		//color
		String color = js.executeScript(colorScript).toString();
		System.out.println(color);

	}

}
