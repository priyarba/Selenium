package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose_05 {

	public static void main(String[] args) {

		//Case 1: Quit
//		WebDriver driver= new ChromeDriver();
//		//ChromeDriver: chrome on windows (4e40eb4c4d483c8a6243638cfe56749c)
//		driver.get("https://www.google.com"); //ChromeDriver: chrome on windows (4e40eb4c4d483c8a6243638cfe56749c)
//		
//		String title = driver.getTitle();//Google
//		//ChromeDriver: chrome on windows (4e40eb4c4d483c8a6243638cfe56749c)
//		System.out.println(title);
//		
//		String url=driver.getCurrentUrl();//ChromeDriver: chrome on windows (4e40eb4c4d483c8a6243638cfe56749c)
//		System.out.println(url);
//		
//		driver.quit();
//		//ChromeDriver: chrome on windows (4e40eb4c4d483c8a6243638cfe56749c)
//		
//		System.out.println(driver.getTitle()); //ChromeDriver: chrome on windows (null)
		//NoSuchSessionException : Session ID is null. Using WebDriver after calling quit()?
		
		
		//----------------------------------------------------------
		//Case 2: Close
		
		WebDriver driver= new ChromeDriver(); //(6bcbe44d9559d27e9a985a9aeb7bf363)
		driver.get("https://www.google.com"); //(6bcbe44d9559d27e9a985a9aeb7bf363)
		
		String title = driver.getTitle(); //(6bcbe44d9559d27e9a985a9aeb7bf363)
		System.out.println(title);
		
		String url=driver.getCurrentUrl(); //(6bcbe44d9559d27e9a985a9aeb7bf363)
		System.out.println(url);
		
		driver.close(); //(6bcbe44d9559d27e9a985a9aeb7bf363)
		System.out.println(driver.getTitle()); //(6bcbe44d9559d27e9a985a9aeb7bf363) --Invalid/Expired
		
		//NoSuchSessionException: : invalid session id
		
	}

}
