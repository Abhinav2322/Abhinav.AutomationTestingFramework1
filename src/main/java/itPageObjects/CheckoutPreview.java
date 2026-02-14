package itPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPreview {
	
	
	public WebDriver driver;
	public CheckoutPreview(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By finishButton=By.id("finish");
	
	public void clickFinish()
	{
		driver.findElement(finishButton).click();
	}

}
