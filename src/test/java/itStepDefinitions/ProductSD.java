package itStepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import itDriver.DriverSetup;
import itPageObjects.ProductPage;

public class ProductSD {

	
	public WebDriver driver;
	DriverSetup ds;
	ProductPage pp;
	private static final Logger log1 =  LogManager.getLogger(ProductSD.class);
	
	
	public ProductSD(DriverSetup ds)
	{
		this.ds=ds;
		this.pp=ds.pom.getProductPage();
	}
	
	@When("^user adds items to the cart$")
    public void user_adds_items_to_the_cart() throws Throwable {
		pp.addToCart("backpack");
		pp.addToCart("bike light");
		log1.info("added items to the cart successfully");
		
	}
	
	
	@And("^clicks on cart button$")
    public void clicks_on_cart_button() throws Throwable {
		pp.clickOnCart();
		log1.info("navigating to cart page");
    }
	
	 @Then("^user lands on products page$")
	    public void user_lands_on_products_page() throws Throwable {
		 Assert.assertTrue(pp.verifyLoggedIn());
		 log1.info("logged in sucessfully");
	    }
	
}
