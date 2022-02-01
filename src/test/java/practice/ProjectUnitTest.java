package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ProjectUnitTest {
	
	@Test
	public void projectunittest() throws SQLException
	{
		String ProjectName= "hdfc";
		Connection conn=null;
		
		try {
			Driver  driverref=new Driver();
			DriverManager.registerDriver(driverref);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("connection is done");
			Statement stat = conn.createStatement();
			String query="select * from project";
			ResultSet resultset = stat.executeQuery(query);
			boolean flag=false;
			while(resultset.next())
			{
				String actprojectname=resultset.getString(0);
				if(actprojectname.equals(ProjectName))
				{
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		}
		catch(Exception e){
			
		}
		finally {
			conn.close();
			System.out.println("====close db connection====");
		}
		
	}

}
