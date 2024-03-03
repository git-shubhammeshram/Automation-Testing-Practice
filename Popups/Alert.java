package Popups;

import java.util.Scanner;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alert {

	private static Scanner sc = new Scanner(System.in);
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			System.out.println("Enter:\n1.Alert with Ok\n2.Alert with Ok&Cancel\n3.Alert with Text Box\n4.Exit");
			int choice = sc.nextInt();
			if (choice == 4)
				break;
			switch (choice) {
			case 1:

				getDriver();
				driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
				Thread.sleep(2000);
				org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
				System.out.println(alert1.getText());
				alert1.accept();
				driver.close();

				break;

			case 2:
				getDriver();
				driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
				org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
				System.out.println(alert2.getText());
				// alert2.accept();
				alert2.dismiss();
				WebElement postAlertText = driver.findElement(By.xpath("//p[@id='demo']"));
				String alertText1 = postAlertText.getText();
				if (alertText1.equals("You pressed Ok")) {
					System.out.println("Test Pass:- " + alertText1);
				} else if (alertText1.equals("You Pressed Cancel")) {
					System.out.println("Test Pass:- " + alertText1);

				} else {
					System.out.println("Wrong!!!");
				}
				driver.close();

				break;

			case 3:
				getDriver();
				driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
				org.openqa.selenium.Alert alert3 = driver.switchTo().alert();
				System.out.println(alert3.getText());
				alert3.sendKeys("Automation Testing user");
				alert3.accept();
				WebElement postAlertText2 = driver.findElement(By.xpath("//p[@id='demo1']"));
				String alertText2 = postAlertText2.getText();
				if(alertText2.equals("Hello Automation Testing user How are you today")) {
					System.out.println("Alert is Fine!!! "+alertText2);
				}
				else {
					System.out.println("Wrong!!!");
				}
				driver.close();

				break;

			default:
				break;
			}
		}

	}

	private static void getDriver() {
		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Alerts.html");
	}

}
