package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility_Test.WebDriverUtility;

public class CreateNewContacts extends WebDriverUtility{
	
	WebDriver driver;
	public CreateNewContacts(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//td[text()='Organization Name 			']/..//img[contains(@src,'select')]")
	private WebElement selectOrg;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	
	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSelectOrg() {
		return selectOrg;
	}
	
	public void createContacts(String conLastName)
	{
		lastname.sendKeys(conLastName);
		
		saveBtn.click();
		
	}



	public void createContacts(String conLastName,String orgName)
	{
		lastname.sendKeys(conLastName);
		selectOrg.click();
		switchToWindow(driver, "Accounts");
		Organizations op=new Organizations(driver);
		op.getSearchEdt().sendKeys(orgName);
		op.getSearchBtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}

	

}
