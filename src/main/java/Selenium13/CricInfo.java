package Selenium13;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfo {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/the-hundred-women-s-competition-2025-1471001/southern-brave-women-vs-welsh-fire-women-32nd-match-1471067/full-scorecard");
		Thread.sleep(4000);
		
		getWktTakerName("Rhianna Southby");
		getWktTakerName("Sophie Devine");
		
		getScoreCard("Mady Villiers");
		
		

	}
	
	public static List<String> getScoreCard(String playerName) {
		List<WebElement> scoreList = driver.findElements
				(By.xpath("//span[text()='"+playerName+"']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
				
				System.out.println("Size: "+scoreList.size());
				List<String> scoreCardList = new ArrayList<String>();
				for(WebElement e : scoreList) {
					String text = e.getText();
					System.out.println(text);
					scoreCardList.add(text);
				}
				
				return scoreCardList;
	}
	
	public static void getWktTakerName(String playerName) {
		String wktTakerName = driver.findElement(By.xpath("//span[text()='"+playerName+"']/ancestor::td/following-sibling::td"))
				.getText();
				System.out.println(wktTakerName);
	}

}
