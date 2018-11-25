package Phase2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Class3rdPartyServices {

	
	String convertCrrency(String baseCurrencyCode, String conversionCurrenyCode)
	{
		String res = null;
		ThirdPartServices tps = new ThirdPartServices();
		res = tps.conertCrrency("EUR", "PKR");
		
		return res;
	}

	
	public String getQuoteAm(String s)
	{
		String res = "";

			StockServices tps = new StockServices();
			res = tps.stockQueryAm(s);
	
		
		
		return ("Result: "+res);
		
	}
	
	public String getQuotePr(String s)
	{
		String res = "";

			StockServices tps = new StockServices();
			res = tps.stockQueryPs(s);
	
		
		
		return ("Result: "+res);
		
	}
	public String converToFrom(String from,String to)
	{
		String result = "";
		String res = "";
		Statement myStmt;
		float val = 0;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();
			ThirdPartServices tps = new ThirdPartServices();
			res = tps.conertCrrency(from, to);
			//ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.EmployeeInfo where EmployeeId = '"+id+"'");
			//process results
				

			// result += "Account summary of ID: "+ id + "        :\n";
			 
				//while(myRs.next())
				//{
				//	val = (float) (myRs.getInt("Salary") * (myRs.getInt("RetirementFundContributionPercentage")/100.0));
				//}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ("Result: "+res);
	}  
}
