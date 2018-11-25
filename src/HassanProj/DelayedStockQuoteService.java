package FatimaProj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DelayedStockQuoteService {

	
	public String symbolByExchange(String exchange)
	{
		String result = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "fatima");
		
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
	
	
	
	
}
