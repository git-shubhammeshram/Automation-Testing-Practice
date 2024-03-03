package BasicInformations;

import java.awt.Dimension;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

public class SelniumWebDriverAndMethods {

	/*
	 * In a selenium architecture we have a SeleniumContent Interface which is
	 * extended to Webdriver Interface which has unimplemented or abstract methods
	 * which is implemented into :- Selenium Remote Webdriver. has a class
	 * :-ChromeDriver IEDriver GeckoDriver.
	 */

	/*
	 * Selenium WebDriver and its Methods:- get() close() maximize() quit()
	 * findElement() findElements() click() sendKeys() submit() navigate().back()
	 * navigate().forword() takeScreenshots() getTitle()
	 * 
	 */
	private static Scanner sc = new Scanner(System.in);
	private static WebDriver driver;

	public static void main(String[] args) {

		/*
		while (true) {
			System.out.println("Enter\n1.Chrome\n2.Firefox\n3.IE\n4.Opera\n5.Exit");
			int choice = sc.nextInt();
			if (choice == 5)
				break;
			switch (choice) {
			case 1:
				System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
				ChromeOptions con = new ChromeOptions();
				con.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(con);
				driver.get("https://www.google.com/");
				driver.manage().window().maximize();
				driver.close();
				
				break;

			case 2:
				System.setProperty("Webdriver.gecko.driver", "geckoDriver");
				driver = new FirefoxDriver();
				driver.get("https://www.google.com/");
				driver.manage().window().maximize();
				driver.close();

				break;

			case 3:
				

				break;

			case 4:
				System.setProperty("Webdriver.opera.driver", "operaDriver");
				driver = new OperaDriver();
				driver.get("https://www.google.com/");
				driver.manage().window().maximize();
				driver.close();


				break;

			default:
				break;
			}
		}
*/
	
		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
				
		String expURL = "https://www.google.com/";
		String actURL = driver.getCurrentUrl();
		
		if(expURL.equals(expURL)) {
			System.out.println("Test Case Passed:- "+actURL);
		}
		else {
			System.out.println("Test Case Failed:- "+actURL);
		}
		
		String expTitle = "Google";
		String actTitle = driver.getTitle();
		if(expTitle.equals(actTitle)) {
			System.out.println("Test Case Passed:- "+actTitle);
		}
		else {
			System.out.println("Test Case Failed:- "+actTitle);
		}
		
		driver.close();
		
		
	}

}
