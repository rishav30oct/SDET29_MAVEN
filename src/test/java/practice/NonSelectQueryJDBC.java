package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryJDBC {

	public static void main(String[] args) throws SQLException {
		
		Connection conn=null;
		int Result=0;
		try
		{
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("Connection is done");
			Statement stat = conn.createStatement();
			String query="insert into project values ('ty_003','Deepak','12/01/2022','PNB','On_Going','10')";
			Result = stat.executeUpdate(query);
			
		}
		catch(Exception e)
		{
			
		}
		finally {
			if(Result==1)
			{
				System.out.println("project inserted succesfully");
			}
			else
			{
				System.out.println("project is not inserted!!!");
			}
			conn.close();
			System.out.println("-----close db connection-------");
		}

	}

}
