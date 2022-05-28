//=============================================================================================
// HERE WE LEARN ABOUT DIFFERENT LOCATORS
//=============================================================================================

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Sel_Intro {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		String email = "rravneet1@gmail.com";

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

		driver.get("https://rahulshettyacademy.com/locatorspractice/#"); // Opened URL

		System.out.println("Opening : " + driver.getTitle()); // Printing the URL on console

		driver.findElement(By.id("inputUsername")).sendKeys(email); // Adding Username
		driver.findElement(By.name("inputPassword")).sendKeys("Happy@123"); // Adding Password
		driver.findElement(By.className("signInBtn")).click(); // Click on Login Button

		// It will take sometime for the browser to give error -- Response time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); // * Incorrect username or password

		// Click on forgot Password
		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000); // Animation Response time

		// =============================================================================================
		// Now we are on forget password screen
		// =============================================================================================

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ravneet"); // Adding name
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email); // Adding Email
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8439486299"); // Adding Phone number {Using
																				// parent-child Xpath locator}

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); // Click on Reset Login

		// Getting password
		System.out.println(
				"\nSo we got the password String \n" + driver.findElement(By.cssSelector(".infoMsg")).getText());
		// Please use temporary password 'rahulshettyacademy' to Login.

		driver.findElement(By.cssSelector("button.go-to-login-btn")).click(); // GO TO LOGIN PAGE

		// =============================================================================================
		// Now we are on LOGIN screen
		// =============================================================================================

		Thread.sleep(1000);
		String pswd = getPassword();
		System.out.println("Extracted password is : " + pswd); // Printing the password on console
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(pswd); // Adding Password {Using Regular
																					// Expression}

		driver.findElement(By.id("inputUsername")).sendKeys(email); // Username

		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click(); // Enable Remember my username
		driver.findElement(By.id("chkboxTwo")).click(); // Enable I agree to the terms and privacy policy
		driver.findElement(By.className("signInBtn")).click(); // Login Button

		Thread.sleep(1000);

		System.out.println("\n\t" + driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());

		// Assertion
		String output = driver.findElement(By.xpath("//div[@class='login-container']/p")).getText();
		Assert.assertEquals(output, "You are successfully logged in.");

//		 To check whether the username is not changing after Login
		String output1 = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();

//		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());

		Assert.assertEquals(output1, "Hello " + email + ","); // Actual -- Expected

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log Out']")).click(); // To Log Out {Using Text only}

		driver.close();
	}

	// =============================================================================================
	// STATIC METHOD TO EXTRACT THE PASSWORD FROM A STRING
	// =============================================================================================

	public static String getPassword() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/#");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String Password = driver.findElement(By.cssSelector(".infoMsg")).getText(); // Please use temporary password
																					// 'rahulshettyacademy' to Login.
		String[] split = Password.split("'");
		System.out.println(split[1]); // rahulshettyacademy
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click(); // GO TO LOGIN PAGE
		String extracted_password = split[1];
		return extracted_password;
	}

}
