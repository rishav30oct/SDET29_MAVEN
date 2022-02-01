package com.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteContact_1 {
	
	WebDriver driver=null;
	
	
	@Test(priority=1)
	public void deletemultiplecontact_1() throws IOException, InterruptedException
	{
		
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		String BROWSER=pobj.getProperty("browser");
		
		
		FileInputStream fis1=new FileInputStream("./data/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String CONNAME=wb.getSheet("con").getRow(1).getCell(0).getStringCellValue();
		String CONNAME1=wb.getSheet("con").getRow(2).getCell(0).getStringCellValue();

		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		
		
		
		
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String expectedtitle="vtiger";
		String actualtitle = driver.findElement(By.xpath("//a[.='vtiger']")).getText();
		Assert.assertEquals(actualtitle, expectedtitle,"Login page open");
		//Assert.assertEquals(false, false, actualtitle)
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(CONNAME);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(CONNAME1);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[.='piyush']/../..//input[@name='selected_id']")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//a[.='piyush1']/../..//input[@name='selected_id']")).click();
		Thread.sleep(20000);

		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		Thread.sleep(20000);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();
		Actions aa=new Actions(driver);
		WebElement lgo = driver.findElement(By.xpath("(//td[@class='small'])[2]/img"));
		aa.moveToElement(lgo).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();



	}
	@Test(priority=2)
	public void deletecontact_2() throws InterruptedException, IOException
	{
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		FileInputStream fis1=new FileInputStream("./data/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String CONNAME=wb.getSheet("con").getRow(1).getCell(0).getStringCellValue();
		//String CONNAME1=wb.getSheet("con").getRow(2).getCell(0).getStringCellValue();

		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		
		
		
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(CONNAME);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[.='piyush']/../..//input[@name='selected_id']")).click();
		Thread.sleep(20000);
		

		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		Thread.sleep(20000);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();
		Actions aa=new Actions(driver);
		WebElement lgo = driver.findElement(By.xpath("(//td[@class='small'])[2]/img"));
		aa.moveToElement(lgo).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(20000);
		driver.close();

	}
	

}
