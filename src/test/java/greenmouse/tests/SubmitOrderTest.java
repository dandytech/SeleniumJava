package greenmouse.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import greenmouse.TestComponents.BaseTest;
import greenmouse.pageobjects.CartPage;
import greenmouse.pageobjects.CheckoutPage;
import greenmouse.pageobjects.ConfirmationPage;
import greenmouse.pageobjects.OrderPage;
import greenmouse.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = "purchase")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);

		CheckoutPage checkoutPage = cartPage.goToCheckout();

		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OderHistoryTest() {
		// "ZARA COAT 3"

		ProductCatalogue productCatalogue = landingPage.loginApplication("greenmouseapp@gmail.com", "Dandytech@2022");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}

	////Extent Reports - 
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//greenmouse//data//PurchaseOrder.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
	}
	
	
	// return new Object[][] {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"},
			// {"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL" } };

//			HashMap<String, String> map = new HashMap<String, String>();
//			map.put("email", "greenmouseapp@gmail.com");
//			map.put("password", "Dandytech@2022");
//			map.put("product", "ZARA COAT 3");
	//
//			HashMap<String, String> map1 = new HashMap<String, String>();
//			map1.put("email", "shetty@gmail.com");
//			map1.put("password", "Iamking@000");
//			map1.put("product", "ADIDAS ORIGINAL");
			

}
