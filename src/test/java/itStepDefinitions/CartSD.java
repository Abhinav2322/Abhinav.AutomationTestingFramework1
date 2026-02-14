package itStepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import itDriver.DriverSetup;
import itPageObjects.CartPage;

public class CartSD {

	
	public WebDriver driver;
	DriverSetup ds;
	CartPage cp;
	private static final Logger log1 =  LogManager.getLogger(CartSD.class);
	
	public CartSD(DriverSetup ds)
	{
		this.ds=ds;
		this.cp=ds.pom.getCartPage();
		
	}
	
	@Then("^lands on cart page and gets added items$")
    public void lands_on_cart_page_and_gets_added_items() throws Throwable {
		Assert.assertTrue(cp.verifyAddedIems());
		log1.info("added items found in the cart");
	}
	
}
