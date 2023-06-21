import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7ScrollTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	

		driver.manage().window().maximize();

		driver.get("http://www.qaclickacademy.com/");

		driver.findElement(By.xpath("//a[@href='https://www.rahulshettyacademy.com/AutomationPractice']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, 500)");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses'] //tr"));

		System.out.println("Total rows: " + ((List<WebElement>) rows).size());

		List<WebElement> cols = driver.findElements(By.xpath("//table[@name='courses'] //th"));

		System.out.println("Total colums: " + ((List<WebElement>) cols).size());
		
		List<WebElement> r = driver.findElements(By.xpath("//table[@name='courses'] //tr[3]"));
		
		for(int i = 0; i < r.size(); i++)
		{
			System.out.print(r.get(i).getText());
		}

	}

}
