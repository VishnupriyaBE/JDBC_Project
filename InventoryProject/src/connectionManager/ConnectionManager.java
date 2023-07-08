package connectionManager;

import java.sql.*;

public class ConnectionManager 
{
	Connection con =null;

	public Connection establishConnection() throws SQLException, ClassNotFoundException 
	{
		//2.
		Class.forName("com.mysql.cj.jdbc.Driver");
		//3.create connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryProject","root","Vishnu@21");
		return con;
	}
	public void closeConnection() throws SQLException
	{
		con.close();
	}
}


