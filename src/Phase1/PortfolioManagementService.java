package Phase1;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cdyne.ws.GetQuoteDataSetResponseGetQuoteDataSetResult;

import Phase2.StockServices;



public class PortfolioManagementService {

	
	public int noOfEmps(String s)
	{
		int result = 0;

		try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
				//1 get connection
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
				Statement stmt = myConn.createStatement();
			        stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			                   ResultSet.CONCUR_UPDATABLE);
		        ResultSet uprs = stmt.executeQuery("SELECT * FROM demo.EmployeeInfo ");
		        boolean f = false;
		        while (uprs.next()) {
		          result++;
		        }

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return (result-1);
	}
	public int noOfics(String s)
	{
		int result = 0;

		try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
				//1 get connection
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
				Statement stmt = myConn.createStatement();
			        stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			                   ResultSet.CONCUR_UPDATABLE);
		        ResultSet uprs = stmt.executeQuery("SELECT * FROM demo.AccountDetail ");
		        boolean f = false;
		        while (uprs.next()) {
		        	if(!uprs.getString("Item").equals("cash"))
		        			result++;
		        }

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return (result-1);
	}
	
	
	public String getItem(int c)
	{
		String result = "";

		try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
				//1 get connection
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
				Statement stmt = myConn.createStatement();
			        stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			                   ResultSet.CONCUR_UPDATABLE);
		        ResultSet uprs = stmt.executeQuery("SELECT * FROM demo.AccountDetail ");
		        boolean f = false;
		        int x =0;
		        while (uprs.next()) {
		        	if(!uprs.getString("Item").equals("cash"))
		        	{
		        			if(x == c)
		        				result = uprs.getString("Item");
		        			x++;
		        	}
		        }

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	

	
	
	
	public String getCat(int c)
	{
		String result = "";

		try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
				//1 get connection
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
				Statement stmt = myConn.createStatement();
			        stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			                   ResultSet.CONCUR_UPDATABLE);
		        ResultSet uprs = stmt.executeQuery("SELECT * FROM demo.AccountDetail ");
		        boolean f = false;
		        int x =0;
		        while (uprs.next()) {
		        	if(!uprs.getString("Item").equals("cash"))
		        	{
		        			if(x == c)
		        				result = uprs.getString("Category");
		        			x++;
		        	}
		        }

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	public String updateEmployeeRetirementContribution(String id,int percentage)
	{
		String result = "";

		try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
				//1 get connection
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
				Statement stmt = myConn.createStatement();
			        stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			                   ResultSet.CONCUR_UPDATABLE);
		        ResultSet uprs = stmt.executeQuery("SELECT * FROM demo.EmployeeInfo where EmployeeId = '"+id+"'");
		        boolean f = false;
		        while (uprs.next()) {
		           f = true;
		            uprs.updateInt( "RetirementFundContributionPercentage", percentage);
		            uprs.updateRow();
		        }
		        if(f == false)
		        	result = "false";
		        else
		        	result = "true";
		        myConn.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	
	public String createPortFolio(String id,String s)
	{
		String result = "";

		try {
			
				String[] tokens = s.split(",");
				List<String> item = new ArrayList<String>();
				List<String>  cat= new ArrayList<String>();
				List<Integer>  perc= new ArrayList<Integer>();
				int x = 0 ;
				for(int i =0;i<tokens.length;)
				{
				
					item.add(tokens[i]);
					i++;
					cat.add(tokens[i]);
					i++;
					
					int j = Integer.parseInt(tokens[i]);
					perc.add(j);
					x+=j;
					i++;
				}
				if(x==100)
				{	
					DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
					//1 get connection
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
					Statement stmt = null;
				    try {
				        myConn.setAutoCommit(false);
				        stmt = myConn.createStatement();
				        for(int i=0; i<perc.size();i++)
				        {
					        stmt.addBatch(
					            "INSERT INTO PortfolioInfo " +
					            "VALUES('"+id+"', '"+item.get(i)+"',  '"+cat.get(i)+"',  "+perc.get(i)+")");
				        }

				        

				        stmt.executeBatch();
				        myConn.commit();
				        result = "false";
				    } catch(BatchUpdateException e) {
				    	e.printStackTrace();
				    
				    } catch(SQLException e) {
				    	e.printStackTrace();
				    } finally {
				        if (stmt != null) { stmt.close();
				        result = "true";
				        }
				        myConn.setAutoCommit(true);
				    }
				}
				else 
					result = "Sum of %s is not 100: "+ x;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	
	
	public String getIdstr(String s)
	{
		
		String id[] = s.split("-");
		return id[0];
		
	}
	public String getRemstr(String s)
	{
		
		String id[] = s.split("-");
		return id[1];
		
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

		        myStmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			    myRs = myStmt.executeQuery("SELECT * FROM demo.PortfolioInfo where EmployeeId = '"+id+"'");
			    while (myRs.next()) {
			    	int fj =0;
		        	for(int i=0; i<percentage.size();i++)
			        {
			        	if(myRs.getString("Item").equals(item.get(i)) && myRs.getString("Category").equals(category.get(i)) )
			        	{
			        		fj =1;
			        	}
			        }
		        	if(fj == 0)
		        	{
			        	
			        	myRs.absolute(myRs.getRow());
			        	myRs.deleteRow();

		        	}
			    }
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
	

	public String queryPortFolio(String id)
	{
		String result = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();
			ResultSet myRs;
			if(id.equals("-1"))
				 myRs = myStmt.executeQuery("SELECT * FROM demo.PortfolioInfo ");
			else
			 myRs = myStmt.executeQuery("SELECT * FROM demo.PortfolioInfo where EmployeeId = '"+id+"'");
			//process results
				

			
			 

				while(myRs.next())
				{
					result +=  "ID: " +myRs.getString("EmployeeId")+"Item: "+myRs.getString("Item") +"  Category:"+ myRs.getString("Category")+"    %:"+ myRs.getString("PercentageContribution")+ "\n";
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	public String accountSummary(String id)
	{
		String result = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.AccountSummary where EmployeeId = '"+id+"'");
			//process results
				

			
			 result += "Account summary of ID: "+ id + "        :\n";

				while(myRs.next())
				{
					result +=  "Quarter Balance: "+myRs.getString("QuarterEndBalance") +"    Current balance:"+ myRs.getString("CurrentBalance")+ "\n";
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	
	
	public String viewAccountDetails(String id)
	{
		String result = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.AccountDetail where EmployeeId = '"+id+"'");
			//process results
				

			
			 result += "Account summary of ID: "+ id + "        :\n";

				while(myRs.next())
				{
					result +=  "Profit : "+myRs.getString("Profit") +"  Category:"+ myRs.getString("Category")+"    Current balance:"+ myRs.getString("Currentvalue")+ "\n";
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	
	
	public int aggregateAmountPerItemCategory1(String item,String cat)
	{
		 float v = 0 ;
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
				float x = (float) (myRs.getInt("Salary")*( myRs.getInt("RetirementFundContributionPercentage")/100.0));
				ps.add(x);
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.PortfolioInfo where Item = '"+item+"' and Category ='"+cat+"'");
			  v = 0 ;
			 int c = 0;
			while(myRs.next())
			{
				for(int i=0;i<id.size();i++ )
				{
					if(id.get(i).equals(myRs.getString("EmployeeId")))
					{
						v+=((myRs.getInt("PercentageContribution")/100.0)) * ps.get(i);
						c++;
						i = id.size() + 2;
					}
				}
			}
			v = v/c;
			result = "Agg. of"+item+" is :"+v;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return (int)v;
	}
	
	public String aggregateAmountPerItemCategory(String item,String cat)
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
				float x = (float) (myRs.getInt("Salary")*( myRs.getInt("RetirementFundContributionPercentage")/100.0));
				ps.add(x);
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.PortfolioInfo where Item = '"+item+"' and Category ='"+cat+"'");
			 float v = 0 ;
			 int c = 0;
			while(myRs.next())
			{
				for(int i=0;i<id.size();i++ )
				{
					if(id.get(i).equals(myRs.getString("EmployeeId")))
					{
						v+=((myRs.getInt("PercentageContribution")/100.0)) * ps.get(i);
						c++;
						i = id.size() + 2;
					}
				}
			}
			v = v/c;
			result = "Agg. of"+item+" is :"+v;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	
	public String updateSharePerEmployee(String item,String cat,String symbol,String ts, String totalam,String ttype)
	{
		item = "stock";
		cat = "IT";
		symbol = "APPL";
				ts = "1000";
		totalam = "5000";
		ttype="sell";
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
						float nv = x/Float.parseFloat(totalam);
						int ns = (int)(Float.parseFloat(ts) * nv);
						
						 add =x* Float.parseFloat(totalam); //(int)(Float.parseFloat(ts) * nv);
						 
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
	
	
	
	
}
