package Selenium11;

import org.openqa.selenium.WebDriver;

public class CustomXpath {
	static WebDriver driver;

	public static void main(String[] args) {
		//xpath : address of the element in html dom
		//not an attribute
		
		//1. Absolute xpath
		//  /html/body/div/div[2]
		
		//2. Relative xpath: custom xpath
		//htmlTag[@attribute='value']
		//htmlTag[@attribute1='value1'and @attribute2='value2']
		//input[@name and @type and @placeholder]
		
		//2.1 htmlTag[text() = 'value']
		
		//parent to child:
		//direct : / --> only direct
		//Indirect : // --> direct + indirect
		
		//2.2 text() and attribute:
		// htmlTag[@attribute1='value1' and text()='value2']
		
		//2.3 contains(): partial attribute , partial text value
		//htmlTag[contains(text(),'value')]
		
		//htmlTag[contains(@attribute,'value')]
		
		//htmlTag[contains(@attribute,'value1')and contains(text(),'value2')]
		//htmlTag[contains(@attribute,'value1')and @attribute2 ='value2']
		
		//2.4 starts-with():
		//htmlTag[starts-with(text(), 'value')]
		
		//2.5 ends-with(): this has been deprecated: NA
		
		//2.6 starts-with() and contains()
		//htmlTag[starts-with(text(),'value1') and contains(@attr,'value2')]
		
		//Index in xpath
		// (//a[text(),'Forgotten Password'])[1] --> store the xpath in capture group and then provide indexing
		// (//a[text(),'Forgotten Password'])[position=1]
		//if you want to capture last element
		// (//input[@class='form-control'])[last()] --> last() is a function
		// (//input[@class='form-control'])[last()-2] --> third last
		
		//((//div[contains(@class,'navFooterLinkCol')])[last()]//a)[last()]
		
		
		
		
		
		

	}

}
