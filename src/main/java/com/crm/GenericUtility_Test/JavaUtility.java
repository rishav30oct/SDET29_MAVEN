package com.crm.GenericUtility_Test;

/**
 * 
 * @author rishav ranjan
 * 
 */
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int createRandomNo()
	{
		Random random=new Random();
		int ran = random.nextInt(100);
		
		return ran;
	}
	
	public String generateTodayDate()
	{
		Date todaydate=new Date();
		String tdate = todaydate.toString();
		return tdate;
	}
	
	public String specifyTodayDate()
	{
		Date todaydate=new Date();
		String tdate = todaydate.toString();
		String[] tDate = tdate.split(" ");
		String yyyy = tDate[5];
		String mm=tDate[1];
		String dd=tDate[2];
		String sDate=yyyy+"_"+mm+"_"+dd;
		return sDate;
	}

}
