import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();

		// broken URL

		// Step 1 - IS to get all urls tied up to the links using Selenium

		// Java methods will call URL's and gets you the status code

		// if status code >400 then that url is not working-> link which tied to url is
		// broken

		// a[href*="soapui"]'

		//driver.get("https://bog-project.netlify.app/");
		//driver.get("https://5mlogistics.com/"); 
		driver.get("https://doctormoney.com.ng/");
		
		Thread.sleep(3000);
		
		//driver.findElement(By.cssSelector("svg[stroke='currentColor']")).click();
		
		List<WebElement> links = driver.findElements(By.xpath("//body[@data-aos-easing='ease'] //a"));

		SoftAssert a = new SoftAssert ();

		for (WebElement link : links)  //Enhanced loop

		{

			String url = link.getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("HEAD");

			conn.connect();

			int respCode = conn.getResponseCode();

			System.out.println("The link with Text  " + "\"" + link.getText() + "\" " + "Passed with code " + respCode);
			

			a.assertTrue(respCode < 400, "The link with Text " + link.getText() + " is broken with code " + respCode);

		}

		a.assertAll();
	}

}