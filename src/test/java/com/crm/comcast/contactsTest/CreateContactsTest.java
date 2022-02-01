package com.crm.comcast.contactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericUtility_Test.BaseAnnotationClass;
import com.crm.GenericUtility_Test.ExcelUtility;
import com.crm.GenericUtility_Test.FileUtility;
import com.crm.GenericUtility_Test.JavaUtility;
import com.crm.GenericUtility_Test.WebDriverUtility;
import com.vtiger.comcast.pomrepositlib.ContactInfoPage;
import com.vtiger.comcast.pomrepositlib.Contacts;
import com.vtiger.comcast.pomrepositlib.CreateNewContacts;
import com.vtiger.comcast.pomrepositlib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositlib.Home;
import com.vtiger.comcast.pomrepositlib.Login;
import com.vtiger.comcast.pomrepositlib.OrganizationInfo;
import com.vtiger.comcast.pomrepositlib.Organizations;

public class CreateContactsTest extends BaseAnnotationClass{
	
	@Test(groups="smoke Test")
	public  void createContacts() throws Throwable {
	
		int randomint = jlib.createRandomNo();
	
		/*read test data*/	
		String conName=elib.getDataFromExcel("org",5,3)+randomint;
		
		/*navigate to contacts*/
		Home hp=new Home(driver);
		hp.getContactLink().click();
		
		/*navigate to create new contact page*/
		Contacts cp=new Contacts(driver);
		cp.getCreateConImg().click();
		
		/*create new contact with con name*/
		CreateNewContacts cnp=new CreateNewContacts(driver);
		cnp.createContacts(conName);
		
		/*verify the details*/
		ContactInfoPage ci=new ContactInfoPage(driver);
		String actLastName=ci.getOrgHeaderSucMsg().getText();
		Assert.assertTrue(actLastName.contains(conName));
		
	}
		
		@Test(groups= "regression Test")
		public  void createContactsWithOrg() throws Throwable {
			
			
			int randomint = jlib.createRandomNo();
			/*read test data*/
			String orgName=elib.getDataFromExcel("org",5,4)+randomint;
			String conName=elib.getDataFromExcel("org",5,3)+randomint;
			
			/* navigate to organization*/
			Home hp=new Home(driver);
			hp.getOrganizationLink().click();
			
			/*navigate to create org page*/
			Organizations op=new Organizations(driver);
			op.getCreateOrgImg().click();
			
			/*create org*/
			CreateNewOrganization cnop=new CreateNewOrganization(driver);
			cnop.createOrgName(orgName);
			
			/*wait for header element*/
			OrganizationInfo oi=new OrganizationInfo(driver);
			wlib.waitForElementVisibility(driver, oi.getHeaderText());
			
			Assert.assertTrue(oi.getHeaderText().getText().contains(orgName));
			
			/*navigate to contacts*/
			hp.getContactLink().click();
			
			/*navigate to create new contact page*/
			Contacts cp=new Contacts(driver);
			cp.getCreateConImg().click();
			
			/*create new contact with org name*/
			CreateNewContacts cnp=new CreateNewContacts(driver);
			cnp.createContacts(conName, orgName);
			
			/*verify the details*/
			ContactInfoPage ci=new ContactInfoPage(driver);
			String actLastName=ci.getOrgHeaderSucMsg().getText();
			Assert.assertTrue(actLastName.contains(conName));
			
			String actOrgName=ci.getOrgNameInfo().getText();
			System.out.println(actOrgName);
			SoftAssert soft=new SoftAssert();
			soft.assertEquals(actOrgName.trim(), orgName);
			soft.assertAll();
		}

}


