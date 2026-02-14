package itDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class Driver {

		public WebDriver driver;
		
		public WebDriver invokeBrowser()
		{
			if(driver==null)
			{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			}
			return driver;
			
			
			
		}
	}


