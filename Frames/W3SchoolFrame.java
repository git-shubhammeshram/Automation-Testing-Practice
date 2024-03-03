package Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class W3SchoolFrame {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_myfirst");

		driver.switchTo().frame("iframeResult");
		WebElement clickMeBtn = driver.findElement(By.xpath("//button[@type='button']"));
		Thread.sleep(2000);
		clickMeBtn.click();
		Thread.sleep(2000);
		WebElement dateLable = driver.findElement(By.xpath("//p[@id='demo']"));
		String textData = dateLable.getText();
		System.out.println(textData);
		driver.switchTo().defaultContent();
		WebElement runBtn = driver.findElement(By.xpath("//button[@id='runbtn']"));
		runBtn.click();
		Thread.sleep(2000);
		driver.close();

	}

}
