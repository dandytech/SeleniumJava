import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAssignmane5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com");
		
		driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();
		
		driver.switchTo().frame("frame-top");


		driver.switchTo().frame("frame-middle");
		
		System.out.println(driver.findElement(By.id("content")).getText());

	}

}
