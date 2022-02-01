package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryJDBC {
	
	public static void main(String[]args) throws SQLException
	{
		Connection conn=null;
		try
		{
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("Connection is done");
			Statement stat = conn.createStatement();
			String query="select * from project";
			ResultSet set = stat.executeQuery(query);
			while(set.next())
			{
				System.out.println(set.getString(1)+"\t"+set.getString(2)+"\t"+set.getString(3)+"\t"+set.getString(4));
			}
		}
		catch(Exception e)
		{
			
		}
		finally {
			conn.close();
			System.out.println("-----close db connection-------");
		}
		
	}

}
