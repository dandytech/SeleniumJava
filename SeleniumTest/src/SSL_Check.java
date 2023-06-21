import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL_Check {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		//Accept

		ChromeOptions options = new ChromeOptions();

		options.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://expired.badssl.com");

		System.out.println(driver.getTitle());

		
		
		
		// screenshot

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		//FileUtils.copyFile(src, new File("/Users/user/Desktop/TestResults/screenshot.png"));

	}

}
