package itPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfo {
	
	public WebDriver driver;
	public CheckoutInfo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By firstNameTextBox=By.id("first-name");
	By lastNameTextBox=By.id("last-name");
    By postalCodeTextBox=By.id("postal-code");
    By continueButton=By.id("continue");
    
    public void enterDetails(String firstName, String lastName, String pinCode)
    {
    	driver.findElement(firstNameTextBox).sendKeys(firstName);
    	driver.findElement(lastNameTextBox).sendKeys(lastName);
    	driver.findElement(postalCodeTextBox).sendKeys(pinCode);
    }
    
    public void clickContinue()
    {
    	driver.findElement(continueButton).click();
    }

}
