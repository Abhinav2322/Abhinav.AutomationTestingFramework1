package itStepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import itDriver.DriverSetup;
import itPageObjects.CheckoutFinished;
import org.testng.Assert;


public class PostOrderSD {
	
	
	public WebDriver driver;
	CheckoutFinished cof;
	DriverSetup ds;
	private static final Logger log1 =  LogManager.getLogger(PostOrderSD.class);
	
	public PostOrderSD(DriverSetup ds)
	{
		this.ds=ds;
		this.cof=ds.pom.getCheckoutFinishedPage();
	}
	
	@When("^user logs out of the app$")
    public void user_logs_out_of_the_app() throws Throwable {
		cof.clickBurgerBtn();
		log1.info("clicked on hamburger menu icon");
		ds.gen.waitfor();
		cof.logOut();
		log1.info("clicked on logout");
    }
	
	@Then("^user lands on saucedemo login page$")
    public void user_lands_on_saucedemocom_login_page() throws Throwable {
        Assert.assertTrue(cof.verifyLoggedOut());
        log1.info("logged out successfully");
	}


}
