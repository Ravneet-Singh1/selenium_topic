//=============================================================================================
// HERE WE LEARN ABOUT : FULL SCREEN || NAVIGATIONS (FORWARD & BACKWARD)
//=============================================================================================

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravneesi\\OneDrive - Cisco\\Desktop\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // To get full screen

		driver.get("https://www.google.com"); // Open the URL [It will wait until complete page occurs]
		driver.navigate().to("https://www.facebook.com"); // navigating it to new URL [It wont wait for synchronization]

		driver.navigate().back(); // Coming back to Google page

		driver.navigate().forward(); // Going again to facebook page

		// google -> Facebook -> google -> Facebook

	}

}
