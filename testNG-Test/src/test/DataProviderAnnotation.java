package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotation {

	@DataProvider  //for passing multiple data using array
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2]; //two dimensional array
		
		// 1st set
		data[0][0] = "username1"; // row 1, col 1
		data[0][1] = "password1"; // row 1, col 2

		// 2nd set
		data[1][0] = "username2"; // row 2, col 1
		data[1][1] = "password2"; // row 2, col 2

		// 3rd set
		data[2][0] = "username3"; // row 3, col 1
		data[2][1] = "password3"; // row3, col 2

		return data;

	}

	// To invoke the above

	@Test(dataProvider = "getData")
	
	public void MobileSignIn(String username, String password) {
		
		System.out.println("Mobile SignIn Details");

		System.out.println(username);

		System.out.println(password);

	}

}
