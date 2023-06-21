import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BogCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");

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

		driver.get("https://bog-project-new.netlify.app/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//button[text()='Got It']")).click();

		driver.findElement(By.xpath("//button[text()='Login']")).click();

		driver.findElement(By.id("email")).sendKeys("greenmouseapp@gmail.com");

		driver.findElement(By.id("password")).sendKeys("Dandytech@2022");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//p[text()='Switch']")).click();
		
		driver.findElement(By.xpath("//p[text()='Private Client']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='boglogo']")));

		driver.findElement(By.xpath("//img[@alt='boglogo']")).click();

		driver.findElement(By.xpath("//a[text()='Products']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='fw-600 fs-300 lg:fs-600']")));

		driver.findElement(By.xpath("//p[text()='5mm QA Steel 2023']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add To Cart']")));

		driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();
		
		driver.navigate().back();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='5mm QA Steel 2023']")));
		
		driver.findElement(By.xpath("//p[text()='5mm QA Steel 2023']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add To Cart']")));
		
		driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.className("btn-primary")).click();
		
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath("//p[text()='PROCEED TO CHECKOUT']")).click();
		
		driver.findElement(By.xpath("//input[@name='contact_name']")).sendKeys("Daniel");
		
		driver.findElement(By.xpath("//input[@name='contact_email']")).sendKeys("greenmouseapp@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Ikeja");
		
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys("Nigeria");
		
		driver.findElement(By.xpath("//input[@name='contact_phone']")).sendKeys("08099989887");
		
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Lagos");
		
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("2 metalbox rd");
		
		//Thread.sleep(3000);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fw-600 my-4']")));
		
		driver.findElement(By.xpath("//button[contains(text(),'CHECKOUT')]")).click();
		
	
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[id='dgUci']")));
				
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='dgUci']")));
	
		
		//driver.findElement(By.className("card__select")).click();
		
		
		
	}

}
