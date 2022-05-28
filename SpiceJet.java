import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//=============================================================================================
// SpiceJet (Old Website) End-to-End Testing
//=============================================================================================
public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\ravneesi\\\\OneDrive - Cisco\\\\Desktop\\\\Selenium\\\\Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); // Old spicejet website

		// =============================================================================================
		// FROM
		// =============================================================================================

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click(); // From Dropdown
		driver.findElement(By.xpath("//a[@text='Delhi (DEL)']")).click(); // Selecting Delhi

		// =============================================================================================
		// TO
		// =============================================================================================

		Thread.sleep(500);
		// To Dropdown will open on its own
		driver.findElement(By.xpath("(//a[@text='Amritsar (ATQ)'])[2]")).click(); // Selecting Amritsar

		// =============================================================================================
		// DEPARTURE DATE
		// =============================================================================================

		Thread.sleep(500);
		// Calender Dropdown will open on its own
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click(); // Selecting current date

		// =============================================================================================
		// PASSENGER DROPDOWN
		// =============================================================================================

		driver.findElement(By.id("divpaxinfo")).click(); // Passenger Dropdown

		Thread.sleep(1000);
		driver.findElement(By.id("hrefIncAdt")).click(); // Selecting 2 parent

		driver.findElement(By.id("hrefIncChd")).click(); // Selecting 1 child

		driver.findElement(By.id("btnclosepaxoption")).click(); // Clicking Done button

		// =============================================================================================
		// STATIC DROPDOWN FOR SELECTING COUNTRY
		// =============================================================================================

		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(staticDropdown);

		dropdown.selectByValue("USD"); // Selecting USD

		String country = dropdown.getFirstSelectedOption().getText();
		System.out.println("Selected country is : " + country);

		Assert.assertEquals(country, "USD");

		// =============================================================================================
		// SELECTING SENIOR CITIZEN CHECKBOX
		// =============================================================================================

		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click(); // Enabling Senior citizen
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());

		// =============================================================================================
		// ASSERTION FOR RETURN DATE || ENABLING ROUND TRIP
		// =============================================================================================

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) { // Return date attribute
			System.out.println("Its Disabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true);
		}

		// Enabling Round trip option
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click(); // Clicking on Round Trip
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) { // Return date attribute
			System.out.println("Its Enabled now !!");
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true);
		}

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		// =============================================================================================
		// CLICK ON SEARCH BUTTON
		// =============================================================================================

		Thread.sleep(3000);

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click(); // Search Button

		driver.close();

	}

}
