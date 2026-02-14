package itStepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import itDriver.DriverSetup;
import itPageObjects.CartPage;
import itPageObjects.CheckoutFinished;
import itPageObjects.CheckoutInfo;
import itPageObjects.CheckoutPreview;

public class CheckoutProcessSD {
	
	
	public WebDriver driver;
	CartPage cp;
	CheckoutInfo coi;
	CheckoutPreview cop;
	CheckoutFinished cof;
	DriverSetup ds;
	private static final Logger log1 =  LogManager.getLogger(CheckoutProcessSD.class);
	
	public CheckoutProcessSD(DriverSetup ds)
	{
		this.ds=ds;
		this.cp=ds.pom.getCartPage();
		this.coi=ds.pom.getCheckoutInfoPage();
		this.cof=ds.pom.getCheckoutFinishedPage();
		this.cop=ds.pom.getCheckoutPreviewPage();
	}
	
	
	@When("^user checks out the added items with details (.+) , (.+) and (.+)$")
    public void user_checks_out_the_added_items_with_details_and(String firstname, String lastname, String pincode) throws Throwable {
        
		cp.proceedToCheckOut();
		log1.info("clicked on checkout button");
		coi.enterDetails(firstname, lastname, pincode);
		log1.info("entered the details - "+firstname+" , "+lastname+" and "+pincode);
		coi.clickContinue();
		log1.info("clicked on continue");
		cop.clickFinish();
		log1.info("clicked finish");
    }
	
	 @Then("^checkout is complete and order is placed$")
	    public void checkout_is_complete_and_order_is_placed() throws Throwable {
	        Assert.assertTrue(cof.verifyOrder());
	        log1.info("order is placed successfully");
	    }

}
