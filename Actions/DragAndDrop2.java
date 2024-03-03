package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/drag_drop.html");

		WebElement btnFiveTh = driver
				.findElement(By.xpath("//li[@class='block13 ui-draggable']//a[@class='button button-orange']"));
		WebElement bankBox = driver
				.findElement(By.xpath("//li[@class='block14 ui-draggable']//a[@class='button button-orange']"));
		WebElement salesBox = driver
				.findElement(By.xpath("//li[@class='block15 ui-draggable']//a[@class='button button-orange']"));
		WebElement debitAccount = driver.findElement(By.xpath("//div[@class='ui-widget-content']//ol[@id='bank']"));
		WebElement debitAmount = driver.findElement(By.xpath("//div[@class='ui-widget-content']//ol[@id='amt7']"));
		WebElement creditAccount = driver.findElement(By.xpath("//div[@class='ui-widget-content']//ol[@id='loan']"));
		WebElement creditAmount = driver.findElement(By.xpath("//div[@class='ui-widget-content']//ol[@id='amt8']"));
		WebElement perfectBtn = driver
				.findElement(By.xpath("//div[@class='table4_result']//a[@class='button button-green']"));

		Actions act = new Actions(driver);
		act.dragAndDrop(btnFiveTh, debitAmount).build().perform();
		Thread.sleep(1000);
		act.dragAndDrop(bankBox, debitAccount).build().perform();
		Thread.sleep(1000);
		act.dragAndDrop(btnFiveTh, creditAmount).build().perform();
		Thread.sleep(1000);
		act.dragAndDrop(salesBox, creditAccount).build().perform();
		Thread.sleep(1000);

		String expText = "Perfect!";
		String actText = perfectBtn.getText();

		if (expText.equals(actText)) {
			System.out.println("Text is :- " + actText);
		}

		driver.close();
	}
}
