package Actions;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class RailYatriRegistration {

	private static WebDriver driver;
	Actions act = new Actions(driver);
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		while (true) {
			System.out.println("Enter:-\n1.Occupation\n2.Country\n3.Security\n4.Exit");
			int choice = sc.nextInt();
			if (choice == 4)
				break;

			switch (choice) {
			case 1:
				getDriver();
				driver.findElement(By.xpath("//input[@id='user-number']")).sendKeys("1010101010");
				driver.findElement(By.xpath("//input[@id='email_id']")).sendKeys("shubhammeshram9119@gmail.com");
				driver.findElement(By.xpath("//button[@id='irtct-acc-detail']")).click();

				WebElement occupationTextBox = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle']"));

				Actions act = new Actions(driver);
				act.moveToElement(occupationTextBox).click().build().perform();

				for (int i = 0; i < 5; i++) {
					Thread.sleep(3000);
					act.sendKeys(Keys.DOWN).build().perform();

				}
				act.sendKeys(Keys.ENTER).build().perform();
				driver.close();

				break;
			case 2:

				break;

			case 3:

				break;

			default:
				break;
			}

		}
	}

	private static WebDriver getDriver() {
		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.railyatri.in/train-ticket/create-new-irctc-user");
		return driver;
	}
}
