import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravneesi\\OneDrive - Cisco\\Desktop\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // It will contain list of
																							// product

		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText(); // One product at a time

			if (productName.equalsIgnoreCase("Cucumber - 1 Kg")) { // Comparing with product name

				driver.findElements(By.cssSelector(".increment")).get(i).click(); // Incrementing the item
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); // clicked using index
																								// value
				break;
			}
		}

		Thread.sleep(2000);
		driver.close();

	}

}
