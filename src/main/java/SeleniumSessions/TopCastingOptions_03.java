package SeleniumSessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions_03 {

	public static void main(String[] args) {

		//1. CD = CD only chrome
		//ChromeDriver driver = new ChromeDriver();
		
		//2. WD d= new CD
		//Valid and recommended
		//Used only for local execution
		//WebDriver driver = new ChromeDriver();
		
		//3. SC d= new CD();
		//valid but not recommended
		//But we can have only findElement and findElements methods. Cannot utilize get methods
		//SearchContext driver=new ChromeDriver();
		
		//4. WD d=new RMD();
		//valid and recommended : only for remote execution
		//used when we want to run test cases in remote machine, cloud, AwS, Grid, VM
		//WebDriver driver=new RemoteWebDriver(remoteAddress, capabilities);//os/browser
		
		//5. SD d = new RWD();
		//we can have only findElement and findElements methods. Cannot utilize get methods
		//SearchContext driver=new RemoteWebDriver(remoteAddress, capabilities);
		
		//6. RWD d = new CD();
		//Local
		//valid and recommended
		//But few interfaces from JavaScript or TakeScreenshot cannot be utilized
		//RemoteWebDriver driver = new ChromeDriver();
		
		//7. ChromiumDriver = new CD();
		//Local
		//valid but not recommended:
		//only extended by chrome and edge. Firefox and other browsers cannot be supported
		//ChromiumDriver driver = new ChromeDriver();
//		driver = new EdgeDriver();
		
		//8. RWD d= new RWD();
		//Only for remote execution
		//RemoteWebDriver driver = new RemoteWebDriver(remoteAddress, capabilities);
		
	}

}
