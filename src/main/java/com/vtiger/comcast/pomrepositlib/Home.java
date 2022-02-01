package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility_Test.WebDriverUtility;

public class Home extends WebDriverUtility {
	
	WebDriver driver;
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(xpath="//img[contains(@src,'user')]")
	private WebElement adminstatorTag;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getAdminstatorTag() {
		return adminstatorTag;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void logOut()
	{
		mouseOver(driver, adminstatorTag); 
		signOutLink.click();
	}

}
