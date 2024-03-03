package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScrollPage {

	public static void main(String[] args) {
		
		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		WebElement crossBtn = driver.findElement(By.xpath("//span[text()='✕']"));
		crossBtn.click();
		WebElement aboutLable = driver.findElement(By.xpath("//a[@aria-label='About Us']"));
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();", aboutLable);
		
		driver.close();

	}
}
