package Parameterization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Parameterization {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		FileInputStream exceFile = new FileInputStream("C:\\Users\\91942\\eclipse-workspace\\AutomationTesting\\TestData\\Data.xlsx");
		Sheet readExcel = WorkbookFactory.create(exceFile).getSheet("Sheet1");
		
		for(int row=0; row<=readExcel.getLastRowNum();row++) {
			for(int col=0; col<readExcel.getRow(row).getLastCellNum();col++) {
				String value = readExcel.getRow(row).getCell(col).getStringCellValue();
				System.out.println(value+" ");
			}
			System.out.println();
		}
		/*System.setProperty("Webdriver.chrome.driver", "Chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://is.rediff.com/signup/register");

		WebElement nameText = driver.findElement(By.xpath("//input[@id='fullname']"));
		WebElement emailText = driver.findElement(By.xpath("//input[@id='emailid']"));
		WebElement passText = driver.findElement(By.xpath("//input[@id='pass']"));
		WebElement repassText = driver.findElement(By.xpath("//input[@id='repass']"));
		WebElement maleRadio = driver.findElement(By.xpath("//input[@value='m']"));
		WebElement dateListBox = driver.findElement(By.xpath("//select[@name='date_day']"));
		WebElement monthListBox = driver.findElement(By.xpath("//select[@name='date_mon']"));
		WebElement yearListBox = driver.findElement(By.xpath("//select[@name='Date_Year']"));
		WebElement cityText = driver.findElement(By.xpath("//input[@id='signup_city']"));
		WebElement schoolText = driver.findElement(By.xpath("//input[@id='school']"));
		WebElement collegeText = driver.findElement(By.xpath("//input[@id='college']"));
		WebElement captcha = driver.findElement(By.xpath("//input[@id='fld_captcha']"));

		nameText.sendKeys(execl(0, 0));
		Thread.sleep(2000);
		emailText.sendKeys(execl(0, 1));
		Thread.sleep(2000);
		passText.sendKeys(execl(0, 2));
		Thread.sleep(2000);
		repassText.sendKeys(execl(0, 3));
		Thread.sleep(2000);
		maleRadio.click();
		Thread.sleep(2000);
		Select x = new Select(dateListBox);
		x.selectByVisibleText(execl(0, 4));
		Thread.sleep(2000);
		Select y = new Select(monthListBox);
		y.selectByVisibleText(execl(0, 5));
		Thread.sleep(2000);
		Select z = new Select(yearListBox);
		z.selectByVisibleText(execl(0, 6));
		Thread.sleep(2000);
		cityText.sendKeys(execl(0, 7));
		Thread.sleep(2000);
		schoolText.sendKeys(execl(0, 8));
		Thread.sleep(2000);
		collegeText.sendKeys(execl(0, 9));
		Thread.sleep(2000);
		captcha.sendKeys(execl(0, 10));
		Thread.sleep(2000);

		driver.close();*/
	}

	
	private static String execl(int row, int cell) throws FileNotFoundException, IOException {
		FileInputStream readPath = new FileInputStream(
				"C:\\Users\\91942\\eclipse-workspace\\AutomationTesting\\TestData\\Data.xlsx");
		Sheet sheet = WorkbookFactory.create(readPath).getSheet("Sheet1");
		String value = sheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

}
