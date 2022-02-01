package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class SampleTask {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		//String ORGNAME=pobj.getProperty("orgname");
		
		FileInputStream fis1=new FileInputStream("./data/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String ORGNAME=wb.getSheet("org").getRow(1).getCell(0).getStringCellValue();

		WebDriver driver = null;
		if(BROWSER.equals("chrome"))
		{
			 driver=new ChromeDriver();

		}
		if(BROWSER.equals("firefox"))
		{
			 driver=new FirefoxDriver();
		}
		if(BROWSER.equals("ie"))
		{
			 driver=new InternetExplorerDriver();
		}
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.id("qccombo")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[1]")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		String actualtext=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualtext.contains(ORGNAME))
		{
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed");

		}
		
		Actions a=new Actions(driver);
		WebElement lgo = driver.findElement(By.xpath("(//td[@class='small'])[2]/img"));
		a.moveToElement(lgo).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
