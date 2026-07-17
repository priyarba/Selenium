package Selenium23_JavaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorUtil02 {

	private WebDriver driver;
	private JavascriptExecutor js;

	public JavascriptExecutorUtil02(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
	}

	/**
	 * static = belongs to the class
	 * non‑static = belongs to the object
	 * @return
	 */
	public String getTitleByJavascript() {
		return js.executeScript("return document.title;").toString();
	}
	
	public String getURLByJavascript() {
		return js.executeScript("return document.URL;").toString();
	}
	
	//navigate forward and back
	//inspect -> console -> clear -> type : 
	//history.go(0) for refresh; 
	//history.go(-1) for previous page; 
	//history.go(1) for next page;
	
	public void refreshBrowserByJS() {
		js.executeScript("history.go(0)");
	}
	
	public void navigateToBackPage() {
		js.executeScript("history.go(-1)");
	}
	
	public void navigateToForwardPage() {
		js.executeScript("history.go(1)");
	}
	
	//generate alert popup explicitly
	public void generateJSAlert(String message) {
		js.executeScript("alert('" + message + "')");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().dismiss();
	}
	
	//to get text of the whole page: document.documentElement.innerText
	public String getPageInnerText() {
		return js.executeScript("return document.documentElement.innerText;").toString();
	}
	
	//scroll
	//window.scrollTo(0,300);
//window.scrollTo(0,document.body.scrollHeight);
	public void scrollPageDown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollPageDown(String height) {
		js.executeScript("window.scrollTo(0," + height + ");");
	}
	
	public void scrollPageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
	}
	
	//scroll to element
	public void scrollIntoView(WebElement element) {
		js.executeScript("argument[0].scrollIntoView(true);", element);
	}
	
	//Draw the border (Highlight the element): 
	public void drawBorder(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	//Highlight and flash the element
	public void flash(WebElement element) {
		String bgcolor=element.getCssValue("backgroundColor"); //blue
		for(int i=0; i<7; i++) {
			changeColor("rgb(0,200,0)", element); //green
			changeColor(bgcolor, element);//blue
		}
	}
	
	private void changeColor(String color, WebElement element) {
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//zoom page
	//"document.body.style.zoom='400.0%'"
	//"document.body.style.MozTransform='scale(0.5)';"; ---firefox
	public void zoomChromeEdgeFirefox(String zoomPercentage) {
		String zoom = "document.body.style.zoom='"+zoomPercentage+"%'";
		js.executeScript(zoom);
	}
	
	//click element using javascript
	public void clickElementByJS(WebElement element) {
		js.executeScript("argument[0].click();", element);
	}
	
	//document.getElementsByName('firstname').length
	//document.querySelector("input-firstname");
	public void sendKeysUsingWithId(String id, String value) {
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
		//document.getElementById('input-email').value='tom@gmail.com'
	}
	
	//document.evaluate
	//shadow dom
	//pseudo
	//SVG element
}
