package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericUtility_Test.ExcelUtility;
import com.crm.GenericUtility_Test.FileUtility;
import com.crm.GenericUtility_Test.JavaUtility;
import com.crm.GenericUtility_Test.WebDriverUtility;

public class CreateorgWithIndAndType {

	public static void main(String[] args) throws Throwable {
		
		/*Create Objects*/
		JavaUtility jlib=new JavaUtility();
		FileUtility flib=new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
	/* Generate random no*/	
		int randomint = jlib.createRandomNo();
		
	/*Read data from Property file*/ 	
		String URl = flib.getpropertydata("url");
		String USERNAME=flib.getpropertydata("username");
		String PASSWORD=flib.getpropertydata("password");
		String BROWSER=flib.getpropertydata("browser");
	
	/*Read data from Excel file*/	
		String orgName=elib.getDataFromExcel("org",1,3)+randomint;
		String Industry=elib.getDataFromExcel("org", 1,4);
		String Type=elib.getDataFromExcel("org", 1,5);
		WebDriver driver=null;
		
	/*Lunching the browser*/	
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		/* login to App*/
		wlib.waitUntilPageLoad(driver);
		wlib.maximizeThePage(driver);
		driver.get(URl);
	
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	
		/*Navigate to org*/
		driver.findElement(By.linkText("Organizations")).click();
		
		/*navigate to create org*/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		/*create org*/
		driver.findElement(By.xpath("//td[text()='Organization Name 			']/..//input[@name='accountname']")).sendKeys(orgName);
		WebElement IndustryType = driver.findElement(By.name("industry"));
		wlib.select(IndustryType, Industry);
		WebElement Acounttype = driver.findElement(By.name("accounttype"));
		wlib.select(Acounttype, Type);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		/*verify org*/
		String actualorgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actualorgName.contains(orgName))
		{
			System.out.println(orgName+ "created succesfully ");
		}
		else
		{
			System.out.println(orgName+ "not created succesfully ");
		}
		
		/* logout */
		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
		WebElement lgo = driver.findElement(By.xpath("//img[contains(@src,'user')]"));
		wlib.mouseOver(driver, lgo);
		driver.findElement(By.linkText("Sign Out")).click();
		
		/* close the browser */
		driver.close();

	}

}
