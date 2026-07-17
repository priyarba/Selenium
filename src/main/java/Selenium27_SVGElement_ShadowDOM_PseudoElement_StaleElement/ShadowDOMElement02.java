package Selenium27_SVGElement_ShadowDOM_PseudoElement_StaleElement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMElement02 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(2000);
		//driver.findElement(By.id("pizza")).sendKeys("veg pizza");
		//this will not work as the element is inside shadowDOM
		
		/**
		 * Shadow DOM: its another lightweight container or component on the page,
		 * where no. of elements will be maintained inside the page to provide the security, like frames
		 * There are 2 types for shadow-root
		 * 1. shadow-root (closed) : you cannot automate this
		 * 2. shadow-root (open) : can be automated
		 * 
		 * How to handle Shadow root
		 * - Inspect, right click on the element you want to inspect
		 * - Click copy -> click copy JS path
		 * - Go to console and paste it and click enter
		 * 
		 * 
		 * If the page is full of shadowDOM , its recommended to use playwrite
		 * In playwrite, there is auto piercing concept for shadowDOM, there is no need to write a JS code like in selenium.
		 */
		
		//Convert driver to JavaScriptExecutor driver
		String script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//below script will return html element
		//convert HTML element to webElement
		WebElement pizza = (WebElement)js.executeScript(script); //html ele --> webelement
		pizza.sendKeys("veg pizza");
		
		
	}

}
