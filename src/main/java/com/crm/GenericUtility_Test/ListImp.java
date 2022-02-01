package com.crm.GenericUtility_Test;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImp implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		
		String failedtestName=result.getMethod().getMethodName();
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseAnnotationClass.sdriver);
		File srcfile=edriver.getScreenshotAs(OutputType.FILE);
		String systemdate=new Date().toString().replace(":", "_").replace(" ", "_");
		try {
			FileUtils.copyFile(srcfile, new File("./Screenshot"+failedtestName+ "_"+systemdate+" .png"));
			
		} catch (Exception e) {
			
		}
		
	}

}
