package Selenium13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCssSelector {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login/legacy");
		
		//1. id: #id or tag#id
		// #input-email or input#input-email
		
		//2. class: .class or tag.class
		// .list-group-item
		// a.list-group-item
		// img.img-responsive
		
		By image = By.cssSelector("img.img-responsive");
		
		//3.Use id and class together: tag#id.class
		//input#input-email.form-control
		
		//4. tag.class#id
		//input.form-control#input-email
		
		//5. .c1.c2.c3.c4
		//6. tag.c1.c2.c3.c4
		
		//7.tag.c1.c2.c3#id
		//8. tag#id.c1.c2.c3
		
		//OTHER ATTRIBUTES:
		//   htmltag[attr='value']
		//   input[name='email'] --css
		//   input[id='input-email']
		//   Input[placeholder='e-mail Address']
		
		//  htmltag[attr1='value][attr2='value']
		//  htmltag[attr1='value][attr2='value']#id
		//  htmltag[attr1='value][attr2='value']#id.class
		
		//contains:
		// tag[attr *='value']
		// tag[attr *='value']#id
		
		//starts-with:
		// tag[attr ^='value']
		
		//ends-with
		// tag[attr $='value']
		
		//text in css: NA
		
		//parent to child:
		//direct child: >
		//parentTag > childTag
		
		//direct + indirect child
		//parentTag childTag
		//div#content input
		
		//child to parent: NA -- backward traversing is not supported with css
		
		//sibling: only forward sibling is supported
		//tagname[attr='value'] + tagname --> gives immediate sibling
		
		//for all following siblings
		//tagname[attr='value'] ~ tagname
		
		//indexing: nth-of-type(4)
		// select#Form_getForm_Country>option:nth-of-type(4) -- 4th index child
		// select#Form_getForm_Country>option:nth-of-type(n) -- all the elements
		
		// select#Form_getForm_Country>option:first-child -- first child
		// select#Form_getForm_Country>option:last-child -- last child
		
		// select#Form_getForm_Country>option:nth-child(5) -- 5th index child
		// select#Form_getForm_Country>option:nth-last-child(3) -- last 3rd child
		// select#Form_getForm_Country>option:nth-last-child(n) -- all elements
		
		// select#Form_getForm_Country>option:nth-child(n+5) -- captures all elements starting from 5th element
		// select#Form_getForm_Country>option:nth-child(4n) -- captures element for multiples of 4th position
		
		
		// odd, even in css
		// select#Form_getForm_Country>option:nth-child(odd) -- elements present in odd position
		// select#Form_getForm_Country>option:nth-child(even) -- elements present in even position
		
		
		//odd , even in xpath
		// //select[@id='Form_getForm_Country']/option[position() mod 2=1] -- odd
		// //select[@id='Form_getForm_Country']/option[position() mod 2=0] -- even
		
		
		//comma in css:
		// input#username,input#password,input#remember,button#loginBtn
		
		By loginFields = By.cssSelector("input#username,input#password,input#remember,button#loginBtn");
		int loginFieldsCount = driver.findElements(loginFields).size();
		
		if(loginFieldsCount ==4) {
			System.out.println("Login imp fields are available on the page -- PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		//space in xpath:
		//option[normalize-space()='Angola']
		
		//not in css:
		// input.form-control:not(input[name='search']) -- exclude 1 element
		// input.form-control:not(input[name='search'], input#input-firstname) -- exclude 2 elements
		
		//                      xpath           VS          css:
		//1. Syntax:            complex                     simple
		//2. performance:       good                        good
		//3. text:              yes                         NA
		//4. child to parent:   yes                         NA
		//5. parent to child:   yes                         yes
		//6. preceding-sibling: yes                         NA
		//7. following-sibling: yes                         yes
		//8. dynamic element:   yes                         yes
		//9.ends-with:          NA                          yes
		//10. space:            yes                         NA
		//11. comma:            NA                          yes
		//12. not:              yes                         yes
		//13. indexing:         yes                         yes(better than xpath)
		//14. dot(.):           yes                         NA
		//15. SVG element:      yes                         NA
		//16. SHADOW DOM:       NA                          yes
		
		
		

	}

}
