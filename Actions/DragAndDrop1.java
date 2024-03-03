package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frame);
		
		WebElement image1 = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement image2 = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		WebElement image3 = driver.findElement(By.xpath("//img[@alt='Planning the ascent']"));
		WebElement image4 = driver.findElement(By.xpath("//img[@alt='On top of Kozi kopka']"));
		WebElement trashBox = driver.findElement(By.xpath("//div[@id='trash']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(image1).clickAndHold().moveToElement(trashBox).release().build().perform();
		Thread.sleep(1000);
		act.moveToElement(image2).clickAndHold().moveToElement(trashBox).release().build().perform();
		Thread.sleep(1000);
		act.moveToElement(image3).clickAndHold().moveToElement(trashBox).release().build().perform();
		Thread.sleep(1000);
		act.moveToElement(image4).clickAndHold().moveToElement(trashBox).release().build().perform();
		Thread.sleep(1000);
		
		driver.close();
	}

}
