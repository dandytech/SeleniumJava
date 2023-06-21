import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");

		driver.findElement(By.id("password")).sendKeys("learning");

		driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();

		// Thread.sleep(3000);

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		
		System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());

		driver.findElement(By.id("okayBtn")).click();
		
		WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
		 
		Select option = new Select(options);
		
		option.selectByIndex(2);
		
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='btn btn-info']")));
		
		List <WebElement> product = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		
		for (int i=0; i< product.size(); i++)
		{
			product.get(i).click();
		}
		
		Thread.sleep(3000); //to observe the cart content
		
		driver.findElement(By.partialLinkText("Checkout")).click();
	}
 
}