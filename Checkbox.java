//=============================================================================================
//                ABOUT CHECKBOX || ASSERTION (True, False, Equals) || STATIC DROPDOWN
// https://www.udemy.com/selenium-real-time-examplesinterview-questions/learn/v4/t/lecture/2767082
//=============================================================================================

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravneesi\\OneDrive - Cisco\\Desktop\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		// If it gets true, the test will fail.
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		// =============================================================================================
		// CHECKBOX
		// =============================================================================================

		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		// =============================================================================================
		// CHECK WHETHER THE CHECKBOX IS SELECTED
		// =============================================================================================

		System.out.println("Is Family and Friends checkbox is Selected : "
				+ driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		// =============================================================================================
		// COUNT THE NUMBER OF CHECKBOXES
		// =============================================================================================

		int totalCheckbox = driver.findElements(By.cssSelector("input[type='checkbox']")).size(); // here instead of
																									// 'findelement' we
																									// will use
																									// 'findelements'
		System.out.println("Total Checkboxes are : " + totalCheckbox);

		// =============================================================================================
		// STATIC DROPDOWN & ASSERTION
		// =============================================================================================

		WebElement staticdropdown = driver.findElement(By.cssSelector("select[id*='DropDownListCurrency']"));

		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(3); // Selecting the 3rd option (USD)

		String country = dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(country, "USD");
		System.out.println("The country selected is : " + country);

		Thread.sleep(1000);
		driver.close();
	}

}
