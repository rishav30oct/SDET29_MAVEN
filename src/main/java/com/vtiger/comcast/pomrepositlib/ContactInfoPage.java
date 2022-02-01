package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	WebDriver driver;
	public ContactInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(className="dvHeaderText")
	private WebElement orgHeaderSucMsg;
	

	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameInfo;
	
	public WebElement getOrgHeaderSucMsg() {
		return orgHeaderSucMsg;
	}


	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}
	
	
	
}
