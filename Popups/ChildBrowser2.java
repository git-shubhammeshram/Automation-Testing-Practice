package Popups;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChildBrowser2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://skpatro.github.io/demo/links/");

		driver.findElement(By.xpath("//input[@name='NewWindow']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		System.out.println(windows.size());
		String win[] = new String[10];

		for (int i = 0; i < windows.size(); i++) {
			win[i] = itr.next();
		}
		driver.switchTo().window(win[1]);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Home']")).click();
		String curURL = driver.getCurrentUrl();
		if (curURL.equals("https://qavalidation.com/")) {
			System.out.println("Validation Success!!!:- " + curURL);
		} else {
			System.out.println("Wrong!!!");
		}
		
		driver.close();

	}
}
