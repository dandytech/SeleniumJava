import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles=driver.getWindowHandles();
		
		java.util.Iterator<String> it=handles.iterator();
		
		String parentWinId = it.next();
		
		String childWinId = it.next();
		
		driver.switchTo().window(childWinId);
		
		driver.get("https://rahulshettyacademy.com/");
		
		String courseName = driver.findElements(By.cssSelector("a[href='https://courses.rahulshettyacademy.com/p/get-access-to-all-courses/p']")).get(1).getText();
		
		System.out.println(courseName);
		
		driver.switchTo().window(parentWinId);
		
		driver.findElement(By.cssSelector("input[name='name")).sendKeys(courseName);

	}

}
