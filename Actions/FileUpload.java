package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

		
		WebElement fileUploadBtn = driver.findElement(By.xpath("//input[@type='file']"));
		WebElement pressBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		fileUploadBtn.sendKeys("C:\\Users\\91942\\Documents\\TestData");
		Thread.sleep(5000);
		pressBtn.click();
		System.out.println("File Uploaded!!!");
		driver.quit();
	}
}
