package itStepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import itDriver.DriverSetup;
import itPageObjects.LoginPage;
import itPageObjects.ProductPage;
import itUtilities.Generic;



public class LoginSD {
	
	
	public WebDriver driver;
	DriverSetup ds;
	Generic gen;
	LoginPage lp;
	ProductPage pp;
	
	private static final Logger log1 =  LogManager.getLogger(LoginSD.class);
	public LoginSD(DriverSetup ds)
	{
		this.ds=ds;
		this.lp=ds.pom.getLoginPage();
		this.pp=ds.pom.getProductPage();
	}
	
	
	@Given("^user is on swag labs products page$")
    public void user_is_on_swag_labs_products_page() throws Throwable {
		log1.info("logging in");
        lp.login();
     
       Assert.assertTrue(pp.verifyLoggedIn());
       log1.info("logged in successfully");
       
    
}
	
	
	@Given("^user is on login page$")
    public void user_is_on_login_page() throws Throwable {
       Assert.assertTrue(lp.verifyUrl());
    }
	
	
	
	@When("^user enters (.+) and (.+)$")
    public void user_enters_and(String username, String password) throws Throwable {
		log1.info("trying to login with "+username+" and "+password);
		lp.testLogin(username, password);
        
    }
	
	@And("^clicks on login button$")
    public void clicks_on_login_button() throws Throwable {
       lp.clickLoginBtn();
       log1.info("clicked on login button");
    }
	
	 @Then("^user is displayed an error message$")
	    public void user_is_displayed_an_error_message() throws Throwable {
		 Assert.assertTrue(lp.verifyUrl());
		 log1.info("unable to login");
		 Assert.assertTrue(lp.verifyError());
		 log1.info("error message is diplayed");
	    }
	 
	 @When("^user clicks on login button$")
	    public void user_clicks_on_login_button() throws Throwable {
		 lp.clickLoginBtn();  
		 log1.info("clicked on login button");
	    }
	 
	 @Then("^error message \"([^\"]*)\" should be displayed$")
	    public void error_message_something_should_be_displayed(String blankloginerror) throws Throwable {
	        Assert.assertTrue(lp.verifyBlankErrorMsg(blankloginerror));
	        log1.info("error message is displayed");
	    }

}
