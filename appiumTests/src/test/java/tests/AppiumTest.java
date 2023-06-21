package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class AppiumTest {
	
	static AppiumDriver driver;
	
	public static void main(String[] args) {
		
		//Error Tracking
		try {
			openBOG();
		}catch (Exception exp) {
			System.out.println("Cause is: "+exp.getCause());
			System.out.println("Message is: "+exp.getMessage());
			exp.printStackTrace();
		}
		//End Error Tracking
		
	}

	public static void openBOG() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("deviceName", "APP");
		cap.setCapability("duid", "emulator-5554");
		cap.setCapability("app", "/Users/user/Desktop/APKs/lazreb.apk");
		//cap.setCapability("appPackage", "com.bog.app.bog");
		//cap.setCapability("appActivity", "com.bog.app.bog.MainActivity");
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		 driver = new AppiumDriver (url, cap);

		 System.out.println("Application Started...");
		
		driver = new AppiumDriver(cap);
	}
}

