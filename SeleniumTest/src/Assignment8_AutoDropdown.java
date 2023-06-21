import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment8_AutoDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");
		
		//WebDriver driver = new ChromeDriver();
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		
		ChromeDriver driver = new ChromeDriver(options);
	
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		
		Thread.sleep(3000);
		
		//capture all the Countries with Ind
		List<WebElement> opt = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		for(WebElement option :opt) 
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				
			   System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 

				break;
			}
			
		}

	}

}
