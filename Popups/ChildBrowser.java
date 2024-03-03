package Popups;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChildBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.aspsnippets.com/demos/1102/");
		driver.findElement(By.xpath("//input[@value='Open Popup']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String win[] = new String[10];
		System.out.println("Total Windows:- "+windows.size());
		
		
		for(int i=0; i<windows.size(); i++) {
			win[i] = itr.next();
			System.out.println(win[i]);
		}
		driver.switchTo().window(win[1]);
		driver.manage().window().maximize();
		System.out.println("Title of Window:- "+driver.getTitle());
		WebElement FirstTextBox = driver.findElement(By.xpath("//td[contains(text(),'Fir')]"));
		System.out.println(FirstTextBox.getText());
		WebElement LastTextBox = driver.findElement(By.xpath("//td[contains(text(),'Las')]"));
		System.out.println(LastTextBox.getText());

		Thread.sleep(3000);
		
		
		driver.close();
		
	}
}
