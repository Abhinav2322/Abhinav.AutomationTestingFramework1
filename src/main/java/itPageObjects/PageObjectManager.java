package itPageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public WebDriver driver;
	public LoginPage lp;
	public ProductPage pp;
	public CartPage cp;
	public CheckoutPreview cop;
	public CheckoutInfo coi;
	public CheckoutFinished cof;
	
	
	
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	
	
	public LoginPage getLoginPage()
	{
		lp=new LoginPage(driver);
		return lp;
	}
	
	
	public ProductPage getProductPage()
	{
		pp=new ProductPage(driver);
		return pp;
	}
	
	
	
	public CartPage getCartPage() 
	{
	    cp=new CartPage(driver);
	    		return cp;
	}
	
	
	public CheckoutInfo getCheckoutInfoPage()
	{
		coi=new CheckoutInfo(driver);
		return coi;
	}
	
	
	
	public CheckoutPreview getCheckoutPreviewPage()
	{
		cop=new CheckoutPreview(driver);
		return cop;
	}
	
	
	public CheckoutFinished getCheckoutFinishedPage()
	{
		cof=new CheckoutFinished(driver);
		return cof;
	}
	


}
