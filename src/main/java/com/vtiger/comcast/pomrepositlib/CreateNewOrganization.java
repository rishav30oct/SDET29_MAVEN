package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility_Test.WebDriverUtility;

public class CreateNewOrganization extends WebDriverUtility {
	
	WebDriver driver;
	public CreateNewOrganization(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement createOrgEdt;
	
	@FindBy(name="industry")
	private WebElement industryType;
	
	@FindBy(name="accounttype")
	private WebElement accountType;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;

	public WebElement getCreateOrgEdt() {
		return createOrgEdt;
	}

	public WebElement getIndustryType() {
		return industryType;
	}

	public WebElement getAccountType() {
		return accountType;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrgName(String orgName)
	{
		createOrgEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrgNameWithInd(String orgName,String industaryName)
	{
		createOrgEdt.sendKeys(orgName);
		select(industryType, industaryName);
		saveBtn.click();
	}
	
	public void createOrgNameWithIndAndType(String orgName,String industaryName,String accounType)
	{
		createOrgEdt.sendKeys(orgName);
		select(industryType, industaryName);
		select(accountType, accounType );
		saveBtn.click();
	}

}
