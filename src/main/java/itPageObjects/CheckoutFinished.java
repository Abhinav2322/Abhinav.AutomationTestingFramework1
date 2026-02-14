package itPageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import itUtilities.Generic;



public class CheckoutFinished {
	
	
	public WebDriver driver;
	Generic gen=new Generic(driver);
	public CheckoutFinished(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By burgerButton=By.id("react-burger-menu-btn");
    By logOutButton=By.id("logout_sidebar_link");
	By currentOrderStatus=By.cssSelector(".complete-text");
	public void clickBurgerBtn()
	{
		driver.findElement(burgerButton).click();
		
		
	}
	
	

	public void logOut()
	{
		driver.findElement(logOutButton).click();
		
	}
	
	
	public boolean verifyLoggedOut()
	{
		Properties prop3=gen.useProperty();
		if(prop3.getProperty("loginPageURL").equals(driver.getCurrentUrl()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean verifyOrder()
	{
	 Properties prop4=gen.useProperty();
	 if(prop4.getProperty("ordersuccessmsg").equals(driver.findElement(currentOrderStatus).getText()))
	 {
		return true; 
	 }
	 else
	 {
		 return false;
	 }
	}

}
