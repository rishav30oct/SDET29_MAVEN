package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	
	WebDriver driver;
	public OrganizationInfo (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industriesInfo;
	
	public WebElement getHeaderText() {
		return headerText;
	}

	public WebElement getIndustriesInfo() {
		return industriesInfo;
	}
	
	

}
