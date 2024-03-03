package Actions;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class MultiBrowser {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("Press:-\n1.Chrome\n2.Edge\n3.Firefox\n4.Opera\n5.Exit");
			int choice = sc.nextInt();
			if (choice == 5)
				break;
			switch (choice) {
			case 1:
				getChromeBrowser();
				break;
			case 2:
				getEdgeBrowser();
				break;

			case 3:
				getFirefoxBrowser();
				break;

			case 4:
				getOperaBrowser();
				break;

			default:
				break;
			}
		}

	}

	private static void getChromeBrowser() {
		System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("Chrome browser has opened successfully!!!");
		driver.quit();
	}

	private static void getEdgeBrowser() {
		System.setProperty("Webdriver.edge.driver", "EdgeDriver");
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("Edge browser has opened successfully!!!");
		driver.quit();
	}
	
	private static void getFirefoxBrowser() {
		System.setProperty("Webdriver.gecko.driver", "GeckoDriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("Firefox browser has opened successfully!!!");
		driver.quit();
	}
	
	private static void getOperaBrowser() {
		System.setProperty("Webdriver.opera.driver", "OperaDriver");
		WebDriver driver = new OperaDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("Opera browser has opened successfully!!!");
		driver.quit();
	}


}
