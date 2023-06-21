import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UniqueNumPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/Selenium/chromedriver");
		
		
		//WebDriver driver = new ChromeDriver();
		
		
		List<Integer> values = Arrays.asList(3, 2, 4, 2, 7, 5, 1, 9, 7);
		
		//Print distinct numbers, i.e numbers without repetition
		values.stream().distinct().forEach(s -> System.out.println(s));
		
		//sort and get 3rd index
		
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
	
		System.out.println("Index of 2: " + li.get(2));
				

	}

}
