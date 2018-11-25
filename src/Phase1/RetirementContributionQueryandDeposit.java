package Phase1;

import java.sql.*;

import apple.laf.JRSUIConstants.State;

public class RetirementContributionQueryandDeposit {

	
	/*public String breakInputICI(String in)
	{
		   String[] result = in.split(",");
		   return result[0];
	}
	public String breakInputICC(String in)
	{
		   String[] result = in.split(",");
		   return result[1];
	}*/
	public String depositIntoRetirementAccount(String id, int p)
	{
		String result = "";
		Statement myStmt;
		float val = 0;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			Statement stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	                   ResultSet.CONCUR_UPDATABLE);
			ResultSet uprs = stmt.executeQuery("SELECT * FROM demo.AccountDetail  where EmployeeId = '"+id+"' ");
		      int k =0;
		 	while(uprs.next())
				{
					if(uprs.getString("Item").equals("cash"))
		 			{uprs.updateInt( "Currentvalue", (int) (uprs.getInt("Currentvalue")+(p)));
				    uprs.updateRow();}
					
				}
		 	uprs.close();
		}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Added";
	} 
	
	
	
	
	public String monthlyContributionQuery(String id)
	{
		String result = "";
		Statement myStmt;
		float val = 0;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.EmployeeInfo where EmployeeId = '"+id+"'");
			//process results
				

			
			 result += "Account summary of ID: "+ id + "        :\n";
			 
				while(myRs.next())
				{
					val = (float) (myRs.getInt("Salary") * (myRs.getInt("RetirementFundContributionPercentage")/100.0));
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return (""+val);
	}  
	
	
	public String getId(int id)
	{

		Statement myStmt;
		String val = "";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.EmployeeInfo ");
			//process results
				
			int x =0;
				while(myRs.next())
				{
					
					if(x==id)
						val =  myRs.getString("EmployeeId") ;
			
						x++;
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return val;
	} 
	
	public int monthlyContributionQuery1(int id)
	{

		Statement myStmt;
		float val = 0;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.EmployeeInfo ");
			//process results
				
			int x =0;
				while(myRs.next())
				{
					
					if(x==id)
						val = (float) (myRs.getInt("Salary") * (myRs.getInt("RetirementFundContributionPercentage")/100.0));
			
						x++;
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return (int)val;
	} 
	
}
