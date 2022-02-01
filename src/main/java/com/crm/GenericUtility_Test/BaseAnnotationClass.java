package com.crm.GenericUtility_Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositlib.Home;
import com.vtiger.comcast.pomrepositlib.Login;

public class BaseAnnotationClass {
	
	/*create Objects*/
	public JavaUtility jlib=new JavaUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib= new ExcelUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null; 
	
	@BeforeSuite(groups= {"smoke Test","regression Test"})
	public void configBS()
	{
		System.out.println("=========connect to database=======");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke Test","regression Test"})
	public void configBC() throws Throwable
	{
		
		System.out.println("======Launch the Browser=======");
		/*read common data */
		String URl = flib.getpropertydata("url");
		
		String BROWSER=flib.getpropertydata("browser");
		/*launch the browser*/
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.get(URl);
		sdriver=driver;
		
	}
	
	@BeforeMethod(groups= {"smoke Test","regression Test"})
	public void configBM() throws IOException
	{
		
		System.out.println("==========Login============");
		/*read common data */
		String USERNAME=flib.getpropertydata("username");
		String PASSWORD=flib.getpropertydata("password");
		/*lgin to app*/
		wlib.maximizeThePage(driver);
		wlib.waitUntilPageLoad(driver);
		Login lp=new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups= {"smoke Test","regression Test"})
	public void configAM()
	{
		
		System.out.println("=============Logout=============");
		/*logout*/
		Home hp=new Home(driver);
		hp.logOut();
		
	}
	
	@AfterClass(groups= {"smoke Test","regression Test"})
	public void configAC()
	{
		
		System.out.println("========Close the Browser========");
		/*close the browser*/
		driver.close();
		
	}
	
	@AfterSuite(groups= {"smoke Test","regression Test"})
	public void configAS()
	{
		System.out.println("=========close the database=======");
	}
	
	
	
	

}
