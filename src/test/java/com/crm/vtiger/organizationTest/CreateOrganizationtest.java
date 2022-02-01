package com.crm.vtiger.organizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericUtility_Test.BaseAnnotationClass;
import com.crm.GenericUtility_Test.ExcelUtility;
import com.crm.GenericUtility_Test.FileUtility;
import com.crm.GenericUtility_Test.JavaUtility;
import com.crm.GenericUtility_Test.WebDriverUtility;
import com.vtiger.comcast.pomrepositlib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositlib.Home;
import com.vtiger.comcast.pomrepositlib.Login;
import com.vtiger.comcast.pomrepositlib.OrganizationInfo;
import com.vtiger.comcast.pomrepositlib.Organizations;

public class CreateOrganizationtest extends BaseAnnotationClass{

	@Test(groups= "smoke Test")
	public  void createOrganization() throws Throwable {
		
		int randomint = jlib.createRandomNo();
		
		/*read test data*/
		String orgName=elib.getDataFromExcel("org",1,3)+randomint;
		
		/* navigate to organization*/
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();
		
		/*navigate to create org page*/
		Organizations op=new Organizations(driver);
		op.getCreateOrgImg().click();
		
		/*create org*/
		CreateNewOrganization cnop=new CreateNewOrganization(driver);
		cnop.createOrgName(orgName);
		
		/*verify org name*/
		OrganizationInfo oinfop=new OrganizationInfo(driver);
		wlib.waitForElementVisibility(driver, oinfop.getHeaderText());
		String actualorgName=oinfop.getHeaderText().getText();
		
		
		Assert.assertTrue(actualorgName.contains(orgName));
		
	}
	
	@Test(groups= "regression Test")
	public void createOrgWithIndType() throws Throwable {
		
		int randomint = jlib.createRandomNo();
		
		
		/*read test data*/
		String orgName=elib.getDataFromExcel("org",1,3)+randomint;
		String indName=elib.getDataFromExcel("org",1,4);
		
		/* navigate to organization*/
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();
		
		/*navigate to create org page*/
		Organizations op=new Organizations(driver);
		op.getCreateOrgImg().click();
		
		/*create org*/
		CreateNewOrganization cnop=new CreateNewOrganization(driver);
		cnop.createOrgNameWithInd(orgName, indName);
		
		/*verify idusname*/
		
		/*verify org name*/
		OrganizationInfo oinfop=new OrganizationInfo(driver);
		wlib.waitForElementVisibility(driver, oinfop.getHeaderText());
		String actualorgName=oinfop.getHeaderText().getText();
		Assert.assertTrue(actualorgName.contains(orgName));
		
		String actIndustryInfo=oinfop.getIndustriesInfo().getText();
		Assert.assertEquals(actIndustryInfo, indName);
		
	}

}


