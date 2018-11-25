package Phase2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class tempClass2 {

	public String updateSharePerEmployee(String item,String cat,String symbol,String ts, int totalam,String ttype)
	{
		
		String result = "";
		Statement myStmt;
		try {
	
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.EmployeeInfo");
			//process results
				
			
			List<String> id = new ArrayList<String>();
			List<Float>  ps= new ArrayList<Float>();
			while(myRs.next())
			{
				id.add(myRs.getString("EmployeeId"));
				float x = (float) (( myRs.getInt("RetirementFundContributionPercentage")/100.0));
				ps.add(x);
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.PortfolioInfo where Item = '"+item+"' ");
			 float v = 0 ;
			 int c = 0;
				List<String> nid = new ArrayList<String>();
				List<Float>  nps= new ArrayList<Float>();
				List<Float>  stocks= new ArrayList<Float>();
				float add =2;
			while(myRs.next())
			{
				for(int i=0;i<id.size();i++ )
				{
					if(id.get(i).equals(myRs.getString("EmployeeId")))
					{
						nid.add(myRs.getString("EmployeeId"));
						float x = (float) (((myRs.getInt("PercentageContribution")/100.0)) * ps.get(i));
						nps.add(x);
						//int p = myRs.getInt("Profit");
						StockServices tps = new StockServices();
						String s1 = tps.stockQueryAm(item);
						String s2 = tps.stockQueryPs(item);
						int am = Integer.parseInt(s1);
						float pr = Float.parseFloat(s2);
						
			
						//stocks.add((int)x);
						//myRs.updateInt( "Currentvalue", (int) x);
					
						//myRs.updateInt( "Currentvalue", (int) x);
						float nv = x/totalam;
						int ns = (int)(Float.parseFloat(ts) * nv);
						
						 add =x* totalam; //(int)(Float.parseFloat(ts) * nv);
						 
						if(ttype.equals("buy"))
	
						
						{
							add = -1 * add;
						}
						stocks.add(add);
						//add = add + p;
						//myRs.updateRow();
						
					}
				}
			}
			v = v/c;

			myRs.close();
			
			
			
			
			
			
			Statement stmt = myConn.createStatement();
	        stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                   ResultSet.CONCUR_UPDATABLE);
	        ResultSet uprs = stmt.executeQuery("SELECT * FROM demo.AccountDetail ");
	        int f =0;
	    	while(uprs.next())
			{
				for(int i=0;i<nid.size();i++ )
				{
					if(nid.get(i).equals(uprs.getString("EmployeeId")) && uprs.getString("Item").equals("cash"))
					{
						add = uprs.getInt("Profit")+stocks.get(i);
			            uprs.updateInt( "Currentvalue", (int) (uprs.getInt("Currentvalue")+stocks.get(i)));
			           // stocks.set(i, add);
			            uprs.updateRow();
						f=1;
					}
				}
			}
	    	uprs.close();
	        stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	                   ResultSet.CONCUR_UPDATABLE);
		      uprs = stmt.executeQuery("SELECT * FROM demo.AccountSummary ");
		      int k =0;
		 	while(uprs.next())
				{
					for(int i=0;i<nid.size();i++ )
					{
						if(nid.get(i).equals(uprs.getString("EmployeeId")))
						{
					
				          uprs.updateInt( "CurrentBalance", (int) (uprs.getInt("CurrentBalance")+stocks.get(i)));
				            stocks.set(i, add);
				           uprs.updateRow();
							f=uprs.getInt("CurrentBalance");
							k = 8;
						}
					}
				}
 	uprs.close();
			result = "Agg. of"+item+" is :"+f;
		
	
			//result = "Agg. of";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	
	
	public String toBeUpSold(String id,String string)
	{
		String result = "";
	    int row = 0;
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
		   
		    	
		        result = "";
		        int k = 0;
		        while (myRs.next()) {
		        	for(int i=0; i<percentage.size();i++)
			        {
			        	if(myRs.getString("Item").equals(item.get(i)) && myRs.getString("Category").equals(category.get(i)) )
			        	{
			        		
			        		if(row != 0)
			        			result += ",";
			        			result += myRs.getString("Item")+","+ myRs.getString("Category");
			        		row++;
			        	}
			        	
			        	
			        }
		        	
		        	
		        }

			        
			        myConn.close();
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public String toBeBought(String id,String string)
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
			        		boolean jk = true;
			        		added.set(i, jk);
			        		
			        	}
			        	
			        	
			        }
		        	
		        	
		        }
		        for(int i=0; i<percentage.size();i++)
		        {
			        if(added.get(i) == false)
			        {
			        	
			        	if(row != 0)
		        			result += ",";
		        			result += item.get(i)+","+category.get(i) ;
		        		row++;
			        	 
			        }
		        }
		 
			        
			        myConn.close();
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}
