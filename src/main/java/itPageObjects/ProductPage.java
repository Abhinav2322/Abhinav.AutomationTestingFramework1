package itPageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import itUtilities.Generic;



public class ProductPage {
	
	
	public WebDriver driver;
	//public Properties prop1;
	Generic gen=new Generic(driver);
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		
		
	}
	
	By cartIcon=By.cssSelector(".shopping_cart_link");
	
	
	

	
	public void addToCart(String item)
	{
		
		Properties prop1=gen.useProperty();
		String item1=prop1.getProperty("saucelabsbackpack");
		String item2=prop1.getProperty("saucelabsbikelight");
		String item3=prop1.getProperty("saucelabsbolttshirt");
		String item4=prop1.getProperty("saucelabsfleecejacket");
		String item5=prop1.getProperty("saucelabsonesie");
		String item6=prop1.getProperty("saucelabsredtshirt");
		
		
		
		
		if(item.contains("backpack"))
		{
			driver.findElement(By.id(item1)).click();
		}
		else if(item.contains("light"))
		{
			driver.findElement(By.id(item2)).click();
		}
		else if(item.contains("bolt"))
		{
			driver.findElement(By.id(item3)).click();
		}
		else if(item.contains("fleece"))
		{
			driver.findElement(By.id(item4)).click();
		}
		else if(item.contains("onesie"))
		{
			driver.findElement(By.id(item5)).click();
		}
		else if(item.contains("red"))
		{
			driver.findElement(By.id(item6)).click();
		}
		else
		{
			System.out.println("product not available");
		}
		
	}
	
	
	
	public void clickOnCart()
	{
		driver.findElement(cartIcon).click();
	}
	
	
	
	
	
	public boolean verifyLoggedIn()
	{
		Properties prop2=gen.useProperty();
		if(prop2.getProperty("productPageURL").equalsIgnoreCase(driver.getCurrentUrl()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


}
