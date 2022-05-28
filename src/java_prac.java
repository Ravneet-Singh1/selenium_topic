//=============================================================================================
// HERE WE LEARN ABOUT - SIBLING LOCATORS || CHILD-PARENT LOCATOR || ALERT DIALOG
//=============================================================================================

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class java_prac {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		Scanner obj = new Scanner(System.in);

		// =============================================================================================
		// HERE WE ARE SELECTING THE BROWSER WE WANT TO USE
		// =============================================================================================

		System.out.println("Enter which browser u want to use : Firefox | Chrome | Edge");
		String browser = obj.nextLine().toLowerCase();

		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ravneesi\\OneDrive - Cisco\\Desktop\\Selenium\\Drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ravneesi\\OneDrive - Cisco\\Desktop\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\ravneesi\\OneDrive - Cisco\\Desktop\\Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter the Browser name properly !!");
		}

		// =============================================================================================
		// FROM HERE TO OPEN THE BROWSER(LOGIN SCREEN STARTS)
		// =============================================================================================
		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/"); // Opened URL

		// {Using Sibling Locator}
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click(); // Clicking the
																										// LOGIN Button

		// Getting Xpath from Practice button to Signup button {Using a combination of
		// child-parent & parent-child }
		System.out.println(driver.findElement(By.xpath("//button[text()='Practice']/parent::div/button[3]")).getText());
		// O/p -> Signup

		// =============================================================================================
		// HANDLING ALERT DIALOG
		// =============================================================================================

		driver.findElement(By.id("name")).sendKeys("Ravneet"); // Giving text to alert dialog

		// First Alert : Which have only 'OK' Button
		driver.findElement(By.id("alertbtn")).click(); // Clicking on Alert button

		// Thread.sleep(1000); // Just to see the alert bix

		String alertText = driver.switchTo().alert().getText();
		System.out.println("Alert Message : " + alertText);

		Assert.assertEquals(alertText, "Hello Ravneet, share this practice page and share your knowledge"); // Checking
																											// if text
																											// appear on
																											// alert box
																											// is
																											// correct
																											// or not

		driver.switchTo().alert().accept(); // Accepting the alert

		// Second Alert : Which have only 'OK' and 'CANCEL' Button

		driver.findElement(By.id("name")).sendKeys("Ravneet"); // Giving text to alert dialog
		driver.findElement(By.id("confirmbtn")).click(); // Clicking on Confirm button

		// Thread.sleep(1000); // Just to see the alert bix
		String confirmText = driver.switchTo().alert().getText();
		System.out.println("Confirm Message : " + confirmText);

		driver.switchTo().alert().dismiss(); // cancel {driver.switchTo().alert().accept(); to Accepting the alert}

		// =============================================================================================
		// CLOSING THE BROWSER
		// =============================================================================================

		driver.close(); // closing the browser
	}
}