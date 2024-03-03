package ListBox;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HandlingListBox {

	private static WebDriver driver;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		while (true) {

			System.out.println(
					"Press\n1.By Index\n2.By Value\n3.By Visible Text\n4.Get All Options\n5.Multi-Selected Box\n6.Multi-Selected Box Opetions\n7.Exit");
			int choice = sc.nextInt();
			if (choice == 7)
				break;

			switch (choice) {
			case 1:
				/* Handling List Box:- Using Select By Index */
				getDriver();
				WebElement dayBox = driver.findElement(By.xpath("//select[@name='date_day']"));
				Select s = new Select(dayBox);
				s.selectByIndex(10);
				driver.close();

				break;
			case 2:
				/* Handling List Box:- Using Select By Value */
				getDriver();
				WebElement monthBox = driver.findElement(By.xpath("//select[@name='date_mon']"));
				Select s2 = new Select(monthBox);
				s2.selectByValue("12");
				driver.close();

				break;

			case 3:
				/* Handling List Box:- Using Select By Visible Text */
				getDriver();
				WebElement yearBox = driver.findElement(By.xpath("//select[@name='Date_Year']"));
				Select s3 = new Select(yearBox);
				s3.selectByVisibleText("2022");
				driver.close();
				break;

			case 4:
				getDriver();
				WebElement date = driver.findElement(By.xpath("//select[@name='date_day']"));
				Select s4 = new Select(date);
				List<WebElement> options = s4.getOptions();
				for (WebElement opt : options) {
					System.out.println(opt.getText());
				}
				driver.close();
				break;

			case 5:
				getDriver();
				driver.switchTo().frame("iframeResult");
				WebElement carsBox = driver.findElement(By.xpath("//select[@name='cars']"));
				Select s5 = new Select(carsBox);
				List<WebElement> options2 = s5.getOptions();
				System.out.println(s5.isMultiple());
				s5.selectByVisibleText("Volvo");
				Thread.sleep(2000);
				s5.selectByVisibleText("Saab");
				Thread.sleep(2000);
				s5.selectByVisibleText("Opel");
				Thread.sleep(2000);
				s5.selectByVisibleText("Audi");

				for (int i = 0; i <= 2; i++) {
					System.out.println(options2.get(i).getText());
				}
				driver.close();

				break;

			case 6:
				getDriver();
				driver.switchTo().frame("iframeResult");
				WebElement carsBox2 = driver.findElement(By.xpath("//select[@name='cars']"));
				Select s6 = new Select(carsBox2);

				s6.selectByVisibleText("Volvo");
				Thread.sleep(2000);
				s6.selectByVisibleText("Saab");
				Thread.sleep(2000);
				s6.selectByVisibleText("Opel");
				Thread.sleep(2000);
				s6.selectByVisibleText("Audi");
				
				List<WebElement> opt = s6.getAllSelectedOptions();
				
				for(WebElement o:opt) {
					System.out.println(o.getText());
				}

				driver.close();

				break;

			default:
				break;
			}

		}
	}

	private static void getDriver() throws InterruptedException {

		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(
				/* "https://is.rediff.com/signup/register" */"https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Thread.sleep(3000);
	}
}
