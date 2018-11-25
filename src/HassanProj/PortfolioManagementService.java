package FatimaProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PortfolioManagementService {

	public String updateEmployeeRetirementContribution(String id,int percentage)
	{
		boolean c = false;
		
		try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
				//1 get connection
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
				Statement stmt = myConn.createStatement();
			        stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		        ResultSet myRs = stmt.executeQuery("SELECT * FROM demo.EmployeeInfo where EmployeeId = '"+id+"'");
		        while (myRs.next()) {
		          
		           myRs.updateInt("RetirementFundContributionPercentage", percentage);
		           myRs.updateRow();
		           c = true;
		        }
		      
		        myConn.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c)
			return "True";
		else
			return "False";
	}
	
	
	public String createPortFolio(String id, String string)
	{
		String result = "";

		try {
				String[] tokens = string.split(",");
				List<String> item = new ArrayList<String>();
				List<String>  category= new ArrayList<String>();
				List<Integer>  percentage= new ArrayList<Integer>();
				int x = 0 ;
				for(int i =0;i<tokens.length;)
				{
					
					item.add(tokens[i]);
					i++;
					category.add(tokens[i]);
					i++;
					
					int j = Integer.parseInt(tokens[i]);
					percentage.add(j);
					x+=j;
					i++;
				}
				
				if(x==100)
				{	
					DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
					//1 get connection
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
					Statement myStmt = null;
				    try {
				        myConn.setAutoCommit(false);
				        myStmt = myConn.createStatement();
				        for(int i=0; i<percentage.size();i++)
				        {
				        	myStmt.addBatch( "INSERT INTO PortfolioInfo " +"VALUES('"+id+"', '"+item.get(i)+"',  '"+category.get(i)+"',  "+percentage.get(i)+")");
				        }
				        myStmt.executeBatch();
				        myConn.commit();
				        result = "false";
				    } 
				    
				    catch(BatchUpdateException e) {
				    	e.printStackTrace();
				    } 
				    catch(SQLException e) {
				    	e.printStackTrace();
				    }
				    finally {
				        if (myStmt != null) { 
				        	myStmt.close();
				        result = "true";
				        }
				        myConn.setAutoCommit(true);
				    }
				}
				else 
					result = "Not 100%: "+ x;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public String updatePortFolio(String id,String string)
	{
		String result = "";

		try {
				String[] tokens = string.split(",");

				List<String> item = new ArrayList<String>();
				List<String>  category= new ArrayList<String>();
				List<Integer>  percentage= new ArrayList<Integer>();
				List<Boolean>  added= new ArrayList<Boolean>();
				int x = 0 ;
				for(int i =0;i<tokens.length;)
				{
					
					item.add(tokens[i]);
					i++;
					category.add(tokens[i]);
					i++;
					
					int j = Integer.parseInt(tokens[i]);
					percentage.add(j);
					boolean jj = false;
					added.add(jj);
					
					i++;
				}
				
				
				DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
				
				Statement myStmt = myConn.createStatement();
			    myStmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		        ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.PortfolioInfo where EmployeeId = '"+id+"'");
		     
		        boolean flag = false;
		        int xx = 0;
		        int row = 0;
		    	
		        result = "";
		        int k = 0;
		        while (myRs.next()) {
		        	for(int i=0; i<percentage.size();i++)
			        {
			        	if(myRs.getString("Item").equals(item.get(i)) && myRs.getString("Category").equals(category.get(i)) )
			        	{
			        		
			        		myRs.updateInt("PercentageContribution", percentage.get(i));
			        		myRs.updateRow();
			        		k++;
			        		boolean jk = true;
			        		added.set(i, jk);
			        		xx += percentage.get(i);
			        		row++;
			        	}
			        	
			        	
			        }
		        	
		        	
		        }
		        for(int i=0; i<percentage.size();i++)
		        {
		        if(added.get(i) == false)
		        {
		        	  myRs.moveToInsertRow();
		        	  myRs.updateString("EmployeeId", id);
		        	  myRs.updateInt("PercentageContribution", percentage.get(i));
		        	
		        	  myRs.updateString("Item", item.get(i));
		        	  myRs.updateString("Category", category.get(i));
		        	  xx += percentage.get(i);
		        	  myRs.insertRow();
		        	  row++;
		        }
		        }
		        myRs.close();
		        myStmt.close();
		        xx = xx - 100;
		        
		        result  += "Remainder percentage" +xx;
		        
		        
		        xx = -xx;
		        xx = xx / row;
		        
		        result += "  Distribution"+ xx;
		        
		        myStmt = myConn.createStatement();
		        myStmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
		        myRs = myStmt.executeQuery("SELECT * FROM demo.PortfolioInfo WHERE EmployeeId = '"+id+"'");
		        flag = false;

		        while (myRs.next()) {
		  
		        	
		        	   int fatima = myRs.getInt("PercentageContribution");
			           fatima = fatima + xx;
			           myRs.updateInt( "PercentageContribution",fatima)  ;
			           myRs.updateRow();
			        }

			        
			        myConn.close();
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public  String viewAccountSummary(String argEmpolyeeId)
	{
		String result = "";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM AccountSummary WHERE EmployeeId = '"+argEmpolyeeId+"';");
			
			while(myRs.next())
			{
				result +=  myRs.getString("CurrentBalance")+","  ;
				result +=  myRs.getString("QuarterEndBalance");
			}
			
			myRs.close();
		   myStmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	public  String viewAccountDetails(String argEmpolyeeId)
	{
		String result = "";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM AccountDetail WHERE EmployeeId = '"+argEmpolyeeId+"';");
			
			while(myRs.next())
			{
				result +=  myRs.getString("EmployeeId")+","  ;
				result +=  myRs.getString("Item")+"," ;
				result +=  myRs.getString("Category")+","  ;
				result +=  myRs.getString("Currentvalue")+"," ;
				result +=  myRs.getString("Profit")  ;
	
			}
			
			myRs.close();
		   myStmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public  String queryPortFolio(String argEmpolyeeId)
	{
		String result = "";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs ;
			if(argEmpolyeeId.equals("-1"))
					myRs = myStmt.executeQuery("SELECT * FROM PortfolioInfo ;");
			else
					myRs = myStmt.executeQuery("SELECT * FROM PortfolioInfo WHERE EmployeeId = '"+argEmpolyeeId+"';");
			
			while(myRs.next())
			{
				result +=  myRs.getString("EmployeeId")+","  ;
				result +=  myRs.getString("Item")+",";
				result +=  myRs.getString("Category")+","  ;
				result +=  myRs.getString("PercentageContribution");
				result += "  --  "; 
			}
			
			myRs.close();
		   myStmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public  String aggregateAmountPerItemCategory(String category)
	{
	
		List<String>  id= new ArrayList<String>();
		List<Float>  percentage= new ArrayList<Float>();
		float avrg = 0;
		int f =0;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs ;
			myRs = myStmt.executeQuery("SELECT * FROM EmployeeInfo ");
			
			while(myRs.next())
			{
				id.add(myRs.getString("EmployeeId"))   ;
				percentage.add((float) ((myRs.getInt("RetirementFundContributionPercentage")/100.0)*((myRs.getInt("Salary")))) )   ; 
			}
			
	
		   myRs = myStmt.executeQuery("SELECT * FROM PortfolioInfo  WHERE Category = '"+category+"'");
		   
			while(myRs.next())
			{
			    for(int i=0; i<percentage.size();i++)
		        {
		        	if(myRs.getString("EmployeeId").equals(id.get(i)) )
		        	{
		        		
		        		avrg += (myRs.getInt("PercentageContribution")/100.0)*percentage.get(i);
		        		f = (int) avrg;
		        	}
		        }
			}
			
			myRs.close();
		   myStmt.close();
		   
		   
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ""+avrg;
	}

}