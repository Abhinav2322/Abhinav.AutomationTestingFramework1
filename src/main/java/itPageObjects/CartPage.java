package itPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	
public WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By checkOutBTN=By.id("checkout");
	String cartItemText;
	
	public void proceedToCheckOut()
	{
		driver.findElement(checkOutBTN).click();
	}
	
	
	public boolean verifyAddedIems()
	{
		cartItemText=driver.findElement(By.cssSelector("#cart_contents_container")).getText();
		if(cartItemText.contains("Backpack") && cartItemText.contains("Light"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
