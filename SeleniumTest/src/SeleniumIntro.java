import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		
		ChromeDriver driver = new ChromeDriver(options);
	
		
		//System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");

		//ChromeDriver driver = new ChromeDriver();

		driver.get("https://dandytech.netlify.app/");

	}

}
