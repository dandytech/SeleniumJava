import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");
//		
//		WebDriver driver = new ChromeDriver();
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		
		ChromeDriver driver = new ChromeDriver(options);
	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		
		String  checkText = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		
		WebElement selectText = driver.findElement(By.id("dropdown-class-example"));
		
		Select opt = new Select(selectText);
		
		opt.selectByVisibleText(checkText);
	
		driver.findElement(By.id("name")).sendKeys(checkText);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		
		if(alertText.contains(checkText)) 
		{
			
			System.out.print(checkText+ " is present in: "+ alertText);
		}
		else {
			System.out.println("Test fail, result not found");
		}
		
		
		
	}

}
