package Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestions {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		WebElement searchBtn = driver.findElement(By.xpath("//textarea[@name='q']"));
		Thread.sleep(2000);
		searchBtn.sendKeys("Nare");
		Thread.sleep(3000);
		List<WebElement> sugList = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		for(int i=0; i<sugList.size();i++) {
			System.out.println(sugList.get(i).getText());
		}
		
		for(int i=0; i<sugList.size(); i++) {
			
			String expResult = "Narendra Modi Stadium";
			String actResult = sugList.get(i).getText();
			
			if(expResult.equals(actResult)) {
				Thread.sleep(3000);
				JavascriptExecutor js = ((JavascriptExecutor)driver);
				js.executeScript("arguments[0].click()", sugList.get(i));
				break;
			}
		}
		
		driver.close();

	}

}
