package Phase1;

import java.sql.*;

public class SymbolLookupServices {


	public String sayHelloWorld(String exchange  )  
    {  
		String s ="";
		
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
			//2 create statement
			Statement myStmt = myConn.createStatement();
			
			//exe query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where StockExchange = '"+exchange+"'");
			//process results
					
			while(myRs.next())
			{
				s +=  myRs.getString("StockSymbol") + "\n";
			}
		}
		catch(Exception excp)
		{
			excp.printStackTrace();
		}
        return s;  
    }  
	
	public String symbolByExchange(String exchange)
	{
		String result = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where StockExchange = '"+exchange+"'");
			//process results
				
			
			result = "Stock Symbols in exchange: "+ exchange+"\n";
			while(myRs.next())
			{
				result +=  myRs.getString("StockSymbol") +"\n";
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.CommodityInfo where CommodityExchange = '"+exchange+"'");
				//process results
			 result += "***********************************\n";
			 result += "Commodity Symbols in exchange: "+ exchange + "\n";
				if(myRs.getFetchSize() > 0 )
					result = "Commodity Symbols in exchange: "+ exchange;
				while(myRs.next())
				{
					result +=  myRs.getString("CommoditySymbol") + System.getProperty("line.separator")+"\n";
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	
	
	public int stockSymbolByCategorynum(String category)
	{
		int x =0;
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where Category = '"+category+"'");
			//process results
				
			
			
			while(myRs.next())
			{
				x++;
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return x-1;
	}
	
	
	public String stockSymbolByCategorynumSymbol(int id,String category)
	{
		int x =0;
		String r = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where Category = '"+category+"'");
			//process results
				
			
			
			while(myRs.next())
			{
				if(x == id)
					r = myRs.getString("StockSymbol");
				x++;
			}
			
			
	
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return r;
	}
	
	public String stockSymbolByCategoryCurrency(int id,String category)
	{
		int x =0;
		String r = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where Category = '"+category+"'");
			//process results
				
			
			
			while(myRs.next())
			{
				if(x == id)
					r = myRs.getString("TradingCurrency");
				x++;
			}
			
			
	
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return r;
	}
	
	public String stockSymbolByCategory(String category)
	{
		String result = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where Category = '"+category+"'");
			//process results
				
			
			result = "Stock Symbols in category: "+ category+"\n        :";
			while(myRs.next())
			{
				result +=  myRs.getString("StockSymbol") +"\n";
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.CommodityInfo where Category = '"+category+"'");
				//process results
			 result += "***********************************\n";
			 result += "Commodity Symbols in category: "+ category + "        :\n";
				if(myRs.getFetchSize() > 0 )
					result = "Commodity Symbols in category: "+ category;
				while(myRs.next())
				{
					result +=  myRs.getString("CommoditySymbol") + System.getProperty("line.separator")+"\n";
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	
	
	public String commoditySymbolByCategory(String category)
	{
		String result = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where Category = '"+category+"'");
			//process results
				

			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.CommodityInfo where Category = '"+category+"'");
				//process results
			 result += "Commodity Symbols in category: "+ category + "        :\n";
				if(myRs.getFetchSize() > 0 )
					result = "Commodity Symbols in category: "+ category;
				while(myRs.next())
				{
					result +=  myRs.getString("CommoditySymbol") + System.getProperty("line.separator")+"\n";
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	
	
	
	public String symbolByName(String name)
	{
		String result = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where CompanyName = '"+name+"'");
			//process results
				
			
			result = "Stock Symbols with Name: "+ name+"\n        :";
			while(myRs.next())
			{
				result +=  myRs.getString("StockSymbol") +"\n";
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.CommodityInfo where CommodityName = '"+name+"'");
				//process results
			 result += "***********************************\n";
			 result += "Commodity Symbols with name: "+ name + "        :\n";
				if(myRs.getFetchSize() > 0 )
					result = "Commodity Symbols with name: "+ name;
				while(myRs.next())
				{
					result +=  myRs.getString("CommoditySymbol") + System.getProperty("line.separator")+"\n";
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
}
