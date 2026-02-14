package itUtilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic {
	
	
	public WebDriver driver;
	public  WebDriverWait wait;
	public Properties prop;
	
	public Generic(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	
	
	
	//implicit wait
	public void waitfor()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	}
	
	//to close browser
	public void closeBrowser()
	{		
		driver.quit();
	}
	
	
	//to read data from properties file
	public Properties useProperty()
	{
		prop = new Properties();
		try {
			prop.load(new FileInputStream(
					"src/test/resources/configuration.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
		
		
	}

}
