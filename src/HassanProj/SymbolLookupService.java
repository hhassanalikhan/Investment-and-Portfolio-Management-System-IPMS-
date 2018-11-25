package FatimaProj;
import java.sql.*;


public class SymbolLookupService {  
	
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
			
			result = "Stock Symbols in exchange: "+ exchange+"\n";
			while(myRs.next())
			{
				result +=  myRs.getString("StockSymbol") +"\n";
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.CommodityInfo where CommodityExchange = '"+exchange+"'");
			
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
	
	
	public String stockSymbolByCategory(String category)
	{
		String result = "";
		int f =0;
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where Category = '"+category+"'");
			//process results
				
			if(myRs.getFetchSize() > 0 )
			result = "Stock Symbols in category: "+ category;
			
			while(myRs.next())
			{
				f++;
				result +=  myRs.getString("StockSymbol")+ " " ;
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.CommodityInfo where Category = '"+category+"'");
			
				if(myRs.getFetchSize() > 0 )
					result = "Commodity Symbols in category: "+ category;
				while(myRs.next())
				{
					result +=  myRs.getString("CommoditySymbol");
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//result = ""+f;
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
			 result += "Commodity Symbols in category: "+ category ;
				if(myRs.getFetchSize() > 0 )
					result = "Commodity Symbols in category: "+ category;
				while(myRs.next())
				{
					result +=  myRs.getString("CommoditySymbol");
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
			
			result = "Stock Symbols with Name: "+ name;
			while(myRs.next())
			{
				result +=  myRs.getString("StockSymbol") +"\n";
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.CommodityInfo where CommodityName = '"+name+"'");
		
			 result += "Commodity Symbols with name: "+ name ;
				if(myRs.getFetchSize() > 0 )
					result = "Commodity Symbols with name: "+ name;
				while(myRs.next())
				{
					result +=  myRs.getString("CommoditySymbol");
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
}