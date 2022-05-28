import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\ravneesi\\\\OneDrive - Cisco\\\\Desktop\\\\Selenium\\\\Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// =============================================================================================
		// CALENDER
		// =============================================================================================

		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click(); // Opening Calender
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click(); // Selecting the current
																							// date
		
		Thread.sleep(3000);

		// =============================================================================================
		// CALENDER (is Enabled or not) using get Attributes
		// =============================================================================================

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // Enabling round trip
		Thread.sleep(2000);

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click(); // Enabling one way

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style")); // display: block; opacity: 0.5;
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // Enabling round trip
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style")); // display: block; opacity: 1;

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Return Date is enabled !!");
		} else {
			System.out.println("Return Date is disabled !!");
		}

		driver.close();

	}

}
