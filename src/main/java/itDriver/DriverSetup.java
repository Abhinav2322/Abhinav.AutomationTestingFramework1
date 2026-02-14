package itDriver;

import org.openqa.selenium.WebDriver;

import itPageObjects.PageObjectManager;
import itUtilities.Generic;

public class DriverSetup {
	
	
	public WebDriver driver;
	public Driver bd;
	public Generic gen;
	public PageObjectManager pom;
	
	
	public DriverSetup()
	{
		bd=new Driver();
		pom=new PageObjectManager(bd.invokeBrowser());
		gen=new Generic(bd.invokeBrowser());
		
		
	}

}