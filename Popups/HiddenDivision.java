package Popups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HiddenDivision {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
/*		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		WebElement searchBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		searchBtn.click();
		Thread.sleep(2000);

		Alert alt = driver.switchTo().alert();
		String popupText = alt.getText();
		System.out.println("Popup Text:- " + popupText);
		alt.accept();

		driver.close();

*/
		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.redbus.in/");
		WebElement dateBtn = driver.findElement(By.xpath("//div[@id='onwardCal']"));
		dateBtn.click();
	
	
	}

}
