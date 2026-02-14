package itTestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/ITfeatures", glue="itStepDefinitions" ,monochrome=true,
plugin= {"html:Reports/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class ITTestRunner extends AbstractTestNGCucumberTests{
	
	

}
