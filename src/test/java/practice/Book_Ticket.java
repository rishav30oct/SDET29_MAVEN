package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Book_Ticket {
	
	@Test(dataProvider="dataProvider_bookTicketTest")
	public void bookTicketTest(String src,String dest) 
	{
		System.out.println("book ticket from "+src+" to"+dest);
	}
	@DataProvider
	public Object[][] dataProvider_bookTicketTest()
	{
		Object[][] objArr=new Object[5][2];
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Masure";
		
		objArr[2][0]="Bangalore";
		objArr[2][1]="Mangalore";
		
		objArr[3][0]="Bangalore";
		objArr[3][1]="Patna";
		
		objArr[4][0]="Bangalore";
		objArr[4][1]="Delhi";
		
		return objArr;
	}
	

}
