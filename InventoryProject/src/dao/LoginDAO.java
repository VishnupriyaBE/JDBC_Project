package dao;

import model.Login;
import java.sql.*;
import connectionManager.ConnectionManager;

public class LoginDAO 
{
   public boolean validate(Login login) throws ClassNotFoundException, SQLException
	  {
	   String username=login.getUsername();
	   String password=login.getPassword();
		  ConnectionManager conm=new ConnectionManager();
		  Connection con=conm.establishConnection();
		  //query implementation->Statement class(important)
		  //create Statement
		  Statement st=con.createStatement();//predefined method
		  //Result Set->class(the return or select value from the table is converted as list and stored)
		  ResultSet rt=st.executeQuery("select*from login");//table
		  while(rt.next())
		  {
		  if(username.equals(rt.getString("username"))&&password.equals(rt.getString("password")))
		  {
			  conm.closeConnection();
			  return true;
		  }
	  }
			  conm.closeConnection();
			  return false;
		  }
		  
		  
	  }

