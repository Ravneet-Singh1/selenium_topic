//==============================================================================================================
// HERE WE LEARN ABOUT : STATIC DROPDOWNS || LOOPS IN DROPDOWNS || DYNAMIC DROPDOWN || AUTO-SUGGESTIVE DROPDOWN
//==============================================================================================================

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ravneesi\\OneDrive - Cisco\\Desktop\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//=============================================================================================
		// STATIC DROPDOWNS
		//=============================================================================================
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		 
		Select dropdown = new Select(staticDropdown); // Select is a class for static dropdown 
		
		// 1 way to select 
		dropdown.selectByIndex(3);  // Selecting the 3rd option (USD)
		System.out.println(dropdown.getFirstSelectedOption().getText());  // USD
		
		// 2nd way to select it
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());  // AED
		
		// 3rd way to select it
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText()); // INR

		
		//=============================================================================================
		// DROPDOWN (Which requires multiple click)
		//=============================================================================================
		
		driver.findElement(By.id("divpaxinfo")).click(); // Clicking on Passenger Dropdown
		Thread.sleep(1000);
		for(int i=1;i<=3;i++) {
			driver.findElement(By.id("hrefIncAdt")).click(); // 3 Passengers
			i++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click(); // Clicking on Done Button
		
		System.out.println("Total passengers selected : "+driver.findElement(By.id("divpaxinfo")).getText()); // Printing the no. of passenger Selected
			
		
		//=============================================================================================
	    // DYNAMIC DROPDOWN (With WebDriver API)
		//=============================================================================================
				
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); 
		
		driver.findElement(By.xpath("//a[@text='Goa (GOI)']")).click(); // Selecting GOA
		
		// Another dropdown will open by default
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@text='Bengaluru (BLR)'])[2]")).click(); // Selecting Bengaluru
	
		
		//=============================================================================================
	    // AUTO-SUGGESTIVE DROPDOWN
		//=============================================================================================
		
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind"); // Giving "ind" in Country text
		
		Thread.sleep(1000);
		
		List<WebElement> option = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); // This list will consists of
		                                                                                             // "India"  "British Indian Ocean Territory"  "Indonesia"

		//Enhanced Loop
		
		for(WebElement opt : option) {
			if(opt.getText().equalsIgnoreCase("India")) {
				opt.click();
				break;
			}
		}
		
		
		
	}

}
