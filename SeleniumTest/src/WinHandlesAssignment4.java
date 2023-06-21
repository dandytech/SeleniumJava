import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WinHandlesAssignment4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");
				
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com");

		driver.findElement(By.xpath("//a[@href='/windows']")).click();

		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

		Set<String> windows = driver.getWindowHandles();

		java.util.Iterator<String> win = windows.iterator();

		String parentId = win.next();

		String childId = win.next();

		driver.switchTo().window(childId);

		System.out.println(driver.findElement(By.className("example")).getText());
		
		
		driver.switchTo().window(parentId);
		

		System.out.println(driver.findElement(By.xpath("//div[@class='example'] //h3")).getText());
		

		Thread.sleep(5000);
		driver.close();

	}

}
