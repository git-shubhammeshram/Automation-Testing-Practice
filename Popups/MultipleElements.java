package Popups;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultipleElements {

	private static Scanner sc = new Scanner(System.in);
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		while (true) {
			System.out.println("Enter:-\n1.Total links\n2.Auto Suggestions\n3.Exit");
			int choice = sc.nextInt();
			if (choice == 3)
				break;
			switch (choice) {
			case 1:
				getDriver();
				List<WebElement> totalLinks = driver.findElements(By.xpath("//a"));
				System.out.println("Size of links:- " + totalLinks.size());

				for (int i = 0; i < totalLinks.size(); i++) {
					System.out.println(totalLinks.get(i).getText());
				}

				for (int x = 0; x < totalLinks.size(); x++) {
					String expResult = "Images";
					String actResult = totalLinks.get(x).getText();

					if (expResult.equals(actResult)) {
						totalLinks.get(x).click();
						System.out.println(driver.getCurrentUrl());
						break;
					}
				}
				driver.close();
				break;

			case 2:
				getDriver();
				WebElement searchBar = driver.findElement(By.xpath("//textarea[@name='q']"));
				searchBar.sendKeys("Harry");
				Thread.sleep(2000);
				List<WebElement> sugList = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
				for (int i = 0; i < sugList.size(); i++) {
					System.out.println(sugList.get(i).getText());
				}

				for (int x = 0; x < sugList.size(); x++) {
					String expResult = "harry potter cast";
					String actResult = sugList.get(x).getText();

					if (expResult.equals(actResult)) {
						sugList.get(x).click();
						System.out.println(driver.getCurrentUrl());
						break;
					}
					Thread.sleep(5000);
					driver.close();
				}

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
		driver.get("https://www.google.co.in/");
		return driver;
	}

}
