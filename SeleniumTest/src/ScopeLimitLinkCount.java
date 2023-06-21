import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeLimitLinkCount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 1. Give me the count of links on the page.
		// 2. Count of footer section-

		System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");

		System.out.println(driver.findElements(By.tagName("a")).size()); //links count in all the page

		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope to footer

		System.out.println(footerdriver.findElements(By.tagName("a")).size()); //link count for the footer

		// 3- further limiting scope to a column section on footer
		WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size()); //link count on the column on footer

		// 4- click on each link in the column and check if the pages are opening-
		for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++) {

			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			
			Thread.sleep(5000L);

		} 
		
		//5 opens all the tabs
		Set<String> abc = driver.getWindowHandles();// 4
		java.util.Iterator<String> it = abc.iterator();

		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}
}