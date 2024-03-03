package Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GlobalSQAframe {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
		driver.switchTo().frame("globalSqa");
		Thread.sleep(2000);
		WebElement frameSearchBox = driver.findElement(By.xpath("//input[@id='s']"));
		frameSearchBox.sendKeys("Alert Box");
		Thread.sleep(2000);
		WebElement frameSearchBar = driver.findElement(By.xpath("//button[@class='button_search']"));
		frameSearchBar.click();
		
		driver.switchTo().parentFrame();
		WebElement searchBtn = driver.findElement(By.xpath("//input[@id='s']"));
		searchBtn.sendKeys("Alert Box");
		Thread.sleep(2000);
		
		WebElement searchBar = driver.findElement(By.xpath("//button[@class='button_search']"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", searchBar);
		Thread.sleep(2000);
		driver.close();
	}

}
