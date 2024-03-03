package Popups;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTables {

	private static WebDriver driver;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		while (true) {
			System.out.println("Enter:-\n1.Get Data\n2.Get All Data\n3.Exit");
			int choice = sc.nextInt();
			if (choice == 3)
				break;

			switch (choice) {
			case 1:
				getDriver();
				List<WebElement> rowData = driver.findElements(By.xpath("//div[@class='hmbseindicestable show']//ul"));
				List<WebElement> colData = driver
						.findElements(By.xpath("//div[@class='hmbseindicestable show']//ul[1]//li"));

				System.out.println(rowData.size());
				System.out.println(colData.size());

				for (int i = 0; i < rowData.size(); i++) {
					System.out.println(rowData.get(i).getText());
				}

				driver.close();

				break;
			case 2:
				getDriver();

				WebElement moreBtn = driver.findElement(By.xpath("//a[text()='More NSE Indices ']"));
				moreBtn.click();
				Thread.sleep(3000);
				List<WebElement> rowsData = driver.findElements(By.xpath("//div[@id='div_nseindices']//ul"));
				List<WebElement> colsData = driver.findElements(By.xpath("//div[@id='div_nseindices']//ul[1]//li"));

				for (int i = 0; i < rowsData.size(); i++) {
					System.out.println(rowsData.get(i).getText());
				}
				driver.close();
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
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/index.html");
		return driver;
	}
}
