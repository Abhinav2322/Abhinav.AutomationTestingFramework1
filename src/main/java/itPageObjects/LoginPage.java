package itPageObjects;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import itUtilities.Generic;



public class LoginPage {
	
	public WebDriver driver;
	
    Generic gen=new Generic(driver);
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By usernameField=By.id("user-name");
	By passwordField=By.id("password");
	By loginBtn=By.id("login-button");
	By errorbox=By.cssSelector("h3[data-test='error']");
	
	
	public void login()
	{
		
		
		Properties prop=gen.useProperty();
		driver.findElement(usernameField).sendKeys(prop.getProperty("username"));
		driver.findElement(passwordField).sendKeys(prop.getProperty("password"));
		driver.findElement(loginBtn).click();
		
	}
	
	public boolean verifyUrl()
	{
		Properties prop2=gen.useProperty();
		if(prop2.getProperty("loginPageURL").equalsIgnoreCase(driver.getCurrentUrl()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
   
	
	public void testLogin(String username, String password)
	{
		
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		
	}
	
	public void clickLoginBtn()
	{
		driver.findElement(loginBtn).click();
	}
	
	public boolean verifyError()
	{
		Properties prop3=gen.useProperty();
		
		if(prop3.getProperty("loginerrormessage").equals(driver.findElement(errorbox).getText()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean verifyBlankErrorMsg(String blankloginerror) {
		if(driver.findElement(errorbox).getText().contains(blankloginerror))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
