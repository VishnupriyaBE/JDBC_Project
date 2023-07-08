package dao;

import java.sql.*;

import connectionManager.ConnectionManager;
import model.Product;

public class ProductDAO 
{
 public void addProduct(Product product)throws ClassNotFoundException,SQLException
 {
	 //java and JDBC connection
	 ConnectionManager conm=new ConnectionManager();
	 Connection con=conm.establishConnection();
	 
	 String sql_query="insert into product(productId,productName,minSellQuantity,price,quantity) values(?,?,?,?,?)";//(i,2,3,4,5->?)
	 PreparedStatement ps =con.prepareStatement(sql_query);
	 ps.setInt(1,product.getProductId());
	 ps.setString(2,product.getProductName());
	 ps.setInt(3,product.getMinSellQuantity());
	 ps.setInt(4, product.getPrice());
	 ps.setInt(5, product.getQuantity());
	 
	 ps.executeUpdate();
	 
	 conm.closeConnection();
 }
	public void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager conm=new ConnectionManager();
		  Connection con=conm.establishConnection();
		  Statement st=con.createStatement();//predefined method
		  //Result Set->class(the return or select value from the table is converted as list and stored)
		  ResultSet rt=st.executeQuery("select*from product");//table
		  while(rt.next())
		  {
		  System.out.println(rt.getInt("productId")+"|"+rt.getString("productName")+"|"+rt.getInt("minSellQuantity")+"|"+rt.getInt("price")+"|"+rt.getInt("quantity"));
		  }
		  conm.closeConnection();
	  }
	}

