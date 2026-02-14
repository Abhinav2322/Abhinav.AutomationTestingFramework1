package itStepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import itDriver.DriverSetup;


public class SGHooks {
	
	DriverSetup ds;
	private static final Logger log1 =  LogManager.getLogger(SGHooks.class);
	
	public SGHooks(DriverSetup ds)
	{
		this.ds=ds;
	}
	
	@After
	public void afterScenario()
	{
		ds.gen.closeBrowser();
		log1.info("closed the browser");
		
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException
	{
		
		WebDriver driver=ds.bd.invokeBrowser();
		if(scenario.isFailed())
		{
			log1.info("failed...");
			
			File srcpath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(srcpath);
			scenario.attach(fileContent, "image/png", "screenshot");
		}
	}
}
