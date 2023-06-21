package greenmouse.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import greenmouse.TestComponents.BaseTest;
import greenmouse.TestComponents.Retry;
import greenmouse.pageobjects.CartPage;
import greenmouse.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
			
	public void LoginErrorValidation() throws IOException, InterruptedException {

		landingPage.loginApplication("anshika@gmail.com", "Iamki000");
		Assert.assertEquals("Incorrect email  password.", landingPage.getErrorMessage());
		// removed or btw email and passwor to fail the test
	}

	@Test
	public void ProductErrorValidation() throws InterruptedException {

		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingPage.loginApplication("greenmouseapp@gmail.com", "Dandytech@2022");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
	}

}
